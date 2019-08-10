package facade.admin;

import controller.services.admin.RoomRequestAdminService;
import factories.ServiceFactory;
import model.dto.RoomRequestsAdminDto;
import model.entity.RoomRequest;

import java.sql.SQLException;
import java.util.List;

public class RoomRequestsAdminFacade {
    private RoomRequestAdminService service = ServiceFactory.getInstance().getRoomRequestAdminService();

    public RoomRequestsAdminDto getAllRoomRequests(RoomRequestsAdminDto roomRequestsAdminDto) throws SQLException {
        return service.getAllRoomRequests(roomRequestsAdminDto);
    }
}
