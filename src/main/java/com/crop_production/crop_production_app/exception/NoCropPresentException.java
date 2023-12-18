package com.crop_production.crop_production_app.exception;

public class NoCropPresentException extends RuntimeException {
    public NoCropPresentException(String message) {
        super(message);
    }
}
