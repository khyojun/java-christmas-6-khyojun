package christmas.constant;

public enum MenuConstant {


    MENU_LIMIT(20),
    MENU_MIN_NUMBER(1);



    private int number;


    MenuConstant(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }
}
