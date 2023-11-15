package christmas.model;

public class Event {
    private static final String DEFAULT = "없음";
    private static final String GIFT_MENU = "샴페인 1개";
    private static final int PRICE_FOR_GIFT = 120000;

    public String getGiftMenu(final int priceBeforeDiscount) {
        String gift = DEFAULT;
        if (priceBeforeDiscount > PRICE_FOR_GIFT) {
            gift = GIFT_MENU;
        }
        return gift;
    }
}
