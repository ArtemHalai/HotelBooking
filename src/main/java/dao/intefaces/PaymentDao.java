package dao.intefaces;

import model.dto.PaymentDto;
import model.dto.PaymentsAdminDto;
import model.entity.Payment;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Define an data access object used for executing payment's requests to database.
 */
public interface PaymentDao {

    /**
     * Method to add payment.
     *
     * @param paymentDto The PaymentDto object.
     * @return <code>true</code> if payment was added; <code>false</code> otherwise.
     * @throws SQLException If sql exception occurred while processing this request.
     * @see PaymentDto
     */
    boolean addPayment(PaymentDto paymentDto) throws SQLException;

    /**
     * Method to add payment in transaction.
     *
     * @param payment    The Payment object.
     * @param connection The Connection object to connect to database.
     * @return <code>true</code> if payment was added; <code>false</code> otherwise.
     * @throws SQLException If sql exception occurred while processing this request.
     * @see Payment
     */
    boolean addPaymentWithTransaction(Payment payment, Connection connection) throws SQLException;

    /**
     * Method to get all payments from database.
     *
     * @param paymentsAdminDto The GuestAdminDto object.
     * @return The PaymentsAdminDto object containing necessary data.
     * @throws SQLException If sql exception occurred while processing this request.
     * @see PaymentsAdminDto
     */
    PaymentsAdminDto getAllPayments(PaymentsAdminDto paymentsAdminDto) throws SQLException;

    /**
     * Method to get count of all payments in database.
     *
     * @param connection The Connection object to connect to database.
     * @return The int value representing amount of all payments in database.
     * @throws SQLException If sql exception occurred while processing this request.
     */
    int count(Connection connection) throws SQLException;
}
