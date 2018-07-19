package com.wt.pro.exception;

public class UserException extends Exception{

	public UserException(String message)
	{
		super("UserException-"+message);
	}
	
	public UserException(String message, Throwable cause)
	{
		super("UserException-"+message,cause);
	}
	

}
