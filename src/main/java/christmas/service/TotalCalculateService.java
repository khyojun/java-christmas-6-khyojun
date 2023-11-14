package christmas.service;

import christmas.domain.BenefitStatus;
import christmas.domain.SaleStatus;

public class TotalCalculateService {

    public long calculateBenefit(BenefitStatus benefitStatus) {
        return calculate(benefitStatus);
    }

    private long calculate(BenefitStatus benefitStatus) {
        SaleStatus saleStatus = benefitStatus.getSaleStatus();
        return benefitStatus.getGiftBenefitPrice() + saleStatus.getdDaySalePrice()
            + saleStatus.getStarDatePrice() + saleStatus.getWeekSaleStatus().getSalePrice();
    }

    public long calculateTotalSale(SaleStatus saleStatus) {
        return saleStatus.getWeekSaleStatus().getSalePrice()
            + saleStatus.getdDaySalePrice() + saleStatus.getStarDatePrice();
    }
}
