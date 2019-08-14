package enums;

/**
 *  Errors that can be used
 *  <li>{@link #WRONG_USERNAME}</li>
 *  <li>{@link #NAME_DOES_NOT_MATCH}</li>
 *  <li>{@link #SURNAME_DOES_NOT_MATCH}</li>
 *  <li>{@link #PHONE_NUMBER_DOES_NOT_MATCH}</li>
 *  <li>{@link #PASSWORD_DOES_NOT_MATCH}</li>
 *  <li>{@link #PASSPORT_ID_DOES_NOT_MATCH}</li>
 *  <li>{@link #USER_ALREADY_EXISTS}</li>
 *  <li>{@link #USER_DOES_NOT_EXIST}</li>
 *  <li>{@link #DATE_TO_CANT_BE_LESS}</li>
 *  <li>{@link #NO_AVAILABLE_ROOM}</li>
 *  <li>{@link #CV_CODE_ERROR}</li>
 *  <li>{@link #CARD_NUMBER_ERROR}</li>
 *  <li>{@link #EXPIRY_DATE_ERROR}</li>
 *  <li>{@link #AGE_ERROR}</li>
 *  <li>{@link #SOMETHING_WRONG}</li>
 *  <li>{@link #NO_GUESTS}</li>
 *  <li>{@link #NO_ROOMS}</li>
 *  <li>{@link #NO_PAYMENTS}</li>
 *  <li>{@link #NO_RESERVATIONS}</li>
 *  <li>{@link #NO_ROOM_REQUESTS}</li>
 */
public enum Errors {
    /**
     * Wrong username error
     */
    WRONG_USERNAME("Wrong username."),
    /**
     * Name doesn't match error
     */
    NAME_DOES_NOT_MATCH("Name should contains at least 2 letter."),
    /**
     * Surname doesn't match error
     */
    SURNAME_DOES_NOT_MATCH("Surname should contains at least 2 letter."),
    /**
     * Phone number doesn't match error
     */
    PHONE_NUMBER_DOES_NOT_MATCH("Phone number should contains of '+' and 12 digits."),
    /**
     * Password doesn't match error
     */
    PASSWORD_DOES_NOT_MATCH("Password should contains at least 8 characters."),
    /**
     * Passport id doesn't match error
     */
    PASSPORT_ID_DOES_NOT_MATCH("Passport id should contains at least 6 alphanumeric characters."),
    /**
     * User already exist error
     */
    USER_ALREADY_EXISTS("User with such username already exists."),
    /**
     * User doesn't exist error
     */
    USER_DOES_NOT_EXIST("User with such username doesn't exist."),
    /**
     * Date to can't be less error
     */
    DATE_TO_CANT_BE_LESS("Date out can't be less than date in."),
    /**
     * No available room error
     */
    NO_AVAILABLE_ROOM("There is no available room."),
    /**
     * CV code error
     */
    CV_CODE_ERROR("CV code should contains 3 digits."),
    /**
     * Card number error
     */
    CARD_NUMBER_ERROR("Card number should contains 16 digits."),
    /**
     * Expiry date error
     */
    EXPIRY_DATE_ERROR("Expiry date can't be less than current date."),
    /**
     * Age error
     */
    AGE_ERROR("Field age has to be a digit."),
    /**
     * Something wrong error
     */
    SOMETHING_WRONG("Something was wrong."),
    /**
     * No guests error
     */
    NO_GUESTS("No guests were found."),
    /**
     * No rooms error
     */
    NO_ROOMS("No rooms were found."),
    /**
     * No payments error
     */
    NO_PAYMENTS("No payments were found."),
    /**
     * No reservations error
     */
    NO_RESERVATIONS("No reservations were found."),
    /**
     * No room requests error
     */
    NO_ROOM_REQUESTS("No rooms requests were found.");

    private String name;

    /**
     * Sole constructor. It is not possible to invoke this constructor.
     * It is for use by code emitted by the compiler in response to enum type declarations.
     * @param name The name of enum constant, which is the identifier used to declare it.
     */
    Errors(String name) {
        this.name = name;
    }

    /**
     * Gets the value of {@link #name}.
     *
     * @return the value of {@link #name}.
     */
    public String getName() {
        return name;
    }
}
