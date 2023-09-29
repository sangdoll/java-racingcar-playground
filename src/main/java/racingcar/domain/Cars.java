package racingcar.domain;

import racingcar.util.LocationParser;
import racingcar.util.NamesParser;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public final class Cars {
	private static final String COLON = " : ";
	private static final String NEW_LINE = System.getProperty("line.separator");
	private final List<Car> carList;

	public Cars(String names) {
		NamesParser parser = new NamesParser(names);
		this.carList = parser.parsing();
	}

	public List<Car> getCarList() {
		return Collections.unmodifiableList(carList);
	}

	public void moveAllCars(List<Integer> numbers) {
		IntStream.range(0, carList.size())
			.forEach(ind -> carList.get(ind).move(numbers.get(ind)));
	}

	public int getTotalCount() {
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

	@Override
	public String toString() {
		return carList.stream()
			.map(car -> car.getName()
				+ COLON
				+ LocationParser.parsing(car.getLocation())
				+ NEW_LINE)
			.collect(Collectors.joining());
	}
}
