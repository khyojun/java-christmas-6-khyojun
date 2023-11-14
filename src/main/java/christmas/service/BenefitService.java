package christmas.service;

import christmas.constant.MoneyConstant;
import christmas.domain.BenefitStatus;
import christmas.domain.Menu;
import christmas.domain.SaleStatus;
import java.util.Map;

public class BenefitService {


    private final SaleService saleService;

    private final BadgeService badgeService;

    private final TotalCalculateService totalCalculateService;

    public BenefitService() {
        this.saleService = new SaleService();
        this.badgeService = new BadgeService();
        this.totalCalculateService = new TotalCalculateService();
    }

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
        if(totalMenuPrice > MoneyConstant.ACCEPT_GIFT_MIN_MONEY.getMoney()) {
            return Menu.BEVERAGE_CHAMPAGNE.getPrice() * -1;
        }
        return 0;
    }


    public String decideBadge(long totalBenefit) {
        return badgeService.decideBadge(totalBenefit);
    }

}
