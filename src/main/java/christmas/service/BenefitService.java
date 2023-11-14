package christmas.service;

import christmas.domain.BenefitStatus;
import christmas.domain.Menu;
import christmas.domain.WeekSaleStatus;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class BenefitService {



    private final SaleService saleService = new SaleService();

    public BenefitStatus checkBenefit(Integer date, Map<String, Integer> menuInfo, long beforeBenefitMoney) {
        long starDateSalePrice= 0L;
        //int weekDayValue =
        saleService.saleCalculate(date, menuInfo, beforeBenefitMoney);

        long benefitPrice = ddatSalePrice + weekBenefit.getSalePrice() + giftBenefit+ starDateSalePrice;
        BenefitStatus benefitStatus = new BenefitStatus(ddatSalePrice, weekBenefit, giftBenefit, starDateSalePrice);
        if(benefitPrice ==0)
            benefitStatus.hasNothing();
        return benefitStatus;
    }






}
