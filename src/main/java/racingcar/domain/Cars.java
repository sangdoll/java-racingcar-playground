package racingcar.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import racingcar.util.LocationToUIParser;
import racingcar.util.NamesToCarListParser;

public final class Cars {
	private static final String COLON = " : ";
	private static final String NEW_LINE = System.getProperty("line.separator");
	private final List<Car> carList;

	private Cars(String names) {
		this.carList = NamesToCarListParser.parseToCars(names);
	}

	public static Cars from(String names) {
		return new Cars(names);
	}

	public List<Car> getCarList() {
		return Collections.unmodifiableList(carList);
	}

	public void moveAllCars(List<Integer> numbers) {
		IntStream.range(0, carList.size())
			.forEach(index -> carList.get(index).move(numbers.get(index)));
	}

	public int getCarsCount() {
		return carList.size();
	}

	public int getMaxLocation() {
		return carList.stream()
			.map(Car::getLocation)
			.max(Integer::compareTo)
			.orElse(0);
	}

	public String getMaxLocationCarsName() {
		int maxLocation = getMaxLocation();
		return carList.stream()
			.filter(car -> car.isSameLocation(maxLocation))
			.map(Car::getName)
			.collect(Collectors.joining(", "));
	}

	public String getPrintResult() {
		return carList.stream()
			.map(car -> car.getName()
				+ COLON
				+ LocationToUIParser.parse(car.getLocation())
				+ NEW_LINE)
			.collect(Collectors.joining());
	}
}
