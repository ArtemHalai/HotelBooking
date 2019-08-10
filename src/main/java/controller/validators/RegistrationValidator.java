package controller.validators;

import model.entity.Guest;

import java.util.Map;

import static enums.Attributes.*;
import static enums.Errors.*;
import static enums.Regex.*;

public class RegistrationValidator extends LoginValidator {
    private Guest guest;
    private String age;

    public RegistrationValidator(Guest guest, String age) {
        super(guest.getUsername(), guest.getPassword());
        this.guest = guest;
        this.age = age;
    }

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

    private void validateAge() {
        if (!age.matches(AGE_REGEX.getName())) {
            errors.put(AGE.getName(), AGE_ERROR.getName());
        }
    }

    private void validatePassportId() {
        String passportId = guest.getPassportId();

        if (!passportId.matches(PASSPORT_ID_REGEX.getName())){
            errors.put(PASSPORT_ID.getName(), PASSPORT_ID_DOES_NOT_MATCH.getName());
        }
    }

    private void validateName() {
        String name = guest.getName();

        if (!name.matches(NAME_REGEX.getName())) {
            errors.put(NAME.getName(), NAME_DOES_NOT_MATCH.getName());
        }
    }

    private void validateSurname() {
        String surname = guest.getSurname();

        if (!surname.matches(NAME_REGEX.getName())) {
            errors.put(SURNAME.getName(), SURNAME_DOES_NOT_MATCH.getName());
        }
    }

    private void validatePhoneNumber() {
        String phoneNumber = guest.getPhone();

        if (!phoneNumber.matches(PHONE_NUMBER_REGEX.getName())) {
            errors.put(PHONE_NUMBER.getName(), PHONE_NUMBER_DOES_NOT_MATCH.getName());
        }
    }

}
