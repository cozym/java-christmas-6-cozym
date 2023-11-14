package christmas.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Menus {
    private static final int MIN_ORDER = 1;
    private ValidateOrder validateOrder;
    private HashMap<String,Integer> menus;

    public Menus(final String input) {
        validateOrder = new ValidateOrder();
        menus = new HashMap<>();
        List<String> menuWithNum = new ArrayList<>(validateOrder.removeBlankAndSplit(input));
        validateOrder(menuWithNum);
    }

    public void validateOrder(final List<String> menuWithNum) throws IllegalArgumentException {
        String[] splitHyphen;
        for (String menuNum : menuWithNum) {
            splitHyphen = validateOrder.checkHyphen(menuNum).split("-");
            menus.put(splitHyphen[0],Integer.parseInt(splitHyphen[1]));
        }
    }


}
