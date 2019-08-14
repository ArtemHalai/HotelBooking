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

/**
 * Define an data access object used for executing payment's requests to database using JDBC.
 * This class is implementation of PaymentDao.
 *
 * @see PaymentDao
 */
public class PaymentDaoJDBC implements PaymentDao {

    private Connection connection = null;
    private PreparedStatement statement = null;
    private ResultSet resultSet = null;

    /**
     * Method to get connection.
     *
     * @return The Connection object from connection pool.
     * @throws SQLException If sql exception occurred while processing this request.
     * @see JDBCConnectionFactory
     */
    private Connection getConnection() throws SQLException {
        return JDBCConnectionFactory.getInstance().getConnection();
    }

    /**
     * Method to add payment using {@link #connection}, {@link #statement}, {@link #resultSet}.
     *
     * @param paymentDto The PaymentDto object.
     * @return <code>true</code> if payment was added; <code>false</code> otherwise.
     * @throws SQLException If sql exception occurred while processing this request.
     * @see PaymentDto
     */
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

    /**
     * Method to add payment in transaction using {@link #statement}, {@link #resultSet}.
     *
     * @param payment    The Payment object.
     * @param connection The Connection object to connect to database.
     * @return <code>true</code> if payment was added; <code>false</code> otherwise.
     * @throws SQLException If sql exception occurred while processing this request.
     * @see Payment
     */
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

    /**
     * Method to get all payments from database using {@link #connection}, {@link #statement}, {@link #resultSet}.
     *
     * @param paymentsAdminDto The GuestAdminDto object.
     * @return The PaymentsAdminDto object containing necessary data.
     * @throws SQLException If sql exception occurred while processing this request.
     * @see PaymentsAdminDto
     */
    @Override
    public PaymentsAdminDto getAllPayments(PaymentsAdminDto paymentsAdminDto) throws SQLException {
        String getAllPayments = "SELECT * FROM payments LIMIT ? OFFSET ?";
        connection = getConnection();
        int count = count(connection);
        statement = connection.prepareStatement(getAllPayments);
        statement.setInt(1, Integer.parseInt(PAGE_SIZE.getName()));
        statement.setInt(2, Integer.parseInt(PAGE_SIZE.getName()) * (paymentsAdminDto.getPage() - 1));
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

    /**
     * Method to get count of all payments in database using {@link #statement}, {@link #resultSet}.
     *
     * @param connection The Connection object to connect to database.
     * @return The int value representing amount of all payments in database.
     * @throws SQLException If sql exception occurred while processing this request.
     */
    @Override
    public int count(Connection connection) throws SQLException {
        String count = "SELECT COUNT(*) AS total FROM payments";
        statement = connection.prepareStatement(count);
        resultSet = statement.executeQuery();
        int total = 0;
        if (resultSet.next()) {
            total = resultSet.getInt("total");
        }
        return total;
    }

    /**
     * Method to close all connections that are open in this class {@link #connection}, {@link #statement},
     * {@link #resultSet}.
     *
     * @throws SQLException If sql exception occurred while processing this request.
     */
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
