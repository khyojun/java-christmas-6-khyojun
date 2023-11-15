package christmas.constant;

public enum ValidatorConstant {


    MENU_PATTERN("^[A-Za-z가-힣]+-+[\\d]+$"),

    RESTRICT_ONLY_CATEGORY("BEVERAGE");


    private final String value;

    ValidatorConstant(String value) {
        this.value = value;
    }
    public String getValue() {
        return value;
    }


}
