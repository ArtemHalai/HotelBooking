package controller.services.admin;

import dao.intefaces.RoomDao;
import factories.DaoFactory;
import model.dto.RoomsAdminDto;

import java.sql.SQLException;

public class RoomInfoAdminService {

    private RoomDao roomDao;

    public RoomInfoAdminService() {
        this.roomDao = DaoFactory.getInstance().getRoomDao();
    }

    public RoomsAdminDto getAllRooms(RoomsAdminDto roomsAdminDto) throws SQLException {
        return roomDao.getAllRooms(roomsAdminDto);
    }
}
