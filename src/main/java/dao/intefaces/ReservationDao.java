package dao.intefaces;

import model.dto.ReservationsAdminDto;
import model.entity.Guest;
import model.entity.Reservation;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Define an data access object used for executing reservation's requests to database.
 */
public interface ReservationDao {

    /**
     * Method to add reservation.
     *
     * @param reservation The Reservation object.
     * @param connection  The Connection object to connect to database.
     * @return The int value representing id of added reservation.
     * @throws SQLException If sql exception occurred while processing this request.
     * @see Reservation
     */
    int addReservation(Reservation reservation, Connection connection) throws SQLException;

    /**
     * Method to add guest id to reservation.
     *
     * @param guest       The Guest object.
     * @param reservation The Reservation object.
     * @param connection  The Connection object to connect to database.
     * @return The int value representing count of updated rows in database.
     * @throws SQLException If sql exception occurred while processing this request.
     * @see Reservation
     * @see Guest
     */
    int addGuestIdToReservation(Guest guest, Reservation reservation, Connection connection) throws SQLException;

    /**
     * Method to get all reservations from database.
     *
     * @param reservationsAdminDto The ReservationsAdminDto object.
     * @return The ReservationsAdminDto object containing necessary data.
     * @throws SQLException If sql exception occurred while processing this request.
     * @see ReservationsAdminDto
     */
    ReservationsAdminDto getAllReservations(ReservationsAdminDto reservationsAdminDto) throws SQLException;

    /**
     * Method to get count of all reservations in database.
     *
     * @param connection The Connection object to connect to database.
     * @return The int value representing amount of all reservations in database.
     * @throws SQLException If sql exception occurred while processing this request.
     */
    int count(Connection connection) throws SQLException;
}
