package christmas.domain;

public class WeekSaleStatus {


    private long salePrice;
    private String weekDay;

    public WeekSaleStatus(long salePrice, String weekDay) {
        this.salePrice = salePrice;
        this.weekDay = weekDay;
    }

    public static WeekSaleStatus nothing() {
        return new WeekSaleStatus(0, "nothing");
    }

    public long getSalePrice() {
        return salePrice;
    }

    public String getWeekDay() {
        return weekDay;
    }
}
