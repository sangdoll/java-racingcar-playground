package racingcar.domain;

import java.util.Random;

public class Car {
    private static final int THRESHOLD = 4;
    private static final int MAX = 10;
    private final CarName name;
    private final CarLocation carLocation;

    public Car(String name) {
        this.name = new CarName(name);
        this.carLocation = new CarLocation();
    }

    public String getName() {
        return name.getName();
    }

    public void play() {
        int randomNumber = generateRandomValue();
        move(randomNumber);
    }

    private int generateRandomValue() {
        return new Random().nextInt(MAX);
    }

    public void move(int number) {
        validateNumber(number);
        if (isGreaterThanThreshold(number)) {
            carLocation.moveForward();
        }
    }

    private void validateNumber(int number) {
        if (isNotValidNumber(number)) {
            throw new IllegalArgumentException("[ERROR] 숫자 범위는 0부터 9까지만 가능합니다.");
        }
    }

    private boolean isNotValidNumber(int number) {
        return number < 0 || number > 9;
    }

    private boolean isGreaterThanThreshold(int number) {
        return number >= THRESHOLD;
    }

    public int getTotalMove() {
        return carLocation.getTotalMove();
    }

    public String getLocation() {
        return carLocation.getCurrentLocation();
    }
}
