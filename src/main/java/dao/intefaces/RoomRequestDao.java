package dao.intefaces;

import model.dto.RoomRequestDto;
import model.dto.RoomRequestsAdminDto;

import java.sql.Connection;
import java.sql.SQLException;
import java.text.ParseException;

/**
 * Define an data access object used for executing room request's requests to database.
 */
public interface RoomRequestDao {

    /**
     * Method to add room request.
     *
     * @param roomRequestDto The RoomRequestDto object.
     * @return <code>true</code> if room request was added; <code>false</code> otherwise..
     * @throws SQLException If sql exception occurred while processing this request.
     * @see RoomRequestDto
     */
    boolean addRequest(RoomRequestDto roomRequestDto) throws SQLException, ParseException;

    /**
     * Method to get all room requests from database.
     *
     * @param roomRequestsAdminDto The RoomRequestsAdminDto object.
     * @return The RoomRequestsAdminDto object containing necessary data.
     * @throws SQLException If sql exception occurred while processing this request.
     * @see RoomRequestsAdminDto
     */
    RoomRequestsAdminDto getAllRequests(RoomRequestsAdminDto roomRequestsAdminDto) throws SQLException;

    /**
     * Method to get count of all room requests in database.
     *
     * @param connection The Connection object to connect to database.
     * @return The int value representing amount of all room requests in database.
     * @throws SQLException If sql exception occurred while processing this request.
     */
    int count(Connection connection) throws SQLException;
}
