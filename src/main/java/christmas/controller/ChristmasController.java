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
        OutputView.printPriceBeforeDiscount(order.priceBeforeDiscount());
        checkGiftMenu();
    }

    public void benefitInfo() {
        event.applyDiscounts(date.getDate(),order);
        OutputView.printBenefit(event);
        OutputView.printTotalBenefitPrice(event.getTotalDiscount());
        OutputView.printPriceAfterDiscount(order.priceBeforeDiscount(),event.getDirectDiscount());
        OutputView.printEventBadge(event.getEventBadge());
    }

    public void checkGiftMenu() {
        OutputView.printGiftMenu(event.getGiftMenu(order.priceBeforeDiscount()));
    }

}
