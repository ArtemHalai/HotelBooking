package controller.services;

import dao.intefaces.GuestDao;
import dao.intefaces.PaymentDao;
import dao.intefaces.ReservationDao;
import factories.DaoFactory;
import model.dto.PaymentDto;
import model.dto.PaymentTransactionDto;
import model.entity.Guest;
import model.entity.Payment;
import model.entity.Reservation;

import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

public class PaymentService {

    private PaymentDao paymentDao;
    private GuestDao guestDao;
    private ReservationDao reservationDao;

    public PaymentService() {
        this.paymentDao = DaoFactory.getInstance().getPaymentDao();
        this.guestDao = DaoFactory.getInstance().getGuestDao();
        this.reservationDao = DaoFactory.getInstance().getReservationDao();
    }

    public boolean addPayment(PaymentDto paymentDto) throws SQLException {
        return paymentDao.addPayment(paymentDto);
    }

    public boolean addPaymentWithTransaction(PaymentTransactionDto paymentTransactionDto, Connection connection) throws SQLException {

        Guest guest = guestDao.getGuest(paymentTransactionDto, connection);

        if (guest != null) {

            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date d = Date.valueOf(simpleDateFormat.format(new java.util.Date()));

            Payment payment = new Payment(paymentTransactionDto.getRoomId(),
                    paymentTransactionDto.getPrice(), d, guest.getGuestId());
            boolean added = isAdded(connection, payment);

            if (added) {
                Reservation reservation = new Reservation();
                reservation.setId(paymentTransactionDto.getReservationId());
                int count = getCount(connection, guest, reservation);

                if (count == 1) {
                    connection.commit();
                    connection.close();
                    return true;
                }
            }
        }

        connection.rollback();
        connection.close();
        return false;
    }

    public int getCount(Connection connection, Guest guest, Reservation reservation) throws SQLException {
        return reservationDao.addGuestIdToReservation(guest, reservation, connection);
    }

    public boolean isAdded(Connection connection, Payment payment) throws SQLException {
        return paymentDao.addPaymentWithTransaction(payment, connection);
    }
}
