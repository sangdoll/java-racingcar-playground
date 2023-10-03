package racingcar.domain;

import java.util.Objects;

public final class Car {
	private final CarName name;
	private CarLocation location;

	public static Car from(String name) {
		return new Car(name);
	}

	private Car(String name) {
		this.name = CarName.from(name);
		this.location = CarLocation.from(0);
	}

	public void move(int number) {
		this.location = location.increaseLocation(number);
	}

	public String getName() {
		return name.getName();
	}

	public int getLocation() {
		return location.getLocation();
	}

	public boolean isSameLocation(int location) {
		return location == getLocation();
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Car car = (Car)o;
		return Objects.equals(name, car.name) && Objects.equals(location, car.location);
	}

	@Override
	public int hashCode() {
		return Objects.hash(name, location);
	}
}
