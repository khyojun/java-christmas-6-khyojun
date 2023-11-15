package christmas.util;

import static christmas.constant.Delimiter.COMMA;
import static christmas.constant.Delimiter.Hyphen;
import static christmas.constant.ErrorMessage.MENU;
import static christmas.constant.MenuConstant.MENU_LIMIT;
import static christmas.constant.MenuConstant.MENU_MIN_NUMBER;
import static christmas.constant.ValidatorConstant.MENU_PATTERN;
import static christmas.constant.ValidatorConstant.RESTRICT_ONLY_CATEGORY;

import christmas.constant.Delimiter;
import christmas.constant.ErrorMessage;
import christmas.constant.ValidatorConstant;
import christmas.domain.Menu;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.regex.Pattern;

public class MenuValidator {


    public void validate(String inputMenu) {
        try {
            validateCommaCount(inputMenu);
            List<String> firstSplitByComma = List.of(inputMenu.split(COMMA.getDelimiter()));
            validateHyphen(firstSplitByComma);
            validateFormat(firstSplitByComma);
            Map<String, Integer> menuInfo = putMenu(firstSplitByComma);
            validateMenuCountWrongNumber(menuInfo);
            validateMenuDuplicate(menuInfo, firstSplitByComma.size());
            validateInMenu(menuInfo);
            validateMenuTotal(menuInfo);
            validateOnlyBeverage(menuInfo);
        } catch (IllegalArgumentException error) {
            throw new IllegalArgumentException(error.getMessage());
        }
    }

    private void validateHyphen(List<String> firstSplitByComma) {
        for (String splitComma : firstSplitByComma) {
            if (isRightCommaCount(splitComma)) {
                throw new IllegalArgumentException(MENU.getMessage());
            }
        }
    }

    private boolean isRightCommaCount(String splitComma) {
        long count = splitComma.chars()
            .filter(nowValue -> nowValue == Hyphen.getDelimiter().charAt(0)).count();
        return count != 1;
    }

    private void validateCommaCount(String inputMenu) {
        List<String> firstSplitByComma = List.of(inputMenu.split(COMMA.getDelimiter()));
        if (isRightCommaCount(firstSplitByComma, inputMenu)) {
            throw new IllegalArgumentException(MENU.getMessage());
        }

    }

    private boolean isRightCommaCount(List<String> firstSplitByComma, String inputMenu) {
        long count = inputMenu.chars().filter(element -> element == COMMA.getDelimiter().charAt(0))
            .count();
        return firstSplitByComma.size() - 1 != count;
    }

    private void validateOnlyBeverage(Map<String, Integer> menuInfo) {
        List<Menu> values = List.of(Menu.values());
        List<String> beverage = values.stream().filter(m -> m.getMenuCategory().equals(
                RESTRICT_ONLY_CATEGORY.getValue()))
            .map(
                Menu::getMenuName)
            .toList();
        if (isMenuHasOnlyBeverage(menuInfo, beverage)) {
            throw new IllegalArgumentException(MENU.getMessage());
        }
    }

    private boolean isMenuHasOnlyBeverage(Map<String, Integer> menuInfo, List<String> beverage) {
        return countMenuBeverage(menuInfo, beverage) == menuInfo.size();
    }

    private int countMenuBeverage(Map<String, Integer> menuInfo, List<String> beverage) {
        int count = 0;
        for (String menuName : menuInfo.keySet()) {
            if (beverage.contains(menuName)) {
                count++;
            }
        }
        return count;
    }


    private void validateMenuTotal(Map<String, Integer> menuInfo) {
        int total = 0;
        for (Integer value : menuInfo.values()) {
            total += value;
            if (total > MENU_LIMIT.getNumber()) {
                throw new IllegalArgumentException(MENU.getMessage());
            }
        }
    }

    private void validateInMenu(Map<String, Integer> menuInfo) {
        List<String> menuNames = menuNames();
        for (Entry<String, Integer> menuEntry : menuInfo.entrySet()) {
            if (!menuNames.contains(menuEntry.getKey())) {
                throw new IllegalArgumentException(MENU.getMessage());
            }
        }
    }

    private List<String> menuNames() {
        List<Menu> menus = List.of(Menu.values());
        List<String> menuNames = new ArrayList<>();
        for (Menu menu : menus) {
            menuNames.add(menu.getMenuName());
        }
        return menuNames;
    }

    private void validateMenuCountWrongNumber(Map<String, Integer> menuInfo) {
        for (Entry<String, Integer> nowMenuInfo : menuInfo.entrySet()) {
            if (nowMenuInfo.getValue() < MENU_MIN_NUMBER.getNumber()
                || nowMenuInfo.getValue() > MENU_LIMIT.getNumber()) {
                throw new IllegalArgumentException(MENU.getMessage());
            }
        }
    }

    private Map<String, Integer> putMenu(List<String> firstSplitByComma) {
        Map<String, Integer> inputMenuMap = new HashMap<>();
        for (String splitInput : firstSplitByComma) {
            List<String> secondSplitByHighPone = List.of(splitInput.split(Hyphen.getDelimiter()));
            int menuCount = Integer.parseInt(secondSplitByHighPone.get(1));
            inputMenuMap.put(secondSplitByHighPone.get(0), menuCount);
        }
        return inputMenuMap;
    }

    private void validateMenuDuplicate(Map<String, Integer> menuInfo, int size) {
        if (menuInfo.size() != size) {
            throw new IllegalArgumentException(MENU.getMessage());
        }

    }


    private void validateFormat(List<String> splitInputMenus) {
        for (String splitInputMenu : splitInputMenus) {
            if (isNotMatchFormat(splitInputMenu)) {
                throw new IllegalArgumentException(MENU.getMessage());
            }
        }

    }

    private boolean isNotMatchFormat(String splitInputMenu) {
        return !Pattern.matches(MENU_PATTERN.getValue(), splitInputMenu);
    }
}
