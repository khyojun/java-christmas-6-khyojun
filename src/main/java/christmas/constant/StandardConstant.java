package christmas.constant;

public enum StandardConstant {

    NOTHING("없음");


    private String message;

    StandardConstant(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
