package christmas.view;

import christmas.model.Date;
import christmas.model.Event;
import java.text.DecimalFormat;
import java.util.HashMap;

public class OutputView {
    private static final String ORDER_MENU = "<주문 메뉴>";
    private static final String BEFORE_DISCOUNT = "<할인 전 총주문 금액>";
    private static final String GIFT_MENU = "<증정 메뉴>";
    private static final String BENEFIT = "<혜택 내역>";
    private static final String TOTAL_BENEFIT_PRICE = "<총혜택 금액>";
    private static final String PRICE_AFTER_DISCOUNT = "<할인 후 예상 결제 금액>";
    private static final String EVENT_BADGE_MESSAGE = "<12월 이벤트 배지>";
    private static final String NOTHING = "없음";
    private static final int ZERO = 0;
    private static final String DEFAULT_TOTAL_BENEFIT_PRICE = "0원";
    static DecimalFormat df = new DecimalFormat("###,###");


    public static void printEmptyLine() {
        System.out.println();
    }

    public static void startPrintEvent(Date date) {
        System.out.printf("12월 %d일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!",date.getDate());
        printEmptyLine();
    }

    public static void printOrderMenu(HashMap<String,Integer> order) {
        printEmptyLine();
        System.out.println(ORDER_MENU);
        order.forEach((name, price) -> {
            System.out.printf("%s %s개",name,df.format(price));
            printEmptyLine();
        });
    }

    public static void printPriceBeforeDiscount(int priceBeforeDiscount) {
        printEmptyLine();
        System.out.println(BEFORE_DISCOUNT);
        System.out.printf("%s원",df.format(priceBeforeDiscount));
        printEmptyLine();
    }

    public static void printGiftMenu(String giftMenu) {
        printEmptyLine();
        System.out.println(GIFT_MENU);
        System.out.println(giftMenu);
    }

    public static void printBenefit(Event event) {
        printEmptyLine();
        System.out.println(BENEFIT);
        if (event.getBenefits().isEmpty()) {
            System.out.println(NOTHING);
        }
        for (String benefit : event.getBenefits()) {
            System.out.println(benefit);
        }
    }

    public static void printTotalBenefitPrice(int totalDiscount) {
        String totalBenefitPrice = DEFAULT_TOTAL_BENEFIT_PRICE;
        printEmptyLine();
        System.out.println(TOTAL_BENEFIT_PRICE);
        if (totalDiscount != ZERO) {
            totalBenefitPrice = String.format("-%s원",df.format(totalDiscount));
        }
        System.out.println(totalBenefitPrice);
    }

    public static void printPriceAfterDiscount(int priceBeforeDiscount, int directDiscount) {
        printEmptyLine();
        System.out.println(PRICE_AFTER_DISCOUNT);
        System.out.printf("%s원",df.format(priceBeforeDiscount-directDiscount));
        printEmptyLine();
    }

    public static void printEventBadge(String badge) {
        printEmptyLine();
        System.out.println(EVENT_BADGE_MESSAGE);
        System.out.println(badge);
    }
}
