package christmas.service;

import static christmas.constant.MoneyConstant.STARDATE_PLUS_MONEY;

import christmas.constant.MoneyConstant;
import java.util.List;

public class StarDateService {

    private static final List<Integer> STAR_DATE = List.of(3, 10, 17, 24, 25, 31);

    public long calculateStarDateSale(Integer date) {
        return calculate(date);
    }
    private long calculate(Integer date) {
        if(STAR_DATE.contains(date)){
            return STARDATE_PLUS_MONEY.getMoney() * -1;
        }
        return 0L;
    }
}
