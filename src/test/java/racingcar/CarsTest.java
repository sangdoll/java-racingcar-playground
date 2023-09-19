package racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import racingcar.domain.Cars;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CarsTest {
    String names;

    @BeforeEach
    void setUp() {
        names = "sangd,sangh,sangj";
    }

    @DisplayName("참여자들의 이름 문자열이 주어졌을 때, 이를 Car 객체의 리스트로 잘 매핑하는지 확인합니다.")
    @Test
    void makeStringsToCars_WithValidNames_MapsToCarList() {
        List<Car> carList = new Cars(names).getCarList();

        assertThat(carList).extracting(Car::getName)
                .containsExactly("sangd", "sangh", "sangj");
    }

    @DisplayName("입력이 주어졌을 때, 승자를 잘 가려내는지 확인합니다.")
    @Test
    void getWinners_AfterGameComplete_CorrectWinners() {
        Cars cars = new Cars("sangd,sangh,sangj");
        // 모든 차를 1칸씩 전진시킴
        cars.getCarList().forEach(car -> car.move(5));
        assertThat(cars.getWinningCarNames()).contains("sangd, sangh, sangj");
    }

    @DisplayName("최대 전진 횟수를 정확하게 리턴하는지 확인합니다.")
    @Test
    void getMaxMove_AfterCarsMove_CorrectMaxMove() {
        Cars cars = new Cars("sangd,sangh,sangj");
        // 모든 차를 1칸씩 전진시킴
        cars.getCarList().forEach(car -> car.move(5));
        assertThat(cars.getMaxMove()).isEqualTo(1);
    }
}
