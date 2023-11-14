package christmas.service;

import static christmas.constant.MoneyConstant.ACCEPT_GIFT_MIN_MONEY;
import static christmas.constant.MoneyConstant.BENEFIT_MINIMUM_MONEY;

import christmas.domain.BenefitStatus;
import christmas.domain.Menu;
import christmas.domain.SaleStatus;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class MenuService {


    private final BenefitService benefitService;

    private final SaleService saleService;

    public MenuService() {
        this.benefitService = new BenefitService();
        this.saleService = new SaleService();
    }

    public long calculateBeforeBenefit(Map<String, Integer> menuInfo) {
        List<Menu> menus = List.of(Menu.values());
        return calculateTotalMenuPrice(menuInfo, menus);
    }

    private long calculateTotalMenuPrice(Map<String, Integer> menuInfo, List<Menu> menus) {
        long total=0L;
        for (Menu menu : menus) {
            total = multiplyMenu(menuInfo, menu, total);
        }
        return total;
    }

    private long multiplyMenu(Map<String, Integer> menuInfo, Menu menu, long total) {
        for (Entry<String, Integer> menuEntry : menuInfo.entrySet()) {
            if (menu.getMenuName().equals(menuEntry.getKey())) {
                total += (long) menu.getPrice() * menuEntry.getValue();
            }
        }
        return total;
    }

    public boolean giftService(long calculateTotalMoney) {
        return calculateTotalMoney > ACCEPT_GIFT_MIN_MONEY.getMoney();
    }

    public BenefitStatus benefitCalculate(Integer date, Map<String, Integer> menuInfo,
        long calculatedMoney) {
        if (calculatedMoney < BENEFIT_MINIMUM_MONEY.getMoney()) {
            BenefitStatus benefitStatus = BenefitStatus.nothing();
            benefitStatus.hasNothing();
            return benefitStatus;
        }
        return benefitService.checkBenefit(date, menuInfo, calculatedMoney);
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
