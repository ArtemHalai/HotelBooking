package dao.intefaces;

import model.dto.ReservationsAdminDto;
import model.entity.Guest;
import model.entity.Reservation;

import java.sql.Connection;
import java.sql.SQLException;

public interface ReservationDao {
    int addReservation(Reservation reservation, Connection connection) throws SQLException;

    int addGuestIdToReservation(Guest guest, Reservation reservation, Connection connection) throws SQLException;

    ReservationsAdminDto getAllReservations(ReservationsAdminDto reservationsAdminDto) throws SQLException;

    int count(Connection connection) throws SQLException;
}
