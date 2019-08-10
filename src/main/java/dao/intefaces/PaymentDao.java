package dao.intefaces;

import model.dto.PaymentDto;
import model.dto.PaymentsAdminDto;
import model.entity.Payment;

import java.sql.Connection;
import java.sql.SQLException;

public interface PaymentDao {
    boolean addPayment(PaymentDto paymentDto) throws SQLException;

    boolean addPaymentWithTransaction(Payment payment, Connection connection) throws SQLException;

    PaymentsAdminDto getAllPayments(PaymentsAdminDto paymentsAdminDto) throws SQLException;

    int count(Connection connection) throws SQLException;
}
