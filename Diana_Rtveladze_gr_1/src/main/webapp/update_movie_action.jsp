<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.sql.*" %>
<!DOCTYPE html>
<html>
<head>
    <title>Update or Delete Movie Information</title>
</head>
<body>
    <%
    try {
        Class.forName("com.mysql.jdbc.Driver"); // Load MySQL JDBC driver
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/YourFirstNameLastName", "username", "password");

        String action = request.getParameter("action");

        if ("delete".equals(action)) {
            int movieId = Integer.parseInt(request.getParameter("movieId"));
            String deleteQuery = "DELETE FROM movies WHERE MovieId = ?";
            PreparedStatement deleteStatement = connection.prepareStatement(deleteQuery);
            deleteStatement.setInt(1, movieId);
            int rowsDeleted = deleteStatement.executeUpdate();

            out.println("<h1>Movie Deleted Successfully</h1>");
            out.println("<p>" + rowsDeleted + " row(s) deleted.</p>");

            deleteStatement.close();
        }

        connection.close();
    } catch (Exception e) {
        e.printStackTrace();
        out.println("<h1>Error updating movie information</h1>");
        out.println("<p>" + e.getMessage() + "</p>");
    }
    %>
</body>
</html>

