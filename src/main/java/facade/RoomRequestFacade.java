package facade;

import controller.services.RoomRequestService;
import factories.ServiceFactory;
import model.dto.RoomRequestDto;

import java.sql.SQLException;
import java.text.ParseException;

/**
 * A class that works with RoomRequestService.
 *
 * @see RoomRequestService
 */
public class RoomRequestFacade {
    private RoomRequestService service = ServiceFactory.getInstance().getRoomRequestService();

    /**
     * Method to add room request by using RoomRequestService {@link #service}.
     *
     * @param roomRequestDto Object to pass params containing in it.
     * @return <code>true</code> if the request was added;
     * <code>false</code> otherwise.
     * @throws SQLException   If sql exception occurred while processing this request.
     * @throws ParseException If parse exception occurred while processing this request.
     * @see RoomRequestDto
     */
    public boolean addRoomRequest(RoomRequestDto roomRequestDto) throws ParseException, SQLException {
        return service.addRoomRequest(roomRequestDto);
    }
}
