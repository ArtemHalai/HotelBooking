package facade.admin;

import controller.services.admin.GuestInfoAdminService;
import factories.ServiceFactory;
import model.dto.GuestsAdminDto;

import java.sql.SQLException;

public class GuestsAdminFacade {
    private GuestInfoAdminService service = ServiceFactory.getInstance().getGuestInfoAdminService();

    public GuestsAdminDto getAllGuests(GuestsAdminDto guestsAdminDto) throws SQLException {
        return service.getAllGuests(guestsAdminDto);
    }
}
