package com.paradoxus.moviecatalogue.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.paradoxus.moviecatalogue.R;
import com.paradoxus.moviecatalogue.model.Movie;

import java.util.ArrayList;

public class MovieAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<Movie>movies = new ArrayList<>();

    public void setMovies(ArrayList<Movie> movies) {
        this.movies = movies;
    }

    public MovieAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return movies.size();
    }

    @Override
    public Object getItem(int i) {
        return movies.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View itemView = view;
        if(itemView == null){
            itemView = LayoutInflater.from(context).inflate(R.layout.item_movie,viewGroup,false);
        }
        ViewHolder viewHolder = new ViewHolder(itemView);

        Movie movie = (Movie)getItem(i);
        viewHolder.bind(movie);
        return itemView;
    }

    private class ViewHolder {
        private TextView txtMovieName;
        private TextView txtMovieDescription;
        private ImageView imgMoviePoster;

        ViewHolder(View view){
            txtMovieName = view.findViewById(R.id.tv_movie_name);
            txtMovieDescription = view.findViewById(R.id.tv_movie_description);
            imgMoviePoster = view.findViewById(R.id.iv_movie_poster);
        }
        void bind(Movie movie){
            txtMovieName.setText(movie.getMovieName());
            txtMovieDescription.setText(movie.getMovieDescription());
            imgMoviePoster.setImageResource(movie.getMoviePoster());
        }
    }
}
