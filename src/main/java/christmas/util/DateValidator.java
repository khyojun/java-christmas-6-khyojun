package christmas.util;

import static christmas.constant.DateConstant.FIRST_DAY;
import static christmas.constant.DateConstant.LAST_DAY;

import christmas.constant.ErrorMessage;


public class DateValidator{


    public void validate(String inputDate) {
        try {
            validateNumber(inputDate);
            validateRange(Integer.parseInt(inputDate));
        }catch (IllegalArgumentException dateError){
            throw new IllegalArgumentException(ErrorMessage.DATE.getMessage());
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
