package model.dto;

import model.entity.Reservation;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a reservations admin dto.
 */
public class ReservationsAdminDto {
    private int page;
    private int count;
    private List<Reservation> list = new ArrayList<>();

    /**
     * Creates a reservations admin dto without params.
     */
    public ReservationsAdminDto() {
    }

    /**
     * Creates a reservations admin dto with the specified page, count, list.
     *
     * @param page  The reservations admin dto's page.
     * @param count The reservations admin dto's count.
     * @param list  The reservations admin dto's list.
     */
    public ReservationsAdminDto(int page, int count, List<Reservation> list) {
        this.page = page;
        this.count = count;
        this.list = list;
    }

    /**
     * Gets the value of {@link #page}.
     *
     * @return the value of {@link #page}.
     */
    public int getPage() {
        return page;
    }

    /**
     * This is a setter which sets the page
     *
     * @param page - the page to be set
     */
    public void setPage(int page) {
        this.page = page;
    }

    /**
     * Gets the value of {@link #count}.
     *
     * @return the value of {@link #count}.
     */
    public int getCount() {
        return count;
    }

    /**
     * This is a setter which sets the count
     *
     * @param count - the count to be set
     */
    public void setCount(int count) {
        this.count = count;
    }

    /**
     * Gets the value of {@link #list}.
     *
     * @return the value of {@link #list}.
     */
    public List<Reservation> getList() {
        return list;
    }

    /**
     * This is a setter which sets the list
     *
     * @param list - the list to be set
     */
    public void setList(List<Reservation> list) {
        this.list = list;
    }
}
