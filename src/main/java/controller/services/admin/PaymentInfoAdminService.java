package controller.services.admin;

import dao.intefaces.PaymentDao;
import factories.DaoFactory;
import model.dto.PaymentsAdminDto;

import java.sql.SQLException;

public class PaymentInfoAdminService {

    private PaymentDao paymentDao;

    public PaymentInfoAdminService() {
        this.paymentDao = DaoFactory.getInstance().getPaymentDao();
    }

    public PaymentsAdminDto getAllPayments(PaymentsAdminDto paymentsAdminDto) throws SQLException {
        return paymentDao.getAllPayments(paymentsAdminDto);
    }
}
