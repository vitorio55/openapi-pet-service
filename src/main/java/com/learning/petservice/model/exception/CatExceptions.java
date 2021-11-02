package com.learning.petservice.model.exception;

import org.springframework.context.MessageSource;
import org.springframework.web.server.ResponseStatusException;

import java.util.Locale;

import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.NOT_FOUND;

public class CatExceptions {

    public static ResponseStatusException catNotFoundException(MessageSource ms) {
        return new ResponseStatusException(NOT_FOUND,
                ms.getMessage("pet.cat.not_found", null, Locale.ENGLISH));
    }

    public static ResponseStatusException notCatException(MessageSource ms) {
        return new ResponseStatusException(BAD_REQUEST,
                ms.getMessage("pet.cat.not_cat", null, Locale.ENGLISH));
    }
}
