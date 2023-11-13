package christmas.util;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.regex.Pattern;

public class MenuValidator {

    private String menuPattern = "^[A-Za-z가-힣]+\\-+[\\d]+$";


    public void validate(String inputMenu) {
        try {
            List<String> firstSplitByComma = List.of(inputMenu.split(","));
            validateFormat(firstSplitByComma);
            Map<String, Integer> menuInfo = putMenu(firstSplitByComma);
            validateMenuCountWrongNumber(menuInfo);
            validateMenuDuplicate(menuInfo);
        }catch (IllegalArgumentException error){
            throw new IllegalArgumentException(error.getMessage());
        }

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

    private void validateMenuDuplicate(Map<String, Integer> menuInfo) {
        Set<Entry<String, Integer>> menuInfoNoDuplicate = new HashSet<>(menuInfo.entrySet());


    }


    private void validateFormat(List<String> splitInputMenus) {
        for (String splitInputMenu : splitInputMenus) {
            if(Pattern.matches(menuPattern, splitInputMenu))
                throw new IllegalArgumentException("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
        }

    }
}
