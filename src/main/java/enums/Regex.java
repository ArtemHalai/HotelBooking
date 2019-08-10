package enums;

public enum Regex {
    NAME_REGEX("^[a-zA-Zа-яА-Я]{2,}$"),
    USERNAME_REGEX("^[a-zA-Z0-9]{5,}$"),
    PHONE_NUMBER_REGEX("^\\+\\d{12}$"),
    PASSWORD_REGEX("^.{8,}$"),
    CARD_NUMBER_REGEX("^\\d{16}$"),
    CV_CODE_REGEX("^\\d{3}$"),
    AGE_REGEX("^\\d{1,3}$"),
    PASSPORT_ID_REGEX("^[a-zA-Z0-9]{6,}$");

    private String name;

    Regex(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
