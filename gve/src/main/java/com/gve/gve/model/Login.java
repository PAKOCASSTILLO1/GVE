package com.gve.gve.model;

public class Login {

    private String username;
    private String password;


    public Login() {
    }

    public Login(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Login username(String username) {
        this.username = username;
        return this;
    }

    public Login password(String password) {
        this.password = password;
        return this;
    }
    
    
}
