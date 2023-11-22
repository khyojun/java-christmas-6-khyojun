package christmas.service;

import christmas.domain.BenefitStatus;
import christmas.domain.SaleStatus;
import java.util.Map;

public class BenefitService {


    private final SaleService saleService;

    private final BadgeService badgeService;

    private final TotalCalculateService totalCalculateService;
    private final GiftService giftService;

    public BenefitService() {
        this.saleService = new SaleService();
        this.badgeService = new BadgeService();
        this.totalCalculateService = new TotalCalculateService();
        this.giftService = new GiftService();
    }

    public BenefitStatus benefitLogicStart(Integer date, Map<String, Integer> menuInfo,
        long beforeBenefitMoney) {
        SaleStatus saleStatus = saleService.saleCalculate(date, menuInfo);
        BenefitStatus benefitStatus = new BenefitStatus(saleStatus,
            giftCalculate(beforeBenefitMoney));
        if (totalBenefitPrice(benefitStatus) == 0) {
            benefitStatus.hasNothing();
        }
        return benefitStatus;
    }

    private long totalBenefitPrice(BenefitStatus benefitStatus) {
        return totalCalculateService.calculateBenefit(benefitStatus);
    }

    public long totalBenefit(BenefitStatus benefitStatus) {
        return totalBenefitPrice(benefitStatus);
    }


    public String decideBadge(long totalBenefit) {
        return badgeService.decideBadge(totalBenefit);
    }

    public long giftCalculate(long calculateTotalMoney) {
        return giftService.calculateGiftBenefit(calculateTotalMoney);
    }
}
