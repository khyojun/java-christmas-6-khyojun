package christmas.service;

import static christmas.constant.DateConstant.CHRISTMAS_DAY;
import static christmas.constant.DateConstant.FIRST_DAY;
import static christmas.constant.MoneyConstant.D_DAY_PLUS_MONEY;
import static christmas.constant.MoneyConstant.D_DAY_START_MONEY;

import christmas.constant.DateConstant;
import christmas.constant.MoneyConstant;

public class DDayService {



    public long calculateDdayBenefit(Integer date) {
        return calculate(date);
    }

    private long calculate(Integer day) {
        if (day <= CHRISTMAS_DAY.getDateNumber()) {
            return D_DAY_START_MONEY.getMoney() + (day - FIRST_DAY.getDateNumber()) * D_DAY_PLUS_MONEY.getMoney() ;
        }
        return 0;
    }
}
