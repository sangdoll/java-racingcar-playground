package racingcar;

import static org.assertj.core.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ApplicationTest {
	InputStream in;
	OutputStream out;

	@BeforeEach
	void setUp() {
		String input = "pobi,crong,honux\n10";
		in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);

		out = new ByteArrayOutputStream();
		System.setOut(new PrintStream(out));
	}

	@DisplayName("어플리케이션이 정상적으로 동작하는지 확인합니다.")
	@Test
	void main_WithValidInput_PrintResultCorrectly() {
		Application.main(new String[] {});

		assertThat(out.toString()).contains("경주할 자동차 이름", "시도할 횟수",
			"최종 우승", "pobi", "crong", "honux");
	}
}