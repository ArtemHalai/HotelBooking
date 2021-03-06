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

/**
 * A class that works with ReservationDao, RoomDao.
 *
 * @see ReservationDao
 * @see RoomDao
 */
public class BookingService {

    private ReservationDao reservationDao;
    private RoomDao roomDao;

    /**
     * Creates a BookingService object and initialize {@link #reservationDao}, {@link #roomDao}.
     */
    public BookingService() {
        this.reservationDao = DaoFactory.getInstance().getReservationDao();
        this.roomDao = DaoFactory.getInstance().getRoomDao();
    }

    /**
     * Method to create booking by using ReservationDao {@link #reservationDao} and RoomDao {@link #roomDao}.
     *
     * @param necessaryRoomDto Object to pass params containing in it.
     * @return Object of BookingApprovementDto.
     * @throws SQLException   If sql exception occurred while processing this request.
     * @throws ParseException If parse exception occurred while processing this request.
     * @see BookingApprovementDTO
     * @see NecessaryRoomDto
     */
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
            int reservationId = reservationDao.addReservation(reservation, connection);

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

    /**
     * Method to add guest id to created reservation by using ReservationDao {@link #reservationDao}.
     *
     * @param guest       Object to pass params containing in it.
     * @param reservation Object to pass params containing in it.
     * @param connection  Connection to connect to database.
     * @return boolean value which says if adding was successful or not.
     * @throws SQLException If sql exception occurred while processing this request.
     * @see Guest
     * @see Reservation
     */
    public boolean addGuestIdToReservation(Guest guest, Reservation reservation, Connection connection) throws SQLException {

        if (reservationDao.addGuestIdToReservation(guest, reservation, connection) == 1) {
            connection.close();
            return true;
        }
        connection.close();
        return false;
    }
}
