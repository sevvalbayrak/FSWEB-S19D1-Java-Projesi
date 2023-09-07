package com.workintech.manytomany.manytomany.exeptions;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
public class MovieException extends RuntimeException {
    private HttpStatus code;

    public MovieException(String message, HttpStatus code) {
        super(message);
        this.code = code;
    };
}