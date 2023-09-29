package racingcar.domain;

import java.util.Objects;

public final class CarName {
	private static final int MAX_LENGTH = 5;
	private final String name;

	private CarName(String name) {
		if (isExceedLength(name)) {
			throw new IllegalArgumentException("[ERROR] 차량 이름은 5글자를 초과할 수 없습니다.");
		}
		if (name.isBlank()) {
			throw new IllegalArgumentException("[ERROR] 빈 값은 사용될 수 없습니다.");
		}
		this.name = name;
	}

	public static CarName of(String name) {
		return new CarName(name);
	}

	private boolean isExceedLength(String name) {
		return name.length() > MAX_LENGTH;
	}

	public String getName() {
		return name;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		CarName carName = (CarName)o;
		return Objects.equals(name, carName.name);
	}

	@Override
	public int hashCode() {
		return Objects.hash(name);
	}
}
