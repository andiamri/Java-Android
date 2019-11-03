package com.paradoxus.moviecatalogue;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.os.Parcel;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.paradoxus.moviecatalogue.activity.DetailFilmActivity;
import com.paradoxus.moviecatalogue.adapter.MovieAdapter;
import com.paradoxus.moviecatalogue.model.Movie;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private MovieAdapter movieAdapter;
    private String[] movieName;
    private String[] movieDescription;
    private String[] movieRevenue;
    private String[] movieBudget;
    private String[] userRating;
    private TypedArray moviePoster;
    private ArrayList<Movie>movies;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listView = findViewById(R.id.lv_movie_list);
        movieAdapter = new MovieAdapter(this);
        listView.setAdapter(movieAdapter);

        prepare();
        addItem();

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//                Toast.makeText(MainActivity.this,movies.get(i).getMovieName(),Toast.LENGTH_SHORT).show();
                Intent detailActivityIntent = new Intent(MainActivity.this, DetailFilmActivity.class);
                detailActivityIntent.putExtra(DetailFilmActivity.EXTRA_MOVIE,movies.get(i));
                startActivity(detailActivityIntent);
            }
        });
    }

    private void addItem() {
        movies = new ArrayList<>();
        for(int i = 0; i < movieName.length; i++){
            Movie movie = new Movie(Parcel.obtain());
            movie.setMoviePoster(moviePoster.getResourceId(i,-1));
            movie.setMovieName(movieName[i]);
            movie.setMovieDescription(movieDescription[i]);
            movie.setMovieBudget(movieBudget[i]);
            movie.setMovieRevenue(movieRevenue[i]);
            movie.setUserRating(userRating[i]);
            movies.add(movie);
        }
        movieAdapter.setMovies(movies);
    }

    private void prepare() {
        movieName = getResources().getStringArray(R.array.movie_name);
        movieDescription = getResources().getStringArray(R.array.movie_description);
        moviePoster = getResources().obtainTypedArray(R.array.movie_photo);
        movieBudget = getResources().getStringArray(R.array.movie_budget);
        movieRevenue = getResources().getStringArray(R.array.movie_revenue);
        userRating = getResources().getStringArray(R.array.user_rating);


    }
}
