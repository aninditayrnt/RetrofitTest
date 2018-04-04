package com.example.srin.testrestapi.model;

import com.orm.SugarRecord;

/**
 * Created by SRIN on 4/4/2018.
 */

public class AccountDatabase extends SugarRecord{
    private String username;
    private String password;
    private String email;

    public AccountDatabase() {}

    public AccountDatabase(String email, String username, String password)
    {
        this.email = email;
        this.username = username;
        this.password = password;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
