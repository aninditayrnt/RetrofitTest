package com.example.srin.testrestapi.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Anindita on 3/31/18.
 */

public class MovieDetailsResponse {
    @SerializedName("genres")
    private Genre genre;


    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }
}
