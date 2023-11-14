package christmas.util;

import static christmas.constant.DateConstant.FIRST_DAY;
import static christmas.constant.DateConstant.LAST_DAY;


public class DateValidator{


    public void validate(String inputDate) {
        try {
            validateNumber(inputDate);
            validateRange(Integer.parseInt(inputDate));
        }catch (IllegalArgumentException dateError){
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.");
        }
    }

    private void validateRange(Integer convertedInputDate) {
        if(convertedInputDate < FIRST_DAY.getDateNumber() ||  convertedInputDate > LAST_DAY.getDateNumber())
            throw new IllegalArgumentException();

    }

    private void validateNumber(String inputDate) {
        try{
            Integer.parseInt(inputDate);
        }catch (NumberFormatException error){
            throw new IllegalArgumentException();
        }
    }
}
