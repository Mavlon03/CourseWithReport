<%@ page import="uz.pdp.coursewithreportnew.repositories.PaymentRepo" %>
<%@ page import="uz.pdp.coursewithreportnew.classes.Payment" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: user
  Date: 12/3/2024
  Time: 12:03 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <title>Payment page</title>
</head>
<body>
<%
    String id = request.getParameter("id");
    List<Payment> payments = null;
    if (id != null){
        payments = PaymentRepo.getPaymentByStudentId(Integer.parseInt(id));
    }
%>

<div class="row">
    <div class="col-6">
        <form action="/add/payment" method="post" class="form-control">
            <div class="input-group">
                <input type="text" name="amount" placeholder="Enter amount" class="form-control">
                <input type="hidden" name="studentId" value="<%=id%>">
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
        if (payments != null) {
            for (Payment payment : payments) {
    %>
    <tr>
        <td><%= payment.getId() %></td>
        <td><%= payment.getAmount() %></td>
        <td><%= payment.getStudent().getId()%></td>
        <td>
            <form action="/report.jsp">
                <input type="hidden" name="id" value="<%= payment.getId()%>">
                <button class="btn btn-primary">Report</button>
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
