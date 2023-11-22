package christmas.domain;

public class BenefitStatus {

    private final SaleStatus saleStatus;

    private final long giftBenefitPrice;

    private boolean none;

    public BenefitStatus(SaleStatus saleStatus, long giftBenefitPrice) {
        this.saleStatus = saleStatus;
        this.giftBenefitPrice = giftBenefitPrice;
        this.none = false;
    }

    public static BenefitStatus nothing() {
        return new BenefitStatus(new SaleStatus(0, WeekSaleStatus.nothing(), 0), 0);
    }


    public SaleStatus getSaleStatus() {
        return saleStatus;
    }

    public long getGiftBenefitPrice() {
        return giftBenefitPrice;
    }

    public boolean isNone() {
        return none;
    }

    public void hasNothing() {
        this.none = true;
    }

}
