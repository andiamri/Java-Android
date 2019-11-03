package com.paradoxus.moviecatalogue.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.paradoxus.moviecatalogue.R;
import com.paradoxus.moviecatalogue.model.Movie;

public class DetailFilmActivity extends AppCompatActivity {
    public static final String EXTRA_MOVIE = "extra_movie";


    TextView tvMovieName,tvMovieRating,tvBudget,tvRevenue,tvMovieDescription;
    ImageView ivMoviePoster;
    Button btnFavorite;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_film);

        tvMovieName = findViewById(R.id.tv_movie_name);
        tvMovieRating = findViewById(R.id.tv_movie_rating);
        tvBudget = findViewById(R.id.tv_budget);
        tvRevenue = findViewById(R.id.tv_revenue);
        tvMovieDescription = findViewById(R.id.tv_movie_description);
        ivMoviePoster = findViewById(R.id.iv_movie_poster);
        btnFavorite = findViewById(R.id.btn_favorite);

        String title = "Movie Detail";

        assert getSupportActionBar() !=null;
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        getSupportActionBar().setTitle(title);






        btnFavorite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(DetailFilmActivity.this,"Added To Favorite",Toast.LENGTH_SHORT).show();
            }
        });

        Movie movie = getIntent().getParcelableExtra(EXTRA_MOVIE);
        String moviesName = movie.getMovieName();
        String moviesDescription = movie.getMovieDescription();
        String budget = "$"+movie.getMovieBudget();
        String revenue = "$"+movie.getMovieRevenue();
        String rating =movie.getUserRating()+"%";
        int moviePoster = movie.getMoviePoster();
        tvMovieDescription.setText(moviesDescription);
        tvMovieName.setText(moviesName);
        tvBudget.setText(budget);
        tvRevenue.setText(revenue);
        tvMovieRating.setText(rating);
        ivMoviePoster.setImageResource(moviePoster);
    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }
}
