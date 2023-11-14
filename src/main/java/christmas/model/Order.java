package christmas.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Order {
    private static final int MIN_ORDER = 1;
    private ValidateOrder validateOrder;
    private HashMap<String,Integer> order;

    public Order(final String input) throws IllegalArgumentException {
        validateOrder = new ValidateOrder(true);
        order = new HashMap<>();
        List<String> menuWithNum = new ArrayList<>(validateOrder.removeBlankAndSplit(input));
        validateOrder(menuWithNum);
        validateOrder.onlyBeverage();
    }

    public void validateOrder(final List<String> menuWithNum) throws IllegalArgumentException {
        String[] splitHyphen;
        for (String menuNum : menuWithNum) {
            splitHyphen = validateOrder.checkHyphen(menuNum).split("-");
            validateOrder.checkContain(splitHyphen[0]);
            validateOrder.checkOverlap(splitHyphen[0],order);
            order.put(splitHyphen[0],validateOrder.checkNumber(splitHyphen[1]));
        }
    }



}
