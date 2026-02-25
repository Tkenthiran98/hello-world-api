package com.tkenthiran.helloworldapi.service;

import org.springframework.stereotype.Service;

@Service
public class HelloWorldService {

	public boolean isValidName(String name) {
		if (name == null || name.isBlank()) {
			return false;
		}

		char firstChar = Character.toUpperCase(name.charAt(0));
		return firstChar >= 'A' && firstChar <= 'M';
	}

	public String formatName(String name) {
		return name.substring(0, 1).toUpperCase() + name.substring(1).toLowerCase();
	}

}
