package christmas.util;

import christmas.domain.Menu;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.regex.Pattern;

public class MenuValidator {

    private String menuPattern = "^[A-Za-z가-힣]+-+[\\d]+$";


    public void validate(String inputMenu) {
        try {
            List<String> firstSplitByComma = List.of(inputMenu.split(","));
            validateFormat(firstSplitByComma);
            Map<String, Integer> menuInfo = putMenu(firstSplitByComma);
            validateMenuCountWrongNumber(menuInfo);
            validateMenuDuplicate(menuInfo, firstSplitByComma.size());
            validateInMenu(menuInfo);
        }catch (IllegalArgumentException error){
            throw new IllegalArgumentException(error.getMessage());
        }

    }

    private void validateInMenu(Map<String, Integer> menuInfo) {
        List<String> menuNames = menuNames();
        for (Entry<String, Integer> menuEntry : menuInfo.entrySet()) {
            if(!menuNames.contains(menuEntry.getKey()))
                throw new IllegalArgumentException("[ERROR] no menu");
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
            if(nowMenuInfo.getValue() < 1 || nowMenuInfo.getValue() > 20){
                throw new IllegalArgumentException("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
            }

        }
    }

    private Map<String, Integer> putMenu(List<String> firstSplitByComma) {
        Map<String, Integer> inputMenuMap = new HashMap<>();
        for (String splitInput : firstSplitByComma) {
            List<String> secondSplitByHighPone = List.of(splitInput.split("-"));
            int menuCount = Integer.parseInt(secondSplitByHighPone.get(1));
            inputMenuMap.put(secondSplitByHighPone.get(0), menuCount);
        }
        return inputMenuMap;
    }

    private void validateMenuDuplicate(Map<String, Integer> menuInfo, int size) {
        if(menuInfo.size() != size){
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
        }

    }


    private void validateFormat(List<String> splitInputMenus) {
        for (String splitInputMenu : splitInputMenus) {
            if(isNotMatchFormat(splitInputMenu))
                throw new IllegalArgumentException("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
        }

    }

    private boolean isNotMatchFormat(String splitInputMenu) {
        return !Pattern.matches(menuPattern, splitInputMenu);
    }
}
