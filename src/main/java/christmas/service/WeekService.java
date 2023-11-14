package christmas.service;

import static christmas.constant.DateConstant.MONTH;
import static christmas.constant.DateConstant.YEAR;

import christmas.domain.Menu;
import christmas.domain.WeekSaleStatus;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class WeekService {

    private static final String MAIN_MENU = "MAIN";
    private static final String DESERT_MENU = "DESERT";

    private static final String WEEKEND_SALE = "주말 할인";
    private static final String WEEKDAY_SALE = "평일 할인";

    private static final int FRIDAY_WEEK_NUM = 5;
    private static final int SATURDAY_WEEK_NUM = 6;


    public WeekSaleStatus calculateWeekBenefit(Map<String, Integer> menuInfo, Integer date) {
        return calculate(menuInfo, date);
    }

    private WeekSaleStatus calculate(Map<String, Integer> menuInfo, int date) {
        int weekDay = LocalDate.of(YEAR.getDateNumber(), MONTH.getDateNumber(), date).getDayOfWeek().getValue();
        if (isWeekend(weekDay)) {
            return new WeekSaleStatus(checkBenefitMenu(menuInfo, MAIN_MENU), WEEKEND_SALE);
        }
        return new WeekSaleStatus(checkBenefitMenu(menuInfo, DESERT_MENU), WEEKDAY_SALE);
    }

    private boolean isWeekend(int weekDay) {
        return weekDay == FRIDAY_WEEK_NUM || weekDay == SATURDAY_WEEK_NUM;
    }

    private long checkBenefitMenu(Map<String, Integer> menuInfo, String menuCategory) {
        List<Menu> values = List.of(Menu.values());
        long dateSalePrice = 0;
        List<String> sameMenuCategoryNames = values.stream()
            .filter(m -> m.getMenuCategory().equals(menuCategory))
            .map(Menu::getMenuName)
            .toList();

        for (String menuName : sameMenuCategoryNames) {
            dateSalePrice = findCategory(menuInfo, menuName, dateSalePrice);
        }
        return dateSalePrice;
    }

    private long findCategory(Map<String, Integer> menuInfo, String menuName,
        long dateSalePrice) {
        for (Entry<String, Integer> menuEntry : menuInfo.entrySet()) {
            dateSalePrice = calculateCategory(menuName, dateSalePrice, menuEntry);
        }
        return dateSalePrice;
    }


    private long calculateCategory(String menuName, long dateSalePrice,
        Entry<String, Integer> menuEntry) {
        if (menuName.equals(menuEntry.getKey())) {
            dateSalePrice -= menuEntry.getValue() * 2023L;
        }
        return dateSalePrice;
    }
}
