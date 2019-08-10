package controller.validators;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import static enums.Attributes.DATE;
import static enums.Errors.DATE_TO_CANT_BE_LESS;

public class BookingValidator implements Validator {

    protected Map<String, String> errors = new HashMap<>();
    private String dateFrom;
    private String dateTo;

    public BookingValidator(String dateFrom, String dateTo) {
        this.dateFrom = dateFrom;
        this.dateTo = dateTo;
    }

    @Override
    public Map<String, String> validate(){
        try {
            validateDate();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return errors;
    }

    private void validateDate() throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        if (dateFrom!=null&&dateTo!=null) {
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
