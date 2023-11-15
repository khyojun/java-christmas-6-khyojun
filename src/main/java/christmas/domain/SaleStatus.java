package christmas.domain;

public class SaleStatus {

    private final long starDatePrice;

    private final long dDaySalePrice;

    private final WeekSaleStatus weekSaleStatus;

    public SaleStatus(long dDaySalePrice, WeekSaleStatus weekSaleStatus, long starDatePrice) {
        this.dDaySalePrice = dDaySalePrice;
        this.weekSaleStatus = weekSaleStatus;
        this.starDatePrice = starDatePrice;
    }


    public long getStarDatePrice() {
        return starDatePrice;
    }

    public long getDDaySalePrice() {
        return dDaySalePrice;
    }

    public WeekSaleStatus getWeekSaleStatus() {
        return this.weekSaleStatus;
    }
}
