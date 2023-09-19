package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.CarName;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CarNameTest {
    @DisplayName("차량 이름이 유효한지 확인합니다.")
    @Test
    void carName_WithValidName_CreatesValidCarName() {
        String name = "abcde";
        assertThatCode(() -> new CarName(name)).doesNotThrowAnyException();
    }

    @DisplayName("차량 이름이 5글자를 초과했을 때, 예외를 발생시키는지 확인합니다.")
    @Test
    void carName_WithExceedingLength_ThrowsException() {
        String name = "abcdef";
        assertThatThrownBy(() -> new CarName(name)).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 차량 이름은 5글자까지만 허용됩니다.");
    }

    @DisplayName("차량 이름이 0글자일 때, 예외를 발생시키는지 확인합니다.")
    @Test
    void carName_WithNullOrEmptyName_ThrowsException() {
        String name = "";
        assertThatThrownBy(() -> new CarName(name)).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 차량 이름을 입력해주세요.");
    }
}
