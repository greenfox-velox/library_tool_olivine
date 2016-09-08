package com.library.User;

import com.library.model.business.User;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class UserTest {
    @Test()
    public void testGetEmail(){
        User greenfox = new User("Green", "Fox", "password", "model", "model@gfa.com");
        assertEquals("getEmail should return valid email address", "model@gfa.com", greenfox.getEmail());
    }
    @Test()
    public void testGetFirstName(){
        User greenfox = new User("Green", "Fox", "password", "model", "model@gfa.com");
        assertEquals("getFirstName should return valid first name", "Green", greenfox.getFirstName());
    }
    @Test()
    public void testGetLastName(){
        User greenfox = new User("Green", "Fox", "password", "model", "model@gfa.com");
        assertEquals("getLastName should return valid last name", "Fox", greenfox.getLastName());
    }
    @Test()
    public void testGetRole(){
        User greenfox = new User("Green", "Fox", "password", "model", "model@gfa.com");
        assertEquals("getRole should return valid role", "model", greenfox.getRole());
    }
    @Test()
    public void testGetPassword(){
        User greenfox = new User("Green", "Fox", "password", "model", "model@gfa.com");
        assertEquals("getPassword should return valid password", "password", greenfox.getPassword());
    }
    @Test()
    public void testGetUSerName(){
        User greenfox = new User("Green", "Fox", "password", "model", "model@gfa.com");
        assertEquals("getUserName should return valid username", "model", greenfox.getUserName());
    }
}