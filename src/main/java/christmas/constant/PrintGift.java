package christmas.constant;

public enum PrintGift {

    GIFT("샴페인 1개");

    private final String message;

    PrintGift(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
