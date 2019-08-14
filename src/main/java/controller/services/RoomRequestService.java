package controller.services;

import dao.intefaces.RoomRequestDao;
import factories.DaoFactory;
import model.dto.RoomRequestDto;

import java.sql.SQLException;
import java.text.ParseException;

/**
 * A class that works with RoomRequestDao.
 *
 * @see RoomRequestDao
 */
public class RoomRequestService {

    private RoomRequestDao roomRequestDao;

    /**
     * Creates a RoomRequestService object and initialize {@link #roomRequestDao}.
     */
    public RoomRequestService() {
        this.roomRequestDao = DaoFactory.getInstance().getRoomRequestDao();
    }

    /**
     * Method to add room request by using RoomRequestDao {@link #roomRequestDao}.
     *
     * @param roomRequestDto Object to pass params containing in it.
     * @return <code>true</code> if the request was added;
     * <code>false</code> otherwise.
     * @throws SQLException   If sql exception occurred while processing this request.
     * @throws ParseException If parse exception occurred while processing this request.
     * @see RoomRequestDto
     */
    public boolean addRoomRequest(RoomRequestDto roomRequestDto) throws ParseException, SQLException {
        return roomRequestDao.addRequest(roomRequestDto);
    }
}
