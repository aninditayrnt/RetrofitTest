package com.example.srin.testrestapi.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by SRIN on 3/29/2018.
 */

public class GenreIds {
    @SerializedName("id")
    private int id;

    @SerializedName("name")
    private String name;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
