package com.cibertec.exception;

public class OperacionNoPermitidaException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;
    public OperacionNoPermitidaException(String mensaje) {
        super(mensaje);
    }
}