package facade.admin;

import controller.services.admin.GuestInfoAdminService;
import factories.ServiceFactory;
import model.dto.GuestsAdminDto;

import java.sql.SQLException;

/**
 * A class that works with GuestInfoAdminService.
 *
 * @see GuestInfoAdminService
 */
public class GuestsAdminFacade {
    private GuestInfoAdminService service = ServiceFactory.getInstance().getGuestInfoAdminService();

    /**
     * Method to get all guests by using GuestInfoAdminService {@link #service}.
     *
     * @param guestsAdminDto Object to pass params containing in it.
     * @return Object of GuestAdminDto containing list of guests;
     * @throws SQLException If sql exception occurred while processing this request.
     * @see GuestsAdminDto
     */
    public GuestsAdminDto getAllGuests(GuestsAdminDto guestsAdminDto) throws SQLException {
        return service.getAllGuests(guestsAdminDto);
    }
}
