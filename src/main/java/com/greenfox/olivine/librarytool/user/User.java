package com.greenfox.olivine.librarytool.user;

/**
 * Created by Attila on 2016.08.03..
 */
public class User {

    private String firstName;
    private String lastName;
    private String password;
    private String role;
    private String userName;

    public User(String firstName, String lastName, String password, String userName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.userName = userName;
        this.role = "user"; //override in DB for "admin" if needed
    }

    //getters

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getRole() {
        return role;
    }

    public String getPassword() {
        return password;
    }

    public String getUserName() {
        return userName;
    }

    //setters

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
