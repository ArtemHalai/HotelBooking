package controller.validators;

import java.text.ParseException;
import java.util.Map;

public class PaymentValidator extends GuestInfoValidator{

    public PaymentValidator(String cardNumber, String cvCode, String expiryDate) {
        super(cardNumber, cvCode, expiryDate);
    }

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
