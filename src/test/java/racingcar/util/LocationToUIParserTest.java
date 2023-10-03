package racingcar.util;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LocationToUIParserTest {
	@DisplayName("0 미만의 입력값이 들어왔을 때, 예외를 발생시키는지 확인합니다.")
	@Test
	void parse_WithInvalidInput_ThrowsException() {
		assertThatThrownBy(() -> LocationToUIParser.parse(-1))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessageContaining("[ERROR]");
	}

	@DisplayName("입력을 정상적으로 변환하는지 확인합니다.")
	@Test
	void parse_WithValidInput_ParseCorrectly() {
		String expected = "-".repeat(10);
		assertThat(LocationToUIParser.parse(10)).isEqualTo(expected);
	}
}