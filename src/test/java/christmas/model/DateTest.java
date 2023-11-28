package christmas.model;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class DateTest {
    @DisplayName("1~31 숫자가 아닌 경우 예외처리")
    @ValueSource(strings = {"0","32","a"})
    @ParameterizedTest
    void 날짜_유효성검사(String date) {
        assertThatThrownBy(() -> new Date(date))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("유효하지 않은 날짜입니다");
    }
}