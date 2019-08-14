package facade;

import controller.services.GuestInfoService;
import factories.ServiceFactory;
import model.entity.Guest;

import java.sql.SQLException;

/**
 * A class that works with GuestInfoService.
 *
 * @see GuestInfoService
 */
public class GuestInfoFacade {
    private GuestInfoService service = ServiceFactory.getInstance().getGuestInfoService();

    /**
     * Method to add guest by using GuestInfoService {@link #service}.
     *
     * @param guest Object to pass params containing in it.
     * @return int value representing an id of added guest.
     * @throws SQLException If sql exception occurred while processing this request.
     * @see Guest
     */
    public int addGuest(Guest guest) throws SQLException {
        return service.addGuest(guest);
    }
}
