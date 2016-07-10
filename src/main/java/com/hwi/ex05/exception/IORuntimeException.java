package com.hwi.ex05.exception;

public class IORuntimeException extends RuntimeException{
	private static final long serialVersionUID = 1L;
	
	public IORuntimeException(){
		super();
	}
	
	public IORuntimeException(String message){
		super(message);
	}
	
	public IORuntimeException(String message, Throwable cause){
		super(message, cause);
	}
	
	public IORuntimeException(Throwable cause){
		super(cause);
	}
}
