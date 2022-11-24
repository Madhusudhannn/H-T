package com.Humana.Humana.advice;

public class MailIdalreadyExist  extends Exception{

	private static final long serialVersionUID=1L;
	
	public MailIdalreadyExist(String meassage)
	{
		super(meassage);
	} 
}
