package factories;

import controller.services.*;
import controller.services.admin.*;

public class ServiceFactory {
    private static volatile ServiceFactory factory = null;

    private ServiceFactory() {

    }

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

    public LoginService getLoginService(){
        return new LoginService();
    }

    public RegistrationService getRegistrationService(){
        return new RegistrationService();
    }

    public BookingService getBookingService(){
        return new BookingService();
    }

    public GuestInfoService getGuestInfoService(){
        return new GuestInfoService();
    }

    public PaymentService getPaymentService(){
        return new PaymentService();
    }

    public RoomRequestService getRoomRequestService(){
        return new RoomRequestService();
    }

    public GuestInfoAdminService getGuestInfoAdminService(){
        return new GuestInfoAdminService();
    }

    public PaymentInfoAdminService getPaymentInfoAdminService(){
        return new PaymentInfoAdminService();
    }

    public ReservationInfoAdminService getReservationInfoAdminService(){
        return new ReservationInfoAdminService();
    }

    public RoomInfoAdminService getRoomInfoAdminService(){
        return new RoomInfoAdminService();
    }

    public RoomRequestAdminService getRoomRequestAdminService(){
        return new RoomRequestAdminService();
    }
}
