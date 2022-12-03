package it.giocic.restservice;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class GreetingControllerTestCase {

	private GreetingController controller;
	private Greeting greeting;

	@Test
	void testGetGreetingReturnsNotNullObject() {
		givenNewController();
		whenNameIs("Frodo");
		thenGreetingIsNotNull();
	}
	
	@Test
	void testGetGreetingContentReturnsHelloFrodoWhenNameIsFrodo() {
		givenNewController();
		whenNameIs("Frodo");
		thenGreetingContentIs("Hello, Frodo!");
	}
	
	@Test
	void testGetGreetingContentReturnsHelloWorldWhenNameIsNull() {
		givenNewController();
		whenNameIs(null);
		thenGreetingContentIs("Hello, World!");
	}
	
	@Test
	void testGetGreetingIdIsIncrementedWhenNewGreetingIsGenerated() {
		givenNewController();
		whenNewGreetingIsGenerated();
		thenGreetingIdIs(1);
		whenNewGreetingIsGenerated();
		thenGreetingIdIs(2);
		
	}

	private void thenGreetingIdIs(int value) {
		assertThat(greeting.getId()).isEqualTo(value);
	}

	private void whenNewGreetingIsGenerated() {
		greeting = controller.getGreeting(null);
	}

	private void thenGreetingContentIs(String value) {
		assertThat(greeting.getContent()).isEqualTo(value);
	}

	private void thenGreetingIsNotNull() {
		assertThat(greeting).isNotNull();
	}

	private void whenNameIs(String value) {
		greeting = controller.getGreeting(value);
	}

	private void givenNewController() {
		controller = new GreetingController();
	}

}
