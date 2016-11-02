<%-- 
    Document   : index
    Created on : 24-oct-2016, 19:23:18
    Author     : juanj
--%>

<%@page import="java.io.PrintWriter"%>
<%@page import="java.util.ArrayList"%>
<%@page import="AccesoDatos.Alumno"%>
<%@page import="AccesoDatos.AccesoAlumnos"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Curso</title>
    </head>    
    <body>   
        <form method="POST" action="Servlet" > 
            <select id="selector" name="selector">
                <%
                    //Rellena el selector con la lista de los alumnos.
                    response.setContentType("text/html;charset=UTF-8");
                    AccesoAlumnos alumnos = new AccesoAlumnos();
                    ArrayList<Alumno> listaAlumnos = alumnos.getListaAlumnos();
                    Alumno aux;
                    for (int i = 0; i < listaAlumnos.size(); i++) {
                        aux = listaAlumnos.get(i);
                %><option  value="<%=aux.getCodi()%>"><% out.println(listaAlumnos.get(i).getNom());%></option><%   }
                %>
            </select>
            <input type="submit" name="enviar">     
        </form>
    </body>
</html>
