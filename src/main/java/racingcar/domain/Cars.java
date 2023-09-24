package racingcar.domain;

import racingcar.util.LocationParser;
import racingcar.util.NamesParser;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public final class Cars {
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

    public String getResult() {
        LocationParser locationParser = new LocationParser();
        return carList.stream()
                .map(car -> car.getName() + " : " + locationParser.parsing(car.getLocation()) + "\n")
                .collect(Collectors.joining());
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
                .filter(car -> car.getLocation() == maxLocation)
                .map(Car::getName)
                .collect(Collectors.joining(", "));
    }
}
