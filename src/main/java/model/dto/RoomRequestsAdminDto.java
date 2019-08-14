package model.dto;

import model.entity.RoomRequest;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a room requests admin dto.
 */
public class RoomRequestsAdminDto {
    private int page;
    private int count;
    private List<RoomRequest> list = new ArrayList<>();

    /**
     * Creates a room requests admin dto without params.
     */
    public RoomRequestsAdminDto() {
    }

    /**
     * Creates a room requests admin dto with the specified page, count, list.
     *
     * @param page  The room requests admin dto's page.
     * @param count The room requests admin dto's count.
     * @param list  The room requests admin dto's list.
     */
    public RoomRequestsAdminDto(int page, int count, List<RoomRequest> list) {
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
    public List<RoomRequest> getList() {
        return list;
    }

    /**
     * This is a setter which sets the list
     *
     * @param list - the list to be set
     */
    public void setList(List<RoomRequest> list) {
        this.list = list;
    }
}
