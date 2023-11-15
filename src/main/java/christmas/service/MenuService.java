package christmas.service;

import static christmas.constant.MoneyConstant.BENEFIT_MINIMUM_MONEY;

import christmas.domain.BenefitStatus;
import christmas.domain.Menu;
import christmas.domain.SaleStatus;
import java.util.List;
import java.util.Map;

public class MenuService {


    private final BenefitService benefitService;

    private final SaleService saleService;

    private final TotalCalculateService totalCalculateService;


    public MenuService() {
        this.benefitService = new BenefitService();
        this.saleService = new SaleService();
        this.totalCalculateService = new TotalCalculateService();
    }

    public long calculateBeforeBenefit(Map<String, Integer> menuInfo) {
        List<Menu> menus = List.of(Menu.values());
        return calculateTotalMenuPrice(menuInfo, menus);
    }

    private long calculateTotalMenuPrice(Map<String, Integer> menuInfo, List<Menu> menus) {
        return totalCalculateService.calculateTotalMenuPrice(menuInfo, menus);
    }



    public long giftService(long calculateTotalMoney) {
        return benefitService.giftCalculate(calculateTotalMoney);
    }

    public BenefitStatus benefitCalculate(Integer date, Map<String, Integer> menuInfo,
        long calculatedMoney) {
        if (calculatedMoney < BENEFIT_MINIMUM_MONEY.getMoney()) {
            BenefitStatus benefitStatus = BenefitStatus.nothing();
            benefitStatus.hasNothing();
            return benefitStatus;
        }
        return benefitService.benefitLogicStart(date, menuInfo, calculatedMoney);
    }

    public long totalBenefitPrice(BenefitStatus benefitStatus) {
        return benefitService.totalBenefit(benefitStatus);
    }

    public long afterSalePrice(long totalMenuPrice, SaleStatus saleStatus) {
        return totalMenuPrice + saleService.calculateTotalSalePrice(saleStatus);
    }

    public String badgeService(BenefitStatus benefitStatus) {
        return benefitService.decideBadge(totalBenefitPrice(benefitStatus));
    }
}
