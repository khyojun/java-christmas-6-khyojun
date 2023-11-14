package christmas.constant;

public enum ErrorMessage {

    PREFIX("[ERROR] "),

    MENU("유효하지 않은 주문입니다. 다시 입력해 주세요."),

    DATE("유효하지 않은 날짜입니다. 다시 입력해 주세요.");


    private String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return PREFIX.message + message;
    }
}
