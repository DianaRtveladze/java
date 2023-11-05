package com.example.midterm.JSPHandler;

import java.io.IOException;
import java.sql.SQLException;

import com.example.midterm.database.DBUtils;
import com.example.midterm.database.Movie;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/AddMovieServlet")
public class CreateMovieServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String title = request.getParameter("title");
        String director = request.getParameter("director");
        String releaseDate = request.getParameter("releaseDate");
        double rating = Double.parseDouble(request.getParameter("rating"));
        String description = request.getParameter("description");

        Movie movie = new Movie();
        movie.setTitle(title);
        movie.setDirector(director);
        movie.setReleaseDate(java.sql.Date.valueOf(releaseDate));
        movie.setRating((int) rating);
        movie.setDescription(description);

        try {
            DBUtils.addMovie(movie);
            response.sendRedirect("createMovie.jsp?success=true");
        } catch (SQLException e) {
            e.printStackTrace();
            response.sendRedirect("createMovie.jsp?success=false");
        }
    }
}
