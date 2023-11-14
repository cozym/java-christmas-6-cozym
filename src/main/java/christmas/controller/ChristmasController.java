package christmas.controller;

import christmas.model.Date;
import christmas.view.InputView;

public class ChristmasController {
    private Date date;

    public void start() {
        InputView.printStart();

        inputDate();
    }

    public void inputDate() {
        try {
            date = new Date(InputView.readDate());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            inputDate();
        }
    }
}
