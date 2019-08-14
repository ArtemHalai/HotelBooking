package controller.services.admin;

import dao.intefaces.ReservationDao;
import factories.DaoFactory;
import model.dto.ReservationsAdminDto;

import java.sql.SQLException;

/**
 * A class that works with ReservationDao.
 *
 * @see ReservationDao
 */
public class ReservationInfoAdminService {

    private ReservationDao reservationDao;

    /**
     * Creates a ReservationInfoAdminService object and initialize {@link #reservationDao}.
     */
    public ReservationInfoAdminService() {
        this.reservationDao = DaoFactory.getInstance().getReservationDao();
    }

    /**
     * Method to get all reservations by using ReservationDao {@link #reservationDao}.
     *
     * @param reservationsAdminDto Object to pass params containing in it.
     * @return Object of ReservationsAdminDto containing list of reservations;
     * @throws SQLException If sql exception occurred while processing this request.
     * @see ReservationsAdminDto
     */
    public ReservationsAdminDto getAllReservations(ReservationsAdminDto reservationsAdminDto) throws SQLException {
        return reservationDao.getAllReservations(reservationsAdminDto);
    }
}
