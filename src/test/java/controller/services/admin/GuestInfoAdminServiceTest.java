package controller.services.admin;

import dao.intefaces.GuestDao;
import model.dto.GuestsAdminDto;
import model.entity.Guest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class GuestInfoAdminServiceTest {

    @Mock
    private GuestDao guestDao;

    @InjectMocks
    private GuestInfoAdminService service;

    @Test
    public void getAllGuests() throws SQLException {
        GuestsAdminDto guestsAdminDto = mock(GuestsAdminDto.class);

        List<Guest> list = new ArrayList<>();
        list.add(new Guest("Andrey", "Baranov", 20, "+380000000000", "YE567890"));
        list.add(new Guest("Ivan", "Ferkin", 40, "+380000000000", "YE567890"));
        list.add(new Guest("Sergey", "Dubin", 33, "+380000000000", "YE567890"));
        list.add(new Guest("Kostya", "Klinov", 28, "+380000000000", "YE567890"));

        guestsAdminDto.setList(list);
        when(guestDao.getAllGuests(guestsAdminDto)).thenReturn(guestsAdminDto);
        list = service.getAllGuests(guestsAdminDto).getList().stream().filter(x -> x.getAge() > 30).collect(Collectors.toList());
        verify(guestDao).getAllGuests(guestsAdminDto);
        assertFalse(list.size() > 2);
    }
}