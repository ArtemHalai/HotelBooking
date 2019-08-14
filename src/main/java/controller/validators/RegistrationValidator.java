package controller.validators;

import model.entity.Guest;

import java.util.Map;

import static enums.Attributes.*;
import static enums.Errors.*;
import static enums.Regex.*;

/**
 * The object used for validating registration data.
 */
public class RegistrationValidator extends LoginValidator {
    private Guest guest;
    private String age;

    /**
     * Creates a RegistrationValidator object with the specified guest, age.
     *
     * @param guest The guest object of registration info.
     * @param age   The age of registration info.
     * @see Guest
     */
    public RegistrationValidator(Guest guest, String age) {
        super(guest.getUsername(), guest.getPassword());
        this.guest = guest;
        this.age = age;
    }

    /**
     * Method to validate registration info data.
     *
     * @return The empty map if validation was successful, and map containing errors if something was invalid
     * during validation.
     * @see LoginValidator
     */
    @Override
    public Map<String, String> validate() {
        validateName();
        validateSurname();
        validateUsername();
        validatePhoneNumber();
        validatePassword();
        validatePassportId();
        validateAge();
        return errors;
    }

    /**
     * Method to validate age.
     * If age doesn't match regular expression then put the message in map {@link #errors}.
     *
     * @see enums.Errors
     * @see enums.Attributes
     * @see enums.Regex
     */
    private void validateAge() {
        if (!age.matches(AGE_REGEX.getName())) {
            errors.put(AGE.getName(), AGE_ERROR.getName());
        }
    }

    /**
     * Method to validate passport id.
     * If passport id doesn't match regular expression then put the message in map {@link #errors}.
     *
     * @see enums.Errors
     * @see enums.Attributes
     * @see enums.Regex
     */
    private void validatePassportId() {
        String passportId = guest.getPassportId();

        if (!passportId.matches(PASSPORT_ID_REGEX.getName())) {
            errors.put(PASSPORT_ID.getName(), PASSPORT_ID_DOES_NOT_MATCH.getName());
        }
    }

    /**
     * Method to validate name.
     * If name doesn't match regular expression then put the message in map {@link #errors}.
     *
     * @see enums.Errors
     * @see enums.Attributes
     * @see enums.Regex
     */
    private void validateName() {
        String name = guest.getName();

        if (!name.matches(NAME_REGEX.getName())) {
            errors.put(NAME.getName(), NAME_DOES_NOT_MATCH.getName());
        }
    }

    /**
     * Method to validate surname.
     * If surname doesn't match regular expression then put the message in map {@link #errors}.
     *
     * @see enums.Errors
     * @see enums.Attributes
     * @see enums.Regex
     */
    private void validateSurname() {
        String surname = guest.getSurname();

        if (!surname.matches(NAME_REGEX.getName())) {
            errors.put(SURNAME.getName(), SURNAME_DOES_NOT_MATCH.getName());
        }
    }

    /**
     * Method to validate phone number.
     * If phone number doesn't match regular expression then put the message in map {@link #errors}.
     *
     * @see enums.Errors
     * @see enums.Attributes
     * @see enums.Regex
     */
    private void validatePhoneNumber() {
        String phoneNumber = guest.getPhone();

        if (!phoneNumber.matches(PHONE_NUMBER_REGEX.getName())) {
            errors.put(PHONE_NUMBER.getName(), PHONE_NUMBER_DOES_NOT_MATCH.getName());
        }
    }

}
