package dao.intefaces;

import model.dto.GuestDto;
import model.dto.GuestsAdminDto;
import model.dto.PaymentTransactionDto;
import model.entity.Guest;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Define an data access object used for executing guest's requests to database.
 */
public interface GuestDao {

    /**
     * Method to add guest.
     *
     * @param guest The Guest object.
     * @return The int value representing id of added guest.
     * @throws SQLException If sql exception occurred while processing this request.
     * @see Guest
     */
    int addGuest(Guest guest) throws SQLException;

    /**
     * Method to check if guest exists or not.
     *
     * @param guestDto The GuestDto object.
     * @return The Guest object.
     * @throws SQLException If sql exception occurred while processing this request.
     * @see GuestDto
     * @see Guest
     */
    Guest guestExists(GuestDto guestDto) throws SQLException;

    /**
     * Method to check if username exists or not.
     *
     * @param guest      The Guest object.
     * @param connection The Connection object to connect to database.
     * @return <code>true</code> if guest with username exists; <code>false</code> otherwise.
     * @throws SQLException If sql exception occurred while processing this request.
     * @see Guest
     */
    boolean usernameExists(Guest guest, Connection connection) throws SQLException;

    /**
     * Method to add registered guest in database.
     *
     * @param guest      The Guest object.
     * @param connection The Connection object to connect to database.
     * @return <code>true</code> if guest was added; <code>false</code> otherwise.
     * @throws SQLException If sql exception occurred while processing this request.
     * @see Guest
     */
    boolean addRegisteredGuest(Guest guest, Connection connection) throws SQLException;

    /**
     * Method to get all guests from database.
     *
     * @param guestsAdminDto The GuestAdminDto object.
     * @return The GuestsAdminDto object containing necessary data.
     * @throws SQLException If sql exception occurred while processing this request.
     * @see GuestsAdminDto
     */
    GuestsAdminDto getAllGuests(GuestsAdminDto guestsAdminDto) throws SQLException;

    /**
     * Method to get guest from database.
     *
     * @param paymentTransactionDto The PaymentTransactionDto object.
     * @param connection            The Connection object to connect to database.
     * @return The Guest object.
     * @throws SQLException If sql exception occurred while processing this request.
     * @see PaymentTransactionDto
     * @see Guest
     */
    Guest getGuest(PaymentTransactionDto paymentTransactionDto, Connection connection) throws SQLException;

    /**
     * Method to get count of all guests in database.
     *
     * @param connection The Connection object to connect to database.
     * @return The int value representing amount of all guests in database.
     * @throws SQLException If sql exception occurred while processing this request.
     */
    int count(Connection connection) throws SQLException;
}
