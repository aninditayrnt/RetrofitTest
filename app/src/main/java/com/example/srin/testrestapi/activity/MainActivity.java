package com.example.srin.testrestapi.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.telecom.Call;
import android.util.Log;
import android.widget.Toast;

import com.example.srin.testrestapi.R;
import com.example.srin.testrestapi.adapter.MoviesAdapter;
import com.example.srin.testrestapi.model.Genre;
import com.example.srin.testrestapi.model.Movie;
import com.example.srin.testrestapi.model.MovieDatabase;
import com.example.srin.testrestapi.model.MovieDetailsResponse;
import com.example.srin.testrestapi.model.MoviesResponse;
import com.example.srin.testrestapi.rest.APIClient;
import com.example.srin.testrestapi.rest.APIInterface;
import com.orm.SugarContext;

import java.util.List;

import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = MainActivity.class.getSimpleName();

    private final static String api_key = "0a93542634dd25ff0e5108bc0716a4bf";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SugarContext.init(this);
        setContentView(R.layout.activity_main);

        if(api_key.isEmpty()) {
            Toast.makeText(getApplicationContext(), "Please obtain your API KEY first from themoviedb.org", Toast.LENGTH_LONG).show();
            return;
        }

        final RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        final APIInterface apiService = APIClient.getClient().create(APIInterface.class);

        retrofit2.Call call = apiService.getUpcomingMovies(api_key);

        call.enqueue(new Callback<MoviesResponse>(){

            @Override
            public void onResponse(retrofit2.Call<MoviesResponse> call, Response<MoviesResponse> response) {
                int statusCode = response.code();

                if(statusCode == 200) {
                    List<Movie> movie = response.body().getResult();

                    /*for(int i = 0; i < movie.size(); i++) {
                        MovieDatabase md = new MovieDatabase(movie.get(i).getMovie_id());
                        md.setGenre_name(movie.get(i).getTitle());
                        md.setMovieId(movie.get(i).getMovie_id());
                        md.setId(movie.get(i).getMovie_id().longValue());
                        md.save();
                    }*/

                    recyclerView.setAdapter(new MoviesAdapter(movie, R.layout.movie_list, getApplicationContext()));
                }
            }

            @Override
            public void onFailure(retrofit2.Call<MoviesResponse> call, Throwable t) {

            }
        });
    }

    @Override
    public void onBackPressed(){
    }
}
