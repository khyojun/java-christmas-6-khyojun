package christmas.service;

import christmas.domain.BenefitStatus;
import christmas.domain.Menu;
import christmas.domain.SaleStatus;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

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

    public long calculateTotalMenuPrice(Map<String, Integer> menuInfo, List<Menu> menus) {
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
}
