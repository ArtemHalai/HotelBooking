package enums;

public enum Mappings {
    REGISTRATION_PAGE("/WEB-INF/view/registration.jsp"),
    LOGIN_PAGE("/WEB-INF/view/login.jsp"),
    BOOKING_PAGE("/WEB-INF/view/booking.jsp"),
    INDEX_PAGE("/index.jsp"),
    LOGGED_IN("/WEB-INF/view/logged_in.jsp"),
    GUEST_INFO_PAGE("/WEB-INF/view/guest_info.jsp"),
    PAYMENT_PAGE("/WEB-INF/view/payment.jsp"),
    SUCCESSFUL_PAGE("/WEB-INF/view/successful_payment.jsp"),
    UNSUCCESSFUL_PAGE("/WEB-INF/view/unsuccessful_payment.jsp"),
    HOME_ADMIN_PAGE("/WEB-INF/view_admin/home_admin.jsp"),
    ROOMS_ADMIN_PAGE("/WEB-INF/view_admin/rooms_admin.jsp"),
    RESERVATIONS_ADMIN_PAGE("/WEB-INF/view_admin/reservations_admin.jsp"),
    PAYMENTS_ADMIN_PAGE("/WEB-INF/view_admin/payments_admin.jsp"),
    GUESTS_ADMIN_PAGE("/WEB-INF/view_admin/guests_admin.jsp"),
    ROOM_REQUESTS_ADMIN_PAGE("/WEB-INF/view_admin/room_requests_admin.jsp"),
    GUEST_INFO("guest_info"),
    SUCCESSFUL("successful"),
    UNSUCCESSFUL("unsuccessful"),
    PAYMENT("payment"),
    HOME("home"),
    BOOKING("booking"),
    LOGIN_VIEW("login"),
    LOGIN_VIEW_PATH("http://localhost:8080/login"),
    REGISTRATION_VIEW("registration"),
    LOGGED_IN_VIEW("logged_in"),
    HOME_ADMIN("home_admin"),
    ROOMS_ADMIN("rooms_admin"),
    RESERVATIONS_ADMIN("reservations_admin"),
    PAYMENTS_ADMIN("payments_admin"),
    GUESTS_ADMIN("guests_admin"),
    ROOM_REQUESTS_ADMIN("room_requests_admin");

    private String name;

    Mappings(String name) {
        this.name = name;
    }

    public String getName(){
        return name;
    }

}
