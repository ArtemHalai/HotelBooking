package model.dto;

import model.entity.Room;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a rooms admin dto.
 */
public class RoomsAdminDto {
    private int page;
    private int count;
    private List<Room> list = new ArrayList<>();

    /**
     * Creates a rooms admin dto without params.
     */
    public RoomsAdminDto() {
    }

    /**
     * Creates a rooms admin dto with the specified page, count, list.
     *
     * @param page  The rooms admin dto's page.
     * @param count The rooms admin dto's count.
     * @param list  The rooms admin dto's list.
     */
    public RoomsAdminDto(int page, int count, List<Room> list) {
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
    public List<Room> getList() {
        return list;
    }

    /**
     * This is a setter which sets the list
     *
     * @param list - the list to be set
     */
    public void setList(List<Room> list) {
        this.list = list;
    }
}
