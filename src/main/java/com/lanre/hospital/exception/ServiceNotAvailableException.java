package com.lanre.hospital.exception;

public class ServiceNotAvailableException extends RuntimeException{
    public ServiceNotAvailableException(String message){
        super(message);
    }

}
