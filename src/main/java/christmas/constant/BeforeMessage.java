package christmas.constant;

public enum BeforeMessage {


    BEFORE_INPUT_DATE("안녕하세요! 우테코 식당 12월 이벤트 플래너입니다.\n12월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)"),

    BEFORE_INPUT_MENU("주문하실 메뉴를 메뉴와 개수를 알려 주세요. (e.g. 해산물파스타-2,레드와인-1,초코케이크-1)"),

    BEFORE_BENEFIT("12월 %d일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!\n");


    private String message;


    BeforeMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
