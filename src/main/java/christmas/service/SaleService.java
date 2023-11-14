package christmas.service;

import christmas.domain.SaleStatus;
import java.util.Map;

public class SaleService {

    private final DDayService dDayService;
    private final WeekService weekService;
    private final StarDateService starDateService;

    private final TotalCalculateService totalCalculateService;

    public SaleService() {
        this.dDayService = new DDayService();
        this.weekService = new WeekService();
        this.starDateService = new StarDateService();
        this.totalCalculateService = new TotalCalculateService();
    }

    public SaleStatus saleCalculate(Integer date, Map<String, Integer> menuInfo) {
        return new SaleStatus(dDayService.calculateDdayBenefit(date),
            weekService.calculateWeekBenefit(menuInfo, date),
            starDateService.calculateStarDateSale(date));
    }

    public long calculateTotalSalePrice(SaleStatus saleStatus) {
        return totalCalculateService.calculateTotalSale(saleStatus);
    }
}
