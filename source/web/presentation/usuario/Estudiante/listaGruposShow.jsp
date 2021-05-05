<%@page import="logic.grupo.Grupo"%>
<%@page import="logic.grupo.Service"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">

    <%
        Usuario usr = (Usuario) session.getAttribute("usr");
        Service service = (Service) request.getAttribute("listaGrupos");


    %>

    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="/CursosLibres/css/styles.css">
        <link rel="stylesheet" href="/CursosLibres/css/navbar.css">
        <link rel="stylesheet" href="/CursosLibres/css/style-table.css">
        <title>Grupos</title>
    </head>

    <body>
        <div class="main-container">
            <%@include file="/header.jsp"%>
            <div class="tabla-container">
                <ul class="tabla">
                    <li class="tabla-header">
                        <div class="col total-col-4" data-label="Job Id">Grupos</div>
                        <div class="col total-col-4" data-label="Customer Name">Horario</div>
                        <div class="col total-col-4"></div>
                        <div class="col total-col-4"></div>
                    </li>
                    <%
                        if (usr != null) {
                            for (Grupo g : service.gruposList()) {
                                String urlVerInfo = "/CursosLibres/InfoGrupoShow?idGrupo=" + g.getCodigo()
                                        + "&idCurso=" + g.getCurso_codigo() + "&idProfesor=" + g.getProfesor_idPreofesor();
                                String urlMatricular = "/CursosLibres/MatriculaConfirmacionShow?idGrupo=" + g.getCodigo()
                                        + "&idCurso=" + g.getCurso_codigo();
                    %>
                    <li class="tabla-row">
                        <div class="col total-col-4" data-label="Job Id">Grupo
                            <%=g.getCodigo()%>
                        </div>
                        <div class="col total-col-4" data-label="Customer Name">
                            <%=g.getFecha()%>
                        </div>
                        <div class="col total-col-4"><button class="table-btn" onclick="location.href = '<%=urlVerInfo%>'">Ver Grupo</button></div>
                        <div class="col total-col-4"><button class="table-btn" onclick="location.href = '<%=urlMatricular%>'">Matricular</button></div>
                    </li>
                    <%  }
                                            }%>
                </ul>
            </div>
            <div class="push"></div>
        </div>
        <%@ include file="/footer.jsp" %>
    </body>

</html>