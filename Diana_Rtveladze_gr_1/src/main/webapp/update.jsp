<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
    <title>Update or Delete Movie Information</title>
</head>
<body>
    <h1>Update or Delete Movie Information</h1>
    <table border="1">
        <tr>
            <th>Movie ID</th>
            <th>Title</th>
            <th>Director</th>
            <th>Release Date</th>
            <th>Rating</th>
            <th>Description</th>
            <th>Action</th>
        </tr>

        <c:forEach var="movie" items="${movies}">
            <tr>
                <td>${movie.MovieId}</td>
                <td>${movie.Title}</td>
                <td>${movie.Director}</td>
                <td>${movie.ReleaseDate}</td>
                <td>${movie.Rating}</td>
                <td>${movie.Description}</td>
                <td>
                    <form action="update_movie_action.jsp" method="post">
                        <input type="hidden" name="movieId" value="${movie.MovieId}">
                        <input type="hidden" name="action" value="delete">
                        <button type="submit">Delete</button>
                    </form>
                </td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
