package model.dto;

/**
 * Represents a guest dto.
 */
public class GuestDto {
    private String username;
    private String password;

    /**
     * Creates a guest dto without params.
     */
    public GuestDto() {
    }

    /**
     * Creates a guest dto with the specified username, password.
     *
     * @param username The guest dto's username.
     * @param password The guest dto's password.
     */
    public GuestDto(String username, String password) {
        this.username = username;
        this.password = password;
    }

    /**
     * Gets the value of {@link #username}.
     *
     * @return the value of {@link #username}.
     */
    public String getUsername() {
        return username;
    }

    /**
     * This is a setter which sets the username
     *
     * @param username - the username to be set
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Gets the value of {@link #password}.
     *
     * @return the value of {@link #password}.
     */
    public String getPassword() {
        return password;
    }

    /**
     * This is a setter which sets the password
     *
     * @param password - the password to be set
     */
    public void setPassword(String password) {
        this.password = password;
    }
}
