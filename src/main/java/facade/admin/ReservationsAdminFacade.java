package facade.admin;

import controller.services.admin.ReservationInfoAdminService;
import factories.ServiceFactory;
import model.dto.ReservationsAdminDto;

import java.sql.SQLException;

public class ReservationsAdminFacade {
    private ReservationInfoAdminService service = ServiceFactory.getInstance().getReservationInfoAdminService();

    public ReservationsAdminDto getAllReservations(ReservationsAdminDto reservationsAdminDto) throws SQLException {
        return service.getAllReservations(reservationsAdminDto);
    }
}
