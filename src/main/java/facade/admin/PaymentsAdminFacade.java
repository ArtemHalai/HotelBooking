package facade.admin;

import controller.services.admin.PaymentInfoAdminService;
import factories.ServiceFactory;
import model.dto.PaymentsAdminDto;

import java.sql.SQLException;

public class PaymentsAdminFacade {
    private PaymentInfoAdminService service = ServiceFactory.getInstance().getPaymentInfoAdminService();

    public PaymentsAdminDto getAllPayments(PaymentsAdminDto paymentsAdminDto) throws SQLException {
        return service.getAllPayments(paymentsAdminDto);
    }
}
