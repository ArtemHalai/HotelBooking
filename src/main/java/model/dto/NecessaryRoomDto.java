package model.dto;

/**
 * Represents a necessary room dto.
 */
public class NecessaryRoomDto {
    private String balcony;
    private String smoke;
    private String dateIn;
    private String dateOut;
    private String roomTypeId;
    private String priceRange;


    /**
     * Creates a necessary room dto without params.
     */
    public NecessaryRoomDto() {
    }

    /**
     * Creates a necessary room dto with the specified balcony, smoke, dateIn, dateOut, roomTypeId, priceRange.
     *
     * @param balcony    The necessary room dto's balcony.
     * @param smoke      The necessary room dto's smoke.
     * @param dateIn     The necessary room dto's dateIn.
     * @param dateOut    The necessary room dto's dateOut.
     * @param roomTypeId The necessary room dto's roomTypeId.
     * @param priceRange The necessary room dto's priceRange.
     */
    public NecessaryRoomDto(String balcony, String smoke, String dateIn, String dateOut, String roomTypeId, String priceRange) {
        this.balcony = balcony;
        this.smoke = smoke;
        this.dateIn = dateIn;
        this.dateOut = dateOut;
        this.roomTypeId = roomTypeId;
        this.priceRange = priceRange;
    }

    /**
     * Gets the value of {@link #balcony}.
     *
     * @return the value of {@link #balcony}.
     */
    public String getBalcony() {
        return balcony;
    }

    /**
     * This is a setter which sets the balcony
     *
     * @param balcony - the balcony to be set
     */
    public void setBalcony(String balcony) {
        this.balcony = balcony;
    }

    /**
     * Gets the value of {@link #smoke}.
     *
     * @return the value of {@link #smoke}.
     */
    public String getSmoke() {
        return smoke;
    }

    /**
     * This is a setter which sets the smoke
     *
     * @param smoke - the smoke to be set
     */
    public void setSmoke(String smoke) {
        this.smoke = smoke;
    }

    /**
     * Gets the value of {@link #dateIn}.
     *
     * @return the value of {@link #dateIn}.
     */
    public String getDateIn() {
        return dateIn;
    }

    /**
     * This is a setter which sets the dateIn
     *
     * @param dateIn - the dateIn to be set
     */
    public void setDateIn(String dateIn) {
        this.dateIn = dateIn;
    }

    /**
     * Gets the value of {@link #dateOut}.
     *
     * @return the value of {@link #dateOut}.
     */
    public String getDateOut() {
        return dateOut;
    }

    /**
     * This is a setter which sets the dateOut
     *
     * @param dateOut - the dateOut to be set
     */
    public void setDateOut(String dateOut) {
        this.dateOut = dateOut;
    }

    /**
     * Gets the value of {@link #roomTypeId}.
     *
     * @return the value of {@link #roomTypeId}.
     */
    public String getRoomTypeId() {
        return roomTypeId;
    }

    /**
     * This is a setter which sets the roomTypeId
     *
     * @param roomTypeId - the roomTypeId to be set
     */
    public void setRoomTypeId(String roomTypeId) {
        this.roomTypeId = roomTypeId;
    }

    /**
     * Gets the value of {@link #priceRange}.
     *
     * @return the value of {@link #priceRange}.
     */
    public String getPriceRange() {
        return priceRange;
    }

    /**
     * This is a setter which sets the priceRange
     *
     * @param priceRange - the priceRange to be set
     */
    public void setPriceRange(String priceRange) {
        this.priceRange = priceRange;
    }
}
