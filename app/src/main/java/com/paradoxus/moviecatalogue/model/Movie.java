package com.paradoxus.moviecatalogue.model;

import android.os.Parcel;
import android.os.Parcelable;

public class Movie implements Parcelable {
    private int moviePoster;
    private String movieName;
    private String movieDescription;
    private String movieBudget;
    private String movieRevenue;
    private String userRating;



    public Movie(Parcel in) {
        moviePoster = in.readInt();
        movieName = in.readString();
        movieDescription = in.readString();
        movieBudget = in.readString();
        movieRevenue = in.readString();
        userRating = in.readString();

    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(moviePoster);
        dest.writeString(movieName);
        dest.writeString(movieDescription);
        dest.writeString(movieBudget);
        dest.writeString(movieRevenue);
        dest.writeString(userRating);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Movie> CREATOR = new Creator<Movie>() {
        @Override
        public Movie createFromParcel(Parcel in) {
            return new Movie(in);
        }

        @Override
        public Movie[] newArray(int size) {
            return new Movie[size];
        }
    };

    public int getMoviePoster() {
        return moviePoster;
    }

    public void setMoviePoster(int moviePoster) {
        this.moviePoster = moviePoster;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public String getMovieDescription() {
        return movieDescription;
    }

    public void setMovieDescription(String movieDescription) {
        this.movieDescription = movieDescription;
    }

    public String getMovieBudget() {
        return movieBudget;
    }

    public void setMovieBudget(String movieBudget) {
        this.movieBudget = movieBudget;
    }

    public String getMovieRevenue() {
        return movieRevenue;
    }

    public void setMovieRevenue(String movieRevenue) {
        this.movieRevenue = movieRevenue;
    }

    public String getUserRating() {
        return userRating;
    }

    public void setUserRating(String userRating) {
        this.userRating = userRating;
    }
}
