package com.example.midterm.database;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DBUtils {
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/movie";
    private static final String USERNAME = "diana";
    private static final String PASSWORD = "diana";

    public static List<Movie> getAllMovies() throws SQLException {
        List<Movie> movies = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT * FROM movies")) {

            while (resultSet.next()) {
                Movie movie = new Movie();
                movie.setMovieId(String.valueOf(resultSet.getInt("movie_id")));
                movie.setTitle(resultSet.getString("title"));
                movie.setDirector(resultSet.getString("director"));
                movie.setReleaseDate(resultSet.getDate("release_date"));
                movie.setRating((int) resultSet.getDouble("rating"));
                movie.setDescription(resultSet.getString("description"));
                movies.add(movie);
            }
        }
        return movies;
    }

    public static void addMovie(Movie movie) throws SQLException {
        String insertQuery = "INSERT INTO movies (title, director, release_date, rating, description) VALUES (?, ?, ?, ?, ?)";

        try (Connection connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
             PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)) {
            preparedStatement.setString(1, movie.getTitle());
            preparedStatement.setString(2, movie.getDirector());
            preparedStatement.setDate(3, movie.getReleaseDate());
            preparedStatement.setDouble(4, movie.getRating());
            preparedStatement.setString(5, movie.getDescription());

            preparedStatement.executeUpdate();
        }
    }
}
