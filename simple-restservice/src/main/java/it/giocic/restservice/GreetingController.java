package it.giocic.restservice;

import java.util.concurrent.atomic.AtomicLong;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * A controller is a class which handles HTTP requests and responses.
 * This controller is for greeting resource.
 * @author Giovanni Giordano
 *
 */
@RestController   // @RestController is a shorthand for @Controller and @ResponseBody
public class GreetingController {
	
	private static final String DEFAULT_NAME = "World";
	private static final String TEMPLATE = "Hello, %s!";
	private static final Logger LOGGER = LoggerFactory.getLogger(GreetingController.class);
	private AtomicLong counter = new AtomicLong();

	/**
	 * Returns a greeting to user.
	 * @param name - Name of the user. If it is null, a default value is used.
	 * @return a text wich contains a greeting for the user.
	 */
	@GetMapping("/greeting")   // HTTP GET requests to /greeting are mapped to this method
	public Greeting getGreeting(@RequestParam(value = "name", defaultValue = DEFAULT_NAME) String name) {
		// @RequestParam binds the value of query string parameter "name" into the "name" parameter of this method.
		// If the name parameter is absent in the request, the defaultValue is used.
		if(name == null) {
			LOGGER.info("Name parameter is null, default value is used");
			name = DEFAULT_NAME;
		}
		final String content = String.format(TEMPLATE, name);
		final long id = counter.incrementAndGet();
		LOGGER.info("Generated greeting {} with content {}", id, content);
		return new Greeting(id, content);
	}

}
