package christmas.util;

import java.util.List;
import java.util.regex.Pattern;

public class MenuValidator {

    private String menuPattern = "^[A-Za-z가-힣]+\\-+[\\d]+$";

    public void validate(String inputMenu) {
        try {
            List<String> splitInputMenus = List.of(inputMenu.split(","));
            validateFormat(splitInputMenus);
            validateMenuDuplicate(splitInputMenus);
        }catch (IllegalArgumentException error){
            throw new IllegalArgumentException(error.getMessage());
        }

    }

    private void validateMenuDuplicate(List<String> splitInputMenus) {

    }

    private void validateFormat(List<String> splitInputMenus) {
        for (String splitInputMenu : splitInputMenus) {
            if(Pattern.matches(menuPattern, splitInputMenu))
                throw new IllegalArgumentException("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
        }

    }
}
