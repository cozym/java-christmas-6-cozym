package christmas.controller;

import christmas.model.Date;
import christmas.model.Event;
import christmas.model.Order;
import christmas.view.InputView;
import christmas.view.OutputView;

public class ChristmasController {
    private Date date;
    private Order order;
    private Event event;

    public void start() {
        InputView.printStart();

        inputDate();

        inputOrder();

        benefitPreviewStart();

        benefitInfo();
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

    public void benefitPreviewStart() {
        event = new Event();
        OutputView.startPrintEvent(date);
        OutputView.printOrderMenu(order.getOrder());
        OutputView.printPriceBeforeDiscount(order);
        checkGiftMenu();
    }

    public void benefitInfo() {
        int totalDiscountPrice = calculateTotalDiscount();
        OutputView.printBenefit(event);
    }

    public void checkGiftMenu() {
        OutputView.printGiftMenu(event.getGiftMenu(order.priceBeforeDiscount()));
    }

    public int calculateTotalDiscount() {
        int total = 0, visitDate = date.getDate();
        event.christmasDiscount(visitDate);
        event.weekdayDiscount(visitDate,order);
        event.weekendDiscount(visitDate,order);
        event.specialDiscount(visitDate);
        event.giftDiscount();
        return total;
    }
}
