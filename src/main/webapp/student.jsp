<%@ page import="uz.pdp.coursewithreportnew.repositories.StudentRepo" %>
<%@ page import="java.util.List" %>
<%@ page import="uz.pdp.coursewithreportnew.classes.Student" %><%--
  Created by IntelliJ IDEA.
  User: user
  Date: 12/3/2024
  Time: 10:44 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
  <title>Student page</title>
</head>
<body>

  <%
    String id = request.getParameter("id");
    List<Student> students = null;
    if (id != null){
      students = StudentRepo.getStudentByGroupId(Integer.parseInt(id));
    }
  %>

  <div class="row">
    <div class="col-6">
      <form action="/add/student" method="post" class="form-control">
        <div class="input-group">
          <input type="text" name="name" placeholder="Enter student name" class="form-control">
          <input type="hidden" name="groupId" value="<%=id%>">
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
      <th>GroupsId</th>
      <th>Action</th>
    </tr>
    </thead>
    <tbody>
    <%
      if (students != null) {
        for (Student student : students) {
    %>
    <tr>
      <td><%= student.getId() %></td>
      <td><%= student.getName() %></td>
      <td><%= student.getGroups().getId()%></td>
      <td>
        <form action="/payment.jsp">
          <input type="hidden" name="id" value="<%= student.getId()%>">
          <button class="btn btn-primary">Payment</button>
        </form>
      </td>
    </tr>
    <%
        }
      }
    %>
    </tbody>
  </table>

</body>
</html>
