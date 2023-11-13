package christmas.util;


public class Validator {

    private final DateValidator dateValidator;

    public Validator() {
        this.dateValidator = new DateValidator();

    }

    public void dateValidate(String inputDate){
        dateValidator.validate(inputDate);
    }


}
