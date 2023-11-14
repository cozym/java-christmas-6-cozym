package christmas.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private static final String START_MESSAGE = "안녕하세요! 우테코 식당 12월 이벤트 플래너입니다.";
    private static final String DATE_INPUT_MESSAGE = "12월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)";

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

}
