<%@ page import="uz.pdp.coursewithreportnew.repositories.CourseRepo" %>
<%@ page import="uz.pdp.coursewithreportnew.classes.Course" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: user
  Date: 12/3/2024
  Time: 2:32 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">

    <title>Course page</title>
</head>
<body>
    <%
        List<Course> courseList = CourseRepo.getCourseList();

    %>
<div class="row">
    <div class="col-6">
        <form action="/add/course" method="post">
            <div class="input group">
                <input type="text" name = "name" placeholder="Enter course name" class="form-control">
                <button class="btn btn-primary">Add</button>
            </div>
        </form>
    </div>
</div>

    <hr>

    <table class="table">
        <thead>
            <tr>
                <th>Id</th>
                <th>Name</th>
                <th>Action</th>
            </tr>
        </thead>

        <tbody>
        <%
            for (Course course : courseList) {
        %>
        <tr>
            <td><%=course.getId()%></td>
            <td><%=course.getName()%></td>
            <td>
                <form action="/module.jsp">
                    <input type="hidden" value="<%=course.getId()%>" name="id">
                    <button class="btn btn-primary">Modules</button>
                </form>
            </td>
        </tr>
        <%
            }
        %>
        </tbody>
    </table>

</body>
</html>
