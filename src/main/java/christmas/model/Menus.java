package christmas.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Menus {
    private HashMap<String,Integer> menus;

    public Menus(final String input) {
        menus = new HashMap<>();
        List<String> menuWithNum = new ArrayList<>(removeBlankAndSplit(input));
        validateOrder(menuWithNum);
    }

    public List<String> removeBlankAndSplit(final String input) {
        return Arrays.asList(input.replace(" ","").split(","));
    }

    public void validateOrder(final List<String> menuWithNum) throws IllegalArgumentException {
        String[] splitHyphen;
        for (String menuNum : menuWithNum) {
            splitHyphen = validateHyphen(menuNum).split("-");
            menus.put(splitHyphen[0],Integer.parseInt(splitHyphen[1]));
        }
    }

    public String validateHyphen(final String menuNum) throws IllegalArgumentException {
        if (!menuNum.contains("-")) {
            throw new IllegalArgumentException(ErrorMessage.invalidOrder());
        }
        return menuNum;
    }


}
