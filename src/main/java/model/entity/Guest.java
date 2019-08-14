package model.entity;

import enums.Role;

/**
 * Represents a guest.
 */
public class Guest {
    private int guestId;
    private String name;
    private String surname;
    private int age;
    private String phone;
    private String passportId;
    private String username;
    private String password;
    /**
     * Represents the role of user.
     */
    private Role role;

    /**
     * Creates a guest without params.
     */
    public Guest() {
    }

    /**
     * Creates a guest with the specified name, surname, age, phone, passportId, username, password.
     *
     * @param name       The guest’s name.
     * @param surname    The guest’s surname.
     * @param age        The guest’s age.
     * @param phone      The guest’s phone.
     * @param passportId The guest’s passportId.
     * @param username   The guest’s username.
     * @param password   The guest’s password.
     */
    public Guest(String name, String surname, int age, String phone, String passportId, String username, String password) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.phone = phone;
        this.passportId = passportId;
        this.username = username;
        this.password = password;
    }

    /**
     * Creates a guest with the specified guestId, name, surname, age, phone, passportId, username, password.
     *
     * @param guestId    The guest's id.
     * @param name       The guest’s name.
     * @param surname    The guest’s surname.
     * @param age        The guest’s age.
     * @param phone      The guest’s phone.
     * @param passportId The guest’s passportId.
     * @param username   The guest’s username.
     * @param password   The guest’s password.
     */
    public Guest(int guestId, String name, String surname, String username, String password,
                 int age, String phone, String passportId) {
        this.guestId = guestId;
        this.name = name;
        this.surname = surname;
        this.username = username;
        this.password = password;
        this.age = age;
        this.phone = phone;
        this.passportId = passportId;
    }

    /**
     * Creates a guest with the specified name, surname, phone, passportId.
     *
     * @param name       The guest’s name.
     * @param surname    The guest’s surname.
     * @param phone      The guest’s phone.
     * @param passportId The guest’s passportId.
     */
    public Guest(String name, String surname, String phone, String passportId) {
        this.name = name;
        this.surname = surname;
        this.phone = phone;
        this.passportId = passportId;
    }

    /**
     * Creates a guest with the specified name, surname, phone, passportId, username, password.
     *
     * @param name       The guest’s name.
     * @param surname    The guest’s surname.
     * @param phone      The guest’s phone.
     * @param passportId The guest’s passportId.
     * @param username   The guest’s username.
     * @param password   The guest’s password.
     */
    public Guest(String name, String surname, String phone, String passportId, String username, String password) {
        this.name = name;
        this.surname = surname;
        this.phone = phone;
        this.passportId = passportId;
        this.username = username;
        this.password = password;
    }

    /**
     * Creates a guest with the specified name, surname, age, phone, passportId.
     *
     * @param name       The guest’s name.
     * @param surname    The guest’s surname.
     * @param age        The guest’s age.
     * @param phone      The guest’s phone.
     * @param passportId The guest’s passportId.
     */
    public Guest(String name, String surname, int age, String phone, String passportId) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.phone = phone;
        this.passportId = passportId;
    }

    /**
     * Creates a guest with the specified guestId, name, surname, age, phone, passportId.
     *
     * @param guestId    The guest's id.
     * @param name       The guest’s name.
     * @param surname    The guest’s surname.
     * @param age        The guest’s age.
     * @param phone      The guest’s phone.
     * @param passportId The guest’s passportId.
     */
    public Guest(int guestId, String name, String surname, int age, String phone, String passportId) {
        this.guestId = guestId;
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.phone = phone;
        this.passportId = passportId;
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

    /**
     * Gets the value of {@link #guestId}.
     *
     * @return the value of {@link #guestId}.
     */
    public int getGuestId() {
        return guestId;
    }

    /**
     * This is a setter which sets the guestId
     *
     * @param guestId - the guestId to be set
     */
    public void setGuestId(int guestId) {
        this.guestId = guestId;
    }

    /**
     * Gets the value of {@link #name}.
     *
     * @return the value of {@link #name}.
     */
    public String getName() {
        return name;
    }

    /**
     * This is a setter which sets the name
     *
     * @param name - the name to be set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the value of {@link #surname}.
     *
     * @return the value of {@link #surname}.
     */
    public String getSurname() {
        return surname;
    }

    /**
     * This is a setter which sets the surname
     *
     * @param surname - the surname to be set
     */
    public void setSurname(String surname) {
        this.surname = surname;
    }

    /**
     * Gets the value of {@link #age}.
     *
     * @return the value of {@link #age}.
     */
    public int getAge() {
        return age;
    }

    /**
     * This is a setter which sets the age
     *
     * @param age - the age to be set
     */
    public void setAge(int age) {
        this.age = age;
    }

    /**
     * Gets the value of {@link #phone}.
     *
     * @return the value of {@link #phone}.
     */
    public String getPhone() {
        return phone;
    }

    /**
     * This is a setter which sets the phone
     *
     * @param phone - the phone to be set
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * Gets the value of {@link #role}.
     *
     * @return the value of {@link #role}.
     */
    public Role getRole() {
        return role;
    }

    /**
     * This is a setter which sets the role
     *
     * @param role - the role to be set
     */
    public void setRole(Role role) {
        this.role = role;
    }

    /**
     * Gets the value of {@link #passportId}.
     *
     * @return the value of {@link #passportId}.
     */
    public String getPassportId() {
        return passportId;
    }

    /**
     * This is a setter which sets the passportId
     *
     * @param passportId - the passportId to be set
     */
    public void setPassportId(String passportId) {
        this.passportId = passportId;
    }
}
