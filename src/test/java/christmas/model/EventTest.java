package christmas.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class EventTest {
    Event event = new Event();
    
    @DisplayName("증정 메뉴 가격 조건 테스트")
    @Test
    void 증정메뉴_가격조건() {
        String gift = event.getGiftMenu(119000);
        Assertions.assertEquals(gift,"없음");
    }

    @DisplayName("크리스마스 디데이 이벤트 테스트")
    @Test
    void 디데이_테스트() {
        String gift = event.getGiftMenu(119000);
        Assertions.assertEquals(gift,"없음");
    }
}