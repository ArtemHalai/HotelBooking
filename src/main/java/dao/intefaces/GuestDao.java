package dao.intefaces;

import model.dto.GuestDto;
import model.dto.GuestsAdminDto;
import model.dto.PaymentTransactionDto;
import model.entity.Guest;

import java.sql.Connection;
import java.sql.SQLException;

public interface GuestDao {
    int addGuest(Guest guest) throws SQLException;

    Guest guestExists(GuestDto guestDto) throws SQLException;

    boolean usernameExists(Guest guest, Connection connection) throws SQLException;

    boolean addRegisteredGuest(Guest guest, Connection connection) throws SQLException;

   GuestsAdminDto getAllGuests(GuestsAdminDto guestsAdminDto) throws SQLException;

    Guest getGuest(PaymentTransactionDto paymentTransactionDto, Connection connection) throws SQLException;

    int count(Connection connection) throws SQLException;
}
