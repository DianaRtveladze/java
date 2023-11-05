package com.example.midterm.JSPHandler;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/updateMovie")
public class UpdateMovieServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try {
            int movieId = Integer.parseInt(request.getParameter("movieId"));
            String title = request.getParameter("title");
            String director = request.getParameter("director");
            String releaseDate = request.getParameter("releaseDate");
            float rating = Float.parseFloat(request.getParameter("rating"));
            String description = request.getParameter("description");
            response.sendRedirect("/movieList");
        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("/errorPage");
        }
    }
}

