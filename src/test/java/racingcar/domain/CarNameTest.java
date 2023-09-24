package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CarNameTest {
    @DisplayName("정상적인 입력을 넣었을 때, 예외를 발생시키지 않는지 확인합니다.")
    @Test
    void constructor_WithValidInput() {
        String name = "abcde";
        assertThatCode(() -> new CarName(name)).doesNotThrowAnyException();
    }

    @DisplayName("5글자를 초과하는 이름을 넣었을 때, 예외를 발생시키는지 확인합니다.")
    @Test
    void constructor_WithInValidInput_ThrowException() {
        String name = "abcdef";
        assertThatThrownBy(() -> new CarName(name))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }
}
