package racingcar.domain;

import java.util.Objects;

public final class CarLocation {
	private static final int MIN_NUMBER = 0;
	private static final int MAX_NUMBER = 9;
	private static final int MIN_FOR_MOVE = 4;
	private static final int MOVE_UNIT = 1;
	private final int location;

	private CarLocation(int location) {
		this.location = location;
	}

	public static CarLocation from(int location) {
		return new CarLocation(location);
	}

	public CarLocation increaseLocation(int number) {
		if (number < MIN_NUMBER || number > MAX_NUMBER) {
			throw new IllegalArgumentException("[ERROR] 숫자는 0부터 9까지만 가능합니다.");
		}
		if (number >= MIN_FOR_MOVE) {
			return CarLocation.from(location + MOVE_UNIT);
		}
		return CarLocation.from(location);
	}

	public int getLocation() {
		return location;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		CarLocation that = (CarLocation)o;
		return location == that.location;
	}

	@Override
	public int hashCode() {
		return Objects.hash(location);
	}
}
