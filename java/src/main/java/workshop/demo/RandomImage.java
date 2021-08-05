package workshop.demo;

import java.security.SecureRandom;
import java.util.List;
import java.util.Random;
import java.util.stream.*;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("singleton")
public class RandomImage {

	private final Random rand = new SecureRandom();

	public RandomImage() { }

	public String[] getImages() {
		return getImages(4);
	}
	public String[] getImages(int count) {
		final String[] images = new String[count];
		int[] nums = IntStream.range(0, 14).collect(Collectors.toList()).toArray();
		return null;
	}

}

