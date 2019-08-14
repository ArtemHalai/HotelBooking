package controller.services;

import dao.intefaces.GuestDao;
import dao.intefaces.PaymentDao;
import dao.intefaces.ReservationDao;
import factories.JDBCConnectionFactory;
import model.dto.PaymentDto;
import model.dto.PaymentTransactionDto;
import model.entity.Guest;
import model.entity.Payment;
import model.entity.Reservation;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.sql.Connection;
import java.sql.SQLException;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class PaymentServiceTest {

    @Mock
    private PaymentDao paymentDao;

    @Mock
    private GuestDao guestDao;

    @Mock
    private ReservationDao reservationDao;

    @InjectMocks
    private PaymentService service;

    @Test
    public void addPayment() throws SQLException {
        PaymentDto payment = new PaymentDto();
        service.addPayment(payment);
        verify(paymentDao).addPayment(payment);

        when(service.addPayment(payment)).thenReturn(true);
        assertTrue(service.addPayment(payment));
    }

    @Test
    public void addPaymentWithTransaction() throws SQLException {
        Connection connection = spy(JDBCConnectionFactory.getInstance().getConnection());
        connection.setTransactionIsolation(Connection.TRANSACTION_REPEATABLE_READ);
        connection.setAutoCommit(false);

        PaymentTransactionDto paymentTransactionDto = new PaymentTransactionDto();

        when(guestDao.getGuest(paymentTransactionDto, connection)).thenReturn(new Guest());
        when(paymentDao.addPaymentWithTransaction(any(), any())).thenReturn(true);
        int count = 1;
        when(reservationDao.addGuestIdToReservation(any(), any(), any())).thenReturn(count);
        service.addPaymentWithTransaction(paymentTransactionDto, connection);
        verify(guestDao).getGuest(paymentTransactionDto, connection);
        verify(paymentDao).addPaymentWithTransaction(any(), any());
        verify(reservationDao).addGuestIdToReservation(any(), any(), any());
    }
}