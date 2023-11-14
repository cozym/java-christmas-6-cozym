package christmas.model;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class OrderTest {
    @DisplayName("공백 제거 및 컴마 기준 스플릿 테스트")
    @Test
    void 공백제거_컴마스플릿() {
        ValidateOrder validateOrder = new ValidateOrder(true);
        List<String> afterCheck = Arrays.asList("타파스-1,제로콜라-1".split(","));
        Assertions.assertEquals(afterCheck,validateOrder.removeBlankAndSplit(" 타파스-1, 제로콜라-1"));
    }

    @DisplayName("-이 존재하지 않는다면 예외처리")
    @Test
    void 하이픈_유무검사() {
        assertThatThrownBy(() -> new Order("타파스1,제로콜라2"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("유효하지 않은 주문입니다");
    }

    @DisplayName("메뉴 개수가 1 이상의 숫자가 아닐 경우 예외처리")
    @ValueSource(strings = {"0","-1","c"})
    @ParameterizedTest
    void 메뉴_개수검사(String orderNum) {
        assertThatThrownBy(() -> new ValidateOrder(true).checkNumber(orderNum))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("유효하지 않은 주문입니다");
    }

    @DisplayName("메뉴판에 없는 메뉴를 입력하거나 중복 메뉴를 입력한 경우 예외처리")
    @ValueSource(strings = {"엽기떡볶이-1,제로콜라-1","타파스-1,타파스-2"})
    @ParameterizedTest
    void 메뉴_유효성검사(String order) {
        assertThatThrownBy(() -> new Order(order))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("유효하지 않은 주문입니다");
    }
}