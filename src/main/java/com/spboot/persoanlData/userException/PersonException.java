package com.spboot.persoanlData.userException;

public class PersonException {

	private String errormessage;
	public PersonException(String string) {
		
		this.errormessage= string;
	}

	public String PersonException() {
       return errormessage;
	}

}
