package controller.services.admin;

import dao.intefaces.PaymentDao;
import factories.DaoFactory;
import model.dto.PaymentsAdminDto;

import java.sql.SQLException;

/**
 * A class that works with PaymentDao.
 *
 * @see PaymentDao
 */
public class PaymentInfoAdminService {

    private PaymentDao paymentDao;

    /**
     * Creates a PaymentInfoAdminService object and initialize {@link #paymentDao}.
     */
    public PaymentInfoAdminService() {
        this.paymentDao = DaoFactory.getInstance().getPaymentDao();
    }

    /**
     * Method to get all payments by using PaymentDao {@link #paymentDao}.
     *
     * @param paymentsAdminDto Object to pass params containing in it.
     * @return Object of PaymentsAdminDto containing list of payments;
     * @throws SQLException If sql exception occurred while processing this request.
     * @see PaymentsAdminDto
     */
    public PaymentsAdminDto getAllPayments(PaymentsAdminDto paymentsAdminDto) throws SQLException {
        return paymentDao.getAllPayments(paymentsAdminDto);
    }
}
