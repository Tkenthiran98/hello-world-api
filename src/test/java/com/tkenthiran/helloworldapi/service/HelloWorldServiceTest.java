package com.tkenthiran.helloworldapi.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class HelloWorldServiceTest {

	private HelloWorldService helloWorldService;

	@BeforeEach
	void setUp() {
		helloWorldService = new HelloWorldService();
	}

	@Test
	void testIsValidNameWithValidLowercaseA() {
		assertTrue(helloWorldService.isValidName("a"));
	}

	@Test
	void testIsValidNameWithValidLowercaseM() {
		assertTrue(helloWorldService.isValidName("m"));
	}

	@Test
	void testIsValidNameWithValidUppercaseA() {
		assertTrue(helloWorldService.isValidName("A"));
	}

	@Test
	void testIsValidNameWithValidUppercaseM() {
		assertTrue(helloWorldService.isValidName("M"));
	}

	@Test
	void testIsValidNameWithInvalidLowercaseN() {
		assertFalse(helloWorldService.isValidName("n"));
	}

	@Test
	void testIsValidNameWithInvalidLowercaseZ() {
		assertFalse(helloWorldService.isValidName("z"));
	}

	@Test
	void testIsValidNameWithInvalidUppercaseN() {
		assertFalse(helloWorldService.isValidName("N"));
	}

	@Test
	void testIsValidNameWithInvalidUppercaseZ() {
		assertFalse(helloWorldService.isValidName("Z"));
	}

	@Test
	void testIsValidNameWithNull() {
		assertFalse(helloWorldService.isValidName(null));
	}

	@Test
	void testIsValidNameWithEmpty() {
		assertFalse(helloWorldService.isValidName(""));
	}

	@Test
	void testIsValidNameWithBlank() {
		assertFalse(helloWorldService.isValidName("   "));
	}

	@Test
	void testIsValidNameWithNumbers() {
		assertFalse(helloWorldService.isValidName("123"));
	}

	@Test
	void testIsValidNameWithSpecialCharacters() {
		assertFalse(helloWorldService.isValidName("!@#"));
	}

	@Test
	void testFormatNameCapitalizesFirstLetterAndLowercasesRest() {
		assertEquals("Alice", helloWorldService.formatName("alice"));
	}

	@Test
	void testFormatNameWithUppercaseInput() {
		assertEquals("Alice", helloWorldService.formatName("ALICE"));
	}

	@Test
	void testFormatNameWithMixedCase() {
		assertEquals("Alice", helloWorldService.formatName("aLiCe"));
	}

	@Test
	void testFormatNameWithSingleCharacter() {
		assertEquals("A", helloWorldService.formatName("a"));
	}

}
