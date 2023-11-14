package christmas.service;



public class BadgeService {

    public String decideBadge(long totalBenefitPrice) {
        return decide(totalBenefitPrice);
    }

    private String decide(long totalBenefitPrice) {
        if (totalBenefitPrice <= -20000) {
            return "산타";
        }
        if (totalBenefitPrice <= -10000) {
            return "트리";
        }
        if (totalBenefitPrice <= -5000) {
            return "별";
        }
        return "없음";
    }
}
