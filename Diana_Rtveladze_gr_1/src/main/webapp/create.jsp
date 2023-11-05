<!DOCTYPE html>
<html>
<head>
  <title>Create Movie</title>
</head>
<body>
<h1>Create a New Movie</h1>
<form action="AddMovieServlet" method="post">
  <label>Title:</label>
  <label>
    <input type="text" name="title" required>
  </label><br>
  <label>Director:</label>
  <label>
    <input type="text" name="director" required>
  </label><br>
  <label>Release Date:</label>
  <label>
    <input type="date" name="releaseDate" required>
  </label><br>
  <label>Rating:</label>
  <label>
    <input type="number" name="rating" min="0" max="10" step="0.1" required>
  </label><br>
  <label>Description:</label>
  <label>
    <textarea name="description" required></textarea>
  </label><br>
  <input type="submit" value="Create Movie">
</form>
</body>
</html>

