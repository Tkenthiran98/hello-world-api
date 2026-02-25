package com.tkenthiran.helloworldapi.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Map;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.tkenthiran.helloworldapi.service.HelloWorldService;

@ExtendWith(MockitoExtension.class)
class HelloWorldControllerTest {

	@Mock
	private HelloWorldService helloWorldService;

	@InjectMocks
	private HelloWorldController helloWorldController;

	@Test
	void testHelloWorldWithValidNameAlice() {
		when(helloWorldService.isValidName("alice")).thenReturn(true);
		when(helloWorldService.formatName("alice")).thenReturn("Alice");

		ResponseEntity<Map<String, String>> response = helloWorldController.helloWorld("alice");

		assertEquals(HttpStatus.OK, response.getStatusCode());
		assertEquals("Hello Alice", response.getBody().get("message"));
	}

	@Test
	void testHelloWorldWithValidNameUppercaseALICE() {
		when(helloWorldService.isValidName("ALICE")).thenReturn(true);
		when(helloWorldService.formatName("ALICE")).thenReturn("Alice");

		ResponseEntity<Map<String, String>> response = helloWorldController.helloWorld("ALICE");

		assertEquals(HttpStatus.OK, response.getStatusCode());
		assertEquals("Hello Alice", response.getBody().get("message"));
	}

	@Test
	void testHelloWorldWithValidNameStartingWithM() {
		when(helloWorldService.isValidName("michael")).thenReturn(true);
		when(helloWorldService.formatName("michael")).thenReturn("Michael");

		ResponseEntity<Map<String, String>> response = helloWorldController.helloWorld("michael");

		assertEquals(HttpStatus.OK, response.getStatusCode());
		assertEquals("Hello Michael", response.getBody().get("message"));
	}

	@Test
	void testHelloWorldWithInvalidNameStartingWithN() {
		when(helloWorldService.isValidName("nancy")).thenReturn(false);

		ResponseEntity<Map<String, String>> response = helloWorldController.helloWorld("nancy");

		assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
		assertEquals("Invalid Input", response.getBody().get("error"));
	}

	@Test
	void testHelloWorldWithInvalidNameStartingWithZ() {
		when(helloWorldService.isValidName("zoe")).thenReturn(false);

		ResponseEntity<Map<String, String>> response = helloWorldController.helloWorld("zoe");

		assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
		assertEquals("Invalid Input", response.getBody().get("error"));
	}

	@Test
	void testHelloWorldWithMissingName() {
		when(helloWorldService.isValidName(null)).thenReturn(false);

		ResponseEntity<Map<String, String>> response = helloWorldController.helloWorld(null);

		assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
		assertEquals("Invalid Input", response.getBody().get("error"));
	}

	@Test
	void testHelloWorldWithEmptyName() {
		when(helloWorldService.isValidName("")).thenReturn(false);

		ResponseEntity<Map<String, String>> response = helloWorldController.helloWorld("");

		assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
		assertEquals("Invalid Input", response.getBody().get("error"));
	}

	@Test
	void testHelloWorldWithBlankName() {
		when(helloWorldService.isValidName("   ")).thenReturn(false);

		ResponseEntity<Map<String, String>> response = helloWorldController.helloWorld("   ");

		assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
		assertEquals("Invalid Input", response.getBody().get("error"));
	}

	@Test
	void testHelloWorldWithNumbers() {
		when(helloWorldService.isValidName("123")).thenReturn(false);

		ResponseEntity<Map<String, String>> response = helloWorldController.helloWorld("123");

		assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
		assertEquals("Invalid Input", response.getBody().get("error"));
	}

	@Test
	void testHelloWorldWithSpecialCharacters() {
		when(helloWorldService.isValidName("!@#")).thenReturn(false);

		ResponseEntity<Map<String, String>> response = helloWorldController.helloWorld("!@#");

		assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
		assertEquals("Invalid Input", response.getBody().get("error"));
	}

}
