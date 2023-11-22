package christmas.domain;

import static christmas.constant.StandardConstant.NOTHING;


public class WeekSaleStatus {


    private final long salePrice;
    private final String weekDay;

    public WeekSaleStatus(long salePrice, String weekDay) {
        this.salePrice = salePrice;
        this.weekDay = weekDay;
    }

    public static WeekSaleStatus nothing() {
        return new WeekSaleStatus(0, NOTHING.getMessage());
    }

    public long getSalePrice() {
        return salePrice;
    }

    public String getWeekDay() {
        return weekDay;
    }
}
