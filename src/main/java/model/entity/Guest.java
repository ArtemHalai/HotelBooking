package model.entity;

import enums.Role;

public class Guest {
    private int guestId;
    private String name;
    private String surname;
    private int age;
    private String phone;
    private String passportId;
    private String username;
    private String password;
    private Role role;

    public Guest() {
    }

    public Guest(String name, String surname, int age, String phone, String passportId, String username, String password) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.phone = phone;
        this.passportId = passportId;
        this.username = username;
        this.password = password;
    }

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

    public Guest(String name, String surname, String phone, String passportId) {
        this.name = name;
        this.surname = surname;
        this.phone = phone;
        this.passportId = passportId;
    }

    public Guest(String name, String surname, String phone, String passportId, String username, String password) {
        this.name = name;
        this.surname = surname;
        this.phone = phone;
        this.passportId = passportId;
        this.username = username;
        this.password = password;
    }

    public Guest(String name, String surname, int age, String phone, String passportId) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.phone = phone;
        this.passportId = passportId;
    }

    public Guest(int guestId, String name, String surname, int age, String phone, String passportId) {
        this.guestId = guestId;
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.phone = phone;
        this.passportId = passportId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getGuestId() {
        return guestId;
    }

    public void setGuestId(int guestId) {
        this.guestId = guestId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String getPassportId() {
        return passportId;
    }

    public void setPassportId(String passportId) {
        this.passportId = passportId;
    }
}
