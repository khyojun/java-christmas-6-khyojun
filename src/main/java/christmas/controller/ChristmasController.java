package christmas.controller;

import christmas.util.Validator;
import christmas.view.InputView;
import christmas.view.OutputView;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        Map<String, Integer> menuInfo = inputMenuProcess();


    }

    private Map<String, Integer> inputMenuProcess() {
        try{
            outputView.beforeInputMenu();
            String inputMenu = inputView.inputMenu();
            validator.menuValidate(inputMenu);
            return convertProcess(inputMenu);
        }catch (IllegalArgumentException error){
            outputView.printError(error.getMessage());
            return inputMenuProcess();
        }

    }

    private Map<String, Integer> convertProcess(String inputMenu) {
        Map<String, Integer> menuInfo = new HashMap<>();
        List<String> split = List.of(inputMenu.split(","));
        for (String s : split) {
            List<String> seperateByHighPone = List.of(s.split("-"));
            menuInfo.put(seperateByHighPone.get(0), Integer.parseInt(seperateByHighPone.get(1)));
        }
        return menuInfo;
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
