<%@page import="logic.curso.Curso"%>
<%@page import="logic.curso.Service"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

    <%
        Service lista = (Service) request.getAttribute("listaCursos");
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
                        <div class="col total-col-2">Cursos</div>
                        <div class="col total-col-2"></div>
                    </li>

                    <% if (lista.cursosList() != null) {%>
                    <%for (Curso c : lista.cursosList()) {
                            String urlVer = "/CursosLibres/GruposMatricularShow?idCurso=" + c.getCodigo();
                    %>
                    <li class="tabla-row">
                        <div class="col total-col-4" data-label="Job Id">
                            <%=c.getNombre()%>
                        </div>
                        <div class="col total-col-4" data-label="Customer Name"><button onclick="location.href = '<%=urlVer%>'" class="table-btn">Matricular</button></div>
                    </li>
                    <%}%>
                    <%}%>

                </ul>
            </div>
            <div class="push"></div>
        </div>
        <%@ include file="/footer.jsp" %>
    </body>

</html>