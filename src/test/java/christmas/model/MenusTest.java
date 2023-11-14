package christmas.model;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class MenusTest {
    @DisplayName("공백 제거 및 컴마 기준 스플릿 테스트")
    @Test
    void 공백제거_컴마스플릿() {
        Menus menus = new Menus("타파스-1,제로콜라-1");
        List<String> afterCheck = Arrays.asList("타파스-1,제로콜라-1".split(","));
        Assertions.assertEquals(afterCheck,menus.removeBlankAndSplit(" 타파스-1, 제로콜라-1"));
    }
}