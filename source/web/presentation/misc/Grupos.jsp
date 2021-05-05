<%@page import="logic.grupo.Grupo"%>
<%@page import="logic.grupo.Service"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">

    <%Usuario usr = (Usuario) session.getAttribute("usr");%>

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
                        <div class="col total-col-3">Grupos</div>
                        <div class="col total-col-3"></div>
                        <div class="col total-col-3"><button class="table-btn formulario-btn1" onclick="location.href = '/CursosLibres/presentation/usuario/Administrador/Curso/agregar_grupo.jsp'">Agregar</button></div>
                    </li>

                    <%if (usr != null) {
                            Service service = (Service) request.getAttribute("listaGrupos");
                            for (Grupo g : service.gruposList()) {%>
                    <li class="tabla-row">
                        <div class="col total-col-3">Grupo <%=+g.getCodigo()%></div>
                        <div class="col total-col-3"><button class="table-btn" onclick="location.href = '/CursosLibres/VerGrupo?idGrupo=<%=g.getCodigo()%>'">Ver Informacion de Grupo</button></div>

                        <%String tipoUsuario = usuario.getClass().getSimpleName();
                            switch (tipoUsuario) {
                                case "Administrador": {%>
                        <div class="col total-col-3">
                            <button class="table-btn" onclick="location.href = '/CursosLibres/editarGrupoShow?idGrupo=<%= g.getCodigo()%>'">Editar</button>
                        </div>
                        <%break;
                                }
                            }%>

                    </li>
                    <%}
                        }
                    %>

                </ul>



            </div>
            <div class="push"></div>
        </div>

        <%@ include file="/footer.jsp" %>
    </body>


</html>
