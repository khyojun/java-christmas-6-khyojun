package christmas.view;

import static christmas.constant.BeforeMessage.BEFORE_INPUT_DATE;
import static christmas.constant.BeforeMessage.BEFORE_INPUT_MENU;
import static christmas.constant.BeforeMessage.BEFORE_BENEFIT;
import static christmas.constant.Notify.AFTER_PREDICT_SALE_PRICE;
import static christmas.constant.Notify.BADGE;
import static christmas.constant.Notify.BEFORE_NOTIFY_BENEFIT_MONEY;
import static christmas.constant.Notify.BEFORE_NOTIFY_ORDER;
import static christmas.constant.Notify.BENEFIT_BOARD;
import static christmas.constant.Notify.TOTAL_BENEFIT_PRICE;
import static christmas.constant.PrintFormatConstant.D_DAY_SALE_FORMAT;
import static christmas.constant.PrintFormatConstant.GIFT_SALE_FORMAT;
import static christmas.constant.PrintFormatConstant.ORDER_FORM;
import static christmas.constant.PrintFormatConstant.STAR_DATE_SALE_FORMAT;
import static christmas.constant.PrintFormatConstant.WEEK_SALE_FORMAT;
import static christmas.constant.PrintGift.GIFT;
import static christmas.constant.StandardConstant.NOTHING;

import christmas.constant.Notify;
import christmas.constant.PrintFormatConstant;
import christmas.domain.BenefitStatus;
import christmas.domain.SaleStatus;
import java.text.DecimalFormat;
import java.util.Map;
import java.util.Map.Entry;

public class OutputView {

    private static final DecimalFormat MONEY = new DecimalFormat(
        PrintFormatConstant.MONEY_FORMAT.getFormat());

    private static OutputView instance;

    private OutputView() {
    }

    public static OutputView getInstance() {
        if (instance == null) {
            instance = new OutputView();
        }
        return instance;
    }

    public void beforeInputDate() {
        System.out.println(BEFORE_INPUT_DATE.getMessage());
    }

    public void printError(String message) {
        System.out.println(message);
    }

    public void beforeInputMenu() {
        System.out.println(BEFORE_INPUT_MENU.getMessage());
    }

    public void printBeforeNotifyBenefit(Integer date) {
        System.out.printf(BEFORE_BENEFIT.getMessage(), date);
    }

    public void printOrderMenu(Map<String, Integer> menuInfo) {
        System.out.println(BEFORE_NOTIFY_ORDER.getNotify());
        for (Entry<String, Integer> menuEntry : menuInfo.entrySet()) {
            System.out.printf(ORDER_FORM.getFormat(), menuEntry.getKey(), menuEntry.getValue());
        }
    }

    public void printBeforeBenefitMoney(long totalPrice) {
        System.out.println(BEFORE_NOTIFY_BENEFIT_MONEY.getNotify());
        System.out.printf(PrintFormatConstant.STANDARD_MONEY_FORMAT.getFormat(),
            changeFormat(totalPrice));
    }

    public void printGiftProcess(long giftPrice) {
        System.out.println(Notify.BEFORE_NOTIFY_GIFT_PROCESS.getNotify());
        if (giftPrice > 0) {
            System.out.println(GIFT.getMessage());
            return;
        }
        System.out.println(NOTHING.getMessage());
    }

    public void printBenefit(BenefitStatus benefitStatus) {
        System.out.println(BENEFIT_BOARD.getNotify());
        if (benefitStatus.isNone()) {
            printNothing();
            return;
        }
        printBenefitProcess(benefitStatus);
    }

    private void printBenefitProcess(BenefitStatus benefitStatus) {
        SaleStatus saleStatus = benefitStatus.getSaleStatus();
        printSalePrice(saleStatus.getDDaySalePrice(), D_DAY_SALE_FORMAT.getFormat());
        printWeekSalePrice(saleStatus);
        printSalePrice(saleStatus.getStarDatePrice(), STAR_DATE_SALE_FORMAT.getFormat());
        printSalePrice(benefitStatus.getGiftBenefitPrice(), GIFT_SALE_FORMAT.getFormat());
    }

    private void printWeekSalePrice(SaleStatus saleStatus) {
        if (saleStatus.getWeekSaleStatus().getSalePrice() > 0) {
            System.out.printf(WEEK_SALE_FORMAT.getFormat(),
                saleStatus.getWeekSaleStatus().getWeekDay(),
                changeFormat(
                    saleStatus.getWeekSaleStatus().getSalePrice()));
        }
    }

    private void printSalePrice(long benefitStatus, String format) {
        if (benefitStatus > 0) {
            System.out.printf(format, changeFormat(benefitStatus));
        }
    }

    private String changeFormat(long salePrice) {
        return MONEY.format(salePrice * -1);
    }

    private void printNothing() {
        System.out.println(NOTHING.getMessage());
    }

    public void printTotalSalePrice(long totalSalePrice) {
        System.out.println(TOTAL_BENEFIT_PRICE.getNotify());
        System.out.printf(PrintFormatConstant.STANDARD_MONEY_FORMAT.getFormat(),
            changeFormat(totalSalePrice));
    }


    public void printAfterSalePrice(long calculateMoney) {
        System.out.println(AFTER_PREDICT_SALE_PRICE.getNotify());
        System.out.printf(PrintFormatConstant.STANDARD_MONEY_FORMAT.getFormat(),
            changeFormat(calculateMoney));
    }

    public void printBadge(String badge) {
        System.out.println(BADGE.getNotify());
        System.out.printf(badge);
    }

}
