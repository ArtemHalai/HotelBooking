package dao.intefaces;

import model.dto.NecessaryRoomDto;
import model.dto.RoomsAdminDto;
import model.entity.Room;

import java.sql.Connection;
import java.sql.SQLException;
import java.text.ParseException;

public interface RoomDao {
    Room getNecessaryRoom(NecessaryRoomDto necessaryRoomDto, Connection connection) throws SQLException, ParseException;

    RoomsAdminDto getAllRooms(RoomsAdminDto roomsAdminDto) throws SQLException;

    int count(Connection connection) throws SQLException;
}
