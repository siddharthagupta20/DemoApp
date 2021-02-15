package com.cg.apps2.demoapp.exception;

public class UserNotFoundException extends IllegalArgumentException{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String msg;
	public UserNotFoundException(String msg) {
		super(msg);
		this.msg = msg;
	}
}