package christmas.constant;

public enum PrintFormatConstant {


    ORDER_FORM("%s %d개\n"),

    STANDARD_MONEY_FORMAT("%s원\n"),

    D_DAY_SALE_FORMAT("크리스마스 디데이 할인: %s원\n"),

    STAR_DATE_SALE_FORMAT("특별 할인: %s원\n"),

    GIFT_SALE_FORMAT("증정 이벤트: %s원\n"),

    WEEK_SALE_FORMAT("%s: %s원\n"),

    MONEY_FORMAT("###,###,###,###");


    private String format;

    PrintFormatConstant(String format) {
        this.format = format;
    }


    public String getFormat() {
        return format;
    }
}
