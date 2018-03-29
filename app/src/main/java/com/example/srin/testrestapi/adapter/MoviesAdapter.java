package com.example.srin.testrestapi.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.srin.testrestapi.R;
import com.example.srin.testrestapi.model.Movie;

import org.w3c.dom.Text;

import java.util.List;

/**
 * Created by SRIN on 3/29/2018.
 */

public class MoviesAdapter extends RecyclerView.Adapter<MoviesAdapter.MyViewHolder>{

    private List<Movie> movies;
    private Context context;
    private int rowLayout;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView movieTitle, genre, year, description;

        public MyViewHolder(View view) {
            super(view);

            movieTitle = (TextView) view.findViewById(R.id.movieTitle);
            genre = (TextView) view.findViewById(R.id.genre);
            year = (TextView) view.findViewById(R.id.year);
            description = (TextView) view.findViewById(R.id.description);
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
        holder.movieTitle.setText(movies.get(position).getTitle());
        holder.year.setText(movies.get(position).getReleaseDate().substring(0, 4));
        holder.description.setText(movies.get(position).getOverView());
    }

    @Override
    public int getItemCount() {
        return movies.size();
    }
}
