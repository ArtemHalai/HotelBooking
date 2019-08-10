package controller.services.admin;

import factories.DaoFactory;
import dao.intefaces.RoomRequestDao;
import model.dto.RoomRequestsAdminDto;
import model.entity.RoomRequest;
import java.sql.SQLException;
import java.util.List;

public class RoomRequestAdminService {

    private RoomRequestDao roomRequestDao;

    public RoomRequestAdminService() {
        this.roomRequestDao = DaoFactory.getInstance().getRoomRequestDao();
    }

    public RoomRequestsAdminDto getAllRoomRequests(RoomRequestsAdminDto roomRequestsAdminDto) throws SQLException {
        return roomRequestDao.getAllRequests(roomRequestsAdminDto);
    }
}
