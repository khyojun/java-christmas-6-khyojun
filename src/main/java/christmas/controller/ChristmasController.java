package christmas.controller;

import christmas.util.Validator;
import christmas.view.InputView;
import christmas.view.OutputView;

public class ChristmasController {


    private InputView inputView;
    private OutputView outputView;

    private Validator validator;

    public ChristmasController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.validator = new Validator();

    }


    public void startOrder() {

        outputView.beforeInputDate();
        validator.dateValidate(inputView.readDate());


    }
}
