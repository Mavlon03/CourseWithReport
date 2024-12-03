<%@ page import="uz.pdp.coursewithreportnew.classes.Groups" %>
<%@ page import="uz.pdp.coursewithreportnew.repositories.GroupsRepo" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: user
  Date: 12/3/2024
  Time: 4:20 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">

    <title>Group page</title>
  </head>
  <body>

  <%
    String id = request.getParameter("id");
    List<Groups> groups = null;
    if (id != null) {
        groups = GroupsRepo.getGroupsByModuleId(Integer.parseInt(id));
    }
  %>


  <div class="row">
    <div class="col-6">
      <form action="/add/group" method="post" class="form">
        <div class="input-group">
          <input type="text" name="name" placeholder="Enter group name" class="form-control">
          <input type="hidden" name="moduleId" value="<%=id%>">
          <button class="btn btn-primary">Add</button>
        </div>
      </form>
    </div>
  </div>

  <table class="table table-bordered">
    <thead>
    <tr>
      <th>Id</th>
      <th>Name</th>
      <th>ModuleId</th>
      <th>Action</th>
    </tr>
    </thead>
    <tbody>
    <%
      if (groups != null && !groups.isEmpty()) {
        for (Groups group : groups) {
    %>
    <tr>
      <td><%= group.getId() %></td>
      <td><%= group.getName() %></td>
      <td><%= group.getModules() != null ? group.getModules().getId() : "N/A" %></td>
      <td>
        <form action="students.jsp" method="post">
          <input type="hidden" name="id" value="<%= group.getId() %>">
          <button class="btn btn-primary">Students</button>
        </form>
      </td>
    </tr>
    <%
      }
    } else {
    %>
    <tr>
      <td colspan="4" class="text-center">No groups found.</td>
    </tr>
    <%
      }
    %>
    </tbody>
  </table>


  </body>
</html>
