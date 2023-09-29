package racingcar.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LocationParserTest {
	@DisplayName("입력을 정상적으로 변환하는지 확인합니다.")
	@Test
	void parsing_WithValidInput_ParseCorrectly() {
		LocationParser parser = new LocationParser();
		assertThat(parser.parsing(10)).isEqualTo("----------");
	}
}