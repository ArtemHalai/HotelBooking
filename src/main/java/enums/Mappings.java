package enums;

/**
 *  Mappings that can be used
 *  <li>{@link #REGISTRATION_PAGE}</li>
 *  <li>{@link #LOGIN_PAGE}</li>
 *  <li>{@link #BOOKING_PAGE}</li>
 *  <li>{@link #INDEX_PAGE}</li>
 *  <li>{@link #LOGGED_IN}</li>
 *  <li>{@link #GUEST_INFO_PAGE}</li>
 *  <li>{@link #PAYMENT_PAGE}</li>
 *  <li>{@link #SUCCESSFUL_PAGE}</li>
 *  <li>{@link #UNSUCCESSFUL_PAGE}</li>
 *  <li>{@link #HOME_ADMIN_PAGE}</li>
 *  <li>{@link #ROOMS_ADMIN_PAGE}</li>
 *  <li>{@link #RESERVATIONS_ADMIN_PAGE}</li>
 *  <li>{@link #PAYMENTS_ADMIN_PAGE}</li>
 *  <li>{@link #GUESTS_ADMIN_PAGE}</li>
 *  <li>{@link #ROOM_REQUESTS_ADMIN_PAGE}</li>
 *  <li>{@link #GUEST_INFO}</li>
 *  <li>{@link #SUCCESSFUL}</li>
 *  <li>{@link #UNSUCCESSFUL}</li>
 *  <li>{@link #PAYMENT}</li>
 *  <li>{@link #HOME}</li>
 *  <li>{@link #BOOKING}</li>
 *  <li>{@link #LOGIN_VIEW}</li>
 *  <li>{@link #LOGIN_VIEW_PATH}</li>
 *  <li>{@link #REGISTRATION_VIEW}</li>
 *  <li>{@link #LOGGED_IN_VIEW}</li>
 *  <li>{@link #HOME_ADMIN}</li>
 *  <li>{@link #ROOMS_ADMIN}</li>
 *  <li>{@link #RESERVATIONS_ADMIN}</li>
 *  <li>{@link #PAYMENTS_ADMIN}</li>
 *  <li>{@link #GUESTS_ADMIN}</li>
 *  <li>{@link #ROOM_REQUESTS_ADMIN}</li>
 */
public enum Mappings {
    /**
     * Registration page mapping
     */
    REGISTRATION_PAGE("/WEB-INF/view/registration.jsp"),
    /**
     * Login page mapping
     */
    LOGIN_PAGE("/WEB-INF/view/login.jsp"),
    /**
     * Booking page mapping
     */
    BOOKING_PAGE("/WEB-INF/view/booking.jsp"),
    /**
     * Index page mapping
     */
    INDEX_PAGE("/index.jsp"),
    /**
     * Logged in mapping
     */
    LOGGED_IN("/WEB-INF/view/logged_in.jsp"),
    /**
     * Guest info page mapping
     */
    GUEST_INFO_PAGE("/WEB-INF/view/guest_info.jsp"),
    /**
     * Payment page mapping
     */
    PAYMENT_PAGE("/WEB-INF/view/payment.jsp"),
    /**
     * Successful page mapping
     */
    SUCCESSFUL_PAGE("/WEB-INF/view/successful_payment.jsp"),
    /**
     * Unsuccessful page mapping
     */
    UNSUCCESSFUL_PAGE("/WEB-INF/view/unsuccessful_payment.jsp"),
    /**
     * Home admin page mapping
     */
    HOME_ADMIN_PAGE("/WEB-INF/view_admin/home_admin.jsp"),
    /**
     * Rooms admin page mapping
     */
    ROOMS_ADMIN_PAGE("/WEB-INF/view_admin/rooms_admin.jsp"),
    /**
     * Reservations admin page mapping
     */
    RESERVATIONS_ADMIN_PAGE("/WEB-INF/view_admin/reservations_admin.jsp"),
    /**
     * Payments admin page mapping
     */
    PAYMENTS_ADMIN_PAGE("/WEB-INF/view_admin/payments_admin.jsp"),
    /**
     * Guests admin page mapping
     */
    GUESTS_ADMIN_PAGE("/WEB-INF/view_admin/guests_admin.jsp"),
    /**
     * Room requests admin page mapping
     */
    ROOM_REQUESTS_ADMIN_PAGE("/WEB-INF/view_admin/room_requests_admin.jsp"),
    /**
     * Guest info mapping
     */
    GUEST_INFO("guest_info"),
    /**
     * Successful mapping
     */
    SUCCESSFUL("successful"),
    /**
     * Unsuccessful mapping
     */
    UNSUCCESSFUL("unsuccessful"),
    /**
     * Payment mapping
     */
    PAYMENT("payment"),
    /**
     * Home mapping
     */
    HOME("home"),
    /**
     * Booking mapping
     */
    BOOKING("booking"),
    /**
     * Login view mapping
     */
    LOGIN_VIEW("login"),
    /**
     * Login view path mapping
     */
    LOGIN_VIEW_PATH("http://localhost:8080/login"),
    /**
     * Registration view mapping
     */
    REGISTRATION_VIEW("registration"),
    /**
     * Logged in view mapping
     */
    LOGGED_IN_VIEW("logged_in"),
    /**
     * Home admin mapping
     */
    HOME_ADMIN("home_admin"),
    /**
     * Rooms admin mapping
     */
    ROOMS_ADMIN("rooms_admin"),
    /**
     * Reservations admin mapping
     */
    RESERVATIONS_ADMIN("reservations_admin"),
    /**
     * Payments admin mapping
     */
    PAYMENTS_ADMIN("payments_admin"),
    /**
     * Guests admin mapping
     */
    GUESTS_ADMIN("guests_admin"),
    /**
     * Room requests admin mapping
     */
    ROOM_REQUESTS_ADMIN("room_requests_admin");

    private String name;

    /**
     * Sole constructor. It is not possible to invoke this constructor.
     * It is for use by code emitted by the compiler in response to enum type declarations.
     * @param name The name of enum constant, which is the identifier used to declare it.
     */
    Mappings(String name) {
        this.name = name;
    }

    /**
     * Gets the value of {@link #name}.
     *
     * @return the value of {@link #name}.
     */
    public String getName(){
        return name;
    }

}
