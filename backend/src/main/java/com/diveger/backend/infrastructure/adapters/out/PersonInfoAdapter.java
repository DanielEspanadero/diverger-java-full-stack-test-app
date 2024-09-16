package com.diveger.backend.infrastructure.adapters.out;

import com.diveger.backend.application.dto.*;
import com.diveger.backend.application.mappers.PeopleMapper;
import com.diveger.backend.application.ports.out.PersonInfoPort;
import com.diveger.backend.domain.Film;
import com.diveger.backend.domain.People;
import com.diveger.backend.infrastructure.common.exceptions.BadRequestException;
import com.diveger.backend.infrastructure.common.exceptions.CharacterNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Component
public class PersonInfoAdapter implements PersonInfoPort {

    private final RestTemplate restTemplate;
    private final PeopleMapper peopleMapper;

    public PersonInfoAdapter(RestTemplate restTemplate, PeopleMapper peopleMapper) {
        this.restTemplate = restTemplate;
        this.peopleMapper = peopleMapper;
    }

    @Override
    @Cacheable(value = "characterCache", key = "#name")
    public List<CharacterResponseDTO> getPersonInfo(String name) {
        validateCharacterName(name);
        try {
            ResultSearchCharacterDTO result = restTemplate.getForObject("/people/?search={name}", ResultSearchCharacterDTO.class, name);
            checkCharacterFound(result, name);

            assert result != null;
            return mapResultsToResponse(result.getResults());
        } catch (CharacterNotFoundException e) {
            throw e;
        } catch (Exception e) {
            log.error("Error occurred while fetching character info", e);
            throw new RuntimeException("Failed to fetch character info");
        }
    }

    private void validateCharacterName(String name) {
        if (name == null || name.trim().isEmpty()) {
            log.error("Character name is null or empty");
            throw new BadRequestException("The character name must not be empty.");
        }
    }

    private void checkCharacterFound(ResultSearchCharacterDTO result, String name) {
        if (result == null || result.getResults().isEmpty()) {
            log.error("Character not found: {}", name);
            throw new CharacterNotFoundException(name);
        }
    }

    private List<CharacterResponseDTO> mapResultsToResponse(List<PeopleDTO> peopleDTOs) {
        List<CharacterResponseDTO> characterResponseList = new ArrayList<>();
        for (PeopleDTO peopleDTO : peopleDTOs) {
            People people = buildCharacterDomain(peopleDTO);
            CharacterResponseDTO responseDTO = mapToCharacterResponseDTO(people);
            characterResponseList.add(responseDTO);
        }
        return characterResponseList;
    }

    private People buildCharacterDomain(PeopleDTO peopleDTO) {
        log.info("Building character domain object for: {}", peopleDTO.getName());

        String planetName = fetchPlanetNameByUrl(peopleDTO.getHomeworld());
        String fastestVehicle = findFastestVehicle(peopleDTO);
        List<Film> films = fetchFilmsFromUrls(peopleDTO.getFilms());

        return new People(
                peopleDTO.getName(),
                peopleDTO.getBirthYear(),
                peopleDTO.getGender(),
                planetName,
                fastestVehicle,
                films
        );
    }

    private String fetchPlanetNameByUrl(String homeWorldUrl) {
        try {
            PlanetDTO planetDTO = restTemplate.getForObject(homeWorldUrl, PlanetDTO.class);
            return planetDTO != null ? planetDTO.getName() : "Unknown";
        } catch (Exception e) {
            log.error("Error occurred while fetching planet info for {}", homeWorldUrl, e);
            return "Unknown";
        }
    }

    private String findFastestVehicle(PeopleDTO peopleDTO) {
        List<String> vehicleAndStarshipUrls = new ArrayList<>(peopleDTO.getVehicles());
        vehicleAndStarshipUrls.addAll(peopleDTO.getStarships());

        return determineFastestVehicle(vehicleAndStarshipUrls);
    }

    private String determineFastestVehicle(List<String> urls) {
        if (urls.isEmpty()) {
            return "n/a";
        }

        String fastestVehicle = "n/a";
        int maxSpeed = 0;

        for (String url : urls) {
            int speed = fetchVehicleOrStarshipSpeed(url);
            if (speed > maxSpeed) {
                maxSpeed = speed;
                fastestVehicle = extractVehicleOrStarshipName(url);
            }
        }

        return fastestVehicle;
    }

    private int fetchVehicleOrStarshipSpeed(String url) {
        try {
            if (url.contains("vehicles")) {
                VehicleDTO vehicleDTO = restTemplate.getForObject(url, VehicleDTO.class);
                return vehicleDTO != null ? parseMaxAtmospheringSpeed(vehicleDTO.getMaxAtmospheringSpeed()) : 0;
            } else if (url.contains("starships")) {
                StarshipDTO starshipDTO = restTemplate.getForObject(url, StarshipDTO.class);
                return starshipDTO != null ? parseMaxAtmospheringSpeed(starshipDTO.getMaxAtmospheringSpeed()) : 0;
            }
        } catch (Exception e) {
            log.error("Error occurred while fetching speed data from URL {}", url, e);
        }
        return 0;
    }

    private String extractVehicleOrStarshipName(String url) {
        try {
            if (url.contains("vehicles")) {
                VehicleDTO vehicleDTO = restTemplate.getForObject(url, VehicleDTO.class);
                return vehicleDTO != null ? vehicleDTO.getName() : "n/a";
            } else if (url.contains("starships")) {
                StarshipDTO starshipDTO = restTemplate.getForObject(url, StarshipDTO.class);
                return starshipDTO != null ? starshipDTO.getName() : "n/a";
            }
        } catch (Exception e) {
            log.error("Error occurred while fetching name data from URL {}", url, e);
        }
        return "n/a";
    }

    private List<Film> fetchFilmsFromUrls(List<String> filmUrls) {
        List<Film> films = new ArrayList<>();
        for (String filmUrl : filmUrls) {
            films.add(fetchFilmDetails(filmUrl));
        }
        return films;
    }

    private Film fetchFilmDetails(String filmUrl) {
        try {
            FilmDTO filmDTO = restTemplate.getForObject(filmUrl, FilmDTO.class);
            return filmDTO != null ? new Film(filmDTO.getTitle(), filmDTO.getReleaseDate()) : null;
        } catch (Exception e) {
            log.error("Error occurred while fetching film info for {}", filmUrl, e);
            return null;
        }
    }

    private int parseMaxAtmospheringSpeed(String speed) {
        try {
            return Integer.parseInt(speed);
        } catch (NumberFormatException e) {
            log.error("Invalid max atmosphere speed value: {}", speed, e);
            return 0;
        }
    }

    private CharacterResponseDTO mapToCharacterResponseDTO(People character) {
        return peopleMapper.peopleToCharacterResponse(character);
    }
}
