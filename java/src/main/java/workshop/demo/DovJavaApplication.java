package workshop.demo;

import java.util.*;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DovJavaApplication {

	public static void main(String[] args) {
		final SpringApplication app = new SpringApplication(DovJavaApplication.class);

		final String port = getPort();
		
		app.setDefaultProperties(Collections.singletonMap("server.port", port));

		System.out.printf("Starting on port %s\n", port);
		app.run(args);
	}

	public static String getPort() {
		String port = "3000";
		Optional<String> opt = Optional.ofNullable(System.getenv("PORT"));
		if (opt.isPresent())
			port = opt.get();
		return (port);
	}

}
