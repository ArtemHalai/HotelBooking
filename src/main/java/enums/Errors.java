package enums;

public enum Errors {
    WRONG_USERNAME("Wrong username."),
    NAME_DOES_NOT_MATCH("Name should contains at least 2 letter."),
    SURNAME_DOES_NOT_MATCH("Surname should contains at least 2 letter."),
    PHONE_NUMBER_DOES_NOT_MATCH("Phone number should contains of '+' and 12 digits."),
    PASSWORD_DOES_NOT_MATCH("Password should contains at least 8 characters."),
    PASSPORT_ID_DOES_NOT_MATCH("Passport id should contains at least 6 alphanumeric characters."),
    USER_ALREADY_EXISTS("User with such username already exists."),
    USER_DOES_NOT_EXIST("User with such username doesn't exist."),
    DATE_TO_CANT_BE_LESS("Date out can't be less than date in."),
    NO_AVAILABLE_ROOM("There is no available room."),
    CV_CODE_ERROR("CV code should contains 3 digits."),
    CARD_NUMBER_ERROR("Card number should contains 16 digits."),
    EXPIRY_DATE_ERROR("Expiry date can't be less than current date."),
    AGE_ERROR("Field age has to be a digit."),
    SOMETHING_WRONG("Something was wrong."),
    NO_GUESTS("No guests were found."),
    NO_ROOMS("No rooms were found."),
    NO_PAYMENTS("No payments were found."),
    NO_RESERVATIONS("No reservations were found."),
    NO_ROOM_REQUESTS("No rooms requests were found.");

    private String name;

    Errors(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
