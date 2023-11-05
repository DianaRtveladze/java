<%@ page import="java.util.List" %>
<%@ page import="com.example.midterm.database.Movie" %>
<%@ page import="com.example.midterm.database.DBUtils" %>
<%@ page import="java.sql.SQLException" %>
<!DOCTYPE html>
<html>
<head>
    <title>Movies</title>
</head>
<body>
<h1>List of Movies</h1>
<table border="1">
    <tr>
        <th>Movie ID</th>
        <th>Title</th>
        <th>Director</th>
        <th>Release Date</th>
        <th>Rating</th>
        <th>Description</th>
    </tr>
    <%
        List<Movie> movies = null;
        try {
            movies = DBUtils.getAllMovies();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        for (Movie movie : movies) {
    %>
    <tr>
        <td><%= movie.getMovieId() %></td>
        <td><%= movie.getTitle() %></td>
        <td><%= movie.getDirector() %></td>
        <td><%= movie.getReleaseDate() %></td>
        <td><%= movie.getRating() %></td>
        <td><%= movie.getDescription() %></td>
    </tr>
    <%
        }
    %>
</table>
</body>
</html>
