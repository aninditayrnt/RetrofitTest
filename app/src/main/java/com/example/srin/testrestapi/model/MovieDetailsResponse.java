package com.example.srin.testrestapi.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Anindita on 3/31/18.
 */

public class MovieDetailsResponse {
    @SerializedName("genres")
    private List<Genre> genre;

    @SerializedName("poster_path")
    private String posterPath;

    @SerializedName("title")
    private String movieTitle;

    @SerializedName("overview")
    private String description;

    @SerializedName("release_date")
    private String date;
    public String getPosterPath() {
        return posterPath;
    }

    public void setPosterPath(String posterPath) {
        this.posterPath = posterPath;
    }

    public String getMovieTitle() {
        return movieTitle;
    }

    public void setMovieTitle(String movieTitle) {
        this.movieTitle = movieTitle;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public List<Genre> getGenre() {
        return genre;
    }

    public void setGenre(List<Genre> genre) {
        this.genre = genre;
    }
}
