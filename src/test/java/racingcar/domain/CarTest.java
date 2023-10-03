package racingcar.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CarTest {
	Car car;

	@BeforeEach
	void setUp() {
		car = Car.from("jin");
	}

	@DisplayName("0 미만의 숫자를 넣었을 때 오류를 발생시키는지 확인합니다.")
	@Test
	void move_WithNumberLessThan0_ThrowsException() {
		assertThatThrownBy(() -> car.move(-1))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessageContaining("[ERROR]");
	}

	@DisplayName("9를 초과하는 숫자를 넣었을 때 오류를 발생시키는지 확인합니다.")
	@Test
	void move_WithNumberGreaterThan9_ThrowsException() {
		assertThatThrownBy(() -> car.move(10))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessageContaining("[ERROR]");
	}

	@DisplayName("4 이상의 숫자를 넣었을 때, 위치를 전진시키는지 확인합니다.")
	@ParameterizedTest
	@ValueSource(ints = {4, 5, 6, 7, 8, 9})
	void move_WithNumber4OrMore_MoveForward(int value) {
		// Given
		Car expected = Car.from("jin");
		expected.move(value);

		// When
		car.move(value);

		assertThat(car).isEqualTo(expected);
	}

	@DisplayName("4 미만의 숫자를 넣었을 때, 위치를 전진시키지 않는지를 확인합니다.")
	@ParameterizedTest
	@ValueSource(ints = {1, 2, 3, 4})
	void move_WithNumberLessThan4_DontMove(int value) {
		// Given
		Car expected = Car.from("jin");
		expected.move(value);

		// When
		car.move(value);

		assertThat(car).isEqualTo(expected);
	}
}
