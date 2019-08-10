package facade;

import controller.services.RoomRequestService;
import factories.ServiceFactory;
import model.dto.RoomRequestDto;

import java.sql.SQLException;
import java.text.ParseException;

public class RoomRequestFacade {
    private RoomRequestService service = ServiceFactory.getInstance().getRoomRequestService();

    public boolean addRoomRequest(RoomRequestDto roomRequestDto) throws ParseException, SQLException {
        return service.addRoomRequest(roomRequestDto);
    }
}
