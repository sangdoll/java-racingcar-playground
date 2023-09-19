package racingcar.domain;

import java.util.*;
import java.util.stream.Collectors;

public class Cars {
    private final List<Car> carList;

    public Cars(String names) {
        this.carList = mapNamesToCars(names);
    }

    private List<Car> mapNamesToCars(String names) {
        return Arrays.stream(names.split(","))
                .map(Car::new)
                .collect(Collectors.toList());
    }

    public List<Car> getCarList() {
        return carList;
    }

    public void moveAllCars() {
        carList.forEach(Car::play);
    }

    public Set<Map.Entry<String, String>> getRoundResult() {
        Map<String, String> result = new HashMap<>();
        carList.forEach(car -> result.put(car.getName(), car.getLocation()));
        return result.entrySet();
    }

    public int getMaxMove() {
        return carList.stream()
                .map(Car::getLocation)
                .mapToInt(String::length)
                .max()
                .orElse(0);
    }

    public String getWinningCarNames() {
        int maxMove = getMaxMove();
        return carList.stream()
                .filter(car -> car.getTotalMove() == maxMove)
                .map(Car::getName)
                .collect(Collectors.joining(", "));
    }
}
