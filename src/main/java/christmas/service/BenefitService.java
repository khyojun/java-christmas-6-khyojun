package christmas.service;

import christmas.domain.BenefitStatus;
import christmas.domain.Menu;
import christmas.domain.WeekSaleStatus;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class BenefitService {


    private static final int year = 2023;
    private static final int month = 12;

    private static final int FIRST_DAY = 1;

    private List<Integer> starDate = List.of(3, 10, 17, 24, 25, 31);

    public BenefitStatus checkBenefit(Integer date, Map<String, Integer> menuInfo, long beforeBenefitMoney) {
        long starDatePrice= 0L;
        int weekDayValue = LocalDate.of(year, month, date).getDayOfWeek().getValue();
        long ddayBenefit = calculateDdayBenefit(date);
        WeekSaleStatus weekBenefit = calculateWeekBenefit(menuInfo, weekDayValue);
        long specialBenefit = calculateGiftBenefit(beforeBenefitMoney);
        starDatePrice = checkStarDateSale(date, starDatePrice);
        long salePrice = ddayBenefit + weekBenefit.getSalePrice() + specialBenefit+ starDatePrice;
        BenefitStatus benefitStatus = new BenefitStatus(ddayBenefit, weekBenefit, specialBenefit, starDatePrice);

        if(salePrice ==0)
            benefitStatus.hasNothing();
        return benefitStatus;
    }

    private long checkStarDateSale(Integer date, long starDatePrice) {
        if(starDate.contains(date)){
            starDatePrice = 1000 * -1;
        }
        return starDatePrice;
    }

    private long calculateGiftBenefit(long beforeBenefitMoney) {
        if(beforeBenefitMoney > 120000) {
            return Menu.BEVERAGE_CHAMPAGNE.getPrice() * -1;
        }
        return 0L;
    }

    private WeekSaleStatus calculateWeekBenefit(Map<String, Integer> menuInfo, int value) {
        if (value == 5 || value == 6) {
            return new WeekSaleStatus(checkBenefitMenu(menuInfo, "MAIN"), "주말 할인");
        }
        return new WeekSaleStatus(checkBenefitMenu(menuInfo, "DESERT"), "평일 할인");
    }

    private long calculateDdayBenefit(Integer date) {
        if (date < 25) {
            return -1000 + (date - FIRST_DAY) * 100L * -1;
        }
        return 0;
    }

    private long checkBenefitMenu(Map<String, Integer> menuInfo, String menuCategory) {
        List<Menu> values = List.of(Menu.values());
        long dateSalePrice = 0;
        List<String> categoryNames = values.stream()
            .filter(m -> m.getMenuCategory().equals(menuCategory))
            .map(Menu::getMenuName)
            .toList();

        for (String categoryName : categoryNames) {
            dateSalePrice = findCategory(menuInfo, categoryName, dateSalePrice);
        }
        return dateSalePrice;

    }

    private long findCategory(Map<String, Integer> menuInfo, String desertName,
        long dateSalePrice) {
        for (Entry<String, Integer> menuEntry : menuInfo.entrySet()) {
            dateSalePrice = calculateCategory(desertName, dateSalePrice, menuEntry);
        }
        return dateSalePrice;
    }

    private long calculateCategory(String categoryName, long dateSalePrice,
        Entry<String, Integer> menuEntry) {
        if (categoryName.equals(menuEntry.getKey())) {
            dateSalePrice -= menuEntry.getValue() * 2023L;
        }
        return dateSalePrice;
    }


}
