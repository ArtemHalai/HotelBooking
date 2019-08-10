package controller.services;

import dao.intefaces.GuestDao;
import model.entity.Guest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.sql.SQLException;

import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class GuestInfoServiceTest {

    @Mock
    private GuestDao dao;

    @InjectMocks
    private GuestInfoService infoService = new GuestInfoService();

    @Test
    public void addGuest() throws SQLException {
        Guest guest = new Guest();
        infoService.addGuest(guest);
        verify(dao).addGuest(guest);
    }
}