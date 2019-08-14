package factories;

import controller.services.*;
import controller.services.admin.*;

/**
 * A class that provides factory to get necessary service.
 */
public class ServiceFactory {

    /**
     * Static instance of this class.
     */
    private static volatile ServiceFactory factory = null;

    /**
     * Private constructor to prevent
     * the instantiation of this class directly
     */
    private ServiceFactory() {

    }

    /**
     * Gets the instance of factory.
     *
     * @return the instance of {@link #factory}.
     */
    public static ServiceFactory getInstance() {
        if (factory == null) {
            synchronized (ServiceFactory.class) {
                if (factory == null) {
                    factory = new ServiceFactory();
                }
            }
        }
        return factory;
    }

    /**
     * Gets the LoginService.
     *
     * @return the instance of LoginService.
     *
     * @see LoginService
     */
    public LoginService getLoginService() {
        return new LoginService();
    }

    /**
     * Gets the RegistrationService.
     *
     * @return the instance of RegistrationService.
     *
     * @see RegistrationService
     */
    public RegistrationService getRegistrationService() {
        return new RegistrationService();
    }

    /**
     * Gets the BookingService.
     *
     * @return the instance of BookingService.
     *
     * @see BookingService
     */
    public BookingService getBookingService() {
        return new BookingService();
    }

    /**
     * Gets the GuestInfoService.
     *
     * @return the instance of GuestInfoService.
     *
     * @see GuestInfoService
     */
    public GuestInfoService getGuestInfoService() {
        return new GuestInfoService();
    }

    /**
     * Gets the PaymentService.
     *
     * @return the instance of PaymentService.
     *
     * @see PaymentService
     */
    public PaymentService getPaymentService() {
        return new PaymentService();
    }

    /**
     * Gets the RoomRequestService.
     *
     * @return the instance of RoomRequestService.
     *
     * @see RoomRequestService
     */
    public RoomRequestService getRoomRequestService() {
        return new RoomRequestService();
    }

    /**
     * Gets the GuestInfoAdminService.
     *
     * @return the instance of GuestInfoAdminService.
     *
     * @see GuestInfoAdminService
     */
    public GuestInfoAdminService getGuestInfoAdminService() {
        return new GuestInfoAdminService();
    }

    /**
     * Gets the PaymentInfoAdminService.
     *
     * @return the instance of PaymentInfoAdminService.
     *
     * @see PaymentInfoAdminService
     */
    public PaymentInfoAdminService getPaymentInfoAdminService() {
        return new PaymentInfoAdminService();
    }

    /**
     * Gets the ReservationInfoAdminService.
     *
     * @return the instance of ReservationInfoAdminService.
     *
     * @see ReservationInfoAdminService
     */
    public ReservationInfoAdminService getReservationInfoAdminService() {
        return new ReservationInfoAdminService();
    }

    /**
     * Gets the RoomInfoAdminService.
     *
     * @return the instance of RoomInfoAdminService.
     *
     * @see RoomInfoAdminService
     */
    public RoomInfoAdminService getRoomInfoAdminService() {
        return new RoomInfoAdminService();
    }

    /**
     * Gets the RoomRequestAdminService.
     *
     * @return the instance of RoomRequestAdminService.
     *
     * @see RoomRequestAdminService
     */
    public RoomRequestAdminService getRoomRequestAdminService() {
        return new RoomRequestAdminService();
    }
}
