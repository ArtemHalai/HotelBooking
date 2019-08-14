package facade.admin;

import controller.services.admin.PaymentInfoAdminService;
import factories.ServiceFactory;
import model.dto.PaymentsAdminDto;

import java.sql.SQLException;

/**
 * A class that works with PaymentInfoAdminService.
 *
 * @see PaymentInfoAdminService
 */
public class PaymentsAdminFacade {
    private PaymentInfoAdminService service = ServiceFactory.getInstance().getPaymentInfoAdminService();

    /**
     * Method to get all payments by using PaymentInfoAdminService {@link #service}.
     *
     * @param paymentsAdminDto Object to pass params containing in it.
     * @return Object of PaymentsAdminDto containing list of payments;
     * @throws SQLException If sql exception occurred while processing this request.
     * @see PaymentsAdminDto
     */
    public PaymentsAdminDto getAllPayments(PaymentsAdminDto paymentsAdminDto) throws SQLException {
        return service.getAllPayments(paymentsAdminDto);
    }
}
