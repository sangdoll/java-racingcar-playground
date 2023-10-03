package racingcar.util;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class RandomNumbersList {
	private static final int MIN = 0;
	private static final int MAX = 9;
	private final Random random = new Random();

	public List<Integer> getRandomNumbers(int count) {
		return random.ints(MIN, MAX + 1)
			.limit(count)
			.boxed()
			.collect(Collectors.toList());
	}
}
