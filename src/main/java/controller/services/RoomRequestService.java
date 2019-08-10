package controller.services;

import dao.intefaces.RoomRequestDao;
import factories.DaoFactory;
import model.dto.RoomRequestDto;

import java.sql.SQLException;
import java.text.ParseException;

public class RoomRequestService {

    private RoomRequestDao roomRequestDao;

    public RoomRequestService() {
        this.roomRequestDao = DaoFactory.getInstance().getRoomRequestDao();
    }

    public boolean addRoomRequest(RoomRequestDto roomRequestDto) throws ParseException, SQLException {
        return roomRequestDao.addRequest(roomRequestDto);
    }
}
