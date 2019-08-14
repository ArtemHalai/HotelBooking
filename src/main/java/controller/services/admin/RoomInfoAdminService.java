package controller.services.admin;

import dao.intefaces.RoomDao;
import factories.DaoFactory;
import model.dto.RoomsAdminDto;

import java.sql.SQLException;

/**
 * A class that works with RoomDao.
 *
 * @see RoomDao
 */
public class RoomInfoAdminService {

    private RoomDao roomDao;

    /**
     * Creates a RoomInfoAdminService object and initialize {@link #roomDao}.
     */
    public RoomInfoAdminService() {
        this.roomDao = DaoFactory.getInstance().getRoomDao();
    }

    /**
     * Method to get all rooms by using RoomDao {@link #roomDao}.
     *
     * @param roomsAdminDto Object to pass params containing in it.
     * @return Object of RoomsAdminDto containing list of rooms;
     * @throws SQLException If sql exception occurred while processing this request.
     * @see RoomsAdminDto
     */
    public RoomsAdminDto getAllRooms(RoomsAdminDto roomsAdminDto) throws SQLException {
        return roomDao.getAllRooms(roomsAdminDto);
    }
}
