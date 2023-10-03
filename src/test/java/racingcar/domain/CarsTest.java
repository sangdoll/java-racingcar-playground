package racingcar.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CarsTest {
    Cars cars;

    @BeforeEach
    void setUp() {
        String names = "sang,doll,sujin";
        cars = Cars.from(names);
    }

    @DisplayName("입력이 주어졌을 때, 모든 차량을 정상적으로 전진시키는지 확인합니다.")
    @Test
    void moveAllCars_WithValidInput_MoveCorrectly() {
        // 각 차량을 1번, 0번, 1번 전진시킴
        cars.moveAllCars(List.of(5, 3, 7));

        assertThat(cars.getCarList()).extracting(Car::getLocation).containsOnly(1, 0, 1);
    }

    @DisplayName("차량을 전진시킨 뒤, 결과를 정상적으로 얻어내는지 확인합니다.")
    @Test
    void getResult_AfterAllCarMoves_isCorrectResult() {
        // 모든 차량을 총 2칸 전진시킴
        cars.moveAllCars(List.of(1, 5, 6));
        cars.moveAllCars(List.of(7, 2, 8));
        cars.moveAllCars(List.of(4, 9, 3));

        // 결과 출력이 정확히 되는지 확인
        assertThat(cars.getPrintResult()).isEqualTo("sang : --\ndoll : --\nsujin : --\n");
    }

    @DisplayName("차량을 전진시킨 뒤, 최대 전진 횟수를 정확히 구하는지 확인합니다.")
    @Test
    void getMaxLocation_AfterAllCarMoves_isCorrectResult() {
        // 첫번째 차량만 3칸, 나머지는 2칸씩 전진시킴
        cars.moveAllCars(List.of(9, 4, 5));
        cars.moveAllCars(List.of(9, 1, 4));
        cars.moveAllCars(List.of(9, 4, 3));

        // 최대 전진횟수가 3인지를 확인함
        assertThat(cars.getMaxLocation()).isEqualTo(3);
    }

    @DisplayName("차량을 전진시킨 뒤, 가장 많이 전진한 차량 이름을 정확하게 구하는지 확인합니다.")
    @Test
    void getMaxLocationCarsName_AfterAllCarMoves_isCorrectResult() {
        // 첫 번째 차량과 세 번째 차량은 5칸, 두 번째 차량은 2칸을 이동시킴
        cars.moveAllCars(List.of(9, 5, 4));
        cars.moveAllCars(List.of(5, 3, 4));
        cars.moveAllCars(List.of(4, 1, 4));
        cars.moveAllCars(List.of(5, 0, 4));
        cars.moveAllCars(List.of(5, 9, 9));

        // 가장 많이 전진한 차량 이름이 첫 번째와 세 번째 차량의 이름인지를 확인함
        assertThat(cars.getMaxLocationCarsName()).isEqualTo("sang, sujin");
    }
}
