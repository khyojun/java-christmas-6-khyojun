package christmas.constant;

public enum WeekConstant {

    WEEKEND("주말 할인", "MAIN"),
    WEEKDAY("평일 할인", "DESERT");


    private final String saleMessage;
    private final String menuCategory;

    WeekConstant(String saleMessage, String menuCategory) {
        this.saleMessage = saleMessage;
        this.menuCategory = menuCategory;
    }

    public String getSaleMessage() {
        return saleMessage;
    }

    public String getMenuCategory() {
        return menuCategory;
    }
}
