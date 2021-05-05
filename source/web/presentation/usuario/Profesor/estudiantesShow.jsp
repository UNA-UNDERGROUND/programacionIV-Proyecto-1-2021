<%@page import="logic.usuario.estudiante.Service"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%
        Service listaEstudiantes = (Service) request.getAttribute("listaEstudiantes");
        String idGrupo = (String) request.getAttribute("idGrupo");
    %>
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
        <title>Cursos Administrador</title>
        <link rel="stylesheet" href="/CursosLibres/css/styles.css">
        <link rel="stylesheet" href="/CursosLibres/css/navbar.css">
        <link rel="stylesheet" href="/CursosLibres/css/style-table.css">
    </head>

    <body>
        <div class="main-container">
            <%@ include file="/header.jsp" %>

            <div class="tabla-container">
                <ul class="tabla">
                    <li class="tabla-header">
                        <div class="col total-col-4">Cedula</div>
                        <div class="col total-col-4">Nombre</div>
                        <div class="col total-col-4">Nota</div>
                        <div class="col total-col-4"></div>
                    </li>
                    <%if (listaEstudiantes != null) {
                            for (Estudiante e : listaEstudiantes.estudiantesList()) {

                                int cedula = e.getCedula();
                                String nombre = e.getNombre();
                                nombre = nombre + " " + e.getApellido1();
                                String nota = e.getNota() != 0 ? String.valueOf(e.getNota()) : "N/A";
                                String URL = "/CursosLibres/Profesor/CalificarEstudianteShow?idGrupo=";
                                URL = URL + idGrupo + "&idEstudiante=" + cedula;
                    %>
                    <li class="tabla-row">
                        <div class="col total-col-4"><%=cedula%></div>
                        <div class="col total-col-4"><%=nombre%></div>
                        <div class="col total-col-4"><%=nota%></div>
                        <div class="col total-col-4"><button onclick="location.href = '<%=URL%>'" class="table-btn">Calificar</button></div>
                    </li>
                    <%}
                        }%>
                </ul>
            </div>
            <div class="push"></div>
        </div>
        <%@ include file="/footer.jsp" %>
    </body>
</html>
