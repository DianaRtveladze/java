package com.example.midterm.database;

import java.util.Date;

public class Movie {
    private String movie_id;
    private String title;
    private String director;
    private Date release_date;
    private int rating;
    private String description;

    public String getMovieId() {
        return movie_id;
    }

    public void setMovieId(String movie_id) {
        this.movie_id = movie_id;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "movie_id='" + movie_id + '\'' +
                ", title='" + title + '\'' +
                ", director='" + director + '\'' +
                ", release_date=" + release_date +
                ", rating=" + rating +
                ", description='" + description + '\'' +
                '}';
    }

    public Movie(String movie_id, String title, String director, Date release_date, int rating, String description) {
        this.movie_id = movie_id;
        this.title = title;
        this.director = director;
        this.release_date = release_date;
        this.rating = rating;
        this.description = description;
    }

    public Movie() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public java.sql.Date getReleaseDate() {
        return (java.sql.Date) release_date;
    }

    public void setReleaseDate(Date release_date) {
        this.release_date = release_date;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
