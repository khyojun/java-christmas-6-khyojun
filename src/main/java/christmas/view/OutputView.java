package christmas.view;

import christmas.domain.BenefitStatus;
import java.text.DecimalFormat;
import java.util.Map;
import java.util.Map.Entry;

public class OutputView {


    private static final String FORMAT = "###,###,###,###";

    private static OutputView instance;



    private OutputView() {
    }

    public static OutputView getInstance() {
        if(instance == null)
            instance = new OutputView();
        return instance;
    }

    public void beforeInputDate() {
        System.out.printf(
            "안녕하세요! 우테코 식당 12월 이벤트 플래너입니다.\n12월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)\n");
    }

    public void printError(String message) {
        System.out.println(message);
    }

    public void beforeInputMenu() {
        System.out.println("주문하실 메뉴를 메뉴와 개수를 알려 주세요. (e.g. 해산물파스타-2,레드와인-1,초코케이크-1)");
    }

    public void printBeforeNotifyBenefit(Integer date) {
        System.out.printf("12월 %d일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!\n\n", date);
    }

    public void printOrderMenu(Map<String, Integer> menuInfo) {
        System.out.println("<주문 메뉴>");
        for (Entry<String, Integer> menuEntry : menuInfo.entrySet()) {
            System.out.printf("%s %d개\n", menuEntry.getKey(), menuEntry.getValue());
        }
    }

    public void printBeforeBenefitMoney(long totalPrice) {
        System.out.println("<할인 전 총주문 금액>");
        System.out.printf("%d원\n", totalPrice);
    }

    public void printGiftProcess(boolean gifted) {
        System.out.println("<증정 메뉴>");
        if(gifted){
            System.out.println("샴페인 1개");
            return;
        }
        System.out.println("없음");
    }

    public void printBenefit(BenefitStatus benefitStatus) {
        if(benefitStatus.isNone()){
            printNothng();
        }
        printBenefitProcess(benefitStatus);
    }

    private void printBenefitProcess(BenefitStatus benefitStatus) {
        System.out.println("<혜택 내역>");
        DecimalFormat decimalFormat = new DecimalFormat(FORMAT);
        printSalePrice(benefitStatus.getdDaySalePrice(), "크리스마스 디데이 할인: %s원\n", decimalFormat);
        printWeekSalePrice(benefitStatus, decimalFormat);
        printSalePrice(benefitStatus.getSpecialDatePrice(), "특별 할인: %s원\n", decimalFormat);
        printSalePrice(benefitStatus.getGiftSalePrice(), "증정 이벤트: %s원", decimalFormat);
    }

    private void printWeekSalePrice(BenefitStatus benefitStatus, DecimalFormat decimalFormat) {
        if(benefitStatus.getWeekSaleStatus().getSalePrice()<0)
            System.out.printf("%s: %s원\n", benefitStatus.getWeekSaleStatus().getWeekDay(), changeFormat(
                decimalFormat, benefitStatus.getWeekSaleStatus().getSalePrice()));
    }

    private void printSalePrice(long benefitStatus, String format, DecimalFormat decimalFormat) {
        if (benefitStatus < 0) {
            System.out.printf(format, changeFormat(decimalFormat, benefitStatus));
        }
    }

    private String changeFormat(DecimalFormat decimalFormat, long salePrice) {
        return decimalFormat.format(salePrice);
    }

    private void printNothng() {
        System.out.println("<혜택 내역>");
        System.out.println("없음");
    }


}
