package controller.services.admin;

import dao.intefaces.RoomDao;
import model.dto.RoomsAdminDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.sql.SQLException;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class RoomInfoAdminServiceTest {

    @Mock
    private RoomDao roomDao;

    @InjectMocks
    private RoomInfoAdminService service;

    @Test
    public void getAllRooms() throws SQLException {
        RoomsAdminDto roomsAdminDto = new RoomsAdminDto();
        roomsAdminDto.setCount(10);
        doReturn(roomsAdminDto).when(roomDao).getAllRooms(roomsAdminDto);
        assertEquals(10, service.getAllRooms(roomsAdminDto).getCount());

        service.getAllRooms(roomsAdminDto);
        verify(roomDao, times(2)).getAllRooms(roomsAdminDto);
    }
}