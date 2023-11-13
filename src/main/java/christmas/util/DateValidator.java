package christmas.util;

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
        if(convertedInputDate < 1 ||  convertedInputDate > 31)
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
