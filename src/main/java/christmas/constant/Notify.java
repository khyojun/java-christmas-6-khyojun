package christmas.constant;

public enum Notify {

    BEFORE_NOTIFY_ORDER("\n<주문 메뉴>"),

    BEFORE_NOTIFY_BENEFIT_MONEY("\n<할인 전 총주문 금액>"),

    BEFORE_NOTIFY_GIFT_PROCESS("\n<증정 메뉴>"),

    BENEFIT_BOARD("\n<혜택 내역>"),

    TOTAL_BENEFIT_PRICE("\n<총혜택 금액>"),

    AFTER_PREDICT_SALE_PRICE("\n<할인 후 예상 결제 금액>"),

    BADGE("\n<12월 이벤트 배지>");


    private final String notify;

    Notify(String notify) {
        this.notify = notify;
    }

    public String getNotify() {
        return notify;
    }
}
