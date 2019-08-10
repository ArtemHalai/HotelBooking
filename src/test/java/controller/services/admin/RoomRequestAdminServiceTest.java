package controller.services.admin;

import dao.intefaces.RoomRequestDao;
import model.dto.RoomRequestsAdminDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.sql.SQLException;

import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class RoomRequestAdminServiceTest {

    @Mock
    private RoomRequestDao roomRequestDao;

    @InjectMocks
    private RoomRequestAdminService service;

    @Test
    public void getAllRoomRequests() throws SQLException {
        RoomRequestsAdminDto roomRequestsAdminDto = new RoomRequestsAdminDto();
        service.getAllRoomRequests(roomRequestsAdminDto);
        verify(roomRequestDao).getAllRequests(roomRequestsAdminDto);
    }
}