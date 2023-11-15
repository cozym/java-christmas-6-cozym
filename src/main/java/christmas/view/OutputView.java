package christmas.view;

import christmas.model.Date;
import java.util.HashMap;

public class OutputView {
    private static final String ORDER_MENU = "<주문 메뉴>";


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
            System.out.printf("%s %d개",name,price);
            printEmptyLine();
        });
    }
}
