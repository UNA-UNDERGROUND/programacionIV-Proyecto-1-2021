<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%
        int cursoID = (int) request.getAttribute("cursoID");
        String cursoIdString = String.valueOf(cursoID);
        String urlGruposShow = "/CursosLibres/GruposMatricularShow?idCurso=" + cursoIdString;
        String nombreCurso = (String) request.getAttribute("nombreCurso");
        String nombreProfesor = (String) request.getAttribute("nombreProfesor");
        String horario = (String) request.getAttribute("horario");
    %>

    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="/CursosLibres/css/styles.css">
        <link rel="stylesheet" href="/CursosLibres/css/navbar.css">
        <link rel="stylesheet" href="/CursosLibres/css/style-table.css">
        <title>Ver Grupo</title>
    </head>

    <body>
        <div class="main-container">
            <%@include file="/header.jsp"%>

            <div class="curso-container">
                <div class="tabla-container">
                    <ul class="tabla">
                        <li class="tabla-header">
                            <div class="col total-col-1">Informacion del curso:</div>
                        </li>
                        <li class="tabla-row">
                            <div class="col total-col-2">Nombre del curso:</div>
                            <div class="col total-col-2">
                                <%=nombreCurso%>
                            </div>
                        </li>
                        <li class="tabla-row">
                            <div class="col total-col-2">Nombre del Profesor:</div>
                            <div class="col total-col-2">
                                <%=nombreProfesor%>
                            </div>
                        </li>
                        <li class="tabla-row">
                            <div class="col total-col-2">Horario:</div>
                            <div class="col total-col-2">
                                <%=horario%>
                            </div>
                        </li>
                    </ul>
                </div>
            </div>
            <div class="push"></div>
        </div>
        <%@ include file="/footer.jsp" %>
    </body>

</html>