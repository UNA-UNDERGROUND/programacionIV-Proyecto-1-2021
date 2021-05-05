<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="logic.curso.Service"%>
<%@page import="logic.curso.Curso" %>
<!DOCTYPE html>
<html>

    <%
        Service listaCursos = (Service) request.getAttribute("listaCursos");
    %>

    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
        <link rel="stylesheet" href="/CursosLibres/css/styles.css">
        <link rel="stylesheet" href="/CursosLibres/css/navbar.css">
        <link rel="stylesheet" href="/CursosLibres/css/style-table.css">
        <title>Cursos Impartidos</title>
    </head>

    <body>
        <div class="main-container">
            <%@ include file="/header.jsp" %>
            <div class="tabla-container">
                <ul class="tabla">
                    <li class="tabla-header">
                        <div class="col total-col-2">Cursos</div>
                        <div class="col total-col-2"></div>
                    </li>
                    <%if (listaCursos != null) {
                            for (Curso c : listaCursos.cursosList()) {
                                String nombre = c.getNombre();
                                int codigo = c.getCodigo();
                                String urlVerGrupos = "/CursosLibres/Profesor/GruposShow?idCurso=" + codigo;%>

                    <li class="tabla-row">
                        <div class="col total-col-2" data-label="Job Id"><%=nombre%></div>
                        <div class="col total-col-2" data-label="Customer Name"><button onclick="location.href = '<%=urlVerGrupos%>'" class="table-btn">Ver Grupos</button></div>
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
