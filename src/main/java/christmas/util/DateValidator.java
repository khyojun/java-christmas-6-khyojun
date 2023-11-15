package christmas.util;

import static christmas.constant.DateConstant.FIRST_DAY;
import static christmas.constant.DateConstant.LAST_DAY;
import static christmas.constant.ErrorMessage.DATE;

import christmas.constant.ErrorMessage;


public class DateValidator {


    public void validate(String inputDate) {
        try {
            validateNumber(inputDate);
            validateRange(Integer.parseInt(inputDate));
        } catch (IllegalArgumentException dateError) {
            throw new IllegalArgumentException(DATE.getMessage());
        }
    }

    private void validateRange(Integer convertedInputDate) {
        if (isInDateRange(convertedInputDate)) {
            throw new IllegalArgumentException();
        }

    }

    private boolean isInDateRange(Integer convertedInputDate) {
        return convertedInputDate < FIRST_DAY.getDateNumber()
            || convertedInputDate > LAST_DAY.getDateNumber();
    }

    private void validateNumber(String inputDate) {
        try {
            Integer.parseInt(inputDate);
        } catch (NumberFormatException error) {
            throw new IllegalArgumentException();
        }
    }
}
