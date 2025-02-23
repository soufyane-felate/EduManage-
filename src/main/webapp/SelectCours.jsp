<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="fr">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Select Courses</title>
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css">
</head>
<body>
<div class="container">
  <h2 class="text-center mb-4">Select Courses for Student</h2>
  <form action="EnrollStudentServlet" method="post">
    <input type="hidden" name="student_id" value="${student_id}">
    <table class="table table-striped">
      <thead>
      <tr>
        <th>Select</th>
        <th>Course Name</th>
        <th>Description</th>
      </tr>
      </thead>
      <tbody>
      <c:if test="${empty coursList}">
        <tr>
          <td colspan="3" class="text-center text-muted">No courses available.</td>
        </tr>
      </c:if>
      <c:forEach var="cours" items="${coursList}">
        <tr>
          <td>
            <input type="checkbox" name="course_ids" value="${cours.id}">
          </td>
          <td>${cours.nom_cours}</td>
          <td>${cours.description}</td>
        </tr>
      </c:forEach>
      </tbody>
    </table>
    <button type="submit" name="action" value="enroll" class="btn btn-success">Enroll</button>
    <a href="StudentServlet?action=list" class="btn btn-primary">Back to Students</a>
  </form>
</div>
</body>
</html>