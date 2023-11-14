package christmas.domain;

public class BenefitStatus {

    private final long dDaySalePrice;
    private final WeekSaleStatus weekSalePrice;
    private final long giftPrice;
    private final long starDatePrice;


    private boolean none;

    public BenefitStatus(long dDaySalePrice, WeekSaleStatus weekSaleStatus, long giftPrice,
        long starDatePrice) {
        this.dDaySalePrice = dDaySalePrice;
        this.weekSalePrice = weekSaleStatus;
        this.giftPrice = giftPrice;
        this.starDatePrice = starDatePrice;
        this.none = false;
    }


    public long getStarDatePrice() {
        return this.starDatePrice;
    }

    public long getdDaySalePrice() {
        return this.dDaySalePrice;
    }

    public long getGiftSalePrice() {
        return giftPrice;
    }

    public WeekSaleStatus getWeekSaleStatus() {
        return this.weekSalePrice;
    }

    public boolean isNone() {
        return none;
    }

    public void hasNothing() {
        this.none = true;
    }

}
