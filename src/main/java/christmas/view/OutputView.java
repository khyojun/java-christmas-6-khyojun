package christmas.view;

import christmas.domain.BenefitStatus;
import christmas.domain.SaleStatus;
import java.text.DecimalFormat;
import java.util.Map;
import java.util.Map.Entry;

public class OutputView {
    private static final String BEFORE_INPUT_DATE = "안녕하세요! 우테코 식당 12월 이벤트 플래너입니다.\n12월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)";
    private static final String BEFORE_INPUT_MENU = "주문하실 메뉴를 메뉴와 개수를 알려 주세요. (e.g. 해산물파스타-2,레드와인-1,초코케이크-1)";
    private static final String BEFORE_NOTIFY_BENEFIT = "12월 %d일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!\n";
    private static final String BEFORE_NOTIFY_ORDER = "\n<주문 메뉴>";
    private static final String ORDER_FORM = "%s %d개\n";
    private static final String BEFORE_NOTIFY_BENEFIT_MONEY = "\n<할인 전 총주문 금액>";
    private static final String STANDARD_MONEY_FORMAT = "%s원\n";
    private static final String NOTIFY_BEFORE_GIFT_PROCESS = "\n<증정 메뉴>";
    private static final String GIFT = "샴페인 1개";
    private static final String NOTHING = "없음";
    private static final String NOTIFY_BENEFIT_BOARD = "\n<혜택 내역>";
    private static final String D_DAY_SALE_FORMAT = "크리스마스 디데이 할인: %s원\n";
    private static final String STAR_DATE_SALE_FORMAT = "특별 할인: %s원\n";
    private static final String GIFT_SALE_FORMAT = "증정 이벤트: %s원\n";
    private static final String WEEK_SALE_FORMAT = "%s: %s원\n";
    private static final String TOTAL_BENEFIT_PRICE_NOTIFY = "\n<총혜택 금액>";
    private static final String NOTIFY_AFTER_PREDICT_SALE_PRICE = "\n<할인 후 예상 결제 금액>";
    private static final String NOTIFY_BADGE = "\n<12월 이벤트 배지>";
    private static final String FORMAT = "###,###,###,###";
    private static final DecimalFormat MONEY_FORMAT = new DecimalFormat(FORMAT);


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
        System.out.println(BEFORE_INPUT_DATE);
    }

    public void printError(String message) {
        System.out.println(message);
    }

    public void beforeInputMenu() {
        System.out.println(BEFORE_INPUT_MENU);
    }

    public void printBeforeNotifyBenefit(Integer date) {
        System.out.printf(BEFORE_NOTIFY_BENEFIT, date);
    }

    public void printOrderMenu(Map<String, Integer> menuInfo) {
        System.out.println(BEFORE_NOTIFY_ORDER);
        for (Entry<String, Integer> menuEntry : menuInfo.entrySet()) {
            System.out.printf(ORDER_FORM, menuEntry.getKey(), menuEntry.getValue());
        }
    }

    public void printBeforeBenefitMoney(long totalPrice) {
        System.out.println(BEFORE_NOTIFY_BENEFIT_MONEY);
        System.out.printf(STANDARD_MONEY_FORMAT, changeFormat(totalPrice));
    }

    public void printGiftProcess(boolean gifted) {
        System.out.println(NOTIFY_BEFORE_GIFT_PROCESS);
        if (gifted) {
            System.out.println(GIFT);
            return;
        }
        System.out.println(NOTHING);
    }

    public void printBenefit(BenefitStatus benefitStatus) {
        System.out.println(NOTIFY_BENEFIT_BOARD);
        if (benefitStatus.isNone()) {
            printNothing();
            return;
        }
        printBenefitProcess(benefitStatus);
    }

    private void printBenefitProcess(BenefitStatus benefitStatus) {
        SaleStatus saleStatus = benefitStatus.getSaleStatus();
        printSalePrice(saleStatus.getdDaySalePrice(), D_DAY_SALE_FORMAT);
        printWeekSalePrice(saleStatus);
        printSalePrice(saleStatus.getStarDatePrice(), STAR_DATE_SALE_FORMAT);
        printSalePrice(benefitStatus.getGiftBenefitPrice(), GIFT_SALE_FORMAT);
    }

    private void printWeekSalePrice(SaleStatus saleStatus) {
        if (saleStatus.getWeekSaleStatus().getSalePrice() < 0) {
            System.out.printf(WEEK_SALE_FORMAT, saleStatus.getWeekSaleStatus().getWeekDay(),
                changeFormat(
                    saleStatus.getWeekSaleStatus().getSalePrice()));
        }
    }

    private void printSalePrice(long benefitStatus, String format) {
        if (benefitStatus < 0) {
            System.out.printf(format, changeFormat(benefitStatus));
        }
    }

    private String changeFormat(long salePrice) {
        return MONEY_FORMAT.format(salePrice);
    }

    private void printNothing() {
        System.out.println(NOTHING);
    }

    public void printTotalSalePrice(long totalSalePrice) {
        System.out.println(TOTAL_BENEFIT_PRICE_NOTIFY);
        System.out.printf(STANDARD_MONEY_FORMAT, changeFormat(totalSalePrice));
    }


    public void printAfterSalePrice(long calculateMoney) {
        System.out.println(NOTIFY_AFTER_PREDICT_SALE_PRICE);
        System.out.printf(STANDARD_MONEY_FORMAT, changeFormat(calculateMoney));
    }

    public void printBadge(String badge) {
        System.out.println(NOTIFY_BADGE);
        System.out.printf(badge);
    }

}
