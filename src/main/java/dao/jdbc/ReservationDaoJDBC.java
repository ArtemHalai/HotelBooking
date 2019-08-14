package dao.jdbc;

import dao.intefaces.ReservationDao;
import factories.JDBCConnectionFactory;
import model.dto.ReservationsAdminDto;
import model.entity.Guest;
import model.entity.Reservation;

import java.sql.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import static enums.Attributes.PAGE_SIZE;

/**
 * Define an data access object used for executing reservation's requests to database using JDBC.
 * This class is implementation of ReservationDao.
 *
 * @see ReservationDao
 */
public class ReservationDaoJDBC implements ReservationDao {

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
     * Method to add reservation using {@link #statement}, {@link #resultSet}.
     *
     * @param reservation The Reservation object.
     * @param connection  The Connection object to connect to database.
     * @return The int value representing id of added reservation.
     * @throws SQLException If sql exception occurred while processing this request.
     * @see Reservation
     */
    @Override
    public int addReservation(Reservation reservation, Connection connection) throws SQLException {
        String insertReservation = "INSERT INTO reservations (date_in, date_out, room_id) VALUES (?,?,?)";
        statement = connection.prepareStatement(insertReservation, Statement.RETURN_GENERATED_KEYS);
        statement.setDate(1, reservation.getDateIn(), Calendar.getInstance());
        statement.setDate(2, reservation.getDateOut(), Calendar.getInstance());
        statement.setInt(3, reservation.getRoomId());


        statement.executeUpdate();

        resultSet = statement.getGeneratedKeys();

        int reservationId = -1;
        if (resultSet.next()) {
            reservationId = resultSet.getInt(1);
        }

        close();
        return reservationId;
    }

    /**
     * Method to add guest id to reservation using {@link #statement}, {@link #resultSet}.
     *
     * @param guest       The Guest object.
     * @param reservation The Reservation object.
     * @param connection  The Connection object to connect to database.
     * @return The int value representing count of updated rows in database.
     * @throws SQLException If sql exception occurred while processing this request.
     * @see Reservation
     * @see Guest
     */
    @Override
    public int addGuestIdToReservation(Guest guest, Reservation reservation, Connection connection) throws SQLException {
        String addGuestId = "UPDATE reservations SET user_id = ? WHERE reservation_id = ?";
        statement = connection.prepareStatement(addGuestId, Statement.RETURN_GENERATED_KEYS);
        statement.setInt(1, guest.getGuestId());
        statement.setInt(2, reservation.getId());

        int count = statement.executeUpdate();

        close();
        return count;
    }

    /**
     * Method to get all reservations from database using {@link #connection}, {@link #statement}, {@link #resultSet}.
     *
     * @param reservationsAdminDto The ReservationsAdminDto object.
     * @return The ReservationsAdminDto object containing necessary data.
     * @throws SQLException If sql exception occurred while processing this request.
     * @see ReservationsAdminDto
     */
    public ReservationsAdminDto getAllReservations(ReservationsAdminDto reservationsAdminDto) throws SQLException {
        String getAllReservations = "SELECT * FROM reservations LIMIT ? OFFSET ?";
        connection = getConnection();
        int count = count(connection);
        statement = connection.prepareStatement(getAllReservations);
        statement.setInt(1, Integer.parseInt(PAGE_SIZE.getName()));
        statement.setInt(2, Integer.parseInt(PAGE_SIZE.getName()) * (reservationsAdminDto.getPage() - 1));
        resultSet = statement.executeQuery();

        List<Reservation> list = new ArrayList<>();

        while (resultSet.next()) {
            int reservationId = resultSet.getInt("reservation_id");
            java.sql.Date dateIn = resultSet.getDate("date_in");
            java.sql.Date dateOut = resultSet.getDate("date_out");
            int roomId = resultSet.getInt("room_id");
            int guestId = resultSet.getInt("user_id");

            list.add(new Reservation(reservationId, dateIn, dateOut, guestId, roomId));
        }
        reservationsAdminDto.setList(list);
        reservationsAdminDto.setCount(count);
        close();
        return reservationsAdminDto;
    }

    /**
     * Method to get count of all reservations in database using {@link #statement},
     * {@link #resultSet}.
     *
     * @param connection The Connection object to connect to database.
     * @return The int value representing amount of all reservations in database.
     * @throws SQLException If sql exception occurred while processing this request.
     */
    @Override
    public int count(Connection connection) throws SQLException {
        String count = "SELECT COUNT(*) AS total FROM reservations";
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
