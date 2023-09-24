package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class CarNameTest {
    @DisplayName("정상적인 입력을 넣었을 때, 예외를 발생시키지 않는지 확인합니다.")
    @Test
    void constructor_WithValidInput() {
        String name = "abcde";
        assertThatCode(() -> CarName.of(name)).doesNotThrowAnyException();
    }

    @DisplayName("정상적인 입력을 넣었을 때, 올바른 객체를 생성하는지 확인합니다.")
    @Test
    void constructor_WithValidInput_MakeCorrectObject() {
        // Given
        String name = "sangJ";
        CarName expected = CarName.of(name);

        assertThat(CarName.of("sangJ")).isEqualTo(expected);
    }

    @DisplayName("5글자를 초과하는 이름을 넣었을 때, 예외를 발생시키는지 확인합니다.")
    @Test
    void constructor_WithInValidInput_ThrowException() {
        String name = "abcdef";
        assertThatThrownBy(() -> CarName.of(name))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }
}
