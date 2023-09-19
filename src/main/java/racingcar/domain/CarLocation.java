package racingcar.domain;

public class CarLocation {
    private static final String UNIT = "-";
    private final StringBuilder currentLocation;

    public CarLocation() {
        this.currentLocation = new StringBuilder();
    }

    public void moveForward() {
        currentLocation.append(UNIT);
    }

    public String getCurrentLocation() {
        return currentLocation.toString();
    }

    public int getTotalMove() {
        return currentLocation.length();
    }
}
