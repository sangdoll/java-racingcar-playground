package racingcar.util;

import racingcar.domain.Car;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class NamesToCarListParserTest {
	@DisplayName("이름이 정상적으로 입력되었을 때, 차량 리스트를 정상적으로 만드는지 확인합니다.")
	@Test
	void parseToCars_WithValidInput_MakeCorrectCarList() {
		String names = "sang,doll,sujin";
		assertThat(NamesToCarListParser.parseToCars(names)).extracting(Car::getName)
			.containsOnly("sang", "doll", "sujin");
	}

	@DisplayName("쉼표가 아닌 구분자가 주어졌을 때, 에러를 발생시키는지 확인합니다.")
	@Test
	void parseToCars_WithInvalidInput_ThrowsException() {
		String names = "sang:doll:sujin";
		assertThatThrownBy(() -> NamesToCarListParser.parseToCars(names)).isInstanceOf(IllegalArgumentException.class)
			.hasMessage("[ERROR] 유효하지 않은 입력입니다.");
	}
}