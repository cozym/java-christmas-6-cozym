package christmas.model;

public class ErrorMessage {
    private static final String START_IN = "[ERROR] ";
    private static final String INVALID_DATE = "유효하지 않은 날짜입니다. 다시 입력해 주세요.";
    private static final String INVALID_ORDER = "유효하지 않은 주문입니다. 다시 입력해 주세요.";
    private static final String IMPOSSIBLE_ONLY_BEVERAGE = "음료만 주문 시, 주문할 수 없습니다.";

    public static String invalidDate() {
        return START_IN+INVALID_DATE;
    }

    public static String invalidOrder() {
        return START_IN+INVALID_ORDER;
    }

    public static String impossibleOnlyBeverage() {
        return START_IN+IMPOSSIBLE_ONLY_BEVERAGE;
    }

}
