package christmas.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Order {
    private ValidateOrder validateOrder;
    private HashMap<String,Integer> order;

    public Order(final String input) throws IllegalArgumentException {
        validateOrder = new ValidateOrder(true);
        order = new HashMap<>();
        List<String> menuWithNum = new ArrayList<>(validateOrder.removeBlankAndSplit(input));
        validateOrder(menuWithNum);
        validateOrder.onlyBeverage();
        validateOrder.checkMaxOrderNum(order);
    }

    private void validateOrder(final List<String> menuWithNum) throws IllegalArgumentException {
        String[] splitHyphen;
        for (String menuNum : menuWithNum) {
            splitHyphen = validateOrder.checkHyphen(menuNum).split("-");
            validateOrder.checkContain(splitHyphen[0]);
            validateOrder.checkOverlap(splitHyphen[0],order);
            order.put(splitHyphen[0],validateOrder.checkNumber(splitHyphen[1]));
        }
    }

    public int priceBeforeDiscount() {
        int priceSum = 0;
        for (String name : order.keySet()) {
            priceSum += getMenuPrice(name) * order.get(name); // 메뉴 가격 * 메뉴 개수
        }
        return priceSum;
    }

    private int getMenuPrice(String name) {
        int price = 0;
        for (Menus menu : Menus.values()) {
            if(name.equals(menu.getName())) {
                price = menu.getPrice();
            }
        }
        return price;
    }

    public int getClassificationNum(String classification) {
        int num = 0;
        for (String name : order.keySet()) {
            if (isClassification(name,classification)) {
                num += order.get(name);
            }
        }
        return num;
    }

    private boolean isClassification(String menuName , String classification) {
        boolean match = false;
        for (Menus menu : Menus.values()) {
            if(menuName.equals(menu.getName()) && classification.equals(menu.getClassification())) {
                match = true;
            }
        }
        return match;
    }

    public HashMap<String,Integer> getOrder() {
        return order;
    }
}
