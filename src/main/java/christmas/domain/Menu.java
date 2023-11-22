package christmas.domain;

public enum Menu {

    APPETIZER_MUSHROOM_CREAEM_SOUP("양송이수프", 6000, "APPETIZER"),
    APPETIZER_TAPAS("타파스", 5500, "APPETIZER"),
    APPETIZER_Caesar_Salad("시저샐러드", 8000, "APPETIZER"),

    MAIN_T_BONE_STEAK("티본스테이크", 55000, "MAIN"),
    MAIN_BARBECUE_RIBS("바비큐립", 54000, "MAIN"),
    MAIN_SEAFOOD_PASTA("해산물파스타", 35000, "MAIN"),
    MAIN_CHRISTMAS_PASTA("크리스마스파스타", 25000, "MAIN"),

    DESERT_CHOCO_CAKE("초코케이크", 15000, "DESERT"),
    DESERT_ICE_CREAM("아이스크림", 5000, "DESERT"),

    BEVERAGE_ZERO_COKE("제로콜라", 3000, "BEVERAGE"),
    BEVERAGE_RED_WINE("레드와인", 60000, "BEVERAGE"),
    BEVERAGE_CHAMPAGNE("샴페인", 25000, "BEVERAGE");


    private final String menuName;
    private final int price;
    private final String menuCategory;

    Menu(String menuName, int price, String menuCategory) {
        this.menuName = menuName;
        this.price = price;
        this.menuCategory = menuCategory;
    }

    public String getMenuName() {
        return menuName;
    }

    public int getPrice() {
        return price;
    }

    public String getMenuCategory() {
        return menuCategory;
    }


}
