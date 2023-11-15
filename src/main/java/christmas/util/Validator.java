package christmas.util;


import java.util.Map;

public class Validator {

    private final DateValidator dateValidator;
    private final MenuValidator menuValidator;

    public Validator() {
        this.dateValidator = new DateValidator();
        this.menuValidator = new MenuValidator();
    }

    public void dateValidate(String inputDate) {
        dateValidator.validate(inputDate);
    }


    public void menuValidate(String inputMenu) {
        menuValidator.validate(inputMenu);
    }
}
