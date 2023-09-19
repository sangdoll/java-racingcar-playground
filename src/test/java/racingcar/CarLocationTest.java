package racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.CarLocation;

import static org.assertj.core.api.Assertions.assertThat;

public class CarLocationTest {
    CarLocation location;

    @BeforeEach
    void setUp() {
        location = new CarLocation();
    }

    @DisplayName("위치를 전진시키고, 이동한 거리를 잘 출력하는지 확인합니다.")
    @Test
    void moveForward_MoveMultipleTimes_CorrectLocation() {
        for (int i = 0; i < 10; i++) {
            location.moveForward();
        }
        assertThat(location.getTotalMove()).isEqualTo(10);
        assertThat(location.getCurrentLocation()).isEqualTo("----------");
    }
}
