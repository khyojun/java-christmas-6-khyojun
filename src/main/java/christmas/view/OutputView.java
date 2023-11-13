package christmas.view;

import java.util.Map;
import java.util.Map.Entry;

public class OutputView {

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

    public void printGiftProcess(String message) {
        System.out.println("<증정 메뉴>");
        System.out.println(message);
    }
}
