package controller.validators;

import java.text.ParseException;
import java.util.Map;

/**
 * The object used for validating payment data.
 */
public class PaymentValidator extends GuestInfoValidator {

    /**
     * Creates a PaymentValidator object with the specified cardNumber, cvCode, expiryDate.
     *
     * @param cardNumber The card number of payment info.
     * @param cvCode     The CV code of payment info.
     * @param expiryDate The expiry date of payment info.
     */
    public PaymentValidator(String cardNumber, String cvCode, String expiryDate) {
        super(cardNumber, cvCode, expiryDate);
    }

    /**
     * Method to validate payment info data.
     *
     * @return The empty map if validation was successful, and map containing errors if something was invalid
     * during validation.
     * @see GuestInfoValidator
     */
    @Override
    public Map<String, String> validate() {
        validateCardNumber();
        validateCVCode();
        try {
            validateExpiryDate();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return errors;
    }
}
