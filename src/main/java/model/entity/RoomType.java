package model.entity;

/**
 * Represents a room type.
 */
public class RoomType {
    private int id;
    private String description;
    private int capacity;

    /**
     * Gets the value of {@link #id}.
     *
     * @return the value of {@link #id}.
     */
    public int getId() {
        return id;
    }

    /**
     * This is a setter which sets the id
     *
     * @param id - the id to be set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Gets the value of {@link #description}.
     *
     * @return the value of {@link #description}.
     */
    public String getDescription() {
        return description;
    }

    /**
     * This is a setter which sets the description
     *
     * @param description - the description to be set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Gets the value of {@link #capacity}.
     *
     * @return the value of {@link #capacity}.
     */
    public int getCapacity() {
        return capacity;
    }

    /**
     * This is a setter which sets the capacity
     *
     * @param capacity - the capacity to be set
     */
    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
}
