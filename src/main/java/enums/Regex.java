package enums;

/**
 *  Regex that can be used
 *  <li>{@link #NAME_REGEX}</li>
 *  <li>{@link #USERNAME_REGEX}</li>
 *  <li>{@link #PHONE_NUMBER_REGEX}</li>
 *  <li>{@link #PASSWORD_REGEX}</li>
 *  <li>{@link #CARD_NUMBER_REGEX}</li>
 *  <li>{@link #CV_CODE_REGEX}</li>
 *  <li>{@link #AGE_REGEX}</li>
 *  <li>{@link #PASSPORT_ID_REGEX}</li>
 */
public enum Regex {
    /**
     * Name regex
     */
    NAME_REGEX("^[a-zA-Zа-яА-Я]{2,}$"),
    /**
     * Username regex
     */
    USERNAME_REGEX("^[a-zA-Z0-9]{5,}$"),
    /**
     * Phone number regex
     */
    PHONE_NUMBER_REGEX("^\\+\\d{12}$"),
    /**
     * Password regex
     */
    PASSWORD_REGEX("^.{8,}$"),
    /**
     * Card number regex
     */
    CARD_NUMBER_REGEX("^\\d{16}$"),
    /**
     * CV code regex
     */
    CV_CODE_REGEX("^\\d{3}$"),
    /**
     * Age regex
     */
    AGE_REGEX("^\\d{1,3}$"),
    /**
     * Passport id regex
     */
    PASSPORT_ID_REGEX("^[a-zA-Z0-9]{6,}$");

    private String name;

    /**
     * Sole constructor. It is not possible to invoke this constructor.
     * It is for use by code emitted by the compiler in response to enum type declarations.
     * @param name The name of enum constant, which is the identifier used to declare it.
     */
    Regex(String name) {
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
