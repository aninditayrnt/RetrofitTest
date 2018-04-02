package com.example.srin.testrestapi.model;

import com.orm.SugarRecord;

/**
 * Created by Anindita on 3/31/18.
 */

public class MovieDatabase extends SugarRecord{
    private String genre_name;
    private Integer movieId;

    public MovieDatabase() {}

    public MovieDatabase(Integer movieId) {
        this.movieId = movieId;
    }

    public String getGenre_name() {
        return genre_name;
    }

    public void setGenre_name(String genre_name) {
        this.genre_name = genre_name;
    }

    public Integer getMovieId() {
        return movieId;
    }

    public void setMovieId(Integer movieId) {
        this.movieId = movieId;
    }
}
