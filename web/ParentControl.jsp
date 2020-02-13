<%--
  Created by IntelliJ IDEA.
  User: GianMarcoColagrossi
  Date: 10/02/2020
  Time: 15:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <title>Student's Home</title>
    <link rel="stylesheet" href="css/toast.css" type="text/css">
    <link rel="stylesheet" href="css/app.css" type="text/css">
    <link rel="stylesheet" href="css/navbar.css" type="text/css">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body style="background-color: #2581b8; color:white">
<ul>
    <li><a href="HomeStudent.jsp">Home</a></li>
    <li><a href="GradesStudent.jsp">Grades</a></li>
    <li><a href="ParentControl.jsp">Absences</a></li>
    <li>
        <form action="LogoutServlet" method="post">
            <input class="buttonLogout" style="padding:14px 16px"  type="submit" value="Logout">
        </form>
    </li>

</ul>

</body>
</html>
