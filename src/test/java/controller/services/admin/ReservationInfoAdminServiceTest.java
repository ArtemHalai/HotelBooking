package controller.services.admin;

import dao.intefaces.ReservationDao;
import model.dto.ReservationsAdminDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.sql.SQLException;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class ReservationInfoAdminServiceTest {

    @Mock
    private ReservationDao reservationDao;

    @InjectMocks
    private ReservationInfoAdminService service;

    @Test
    public void getAllReservations() throws SQLException {
        ReservationsAdminDto reservationsAdminDto = new ReservationsAdminDto();
        service.getAllReservations(reservationsAdminDto);
        service.getAllReservations(reservationsAdminDto);
        service.getAllReservations(reservationsAdminDto);
        verify(reservationDao, times(3)).getAllReservations(reservationsAdminDto);
    }
}