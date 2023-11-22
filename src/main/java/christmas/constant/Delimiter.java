package christmas.constant;

public enum Delimiter {

    COMMA(","),
    Hyphen("-");


    private String delimiter;

    Delimiter(String delimiter) {
        this.delimiter = delimiter;
    }

    public String getDelimiter() {
        return delimiter;
    }
}
