package christmas.controller;

import christmas.model.Date;
import christmas.model.Order;
import christmas.view.InputView;

public class ChristmasController {
    private Date date;
    private Order order;

    public void start() {
        InputView.printStart();

        inputDate();

        inputOrder();
    }

    public void inputDate() {
        try {
            date = new Date(InputView.readDate());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            inputDate();
        }
    }

    public void inputOrder() {
        try {
            order = new Order(InputView.readOrder());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            inputOrder();
        }
    }
}
