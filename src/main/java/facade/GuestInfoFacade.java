package facade;

import controller.services.GuestInfoService;
import factories.ServiceFactory;
import model.entity.Guest;

import java.sql.SQLException;

public class GuestInfoFacade {
    private GuestInfoService service = ServiceFactory.getInstance().getGuestInfoService();

    public int addGuest(Guest guest) throws SQLException {
        return service.addGuest(guest);
    }
}
