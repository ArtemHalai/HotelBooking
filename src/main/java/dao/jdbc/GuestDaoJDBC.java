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

public class GuestDaoJDBC implements GuestDao {

    private Connection connection = null;
    private PreparedStatement statement = null;
    private ResultSet resultSet = null;

    private Connection getConnection() throws SQLException {
        return JDBCConnectionFactory.getInstance().getConnection();
    }

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
