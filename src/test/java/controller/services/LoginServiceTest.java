package controller.services;

import dao.intefaces.GuestDao;
import model.dto.GuestDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.sql.SQLException;

import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class LoginServiceTest {

    @Mock
    private GuestDao guestDao;

    @InjectMocks
    private LoginService service;

    @Test
    public void guestExist() throws SQLException {
        GuestDto guest = new GuestDto();
        service.guestExist(guest);
        verify(guestDao).guestExists(guest);
    }
}