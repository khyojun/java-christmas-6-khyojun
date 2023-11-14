package christmas.service;

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
        long total = 0L;
        List<Menu> menus = List.of(Menu.values());
        total = calculateTotalMenuPrice(menuInfo, menus, total);
        return total;
    }

    private long calculateTotalMenuPrice(Map<String, Integer> menuInfo, List<Menu> menus, long total) {
        for (Menu menu : menus) {
            for (Entry<String, Integer> menuEntry : menuInfo.entrySet()) {
                if (menu.getMenuName().equals(menuEntry.getKey())) {
                    total += (long) menu.getPrice() * menuEntry.getValue();
                }
            }
        }
        return total;
    }

    public boolean giftService(long calculateTotalMoney) {
        return calculateTotalMoney > 120000;
    }

    public BenefitStatus benefitCalculate(Integer date, Map<String, Integer> menuInfo,
        long calculatedMoney) {
        if (calculatedMoney < 10000) {
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
        return benefitService.decideBadge(benefitStatus);
    }
}
