package controller.services;

import dao.intefaces.ReservationDao;
import dao.intefaces.RoomDao;
import model.dto.NecessaryRoomDto;
import model.entity.Guest;
import model.entity.Reservation;
import model.entity.Room;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.sql.Connection;
import java.sql.SQLException;
import java.text.ParseException;

import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class BookingServiceTest {


    @Mock
    private ReservationDao reservationDao;

    @Mock
    private RoomDao roomDao;

    @Mock
    private Connection connection;

    @InjectMocks
    private BookingService service = new BookingService();

    @Test
    public void booking() throws SQLException, ParseException {
        NecessaryRoomDto necessaryRoomDto = new NecessaryRoomDto();
        necessaryRoomDto.setBalcony("on");
        necessaryRoomDto.setSmoke("on");
        necessaryRoomDto.setDateIn("2019-07-21");
        necessaryRoomDto.setDateOut("2019-07-23");
        necessaryRoomDto.setRoomTypeId("1");
        necessaryRoomDto.setPriceRange("0-300");
        service.booking(necessaryRoomDto, connection);

        verify(roomDao).getNecessaryRoom(necessaryRoomDto, connection);

        Reservation reservation = new Reservation();
        reservation.setDateIn(null);
        reservation.setDateOut(null);
        Room room = new Room();
        room.setId(1);
        room.setPrice(200);

        service.addReservation(reservation, connection);
        verify(reservationDao).addReservation(reservation, connection);
    }

    @Test
    public void addGuestIdToReservation() throws SQLException {
        Guest guest = new Guest();
        Reservation reservation = new Reservation();
        service.addGuestIdToReservation(guest, reservation, connection);
        verify(reservationDao).addGuestIdToReservation(guest, reservation, connection);
    }
}