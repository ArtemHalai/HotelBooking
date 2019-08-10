package controller.validators;

import model.entity.Guest;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import static enums.Attributes.*;
import static enums.Errors.*;
import static enums.Regex.*;

public class GuestInfoValidator implements Validator {
    protected Map<String, String> errors = new HashMap<>();
    private Guest guest;
    private String cardNumber;
    private String cvCode;
    private String expiryDate;
    private String age;

    public GuestInfoValidator(Guest guest, String cardNumber, String cvCode, String expiryDate, String age) {
        this.guest = guest;
        this.cardNumber = cardNumber;
        this.cvCode = cvCode;
        this.expiryDate = expiryDate;
        this.age = age;
    }

    public GuestInfoValidator(String cardNumber, String cvCode, String expiryDate) {
        this.cardNumber = cardNumber;
        this.cvCode = cvCode;
        this.expiryDate = expiryDate;
    }

    @Override
    public Map<String, String> validate() {
        validateName();
        validateSurname();
        validatePhoneNumber();
        validatePassportId();
        validateCardNumber();
        validateAge();
        try {
            validateExpiryDate();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        validateCVCode();
        return errors;
    }

    private void validateAge() {
        if (!age.matches(AGE_REGEX.getName())) {
            errors.put(AGE.getName(), AGE_ERROR.getName());
        }
    }

    protected void validateCVCode() {
        if (!cvCode.matches(CV_CODE_REGEX.getName())) {
            errors.put(CV_CODE.getName(), CV_CODE_ERROR.getName());
        }
    }

    protected void validateExpiryDate() throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = dateFormat.parse(expiryDate);

        java.sql.Date d = new java.sql.Date(date.getTime());
        java.sql.Date now = new java.sql.Date(System.currentTimeMillis());
        if (d.getTime() < now.getTime()) {
            errors.put(EXPIRY_DATE.getName(),EXPIRY_DATE_ERROR.getName());
        }
    }

    protected void validateCardNumber() {
        if (!cardNumber.matches(CARD_NUMBER_REGEX.getName())) {
            errors.put(CARD_NUMBER.getName(), CARD_NUMBER_ERROR.getName());
        }
    }

    private void validatePassportId() {
        String passportId = guest.getPassportId();

        if (!passportId.matches(PASSPORT_ID_REGEX.getName())) {
            errors.put(PASSPORT_ID.getName(),PASSPORT_ID_DOES_NOT_MATCH.getName());
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
