package command;

import controller.validators.PaymentValidator;
import controller.validators.Validator;
import facade.PaymentFacade;
import model.dto.PaymentTransactionDto;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;
import java.util.Map;

import static enums.Attributes.*;
import static enums.Mappings.SUCCESSFUL;
import static enums.Mappings.UNSUCCESSFUL;

public class PaymentCommand extends AbstractCommand {
    private PaymentFacade paymentFacade = new PaymentFacade();

    private final Logger logger = Logger.getLogger(this.getClass());

    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) {

        String room = req.getParameter(ROOM_ID.getName());
        String reservationId = req.getParameter(RESERVATION_ID.getName());
        String cardNumber = req.getParameter(CARD_NUMBER.getName());
        String cvCode = req.getParameter(CV_CODE.getName());
        String expiryDate = req.getParameter(EXPIRY_DATE.getName());
        String username = req.getParameter(GUEST.getName());
        String price = req.getParameter(PRICE.getName());

        Validator paymentValidator = new PaymentValidator(cardNumber, cvCode, expiryDate);
        Map<String, String> errors = paymentValidator.validate();

        HttpSession session = req.getSession();
        session.removeAttribute(ERRORS.getName());
        session.removeAttribute(PRICE.getName());
        session.removeAttribute(RESERVATION_ID.getName());
        session.setAttribute(GUEST.getName(), username);
        req.setAttribute(ERRORS.getName(), errors);
        req.setAttribute(PRICE.getName(), price);
        req.setAttribute(RESERVATION_ID.getName(), reservationId);

        if (!errors.isEmpty()) {
            session.setAttribute(ERRORS.getName(), errors);
            session.setAttribute(PRICE.getName(), price);
            session.setAttribute(RESERVATION_ID.getName(), reservationId);
            return ERRORS.getName();
        } else {
            boolean added = false;

            try {

                PaymentTransactionDto paymentTransactionDto = new PaymentTransactionDto(Integer.parseInt(room), Double.parseDouble(price),
                        username, Integer.parseInt(reservationId));
                added = paymentFacade.addPaymentWithTransaction(paymentTransactionDto);
            } catch (SQLException e) {
                logger.error(e.getMessage());
            }

            if (added) {
                logger.info("Payment was successful");
                return SUCCESSFUL.getName();
            } else {
                logger.info("Payment was unsuccessful");
                return UNSUCCESSFUL.getName();
            }
        }
    }
}
