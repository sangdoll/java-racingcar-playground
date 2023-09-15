package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringAddCalculatorTest {

    @Test
    public void splitAndSum_null_또는_빈문자() {
        int result = StringAddCalculator.splitAndSum(null);
        assertThat(result).isEqualTo(0);

        result = StringAddCalculator.splitAndSum("");
        assertThat(result).isEqualTo(0);
    }

    @Test
    public void splitAndSum_숫자하나() throws Exception {
        int result = StringAddCalculator.splitAndSum("1");
        assertThat(result).isEqualTo(1);
    }

    @Test
    public void splitAndSum_쉼표구분자() throws Exception {
        int result = StringAddCalculator.splitAndSum("1,2");
        assertThat(result).isEqualTo(3);
    }

    @Test
    public void splitAndSum_쉼표_또는_콜론_구분자() throws Exception {
        int result = StringAddCalculator.splitAndSum("1,2:3");
        assertThat(result).isEqualTo(6);
    }

    @Test
    public void splitAndSum_custom_구분자() throws Exception {
        int result = StringAddCalculator.splitAndSum("//;\n1;2;3");
        assertThat(result).isEqualTo(6);
    }

    @Test
    public void splitAndSum_negative() throws Exception {
        assertThatThrownBy(() -> StringAddCalculator.splitAndSum("-1,2,3"))
                .isInstanceOf(RuntimeException.class);
    }

    @DisplayName("음수가 존재할 때, 예외를 잘 발생시키는지를 확인합니다.")
    @Test
    public void getSum_canThrowException() throws Exception {
        assertThatThrownBy(() -> StringAddCalculator.getSum(new String[] {"1","-1","2"}))
                .isInstanceOf(RuntimeException.class);
    }

    @DisplayName("조건을 만족할 때, 정확한 합을 구하는지 확인합니다.")
    @Test
    public void getSum_canGetValidateSum() throws Exception {
        assertThat(StringAddCalculator.getSum(new String[] {"1","2","3"}))
                .isEqualTo(6);
    }

    @DisplayName("여러 문자열을 넣었을 때, 파싱이 정확히 이루어지는지를 확인합니다.")
    @Test
    public void parser() {
        assertThat(StringAddCalculator.textParser("1")).containsExactly("1");
        assertThat(StringAddCalculator.textParser("//;\n1;2;3")).containsExactly("1","2","3");
        assertThat(StringAddCalculator.textParser("1,2,3:4,5:6")).containsExactly("1","2","3","4","5","6");
    }
}
