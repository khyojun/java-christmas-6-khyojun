package christmas.service;

import christmas.domain.BenefitStatus;
import christmas.domain.Menu;
import christmas.domain.SaleStatus;
import java.util.Map;

public class BenefitService {



    private final SaleService saleService = new SaleService();


    public BenefitStatus checkBenefit(Integer date, Map<String, Integer> menuInfo, long beforeBenefitMoney) {
        SaleStatus saleStatus = saleService.saleCalculate(date, menuInfo);
        BenefitStatus benefitStatus = new BenefitStatus(saleStatus, calculateGiftBenefit(beforeBenefitMoney));
        if(totalBenefitPrice(benefitStatus)==0)
            benefitStatus.hasNothing();
        return benefitStatus;
    }

    private long totalBenefitPrice(BenefitStatus benefitStatus) {
        SaleStatus saleStatus = benefitStatus.getSaleStatus();
        return benefitStatus.getGiftBenefitPrice()+saleStatus.getdDaySalePrice()+saleStatus.getStarDatePrice()+saleStatus.getWeekSaleStatus().getSalePrice();
    }


    private long calculateGiftBenefit(long beforeBenefitMoney) {
        if(beforeBenefitMoney > 120000) {
            return Menu.BEVERAGE_CHAMPAGNE.getPrice() * -1;
        }
        return 0L;
    }


    public String decideBadge(BenefitStatus benefitStatus) {
        SaleStatus saleStatus = benefitStatus.getSaleStatus();
        long allSalePrice = saleStatus.getdDaySalePrice() + saleStatus.getStarDatePrice()
            + saleStatus.getWeekSaleStatus().getSalePrice() + benefitStatus.getGiftBenefitPrice();
        if (allSalePrice <= -20000) {
            return "산타";
        }
        if (allSalePrice <= -10000) {
            return "트리";
        }
        if (allSalePrice <= -5000) {
            return "별";
        }
        return "없음";
    }

    public long totalBenefit(BenefitStatus benefitStatus) {
        SaleStatus saleStatus = benefitStatus.getSaleStatus();
        return saleStatus.getWeekSaleStatus().getSalePrice() + benefitStatus.getGiftBenefitPrice()
            + saleStatus.getdDaySalePrice() + saleStatus.getStarDatePrice();
    }
}
