package christmas.model;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Event {
    private static final String DEFAULT = "없음";
    private static final String GIFT_MENU = "샴페인 1개";
    private static final int PRICE_FOR_GIFT = 120000;
    private static final int CHRISTMAS_DEFALT_DISCOUNT = 1000;
    private static final int CHRISTMAS_DATE = 25;
    private List<Integer> weekend;
    private List<Integer> weekday;
    private List<Integer> starday;
    private List<String> benefits;
    private boolean gift;
    DecimalFormat df = new DecimalFormat("###,###");

    public Event() {
        weekend = Arrays.asList(1,2,8,9,15,16,22,23,29,30);
        weekday = new ArrayList<>();
        setWeekday();
        starday = Arrays.asList(3,10,17,24,25,31);
        benefits = new ArrayList<>();
        gift = false;
    }

    public String getGiftMenu(final int priceBeforeDiscount) {
        String gift = DEFAULT;
        if (priceBeforeDiscount > PRICE_FOR_GIFT) {
            gift = GIFT_MENU;
            this.gift = true;
        }
        return gift;
    }

    private void setWeekday() {
        for (int date = 1; date <= 31; date++) {
            if (!weekend.contains(date)) {
                weekday.add(date);
            }
        }
    }

    public List<String> getBenefits() {

    }

    public int christmasDiscount(int date) {
        int discount = 0;
        if (date <= CHRISTMAS_DATE) {
            discount = (date-1) * 100 +CHRISTMAS_DEFALT_DISCOUNT;
            benefits.add(String.format("크리스마스 디데이 할인: -%s원",df.format(discount)));
        }
        return discount;
    }

    public int calculateTotalDiscount() {
        int total = 0;

        return total;
    }
}
