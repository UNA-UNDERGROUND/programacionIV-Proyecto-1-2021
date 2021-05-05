<%@page import="logic.grupo.Service"%>
<%@page import="logic.grupo.Grupo"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

    <%
        Service listaCursos = (Service) request.getAttribute("listaGrupos");
    %>
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
        <title>Grupos</title>
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
                        <div class="col total-col-3">Grupos</div>
                        <div class="col total-col-3">Horario</div>
                        <div class="col total-col-3"></div>
                    </li>
                    <%
                        if (listaCursos != null) {
                            for (Grupo g : listaCursos.gruposList()) {
                                int idGrupo = g.getCodigo();
                                String URL = "/CursosLibres/Profesor/EstudiantesShow?idGrupo=" + idGrupo;
                                int codigo = g.getCodigo();
                                String horario = g.getFecha();
                    %>
                    <li class="tabla-row">
                        <div class="col total-col-3" data-label="Job Id"><%=codigo%></div>
                        <div class="col total-col-3" data-label="Customer Name"><%=horario%></div>
                        <div class="col total-col-3"><button onclick="location.href = '<%=URL%>'" class="table-btn">Ver estudiantes</button></div>
                    </li>
                    <%
                            }
                        }

                    %>
                </ul>
            </div>
            <div class="push"></div>
        </div>
        <%@ include file="/footer.jsp" %>
    </body>
</html>
