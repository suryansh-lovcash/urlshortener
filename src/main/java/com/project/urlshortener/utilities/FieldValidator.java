package com.project.urlshortener.utilities;

public class FieldValidator {

	public static Boolean isValidString(String input) {
		return (input != null) && (input.length() > 0);
	}
	
	public static Boolean isValidTime(String input) {
		if(isValidString(input)) {
			try {
				Long value = Long.getLong(input);
			} catch (NumberFormatException e) {
				return false;
			}
		}
		return true;
	}
}
