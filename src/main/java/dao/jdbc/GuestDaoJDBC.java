package dao.jdbc;

import dao.intefaces.GuestDao;
import enums.Role;
import factories.JDBCConnectionFactory;
import model.dto.GuestDto;
import model.dto.GuestsAdminDto;
import model.dto.PaymentTransactionDto;
import model.entity.Guest;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static enums.Attributes.PAGE_SIZE;

/**
 * Define an data access object used for executing guest's requests to database using JDBC.
 * This class is implementation of GuestDao.
 *
 * @see GuestDao
 */
public class GuestDaoJDBC implements GuestDao {

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
     * Method to add guest using {@link #connection}, {@link #statement}, {@link #resultSet}.
     *
     * @param guest The Guest object.
     * @return The int value representing id of added guest.
     * @throws SQLException If sql exception occurred while processing this request.
     * @see Guest
     */
    public int addGuest(Guest guest) throws SQLException {
        String insertGuest = "INSERT INTO users (name, surname, username, password, age, phone, passport_id, role) VALUES (" +
                "?,?,?,?,?,?,?,?)";
        connection = getConnection();
        statement = connection.prepareStatement(insertGuest, Statement.RETURN_GENERATED_KEYS);
        statement.setString(1, guest.getName());
        statement.setString(2, guest.getSurname());
        statement.setString(3, guest.getUsername());
        statement.setString(4, guest.getPassword());
        statement.setInt(5, guest.getAge());
        statement.setString(6, guest.getPhone());
        statement.setString(7, guest.getPassportId());
        statement.setString(8, guest.getRole().toString());

        statement.executeUpdate();

        int guestId = -1;
        resultSet = statement.getGeneratedKeys();
        if (resultSet.next()) {
            guestId = resultSet.getInt(1);
        }
        close();
        return guestId;
    }

    /**
     * Method to check if guest exists or not using {@link #connection}, {@link #statement}, {@link #resultSet}.
     *
     * @param guestDto The GuestDto object.
     * @return The Guest object.
     * @throws SQLException If sql exception occurred while processing this request.
     * @see GuestDto
     * @see Guest
     */
    public Guest guestExists(GuestDto guestDto) throws SQLException {
        String getGuest = "SELECT * FROM users WHERE username = ? AND password = ?";
        connection = getConnection();
        statement = connection.prepareStatement(getGuest);
        statement.setString(1, guestDto.getUsername());
        statement.setString(2, guestDto.getPassword());
        resultSet = statement.executeQuery();

        Guest guest = null;
        while (resultSet.next()) {
            int id = resultSet.getInt("user_id");
            String name = resultSet.getString("name");
            String surName = resultSet.getString("surname");
            int age = resultSet.getInt("age");
            String phone = resultSet.getString("phone");
            String passportId = resultSet.getString("passport_id");
            String role = resultSet.getString("role");
            guest = new Guest(id, name, surName, age, phone, passportId);
            if (role != null) {
                guest.setRole(Role.valueOf(role));
            }
        }
        close();
        return guest;
    }

    /**
     * Method to check if username exists or not using {@link #statement}, {@link #resultSet}.
     *
     * @param guest      The Guest object.
     * @param connection The Connection object to connect to database.
     * @return <code>true</code> if guest with username exists; <code>false</code> otherwise.
     * @throws SQLException If sql exception occurred while processing this request.
     * @see Guest
     */
    public boolean usernameExists(Guest guest, Connection connection) throws SQLException {
        String getGuest = "SELECT * FROM users WHERE username = ?";

        statement = connection.prepareStatement(getGuest);
        statement.setString(1, guest.getUsername());
        resultSet = statement.executeQuery();

        if (resultSet.next()) {
            close();
            return true;
        }
        close();
        return false;
    }

    /**
     * Method to add registered guest in database using {@link #statement}, {@link #resultSet}.
     *
     * @param guest      The Guest object.
     * @param connection The Connection object to connect to database.
     * @return <code>true</code> if guest was added; <code>false</code> otherwise.
     * @throws SQLException If sql exception occurred while processing this request.
     * @see Guest
     */
    public boolean addRegisteredGuest(Guest guest, Connection connection) throws SQLException {
        String insertGuest = "INSERT INTO users (name, surname, username, password, age, phone, passport_id, role) VALUES (" +
                "?,?,?,?,?,?,?,?)";
        statement = connection.prepareStatement(insertGuest, Statement.RETURN_GENERATED_KEYS);
        statement.setString(1, guest.getName());
        statement.setString(2, guest.getSurname());
        statement.setString(3, guest.getUsername());
        statement.setString(4, guest.getPassword());
        statement.setInt(5, guest.getAge());
        statement.setString(6, guest.getPhone());
        statement.setString(7, guest.getPassportId());
        statement.setString(8, guest.getRole().toString());

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
     * Method to get all guests from database using {@link #connection}, {@link #statement}, {@link #resultSet}.
     *
     * @param guestsAdminDto The GuestAdminDto object.
     * @return The GuestsAdminDto object containing necessary data.
     * @throws SQLException If sql exception occurred while processing this request.
     * @see GuestsAdminDto
     */
    public GuestsAdminDto getAllGuests(GuestsAdminDto guestsAdminDto) throws SQLException {
        String getAllGuests = "SELECT * FROM users LIMIT ? OFFSET ?";
        connection = getConnection();
        int count = count(connection);
        statement = connection.prepareStatement(getAllGuests);
        statement.setInt(1, Integer.parseInt(PAGE_SIZE.getName()));
        statement.setInt(2, Integer.parseInt(PAGE_SIZE.getName()) * (guestsAdminDto.getPage() - 1));
        resultSet = statement.executeQuery();

        List<Guest> list = new ArrayList<>();

        while (resultSet.next()) {
            int id = resultSet.getInt("user_id");
            String name = resultSet.getString("name");
            String surname = resultSet.getString("surname");
            String username = resultSet.getString("username");
            String password = resultSet.getString("password");
            int age = resultSet.getInt("age");
            String phone = resultSet.getString("phone");
            String passportId = resultSet.getString("passport_id");

            Guest guest = new Guest(id, name, surname, username, password, age, phone, passportId);
            list.add(guest);
        }

        guestsAdminDto.setList(list);
        guestsAdminDto.setCount(count);
        close();
        return guestsAdminDto;
    }

    /**
     * Method to get guest from database using {@link #statement}, {@link #resultSet}.
     *
     * @param paymentTransactionDto The PaymentTransactionDto object.
     * @param connection            The Connection object to connect to database.
     * @return The Guest object.
     * @throws SQLException If sql exception occurred while processing this request.
     * @see PaymentTransactionDto
     * @see Guest
     */
    @Override
    public Guest getGuest(PaymentTransactionDto paymentTransactionDto, Connection connection) throws SQLException {
        String getGuest = "SELECT * FROM users WHERE username = ?";

        statement = connection.prepareStatement(getGuest);
        statement.setString(1, paymentTransactionDto.getUsername());
        resultSet = statement.executeQuery();

        Guest guest = null;
        if (resultSet.next()) {
            guest = new Guest();
            guest.setGuestId(resultSet.getInt("user_id"));
        }
        close();
        return guest;
    }

    /**
     * Method to get count of all guests in database using {@link #statement}, {@link #resultSet}.
     *
     * @param connection The Connection object to connect to database.
     * @return The int value representing amount of all guests in database.
     * @throws SQLException If sql exception occurred while processing this request.
     */
    @Override
    public int count(Connection connection) throws SQLException {
        String count = "SELECT COUNT(*) AS total FROM users";
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
