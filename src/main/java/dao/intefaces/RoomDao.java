package dao.intefaces;

import model.dto.NecessaryRoomDto;
import model.dto.RoomsAdminDto;
import model.entity.Room;

import java.sql.Connection;
import java.sql.SQLException;
import java.text.ParseException;

/**
 * Define an data access object used for executing room's requests to database.
 */
public interface RoomDao {

    /**
     * Method to find room in database with given params.
     *
     * @param necessaryRoomDto The NecessaryRoomDto object containing params of necessary room.
     * @param connection       The Connection object to connect to database.
     * @return The Room object.
     * @throws SQLException If sql exception occurred while processing this request.
     * @see NecessaryRoomDto
     */
    Room getNecessaryRoom(NecessaryRoomDto necessaryRoomDto, Connection connection) throws SQLException, ParseException;

    /**
     * Method to get all rooms from database.
     *
     * @param roomsAdminDto The RoomsAdminDto object.
     * @return The RoomsAdminDto object containing necessary data.
     * @throws SQLException If sql exception occurred while processing this request.
     * @see RoomsAdminDto
     */
    RoomsAdminDto getAllRooms(RoomsAdminDto roomsAdminDto) throws SQLException;

    /**
     * Method to get count of all rooms in database.
     *
     * @param connection The Connection object to connect to database.
     * @return The int value representing amount of all rooms in database.
     * @throws SQLException If sql exception occurred while processing this request.
     */
    int count(Connection connection) throws SQLException;
}
