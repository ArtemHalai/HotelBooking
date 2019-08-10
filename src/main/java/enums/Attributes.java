package enums;

public enum Attributes {
    GUEST("guest"),
    DATE("date"),
    AVAILABLE("available"),
    RESERVATION_ID("reservationId"),
    ERRORS("errors"),
    USER("user"),
    PRICE("price"),
    ROOM_ID("roomId"),
    PAGE("page"),
    COUNT("count"),
    GUESTS("guests"),
    ROOMS("rooms"),
    PAYMENTS("payments"),
    RESERVATIONS("reservations"),
    ROOM_REQUESTS("roomRequests"),
    PAGE_SIZE("10"),
    GUEST_ID("id"),
    NAME("name"),
    SURNAME("surname"),
    USERNAME("username"),
    PASSWORD("password"),
    AGE("age"),
    PHONE_NUMBER("phoneNumber"),
    PASSPORT_ID("passportId"),
    CV_CODE("cvCode"),
    CARD_NUMBER("cardNumber"),
    EXPIRY_DATE("expiryDate");

    private String name;

    Attributes(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
