package christmas.service;

import static christmas.constant.DateConstant.MONTH;
import static christmas.constant.DateConstant.YEAR;
import static christmas.constant.WeekConstant.WEEKDAY;
import static christmas.constant.WeekConstant.WEEKEND;
import static christmas.constant.WeekNumConstant.FRIDAY;
import static christmas.constant.WeekNumConstant.PLUS_MONEY;
import static christmas.constant.WeekNumConstant.SATURDAY;

import christmas.constant.WeekNumConstant;
import christmas.domain.Menu;
import christmas.domain.WeekSaleStatus;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class WeekService {


    public WeekSaleStatus calculateWeekBenefit(Map<String, Integer> menuInfo, Integer date) {
        return calculate(menuInfo, date);
    }

    private WeekSaleStatus calculate(Map<String, Integer> menuInfo, int date) {
        int weekDay = LocalDate.of(YEAR.getDateNumber(), MONTH.getDateNumber(), date).getDayOfWeek()
            .getValue();
        if (isWeekend(weekDay)) {
            return new WeekSaleStatus(checkBenefitMenu(menuInfo, WEEKEND.getMenuCategory()),
                WEEKEND.getSaleMessage());
        }
        return new WeekSaleStatus(checkBenefitMenu(menuInfo, WEEKDAY.getMenuCategory()),
            WEEKDAY.getSaleMessage());
    }

    private boolean isWeekend(int weekDay) {
        return weekDay == FRIDAY.getNumber() || weekDay == SATURDAY.getNumber();
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
            dateSalePrice += menuEntry.getValue() * PLUS_MONEY.getNumber();
        }
        return dateSalePrice;
    }
}
