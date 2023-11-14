package christmas.service;

import java.util.List;

public class StarDateService {

    private List<Integer> starDate = List.of(3, 10, 17, 24, 25, 31);

    public long calculateStarDateSale(Integer date) {
        return calculate(date);
    }
    private long calculate(Integer date) {
        if(starDate.contains(date)){
            return 1000 * -1;
        }
        return 0L;
    }
}
