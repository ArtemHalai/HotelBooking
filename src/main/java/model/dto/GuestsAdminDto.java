package model.dto;

import model.entity.Guest;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a guests admin dto.
 */
public class GuestsAdminDto {
    private int page;
    private int count;
    private List<Guest> list = new ArrayList<>();

    /**
     * Creates a guests admin dto without params.
     */
    public GuestsAdminDto() {
    }

    /**
     * Creates a guests admin dto with the specified page, count, list.
     *
     * @param page The guests admin dto's page.
     * @param count The guests admin dto's count.
     * @param list The guests admin dto's list.
     */
    public GuestsAdminDto(int page, int count, List<Guest> list) {
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
    public List<Guest> getList() {
        return list;
    }

    /**
     * This is a setter which sets the list
     *
     * @param list - the list to be set
     */
    public void setList(List<Guest> list) {
        this.list = list;
    }
}
