package christmas.constant;

public enum BadgeConstant {

    SANTA_BADGE("산타", -20000),
    TREE_BADGE("트리", -10000),
    STAR_BADGE("별", -5000);



    private String badgeName;
    private int salePrice;

    BadgeConstant(String badgeName, int salePrice) {
        this.badgeName = badgeName;
        this.salePrice = salePrice;
    }

    public String getBadgeName() {
        return badgeName;
    }

    public int getSalePrice() {
        return salePrice;
    }
}
