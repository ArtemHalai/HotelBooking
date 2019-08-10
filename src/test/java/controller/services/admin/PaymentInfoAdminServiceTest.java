package controller.services.admin;

import dao.intefaces.PaymentDao;
import model.dto.PaymentsAdminDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.sql.SQLException;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class PaymentInfoAdminServiceTest {

    @Mock
    private PaymentDao paymentDao;

    @InjectMocks
    private PaymentInfoAdminService service;

    @Test
    public void getAllPayments() throws SQLException {
        PaymentsAdminDto paymentsAdminDto = new PaymentsAdminDto();
        PaymentsAdminDto adminDto = new PaymentsAdminDto();
       when(service.getAllPayments(paymentsAdminDto)).thenReturn(adminDto);
        assertEquals(adminDto, service.getAllPayments(paymentsAdminDto));
       verify(paymentDao).getAllPayments(paymentsAdminDto);
    }
}