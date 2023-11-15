package christmas.view;

import christmas.model.Date;

public class OutputView {


    public static void printEmptyLine() {
        System.out.println();
    }

    public static void startPrintEvent(Date date) {
        System.out.printf("12월 %d일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!",date.getDate());
        printEmptyLine();
    }


}
