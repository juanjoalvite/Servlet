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
        <a href=".">Volver</a>
        <form id="formAlumno"> 
            <select name="selector">
                <%
                    Alumno aux;
                    ArrayList<Alumno> listaAux = (ArrayList<Alumno>) request.getAttribute("listaAlumnos");
                    for (int i = 0; i < listaAux.size(); i++) {
                        aux = listaAux.get(i);
                %><option  value="<%=aux.getCodi()%>"><% out.println(listaAux.get(i).getNom());%></option><%   }
                %>
            </select>
            <input type="submit">     
        </form>

        <div id="resultado"></div>

        <script
            src="https://code.jquery.com/jquery-3.1.1.min.js"
            integrity="sha256-hVVnYaiADRTO2PzUGmuLJr8BLUSjGIZsDYGmIJLv2b8="
            crossorigin="anonymous"></script>
        
        <script>
            $('#formAlumno').on("submit", function (ev) {
                ev.preventDefault();
                //console.log("paramos envío formulario");

                $.ajax({
                    "url": window.location.pathname,
                    "method": "post",
                    "data": $('#formAlumno').serialize(),
                    "cache": false,
                    "complete": function (xhr, status) {
                        if (status !== "success") {
                            console.log("Error al recibir respuesta de servidor");
                        }
                    },
                    "success": function(data) {
                        //console.log("datos recibidos", data);
                        var resultado = $('#resultado');
                        resultado.empty();
                        
                        var codigo = $("<div><strong>Código:</strong> <span>"+data.codi+"</span></div>");
                        var nombre = $("<div><strong>Nombre:</strong> <span>"+data.nom+"</span></div>");
                        var asignatura = $("<div><strong>Asignatura:</strong> <span>"+data.asign+"</span></div>");
                        
                        resultado.append(codigo);
                        resultado.append(nombre);
                        resultado.append(asignatura);
                    }
                });
            });
        </script>
    </body>
</html>
