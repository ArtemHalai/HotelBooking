package facade.admin;

import controller.services.admin.RoomInfoAdminService;
import factories.ServiceFactory;
import model.dto.RoomsAdminDto;

import java.sql.SQLException;

/**
 * A class that works with RoomInfoAdminService.
 *
 * @see RoomInfoAdminService
 */
public class RoomsAdminFacade {
    private RoomInfoAdminService service = ServiceFactory.getInstance().getRoomInfoAdminService();

    /**
     * Method to get all rooms by using RoomInfoAdminService {@link #service}.
     *
     * @param roomsAdminDto Object to pass params containing in it.
     * @return Object of RoomsAdminDto containing list of rooms;
     * @throws SQLException If sql exception occurred while processing this request.
     * @see RoomsAdminDto
     */
    public RoomsAdminDto getAllRooms(RoomsAdminDto roomsAdminDto) throws SQLException {
        return service.getAllRooms(roomsAdminDto);
    }
}
