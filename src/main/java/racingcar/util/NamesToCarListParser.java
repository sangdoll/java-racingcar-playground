package racingcar.util;

import racingcar.domain.Car;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class NamesToCarListParser {
	private NamesToCarListParser() {
	}

	private static void validateNames(String names) {
		if (!names.matches("([\\w]+,?)+")) {
			throw new IllegalArgumentException("[ERROR] 유효하지 않은 입력입니다.");
		}
	}

	public static List<Car> parseToCars(String names) {
		validateNames(names);
		return Arrays.stream(names.split(","))
			.map(Car::from)
			.collect(Collectors.toList());
	}

}
