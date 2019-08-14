package facade.admin;

import controller.services.admin.ReservationInfoAdminService;
import factories.ServiceFactory;
import model.dto.ReservationsAdminDto;

import java.sql.SQLException;

/**
 * A class that works with ReservationInfoAdminService.
 *
 * @see ReservationInfoAdminService
 */
public class ReservationsAdminFacade {
    private ReservationInfoAdminService service = ServiceFactory.getInstance().getReservationInfoAdminService();

    /**
     * Method to get all reservations by using ReservationInfoAdminService {@link #service}.
     *
     * @param reservationsAdminDto Object to pass params containing in it.
     * @return Object of ReservationsAdminDto containing list of reservations;
     * @throws SQLException If sql exception occurred while processing this request.
     * @see ReservationsAdminDto
     */
    public ReservationsAdminDto getAllReservations(ReservationsAdminDto reservationsAdminDto) throws SQLException {
        return service.getAllReservations(reservationsAdminDto);
    }
}
