package com.library.model.business;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.Size;

public class User {

    private int user_id;

    @NotEmpty(message = "Please enter your first name")
    private String firstName;

    @NotEmpty(message = "Please enter your last name")
    private String lastName;

    private String role;

    @NotEmpty(message = "Please enter your username")
    @Size(min=3, max=30, message = "Username must be at least 3 characters!")
    private String userName;

    @Email(regexp="\\w+@\\w+\\.{1}\\w+", message="Please provide a valid email address!" )
    @NotEmpty(message = "Please enter your email address")
    private String email;

    @NotEmpty(message = "Please enter your password.")
    @Size(min = 6, max = 15, message = "Your password must between 6 and 15 characters")
    private String password;

    @NotEmpty(message = "Please enter your password.")
    @Size(min = 6, max = 15, message = "Your password must between 6 and 15 characters")
    private String confPassword;

    private String project;

    public User(String firstName, String lastName, String password, String userName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.userName = userName;
        this.email = email;
        this.role = "user"; //override in DB for "admin" if needed
    }

    public User() {}

//    public User() {
//        this.role = "user";
//    }

    //getters


    public int getUser_id() {
        return user_id;
    }

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

    public String getEmail() {
        return email;
    }

    public String getProject() {
        return project;
    }

    public String getConfPassword() {
        return confPassword;
    }

    //setters


    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

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

    public void setEmail(String email) {
        this.email = email;
    }

    public void setProject(String project) {
        this.project = project;
    }

    public void setConfPassword(String confPassword) {
        this.confPassword = confPassword;
    }
}
