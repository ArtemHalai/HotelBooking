package controller.services.admin;

import dao.intefaces.GuestDao;
import model.dto.GuestsAdminDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.sql.SQLException;

import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class GuestInfoAdminServiceTest {

    @Mock
    private GuestDao guestDao;

    @InjectMocks
    private GuestInfoAdminService service;

    @Test
    public void getAllGuests() throws SQLException {
        GuestsAdminDto guestsAdminDto = new GuestsAdminDto();
        service.getAllGuests(guestsAdminDto);
        verify(guestDao).getAllGuests(guestsAdminDto);
    }
}