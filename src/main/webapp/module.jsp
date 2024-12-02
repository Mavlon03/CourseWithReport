<%@ page import="java.util.List" %>
<%@ page import="uz.pdp.coursewithreportnew.repositories.ModuleRepo" %>
<%@ page import="uz.pdp.coursewithreportnew.classes.Module" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <title>Module page</title>
</head>
<body>
<%
    String id = request.getParameter("id");
    List<Module> modulesList = null;

    if (id != null) {
        modulesList = ModuleRepo.getModuleByCourseId(Integer.parseInt(id));
    }
%>

<div class="row">
    <div class="col-6">
        <form action="/add/module" method="post">
            <div class="input-group">
                <input type="text" name="name" placeholder="Enter module name" class="form-control">
                <input type="hidden" name="courseId" value="<%= id %>">
                <button class="btn btn-primary">Add</button>
            </div> <!-- Yopish tegi -->
        </form>
    </div>
</div>

<hr>
<table class="table">
    <thead>
    <tr>
        <th>Id</th>
        <th>Name</th>
        <th>CourseId</th>
        <th>Action</th>
    </tr>
    </thead>
    <tbody>
    <%
        if (modulesList != null) {
            for (Module module : modulesList) {
    %>
    <tr>
        <td><%= module.getId() %></td>
        <td><%= module.getName() %></td>
        <td><%= module.getCourse().getId() %></td>
        <td>
            <form action="module.jsp">
                <input type="hidden" name="id" value="<%= module.getId() %>">
                <button class="btn btn-primary">Group</button>
            </form> <!-- Bu yerda formani yopish -->
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