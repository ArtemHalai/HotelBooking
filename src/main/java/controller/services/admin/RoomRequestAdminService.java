package controller.services.admin;

import factories.DaoFactory;
import dao.intefaces.RoomRequestDao;
import model.dto.RoomRequestsAdminDto;

import java.sql.SQLException;

/**
 * A class that works with RoomRequestDao.
 *
 * @see RoomRequestDao
 */
public class RoomRequestAdminService {

    private RoomRequestDao roomRequestDao;

    /**
     * Creates a RoomRequestAdminService object and initialize {@link #roomRequestDao}.
     */
    public RoomRequestAdminService() {
        this.roomRequestDao = DaoFactory.getInstance().getRoomRequestDao();
    }

    /**
     * Method to get all room requests by using RoomRequestDao {@link #roomRequestDao}.
     *
     * @param roomRequestsAdminDto Object to pass params containing in it.
     * @return Object of RoomRequestsAdminDto containing list of room requests;
     * @throws SQLException If sql exception occurred while processing this request.
     * @see RoomRequestsAdminDto
     */
    public RoomRequestsAdminDto getAllRoomRequests(RoomRequestsAdminDto roomRequestsAdminDto) throws SQLException {
        return roomRequestDao.getAllRequests(roomRequestsAdminDto);
    }
}
