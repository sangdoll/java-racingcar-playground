package racingcar.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {
    Car car;

    @BeforeEach
    void setUp() {
        car = new Car("jin");
    }

    @DisplayName("4 이상의 숫자를 넣었을 때, 위치를 전진시키는지 확인합니다.")
    @Test
    void move_WithNumber4OrMore_MoveForward() {
        car.move(9);
        assertThat(car.getLocation()).isEqualTo(1);
    }

    @DisplayName("4 미만의 숫자를 넣었을 때, 위치를 전진시키는지 확인합니다.")
    @Test
    void move_WithNumberLessThan4_DontMove() {
        car.move(3);
        assertThat(car.getLocation()).isEqualTo(0);
    }
}
