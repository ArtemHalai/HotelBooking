package dao.intefaces;

import model.dto.RoomRequestDto;
import model.dto.RoomRequestsAdminDto;

import java.sql.Connection;
import java.sql.SQLException;
import java.text.ParseException;

public interface RoomRequestDao {
    boolean addRequest(RoomRequestDto roomRequestDto) throws SQLException, ParseException;

    RoomRequestsAdminDto getAllRequests(RoomRequestsAdminDto roomRequestsAdminDto) throws SQLException;

    int count(Connection connection) throws SQLException;
}
