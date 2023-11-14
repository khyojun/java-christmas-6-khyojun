package christmas.domain;

public class BenefitStatus {

    private final long dDaySalePrice;
    private final WeekSaleStatus weekSalePrice;
    private final long specialSalePrice;
    private final long starDatePrice;



    private boolean none;

    public BenefitStatus(long dDaySalePrice, WeekSaleStatus weekSaleStatus, long specialSalePrice, long starDatePrice) {
        this.dDaySalePrice = dDaySalePrice;
        this.weekSalePrice = weekSaleStatus;
        this.specialSalePrice = specialSalePrice;
        this.starDatePrice = starDatePrice;
        this.none = false;
    }

    public long getSpecialDatePrice() {
        return this.specialSalePrice;
    }

    public long getStarDatePrice() {
        return this.starDatePrice;
    }

    public long getdDaySalePrice() {
        return this.dDaySalePrice;
    }

    public long getGiftSalePrice() {
        return specialSalePrice;
    }

    public WeekSaleStatus getWeekSaleStatus() {
        return this.weekSalePrice;
    }

    public boolean isNone(){
        return none;
    }

    public void hasNothing() {
        this.none=true;
    }

}
