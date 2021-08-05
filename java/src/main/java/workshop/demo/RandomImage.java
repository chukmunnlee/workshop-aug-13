package workshop.demo;

import java.security.SecureRandom;
import java.util.Arrays;
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

	public Object[] getImages() {
		return getImages(4);
	}
	public Object[] getImages(int count) {
		final String[] images = new String[count];
		int[] nums = IntStream.range(0, 14).toArray();
		for (int i = 0; i < nums.length; i++) {
			final int idx = rand.nextInt(nums.length);
			int v = nums[i];
			nums[i] = nums[idx];
			nums[idx] = v;
		}
		return IntStream.range(0, count)
			.mapToObj(v -> String.format("/images/dov%d.gif", nums[v]))
			.toArray();
	}
}

