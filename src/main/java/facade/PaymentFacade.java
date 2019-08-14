package facade;

import controller.services.PaymentService;
import factories.JDBCConnectionFactory;
import factories.ServiceFactory;
import model.dto.PaymentDto;
import model.dto.PaymentTransactionDto;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * A class that works with PaymentService.
 *
 * @see PaymentService
 */
public class PaymentFacade {
    private PaymentService service = ServiceFactory.getInstance().getPaymentService();

    /**
     * Method to add payment by using PaymentService {@link #service}.
     *
     * @param paymentDto Object to pass params containing in it.
     * @return <code>true</code> if the payment was added in database; <code>false</code> otherwise.
     * @throws SQLException If sql exception occurred while processing this request.
     * @see PaymentDto
     */
    public boolean addPayment(PaymentDto paymentDto) throws SQLException {
        return service.addPayment(paymentDto);
    }

    /**
     * Method to add payment in transaction by using PaymentService {@link #service}.
     *
     * @param paymentTransactionDto Object to pass params containing in it.
     * @return <code>true</code> if the payment was added in database; <code>false</code> otherwise.
     * @throws SQLException If sql exception occurred while processing this request.
     * @see PaymentTransactionDto
     */
    public boolean addPaymentWithTransaction(PaymentTransactionDto paymentTransactionDto) throws SQLException {
        Connection connection = JDBCConnectionFactory.getInstance().getConnection();
        connection.setTransactionIsolation(Connection.TRANSACTION_REPEATABLE_READ);
        connection.setAutoCommit(false);
        return service.addPaymentWithTransaction(paymentTransactionDto, connection);
    }
}
