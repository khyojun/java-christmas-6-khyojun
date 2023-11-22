package christmas.constant;

public enum StandardConstant {

    NOTHING("없음");


    private final String message;

    StandardConstant(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
