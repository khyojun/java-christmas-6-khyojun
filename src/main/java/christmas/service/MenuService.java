package christmas.service;

import christmas.domain.BenefitStatus;
import christmas.domain.Menu;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class MenuService {



    private final BenefitService benefitService;

    public MenuService() {
        this.benefitService = new BenefitService();
    }

    public long calculateBeforeBenefit(Map<String, Integer> menuInfo) {
        long total=0L;
        List<Menu> menus= List.of(Menu.values());
        for (Menu menu : menus) {
            for (Entry<String, Integer> menuEntry : menuInfo.entrySet()) {
                if(menu.getMenuName().equals(menuEntry.getKey()))
                    total+= (long) menu.getPrice() * menuEntry.getValue();
            }
        }
        return total;
    }

    public boolean giftService(long calculateTotalMoney) {
        return calculateTotalMoney > 120000;
    }

    public BenefitStatus benefitCalculate(Integer date, Map<String, Integer> menuInfo, long calculatedMoney) {
        if(calculatedMoney < 10000){
            BenefitStatus benefitStatus = new BenefitStatus(0, null, 0, 0);
            benefitStatus.hasNothing();
            return benefitStatus;
        }
        return benefitService.checkBenefit(date,menuInfo, calculatedMoney);
    }
}
