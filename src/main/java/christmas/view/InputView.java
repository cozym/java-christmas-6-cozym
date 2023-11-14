package christmas.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private static final String START_MESSAGE = "안녕하세요! 우테코 식당 12월 이벤트 플래너입니다.";
    private static final String DATE_INPUT_MESSAGE = "12월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)";
    private static final String MENU_INPUT_MESSAGE = "주문하실 메뉴와 개수를 알려 주세요. (e.g. 해산물파스타-2,레드와인-1,초코케이크-1)";

    public static void printEmptyLine() {
        System.out.println();
    }

    public static void printStart() {
        System.out.println(START_MESSAGE);
    }

    public static String readDate() {
        System.out.println(DATE_INPUT_MESSAGE);
        return Console.readLine();
    }

    public static String readMenu() {
        System.out.println(MENU_INPUT_MESSAGE);
        return Console.readLine();
    }
}
