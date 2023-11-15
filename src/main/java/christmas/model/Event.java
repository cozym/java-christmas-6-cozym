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
    private static final int CHAMPAGNE_PRICE = 25000;
    private static final int WEEK_DISCOUNT_PRICE = 2023;
    private static final int SPECIAL_DISCOUNT_PRICE = 1000;
    private List<Integer> weekend;
    private List<Integer> weekday;
    private List<Integer> specialday;
    private List<String> benefits;
    private boolean gift;
    private int totalDiscount;
    DecimalFormat df = new DecimalFormat("###,###");

    public Event() {
        weekend = Arrays.asList(1,2,8,9,15,16,22,23,29,30);
        weekday = new ArrayList<>();
        setWeekday();
        specialday = Arrays.asList(3,10,17,24,25,31);
        benefits = new ArrayList<>();
        gift = false;
        totalDiscount = 0;
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
        return this.benefits;
    }

    public int getTotalDiscount() {
        return this.totalDiscount;
    }

    public int christmasDiscount(int date) {
        int discount = 0;
        if (date <= CHRISTMAS_DATE) {
            discount = (date-1) * 100 +CHRISTMAS_DEFALT_DISCOUNT;
            benefits.add(String.format("크리스마스 디데이 할인: -%s원",df.format(discount)));
            totalDiscount += discount;
        }
        return discount;
    }

    public int giftDiscount() {
        int discount = 0;
        if (gift) {
            discount += CHAMPAGNE_PRICE;
            benefits.add(String.format("증정 이벤트: -%s원",df.format(discount)));
            totalDiscount += discount;
        }
        return discount;
    }

    public int weekdayDiscount(int date, Order order) {
        int discount = 0;
        if (weekday.contains(date)) {
            discount = order.getClassificationNum("Dessert") * WEEK_DISCOUNT_PRICE;
            benefits.add(String.format("평일 할인: -%s원",df.format(discount)));
            totalDiscount += discount;
        }
        return discount;
    }

    public int weekendDiscount(int date, Order order) {
        int discount = 0;
        if (weekend.contains(date)) {
            discount = order.getClassificationNum("MainDish") * WEEK_DISCOUNT_PRICE;
            benefits.add(String.format("주말 할인: -%s원",df.format(discount)));
            totalDiscount += discount;
        }
        return discount;
    }

    public int specialDiscount(int date) {
        int discount = 0;
        if (specialday.contains(date)) {
            discount += SPECIAL_DISCOUNT_PRICE;
            benefits.add(String.format("특별 할인: -%s원",df.format(discount)));
            totalDiscount += discount;
        }
        return discount;
    }

    public void applyDiscounts(int visitDate, Order order) {
        christmasDiscount(visitDate);
        weekdayDiscount(visitDate,order);
        weekendDiscount(visitDate,order);
        specialDiscount(visitDate);
        giftDiscount();
    }
}
