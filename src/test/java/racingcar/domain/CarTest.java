package racingcar.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CarTest {
	Car car;

	@BeforeEach
	void setUp() {
		car = Car.of("jin");
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
	@Test
	void move_WithNumber4OrMore_MoveForward() {
		// Given
		Car expected = Car.of("jin");
		expected.move(9);

		// When
		car.move(9);

		assertThat(car).isEqualTo(expected);
	}

	@DisplayName("4 미만의 숫자를 넣었을 때, 위치를 전진시키는지 확인합니다.")
	@Test
	void move_WithNumberLessThan4_DontMove() {
		// Given
		Car expected = Car.of("jin");
		expected.move(3);

		// When
		car.move(3);

		assertThat(car).isEqualTo(expected);
	}
}
