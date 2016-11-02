<%-- 
    Document   : datosAl
    Created on : 01-nov-2016, 18:22:43
    Author     : juanj
--%>

<%@page import="AccesoDatos.Alumno"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    Alumno al = (Alumno) request.getAttribute("alumno");
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Informacion del alumno:</h1>
        Alumno:  <%out.println(al.getNom());%><br>
        Código:  <%out.println(al.getCodi()); %><br>
        Asignaturas:  <%out.println(al.getAsign()); %><br>
        Tutorías:  <%out.println(al.getTut());%>
    </body>
</html>
