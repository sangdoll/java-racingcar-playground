package racingcar.domain;

public class CarLocation {
    private static final int THRESHOLD_FOR_MOVE = 4;
    private static final int MOVE_UNIT = 1;
    private final int location;

    public CarLocation() {
        this(0);
    }

    public CarLocation(int location) {
        this.location = location;
    }

    public void increaseLocation(int number) {
        if (isIncreasable(number)) {
            location += MOVE_UNIT;
        }
    }

    private boolean isIncreasable(int number) {
        return number >= THRESHOLD_FOR_MOVE;
    }

    public int getLocation() {
        return location;
    }
}
