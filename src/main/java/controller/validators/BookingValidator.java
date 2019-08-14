package controller.validators;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import static enums.Attributes.DATE;
import static enums.Errors.DATE_TO_CANT_BE_LESS;

/**
 * The object used for validating booking data.
 */
public class BookingValidator implements Validator {

    protected Map<String, String> errors = new HashMap<>();
    private String dateFrom;
    private String dateTo;

    /**
     * Creates a BookingValidator object with the specified dateFrom, dateTo.
     *
     * @param dateFrom The date_in of booking.
     * @param dateTo   The date_out of booking.
     */
    public BookingValidator(String dateFrom, String dateTo) {
        this.dateFrom = dateFrom;
        this.dateTo = dateTo;
    }

    /**
     * Method to validate booking data.
     *
     * @return The empty map if validation was successful, and map containing errors if something was invalid
     * during validation.
     */
    @Override
    public Map<String, String> validate() {
        try {
            validateDate();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return errors;
    }

    /**
     * Method to validate booking date.
     * If date doesn't match then put the message in map {@link #errors}.
     *
     * @throws ParseException If parse exception occurred while processing this request.
     * @see enums.Errors
     * @see enums.Attributes
     */
    private void validateDate() throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        if (dateFrom != null && dateTo != null) {
            Date checkIn = dateFormat.parse(dateFrom);
            Date checkOut = dateFormat.parse(dateTo);
            java.sql.Date dateIn = new java.sql.Date(checkIn.getTime());
            java.sql.Date dateOut = new java.sql.Date(checkOut.getTime());

            if (dateIn.getTime() >= dateOut.getTime()) {
                errors.put(DATE.getName(), DATE_TO_CANT_BE_LESS.getName());
            }
        }
    }
}
