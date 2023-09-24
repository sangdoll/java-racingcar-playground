package racingcar.domain;

public class Car {
    private final CarName name;
    private final CarLocation location;

    public Car(String name) {
        this.name = new CarName(name);
        this.location = new CarLocation(0);
    }

    public void move(int number) {
        location.increaseLocation(number);
    }

    public String getName() {
        return name.getName();
    }

    public int getLocation() {
        return location.getLocation();
    }
}
