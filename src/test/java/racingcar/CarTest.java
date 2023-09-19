package racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CarTest {
    Car car;

    @BeforeEach
    void setUp() {
        car = new Car("sangd");
    }

    @DisplayName("4 이상의 수를 넣었을 때 전진하는지 확인합니다.")
    @Test
    void move_WithValidNumber_CarMovesCorrectly() {
        int[] numbers = {1, 5, 3, 4, 7};
        // 지정한 횟수만큼 차를 이동함.
        for (int i = 0; i < 5; i++) {
            car.move(numbers[i]);
        }
        assertThat(car.getLocation()).isEqualTo("---");
    }

    @DisplayName("0부터 9 이외의 숫자를 넣었을 때, 예외를 발생시키는지 확인합니다.")
    @Test
    void move_WithInValidNumber_ThrowsException() {
        int number = 10;
        assertThatThrownBy(() -> car.move(number))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 숫자 범위는 0부터 9까지만 가능합니다.");
    }
}
