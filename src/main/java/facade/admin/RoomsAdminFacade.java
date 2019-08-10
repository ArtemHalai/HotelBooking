package facade.admin;

import controller.services.admin.RoomInfoAdminService;
import factories.ServiceFactory;
import model.dto.RoomsAdminDto;

import java.sql.SQLException;

public class RoomsAdminFacade {
    private RoomInfoAdminService service = ServiceFactory.getInstance().getRoomInfoAdminService();

    public RoomsAdminDto getAllRooms(RoomsAdminDto roomsAdminDto) throws SQLException {
        return service.getAllRooms(roomsAdminDto);
    }
}
