package racingcar.domain;

import java.util.Objects;

public final class CarLocation {
    private static final int THRESHOLD_FOR_MOVE = 4;
    private static final int MOVE_UNIT = 1;
    private final int location;

    public static CarLocation of(int location) {
        return new CarLocation(location);
    }

    private CarLocation(int location) {
        this.location = location;
    }


    public CarLocation increaseLocation(int number) {
        if (number < 0 || number > 9) {
            throw new IllegalArgumentException("[ERROR] 숫자는 0부터 9까지만 가능합니다.");
        }
        if (isIncreasable(number)) {
            return CarLocation.of(location + MOVE_UNIT);
        }
        return CarLocation.of(location);
    }

    private boolean isIncreasable(int number) {
        return number >= THRESHOLD_FOR_MOVE;
    }

    public int getLocation() {
        return location;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CarLocation that = (CarLocation) o;
        return location == that.location;
    }

    @Override
    public int hashCode() {
        return Objects.hash(location);
    }
}
