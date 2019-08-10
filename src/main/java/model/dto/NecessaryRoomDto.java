package model.dto;

public class NecessaryRoomDto {
    private String  balcony;
    private String smoke;
    private String dateIn;
    private String dateOut;
    private String  roomTypeId;
    private String priceRange;


    public NecessaryRoomDto() {
    }

    public NecessaryRoomDto(String balcony, String smoke, String dateIn, String dateOut, String roomTypeId, String priceRange) {
        this.balcony = balcony;
        this.smoke = smoke;
        this.dateIn = dateIn;
        this.dateOut = dateOut;
        this.roomTypeId = roomTypeId;
        this.priceRange = priceRange;
    }

    public String getBalcony() {
        return balcony;
    }

    public void setBalcony(String balcony) {
        this.balcony = balcony;
    }

    public String getSmoke() {
        return smoke;
    }

    public void setSmoke(String smoke) {
        this.smoke = smoke;
    }

    public String getDateIn() {
        return dateIn;
    }

    public void setDateIn(String dateIn) {
        this.dateIn = dateIn;
    }

    public String getDateOut() {
        return dateOut;
    }

    public void setDateOut(String dateOut) {
        this.dateOut = dateOut;
    }

    public String getRoomTypeId() {
        return roomTypeId;
    }

    public void setRoomTypeId(String roomTypeId) {
        this.roomTypeId = roomTypeId;
    }

    public String getPriceRange() {
        return priceRange;
    }

    public void setPriceRange(String priceRange) {
        this.priceRange = priceRange;
    }
}
