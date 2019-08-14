package enums;

/**
 *  Attributes that can be used
 *  <li>{@link #GUEST}</li>
 *  <li>{@link #DATE}</li>
 *  <li>{@link #AVAILABLE}</li>
 *  <li>{@link #RESERVATION_ID}</li>
 *  <li>{@link #ERRORS}</li>
 *  <li>{@link #USER}</li>
 *  <li>{@link #PRICE}</li>
 *  <li>{@link #ROOM_ID}</li>
 *  <li>{@link #PAGE}</li>
 *  <li>{@link #COUNT}</li>
 *  <li>{@link #GUESTS}</li>
 *  <li>{@link #ROOMS}</li>
 *  <li>{@link #PAYMENTS}</li>
 *  <li>{@link #RESERVATIONS}</li>
 *  <li>{@link #ROOM_REQUESTS}</li>
 *  <li>{@link #PAGE_SIZE}</li>
 *  <li>{@link #GUEST_ID}</li>
 *  <li>{@link #NAME}</li>
 *  <li>{@link #SURNAME}</li>
 *  <li>{@link #USERNAME}</li>
 *  <li>{@link #PASSWORD}</li>
 *  <li>{@link #AGE}</li>
 *  <li>{@link #PHONE_NUMBER}</li>
 *  <li>{@link #PASSPORT_ID}</li>
 *  <li>{@link #CV_CODE}</li>
 *  <li>{@link #CARD_NUMBER}</li>
 *  <li>{@link #EXPIRY_DATE}</li>
 */
public enum Attributes {

    /**
     * Guest attribute
     */
    GUEST("guest"),
    /**
     * Date attribute
     */
    DATE("date"),
    /**
     * Available attribute
     */
    AVAILABLE("available"),
    /**
     * Reservation id attribute
     */
    RESERVATION_ID("reservationId"),
    /**
     * Errors attribute
     */
    ERRORS("errors"),
    /**
     * User attribute
     */
    USER("user"),
    /**
     * Price attribute
     */
    PRICE("price"),
    /**
     * Room id attribute
     */
    ROOM_ID("roomId"),
    /**
     * Page attribute
     */
    PAGE("page"),
    /**
     * Count attribute
     */
    COUNT("count"),
    /**
     * Guests attribute
     */
    GUESTS("guests"),
    /**
     * Rooms attribute
     */
    ROOMS("rooms"),
    /**
     * Payments attribute
     */
    PAYMENTS("payments"),
    /**
     * Reservations attribute
     */
    RESERVATIONS("reservations"),
    /**
     * Room requests attribute
     */
    ROOM_REQUESTS("roomRequests"),
    /**
     * Page size attribute
     */
    PAGE_SIZE("10"),
    /**
     * Guest id attribute
     */
    GUEST_ID("id"),
    /**
     * Name attribute
     */
    NAME("name"),
    /**
     * Surname attribute
     */
    SURNAME("surname"),
    /**
     * Username attribute
     */
    USERNAME("username"),
    /**
     * Password attribute
     */
    PASSWORD("password"),
    /**
     * Age attribute
     */
    AGE("age"),
    /**
     * Phone number attribute
     */
    PHONE_NUMBER("phoneNumber"),
    /**
     * Passport id attribute
     */
    PASSPORT_ID("passportId"),
    /**
     * CV code attribute
     */
    CV_CODE("cvCode"),
    /**
     * Card number attribute
     */
    CARD_NUMBER("cardNumber"),
    /**
     * Expiry date attribute
     */
    EXPIRY_DATE("expiryDate");

    private String name;

   /**
    * Sole constructor. It is not possible to invoke this constructor.
    * It is for use by code emitted by the compiler in response to enum type declarations.
    * @param name The name of enum constant, which is the identifier used to declare it.
    */
    Attributes(String name) {
        this.name = name;
    }

    /**
     * Gets the value of {@link #name}.
     *
     * @return the value of {@link #name}.
     */
    public String getName() {
        return name;
    }
}
