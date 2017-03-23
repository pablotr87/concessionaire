package com.ptirador.concessionaire.model;

import com.ptirador.concessionaire.util.Constants;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

/**
 * Bean that represents an application user.
 *
 * @author ptirador
 */
@Document(collection = "users")
public class UserBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    private String id;

    private String email;

    private String username;

    private String password;

    private int role;

    private String language;

    public UserBean() {
        setRole(Constants.ROLE_USER_ID);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }
}