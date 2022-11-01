package it.giocic.restservice;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class GreetingTestCase {

	private Greeting newInstance;
	private long givenId;
	private String givenContent;

	@Test
	void testConstructorReturnsNotNullInstance() {
		givenArguments(1, "Hello");
		whenNewInstanceIsCreated();
		assertThat(newInstance).isNotNull();
	}
	
	@Test
	void testGetIdReturnsGivenId() {
		givenArguments(1, null);
		whenNewInstanceIsCreated();
		long instanceId = newInstance.getId();
		assertThat(instanceId == givenId).isTrue();
	}
	
	@Test
	void testSetIdChangesGreetingId() {
		givenArguments(1, "Hello");
		whenNewInstanceIsCreated();
		long newValue = 2;
		newInstance.setId(newValue);
		assertThat(newInstance.getId()).isEqualTo(newValue);
	}
	
	@Test
	void testGetContentReturnsGivenContent() {
		givenArguments(1, "Hello");
		whenNewInstanceIsCreated();
		String instanceContent = newInstance.getContent();
		assertThat(instanceContent).isEqualTo(givenContent);
	}
	
	@Test
	void testSetContentChangesGreetingContent() {
		givenArguments(1, "Hello");
		whenNewInstanceIsCreated();
		String newValue = "Ciao";
		newInstance.setContent(newValue);
		assertThat(newInstance.getContent()).isEqualTo(newValue);
	}
	
	@Test
	void testEqualsReturnsTrueWhenObjectsAreTheSame() {
		givenArguments(1, "Hello");
		whenNewInstanceIsCreated();
		assertThat(newInstance.equals(newInstance)).isTrue();
	}
	
	@Test
	void testEqualsReturnsTrueWhenObjectsHaveSameIdAndContent() {
		givenArguments(1, "Hello");
		whenNewInstanceIsCreated();
		Greeting secondInstance = new Greeting(givenId, givenContent);
		assertThat(newInstance.equals(secondInstance)).isTrue();
	}
	
	@Test
	void testEqualsReturnsFalseWhenObjectsHaveDifferentId() {
		givenArguments(1, "Hello");
		whenNewInstanceIsCreated();
		Greeting secondInstance = new Greeting(2, givenContent);
		assertThat(newInstance.equals(secondInstance)).isFalse();
	}
	
	@Test
	void testEqualsReturnsFalseWhenObjectsHaveDifferentContent() {
		givenArguments(1, "Hello");
		whenNewInstanceIsCreated();
		Greeting secondInstance = new Greeting(givenId, "Ciao");
		assertThat(newInstance.equals(secondInstance)).isFalse();
	}
	
	@Test
	void testEqualsReturnsFalseWhenObjectsHaveDifferentIdAndContent() {
		givenArguments(1, "Hello");
		whenNewInstanceIsCreated();
		Greeting secondInstance = new Greeting(2, "Ciao");
		assertThat(newInstance.equals(secondInstance)).isFalse();
	}
	
	@Test
	void testEqualsReturnsFalseWhenSecondObjectIsNull() {
		givenArguments(1, "Hello");
		whenNewInstanceIsCreated();
		assertThat(newInstance.equals(null)).isFalse();
	}
	
	private void givenArguments(long id, String content) {
		givenId = id;
		givenContent = content;
	}
	
	private void whenNewInstanceIsCreated() {
		newInstance = new Greeting(givenId, givenContent);
	}

}
