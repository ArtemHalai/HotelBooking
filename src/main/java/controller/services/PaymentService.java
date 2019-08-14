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

/**
 * A class that works with GuestDao, PaymentDao, ReservationDao.
 *
 * @see GuestDao
 * @see PaymentDao
 * @see ReservationDao
 */
public class PaymentService {

    private PaymentDao paymentDao;
    private GuestDao guestDao;
    private ReservationDao reservationDao;

    /**
     * Creates a PaymentService object and initialize {@link #guestDao}, {@link #paymentDao}, {@link #reservationDao}.
     */
    public PaymentService() {
        this.paymentDao = DaoFactory.getInstance().getPaymentDao();
        this.guestDao = DaoFactory.getInstance().getGuestDao();
        this.reservationDao = DaoFactory.getInstance().getReservationDao();
    }

    /**
     * Method to add payment by using PaymentDao {@link #paymentDao}.
     *
     * @param paymentDto Object to pass params containing in it.
     * @return <code>true</code> if the payment was added in database; <code>false</code> otherwise.
     * @throws SQLException If sql exception occurred while processing this request.
     * @see PaymentDto
     */
    public boolean addPayment(PaymentDto paymentDto) throws SQLException {
        return paymentDao.addPayment(paymentDto);
    }

    /**
     * Method to add payment in transaction by using GuestDao, PaymentDao, ReservationDao {@link #guestDao},
     * {@link #paymentDao}, {@link #reservationDao}.
     *
     * @param paymentTransactionDto Object to pass params containing in it.
     * @return <code>true</code> if the payment was added in database; <code>false</code> otherwise.
     * @throws SQLException If sql exception occurred while processing this request.
     * @see PaymentTransactionDto
     */
    public boolean addPaymentWithTransaction(PaymentTransactionDto paymentTransactionDto, Connection connection) throws SQLException {

        Guest guest = guestDao.getGuest(paymentTransactionDto, connection);

        if (guest != null) {

            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date d = Date.valueOf(simpleDateFormat.format(new java.util.Date()));

            Payment payment = new Payment(paymentTransactionDto.getRoomId(),
                    paymentTransactionDto.getPrice(), d, guest.getGuestId());
            boolean added = paymentDao.addPaymentWithTransaction(payment, connection);

            if (added) {
                Reservation reservation = new Reservation();
                reservation.setId(paymentTransactionDto.getReservationId());
                int count = reservationDao.addGuestIdToReservation(guest, reservation, connection);

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
}
