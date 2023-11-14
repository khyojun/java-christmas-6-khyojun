package christmas.service;

import christmas.domain.BenefitStatus;
import christmas.domain.Menu;
import christmas.domain.SaleStatus;
import java.util.Map;

public class BenefitService {


    private final SaleService saleService = new SaleService();

    private final BadgeService badgeService = new BadgeService();

    private final TotalCalculateService totalCalculateService = new TotalCalculateService();


    public BenefitStatus checkBenefit(Integer date, Map<String, Integer> menuInfo, long beforeBenefitMoney) {
        SaleStatus saleStatus = saleService.saleCalculate(date, menuInfo);
        BenefitStatus benefitStatus = new BenefitStatus(saleStatus, calculateGiftBenefit(beforeBenefitMoney));
        if(totalBenefitPrice(benefitStatus)==0)
            benefitStatus.hasNothing();
        return benefitStatus;
    }

    private long totalBenefitPrice(BenefitStatus benefitStatus) {
        return totalCalculateService.calculateBenefit(benefitStatus);
    }

    public long totalBenefit(BenefitStatus benefitStatus) {
        return totalBenefitPrice(benefitStatus);
    }


    private long calculateGiftBenefit(long totalMenuPrice) {
        if(totalMenuPrice > 120000) {
            return Menu.BEVERAGE_CHAMPAGNE.getPrice() * -1;
        }
        return 0L;
    }


    public String decideBadge(long totalBenefit) {
        return badgeService.decideBadge(totalBenefit);
    }

}
