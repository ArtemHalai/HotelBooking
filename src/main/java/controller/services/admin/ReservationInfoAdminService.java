package controller.services.admin;

import dao.intefaces.ReservationDao;
import factories.DaoFactory;
import model.dto.ReservationsAdminDto;

import java.sql.SQLException;

public class ReservationInfoAdminService {

    private ReservationDao reservationDao;

    public ReservationInfoAdminService() {
        this.reservationDao = DaoFactory.getInstance().getReservationDao();
    }

    public ReservationsAdminDto getAllReservations(ReservationsAdminDto reservationsAdminDto) throws SQLException {
        return reservationDao.getAllReservations(reservationsAdminDto);
    }
}
