package christmas.domain;

public class BenefitStatus {

    private long dDaySalePrice;
    private WeekSaleStatus weekSalePrice;
    private long specialSalePrice;
    private long starDatePrice;



    private boolean none;

    public BenefitStatus(long dDaySalePrice, WeekSaleStatus weekSaleStatus, long specialSalePrice, long starDatePrice) {
        this.dDaySalePrice = dDaySalePrice;
        this.weekSalePrice = weekSaleStatus;
        this.specialSalePrice = specialSalePrice;
        this.starDatePrice = starDatePrice;
        this.none = false;
    }

    public long getSpecialDatePrice() {
        return starDatePrice;
    }
    public long getdDaySalePrice() {
        return dDaySalePrice;
    }

    public long getGiftSalePrice() {
        return specialSalePrice;
    }

    public WeekSaleStatus getWeekSaleStatus() {
        return weekSalePrice;
    }

    public boolean isNone(){
        return none;
    }

    public void hasNothing() {
        this.none=true;
    }

}
