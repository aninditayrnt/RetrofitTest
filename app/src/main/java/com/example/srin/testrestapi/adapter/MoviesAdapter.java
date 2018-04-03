package com.example.srin.testrestapi.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.srin.testrestapi.R;
import com.example.srin.testrestapi.activity.MainActivity;
import com.example.srin.testrestapi.activity.MovieDetailsActivity;
import com.example.srin.testrestapi.model.Movie;
import com.example.srin.testrestapi.model.MovieDatabase;
import com.squareup.picasso.Picasso;

import org.w3c.dom.Text;

import java.util.List;

/**
 * Created by SRIN on 3/29/2018.
 */

public class MoviesAdapter extends RecyclerView.Adapter<MoviesAdapter.MyViewHolder>{
    private List<Movie> movies;
    private Context context;
    private int rowLayout;

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView movieTitle, genre, year, description;
        ImageView poster_path;
        int movieId;

        public MyViewHolder(View view) {
            super(view);
            view.setOnClickListener(this);

            poster_path = (ImageView) view.findViewById(R.id.poster_path);
            movieTitle = (TextView) view.findViewById(R.id.movieTitle);
            genre = (TextView) view.findViewById(R.id.genre);
            year = (TextView) view.findViewById(R.id.year);
            description = (TextView) view.findViewById(R.id.description);
        }


        @Override
        public void onClick(View view) {
            Intent i = new Intent(context, MovieDetailsActivity.class);
            i.putExtra("movie_id", movieId);
            context.startActivity(i);
        }
    }

    public MoviesAdapter(List<Movie> movies, int rowLayout, Context context) {
        this.movies = movies;
        this.rowLayout = rowLayout;
        this.context = context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(rowLayout, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Picasso.with(context).load(movies.get(position).getPoster_path()).into(holder.poster_path);
        holder.movieTitle.setText(movies.get(position).getTitle());
        holder.year.setText(movies.get(position).getReleaseDate().substring(0, 4));
        holder.description.setText(movies.get(position).getOverView());
        holder.movieId = movies.get(position).getMovie_id();
    }

    @Override
    public int getItemCount() {
        return movies.size();
    }
}
