package com.example.srin.testrestapi.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.srin.testrestapi.R;
import com.example.srin.testrestapi.model.MovieDetailsResponse;
import com.example.srin.testrestapi.rest.APIClient;
import com.example.srin.testrestapi.rest.APIInterface;
import com.orm.SugarContext;
import com.squareup.picasso.Picasso;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by SRIN on 4/3/2018.
 */

public class MovieDetailsActivity extends AppCompatActivity {
    private final static String api_key = "0a93542634dd25ff0e5108bc0716a4bf";
    StringBuilder str = new StringBuilder();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.details);

        final ImageView poster;
        final TextView movieTitle, genre, year, description;

        Intent i = getIntent();
        int movieId = i.getIntExtra("movie_id", 0);

        poster = (ImageView) findViewById(R.id.poster);
        movieTitle = (TextView) findViewById(R.id.movieTitle);
        genre = (TextView)  findViewById(R.id.genre);
        year = (TextView) findViewById(R.id.year);
        description = (TextView) findViewById(R.id.description) ;

        APIInterface apiService = APIClient.getClient().create(APIInterface.class);

        Call call = apiService.getMovieDetails(movieId, api_key);

        call.enqueue(new Callback<MovieDetailsResponse>() {
            @Override
            public void onResponse(Call<MovieDetailsResponse> call, Response<MovieDetailsResponse> response) {
                int statusCode = response.code();

                Picasso.with(getApplicationContext()).load("https://image.tmdb.org/t/p/w500" + response.body().getPosterPath()).into(poster);
                movieTitle.setText(response.body().getMovieTitle());
                for(int i = 0; i < response.body().getGenre().size(); i++) {
                    str.append(response.body().getGenre().get(i).getGenre_name() + ", ");
                }
                str.delete(str.length()-2,str.length());
                genre.setText(str.toString());
//                genre.setText(response.body().getGenre().get(0).getGenre_name());
                year.setText(response.body().getDate().substring(0, 4));
                description.setText(response.body().getDescription());
            }

            @Override
            public void onFailure(Call call, Throwable t) {

            }
        });
    }
}
