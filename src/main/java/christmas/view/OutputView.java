package christmas.view;

import christmas.model.Date;
import christmas.model.Order;
import java.text.DecimalFormat;
import java.util.HashMap;

public class OutputView {
    private static final String ORDER_MENU = "<주문 메뉴>";
    private static final String BEFORE_DISCOUNT = "<할인 전 총주문 금액>";
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

    public static void printPriceBeforeDiscount(Order order) {
        printEmptyLine();
        System.out.println(BEFORE_DISCOUNT);
        System.out.printf("%s원",df.format(order.priceBeforeDiscount()));
        printEmptyLine();
    }
}
