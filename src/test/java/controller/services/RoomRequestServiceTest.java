package controller.services;

import dao.intefaces.RoomRequestDao;
import model.dto.RoomRequestDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.sql.SQLException;
import java.text.ParseException;

import static org.junit.Assert.assertFalse;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class RoomRequestServiceTest {

    @Mock
    private RoomRequestDao roomRequestDao;

    @InjectMocks
    private RoomRequestService service;


    @Test(expected = SQLException.class)
    public void addRoomRequest() throws ParseException, SQLException {
        RoomRequestDto roomRequestDto = new RoomRequestDto();
        when(service.addRoomRequest(roomRequestDto)).thenReturn(false);
        assertFalse(service.addRoomRequest(roomRequestDto));
        verify(roomRequestDao).addRequest(roomRequestDto);

        doThrow(new SQLException()).when(roomRequestDao).addRequest(null);
        roomRequestDao.addRequest(null);
    }
}