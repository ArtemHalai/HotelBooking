package dao.jdbc;

import dao.intefaces.PaymentDao;
import factories.JDBCConnectionFactory;
import model.dto.PaymentDto;
import model.dto.PaymentsAdminDto;
import model.entity.Payment;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import static enums.Attributes.PAGE_SIZE;

public class PaymentDaoJDBC implements PaymentDao {

    private Connection connection = null;
    private PreparedStatement statement = null;
    private ResultSet resultSet = null;

    private Connection getConnection() throws SQLException {
        return JDBCConnectionFactory.getInstance().getConnection();
    }

    @Override
    public boolean addPayment(PaymentDto paymentDto) throws SQLException {
        String insertPayment = "INSERT INTO payments (room_id, amount, user_id, payment_date) VALUES (?,?,?,?)";
        connection = getConnection();

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date d = Date.valueOf(simpleDateFormat.format(new java.util.Date()));
        Payment payment = new Payment(paymentDto.getRoomId(), paymentDto.getPrice(), d, paymentDto.getGuestId());
        statement = connection.prepareStatement(insertPayment, Statement.RETURN_GENERATED_KEYS);
        statement.setInt(1, payment.getRoomId());
        statement.setDouble(2, payment.getAmount());
        statement.setInt(3, payment.getGuestId());
        statement.setDate(4, payment.getPaymentDate(), Calendar.getInstance());
        statement.executeUpdate();

        resultSet = statement.getGeneratedKeys();
        if (resultSet.next()) {
            close();
            return true;
        }
        close();
        return false;
    }

    @Override
    public boolean addPaymentWithTransaction(Payment payment, Connection connection) throws SQLException {
        String insertPayment = "INSERT INTO payments (room_id, amount, user_id, payment_date) VALUES (?,?,?,?)";

        statement = connection.prepareStatement(insertPayment, Statement.RETURN_GENERATED_KEYS);
        statement.setInt(1, payment.getRoomId());
        statement.setDouble(2, payment.getAmount());
        statement.setInt(3, payment.getGuestId());
        statement.setDate(4, payment.getPaymentDate(), Calendar.getInstance());
        statement.executeUpdate();

        resultSet = statement.getGeneratedKeys();

        if (resultSet.next()) {
            close();
            return true;
        }
        close();
        return false;
    }

    @Override
    public PaymentsAdminDto getAllPayments(PaymentsAdminDto paymentsAdminDto) throws SQLException {
        String getAllPayments = "SELECT * FROM payments LIMIT ? OFFSET ?";
        connection = getConnection();
        int count = count(connection);
        statement = connection.prepareStatement(getAllPayments);
        statement.setInt(1,Integer.parseInt(PAGE_SIZE.getName()));
        statement.setInt(2, Integer.parseInt(PAGE_SIZE.getName()) *(paymentsAdminDto.getPage()-1));
        resultSet = statement.executeQuery();

        List<Payment> list = new ArrayList<>();

        while (resultSet.next()) {
            int id = resultSet.getInt("payment_id");
            int roomId = resultSet.getInt("room_id");
            double amount = resultSet.getDouble("amount");
            int guestId = resultSet.getInt("user_id");
            Date paymentDate = resultSet.getDate("payment_date");
            Payment payment = new Payment(id, roomId, amount, paymentDate, guestId);
            list.add(payment);
        }

        paymentsAdminDto.setList(list);
        paymentsAdminDto.setCount(count);
        close();
        return paymentsAdminDto;
    }

    @Override
    public int count(Connection connection) throws SQLException {
        String count = "SELECT COUNT(*) AS total FROM payments";
        statement = connection.prepareStatement(count);
        resultSet = statement.executeQuery();
        int total = 0;
        if (resultSet.next()){
            total = resultSet.getInt("total");
        }
        return total;
    }

    public void close() throws SQLException {
        try {
            if (resultSet != null) {
                resultSet.close();
            }
            if (statement != null) {
                statement.close();
            }
            if (connection != null) {
                connection.close();
            }
        } finally {
            if (statement != null) {
                statement.close();
            }
            if (connection != null) {
                connection.close();
            }
        }
    }
}
