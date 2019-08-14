package facade.admin;

import controller.services.admin.RoomRequestAdminService;
import factories.ServiceFactory;
import model.dto.RoomRequestsAdminDto;

import java.sql.SQLException;

/**
 * A class that works with RoomRequestAdminService.
 *
 * @see RoomRequestAdminService
 */
public class RoomRequestsAdminFacade {
    private RoomRequestAdminService service = ServiceFactory.getInstance().getRoomRequestAdminService();

    /**
     * Method to get all room requests by using RoomRequestAdminService {@link #service}.
     *
     * @param roomRequestsAdminDto Object to pass params containing in it.
     * @return Object of RoomRequestsAdminDto containing list of room requests;
     * @throws SQLException If sql exception occurred while processing this request.
     * @see RoomRequestsAdminDto
     */
    public RoomRequestsAdminDto getAllRoomRequests(RoomRequestsAdminDto roomRequestsAdminDto) throws SQLException {
        return service.getAllRoomRequests(roomRequestsAdminDto);
    }
}
