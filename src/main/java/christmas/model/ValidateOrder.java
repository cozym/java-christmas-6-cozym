package christmas.model;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class ValidateOrder {
    private static final String BEVERAGE = "Beverage";
    private static final int MIN_ORDER = 1;
    private boolean onlyBeverage;

    public ValidateOrder(final boolean onlyBeverage) {
        this.onlyBeverage = onlyBeverage;
    }

    public List<String> removeBlankAndSplit(final String input) {
        return Arrays.asList(input.replace(" ","").split(","));
    }

    public String checkHyphen(final String menuNum) throws IllegalArgumentException {
        if (!menuNum.contains("-")) {
            throw new IllegalArgumentException(ErrorMessage.invalidOrder());
        }
        return menuNum;
    }

    public int checkNumber(String num) throws IllegalArgumentException {
        try {
            int menuNum = Integer.parseInt(num);
            checkRange(menuNum);
            return menuNum;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.invalidOrder());
        }
    }

    private void checkRange(int num) throws IllegalArgumentException {
        if (num < MIN_ORDER ) {
            throw new IllegalArgumentException(ErrorMessage.invalidOrder());
        }
    }

    public void checkContain(final String name) throws IllegalArgumentException {
        boolean include = false;
        for (Menus menu : Menus.values()) {
            if(name.equals(menu.getName())) {
                include = true;

                break;
            }
        }
        if (!include) {
            throw new IllegalArgumentException(ErrorMessage.invalidOrder());
        }
    }

    public void checkOverlap(final String name, HashMap<String,Integer> order) throws IllegalArgumentException {
        if(order.containsKey(name)) {
            throw new IllegalArgumentException(ErrorMessage.invalidOrder());
        }
    }

    public void checkOnlyBeverage(Menus menu) {
        if (!menu.getClassification().equals(BEVERAGE)) {
            this.onlyBeverage = false;
        }
    }

    public void onlyBeverage() throws IllegalArgumentException {
        if (onlyBeverage) {
            throw new IllegalArgumentException(ErrorMessage.impossibleOnlyBeverage());
        }
    }
}
