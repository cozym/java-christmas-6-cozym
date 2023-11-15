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
    void 디데이할인_테스트() {
        Assertions.assertEquals(event.christmasDiscount(25),3400);
        Assertions.assertEquals(event.christmasDiscount(26),0);
    }

    @DisplayName("증정에 따라 할인가격이 정상적으로 반환되는지 확인")
    @Test
    void 증정할인_테스트() {
        event.getGiftMenu(1000);
        Assertions.assertEquals(event.giftDiscount(),0);
        event.getGiftMenu(120000);
        Assertions.assertEquals(event.giftDiscount(),25000);
    }

    @DisplayName("이벤트 참여 불가능할 경우 이벤트 뱃지 반환 테스트")
    @Test
    void 이벤트뱃지_테스트() {
        Order order = new Order("타파스-1");
        event.applyDiscounts(3,order);
        Assertions.assertEquals(event.getEventBadge(),"없음");
    }

    @DisplayName("특별할인 테스트")
    @Test
    void 특별할인_테스트() {
        Assertions.assertEquals(event.specialDiscount(25),1000);
        Assertions.assertEquals(event.specialDiscount(4),0);
    }

    @DisplayName("주말 할인 테스트")
    @Test
    void 주말할인_테스트() {
        Order order = new Order("티본스테이크-2");
        Assertions.assertEquals(event.weekendDiscount(1,order),4046);
        Assertions.assertEquals(event.specialDiscount(27),0);
    }
}