<%@ page import="bean.StudentBean" %>
<%@ page import="bean.GradesPageBean" %>
<%@ page import="bean.MatterBean" %>
<%@ page import="model.Grades" %><%--
  Created by IntelliJ IDEA.
  User: GianMarcoColagrossi
  Date: 10/02/2020
  Time: 15:56
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

<%
    if(session.getAttribute("gradesPage") != null){

        GradesPageBean gpb = (GradesPageBean) session.getAttribute("gradesPage");

%>

<div class="container-fluid col-sm-12" style="padding:30px">
<div class="row col-sm-12 card-deck row container-fluid">


    <div class="col-sm-2">

        Materie

        <%
            for(MatterBean m : gpb.getMatter()){
        %>

        <div class="shadow card col-sm-12" style="background-color: #53a8db; border-radius: 5px;color:white; padding:0px 20px">
            <div class="row">
               <form action="GradesStudentServlet" method="post">
                   <input type="hidden" name="materia" value="<%=m.getMateria()%>"/>
                   <input type="hidden" name="cmd" value="materia">
                   <input type="submit" value="<%=m.getMateria()%>">
               </form>
            </div>
        </div>
        <%}%>

    </div>

    <div class="shadow container-fluid card col-sm-4" style="background-color: #53a8db; border-radius: 5px;color:white; padding:0px 20px">
        Nome Materia<br> <%=gpb.getCurrent_matter().getMateria()%>
        <!-- for per voti -->
        <%for(Grades g : gpb.getCurrent_matter().getGradesForMatter()){%>
        Data: <%=g.getData()%>, Tipologia: <%=g.getTipo()%>, Voto: <%=g.getVoto()%>
        <!-- fine for per voti-->
        <%}%>
    </div>


    <div class="shadow container-fluid card col-sm-6" style="background-color: #53a8db; border-radius: 5px;color:white; padding:0px 20px">
        <br>
        <div align="center"><h5>School Report</h5></div><br>
        <!-- for -->
        <%
            for(MatterBean m : gpb.getMatter()){
        %>

        Nome Materia <%=m.getMateria()%> : Voto <%=m.getMedia()%>
        <%}%>
    </div>

</div>
</div>
<%}%>

</body>
</html>
