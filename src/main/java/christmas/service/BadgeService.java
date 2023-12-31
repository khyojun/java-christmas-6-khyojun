package christmas.service;


import static christmas.constant.BadgeConstant.SANTA_BADGE;
import static christmas.constant.BadgeConstant.STAR_BADGE;
import static christmas.constant.BadgeConstant.TREE_BADGE;
import static christmas.constant.StandardConstant.NOTHING;

import christmas.constant.StandardConstant;


public class BadgeService {


    public String decideBadge(long totalBenefitPrice) {
        return decide(totalBenefitPrice);
    }

    private String decide(long totalBenefitPrice) {
        if (totalBenefitPrice >= SANTA_BADGE.getSalePrice()) {
            return SANTA_BADGE.getBadgeName();
        }
        if (totalBenefitPrice >= TREE_BADGE.getSalePrice()) {
            return TREE_BADGE.getBadgeName();
        }
        if (totalBenefitPrice >= STAR_BADGE.getSalePrice()) {
            return STAR_BADGE.getBadgeName();
        }
        return NOTHING.getMessage();
    }
}
