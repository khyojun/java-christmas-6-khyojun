package christmas.constant;

public enum DateConstant {

    CHRISTMAS_DAY(25),
    FIRST_DAY(1),
    LAST_DAY(31),
    YEAR(2023),
    MONTH(12);

    private int dateNumber;

    DateConstant(int dateNumber) {
        this.dateNumber = dateNumber;
    }

    public int getDateNumber() {
        return dateNumber;
    }

}
