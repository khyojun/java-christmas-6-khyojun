package christmas.service;

public class DDayService {

    private static final int FIRST_DAY = 1;

    public long calculateDdayBenefit(Integer date) {
        return calculate(date);
    }

    private long calculate(Integer date) {
        if (date < 25) {
            return -1000 + (date - FIRST_DAY) * 100L * -1;
        }
        return 0;
    }
}
