package facade;

import controller.services.PaymentService;
import factories.JDBCConnectionFactory;
import factories.ServiceFactory;
import model.dto.PaymentDto;
import model.dto.PaymentTransactionDto;

import java.sql.Connection;
import java.sql.SQLException;

public class PaymentFacade {
    private PaymentService service = ServiceFactory.getInstance().getPaymentService();

    public boolean addPayment(PaymentDto paymentDto) throws SQLException {
        return service.addPayment(paymentDto);
    }

    public boolean addPaymentWithTransaction(PaymentTransactionDto paymentTransactionDto) throws SQLException {
        Connection connection = JDBCConnectionFactory.getInstance().getConnection();
        connection.setTransactionIsolation(Connection.TRANSACTION_REPEATABLE_READ);
        connection.setAutoCommit(false);
        return service.addPaymentWithTransaction(paymentTransactionDto, connection);
    }
}
