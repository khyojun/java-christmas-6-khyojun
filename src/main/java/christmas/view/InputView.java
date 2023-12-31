package christmas.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    private static InputView instance;

    private InputView() {
    }

    public static InputView getInstance() {
        if (instance == null) {
            instance = new InputView();
        }
        return instance;
    }

    public String readDate() {
        return Console.readLine();
    }

    public String inputMenu() {
        return Console.readLine();
    }
}
