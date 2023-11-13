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

        Integer date = inputDateProcess();


    }

    private Integer inputDateProcess() {
        try {
            outputView.beforeInputDate();
            String inputDate = inputView.readDate();
            validator.dateValidate(inputDate);
            return Integer.parseInt(inputDate);
        }catch (IllegalArgumentException error){
            outputView.printError(error.getMessage());
            return inputDateProcess();
        }
    }
}
