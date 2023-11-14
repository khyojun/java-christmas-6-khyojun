package christmas.service;

import christmas.constant.MoneyConstant;
import christmas.domain.Menu;

public class GiftService {


    public long calculateGiftBenefit(long calculateTotalMoney) {
        if(isOverToGetGift(calculateTotalMoney)) {
            return Menu.BEVERAGE_CHAMPAGNE.getPrice() * -1;
        }
        return 0;
    }

    private boolean isOverToGetGift(long calculateTotalMoney) {
        return calculateTotalMoney > MoneyConstant.ACCEPT_GIFT_MIN_MONEY.getMoney();
    }
}
