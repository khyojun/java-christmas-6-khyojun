package christmas.constant;

public enum WeekNumConstant {

    FRIDAY(5),
    SATURDAY(6),
    PLUS_MONEY(2023);


    private final long number;

    WeekNumConstant(long number) {
        this.number = number;
    }

    public long getNumber() {
        return number;
    }

}
