package com.example.annuaire.exceptions;

public class DuplicateException extends RuntimeException{
    public DuplicateException(String ressource) {
        super(String.format("'%s' is duplicate", ressource));
    }
}