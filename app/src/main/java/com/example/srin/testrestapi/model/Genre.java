package com.example.srin.testrestapi.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Anindita on 3/31/18.
 */

public class Genre {
    @SerializedName("id")
    private Integer genre_id;

    @SerializedName("name")
    private String genre_name;


    public Integer getGenre_id() {
        return genre_id;
    }

    public void setGenre_id(Integer genre_id) {
        this.genre_id = genre_id;
    }

    public String getGenre_name() {
        return genre_name;
    }

    public void setGenre_name(String genre_name) {
        this.genre_name = genre_name;
    }
}
