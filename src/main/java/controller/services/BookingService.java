package controller.services;

import dao.intefaces.ReservationDao;
import dao.intefaces.RoomDao;
import factories.DaoFactory;
import model.dto.BookingApprovementDTO;
import model.dto.NecessaryRoomDto;
import model.entity.Guest;
import model.entity.Reservation;
import model.entity.Room;

import java.sql.Connection;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class BookingService {

    private ReservationDao reservationDao;
    private RoomDao roomDao;

    public BookingService() {
        this.reservationDao = DaoFactory.getInstance().getReservationDao();
        this.roomDao = DaoFactory.getInstance().getRoomDao();
}

    public BookingApprovementDTO booking(NecessaryRoomDto necessaryRoomDto, Connection connection) throws SQLException, ParseException {

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        Date checkIn = dateFormat.parse(necessaryRoomDto.getDateIn());
        Date checkOut = dateFormat.parse(necessaryRoomDto.getDateOut());
        java.sql.Date dateFrom = new java.sql.Date(checkIn.getTime());
        java.sql.Date dateTo = new java.sql.Date(checkOut.getTime());

        BookingApprovementDTO bookingApprovementDTO = null;

        Room room = roomDao.getNecessaryRoom(necessaryRoomDto, connection);

        if (room != null) {

            Reservation reservation = new Reservation(dateFrom, dateTo, room.getId());
            int reservationId = addReservation(reservation, connection);

            bookingApprovementDTO = new BookingApprovementDTO(reservationId, room.getId(),
                    room.getPrice() * TimeUnit.DAYS.convert(dateTo.getTime() - dateFrom.getTime(), TimeUnit.MILLISECONDS));

            connection.commit();
            connection.close();
        } else {
            connection.rollback();
            connection.close();
        }
        return bookingApprovementDTO;
    }

    public int addReservation(Reservation reservation, Connection connection) throws SQLException {
        return reservationDao.addReservation( reservation, connection);
    }

    public boolean addGuestIdToReservation(Guest guest, Reservation reservation, Connection connection) throws SQLException {

        if (reservationDao.addGuestIdToReservation(guest, reservation, connection) == 1) {
            connection.close();
            return true;
        }
        connection.close();
        return false;
    }
}
