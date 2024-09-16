package com.diveger.backend.infrastructure.common.exceptions;

public class CharacterNotFoundException extends RuntimeException {
    public CharacterNotFoundException(String name) {
        super("Character with name " + name + " not found");
    }
}
