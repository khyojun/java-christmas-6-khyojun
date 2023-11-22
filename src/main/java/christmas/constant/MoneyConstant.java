package christmas.constant;

public enum MoneyConstant {

    D_DAY_START_MONEY(1000),
    D_DAY_PLUS_MONEY(100),

    BENEFIT_MINIMUM_MONEY(10000),

    WEEKDAY_PLUS_MONEY(2023),

    STARDATE_PLUS_MONEY(1000),

    ACCEPT_GIFT_MIN_MONEY(120000);


    private final long money;

    MoneyConstant(long money) {
        this.money = money;
    }

    public long getMoney() {
        return money;
    }
}
