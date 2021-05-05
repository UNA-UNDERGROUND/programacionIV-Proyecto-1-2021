<%@page import="logic.curso.Curso"%>
    <%@page import="logic.curso.Service"%>

        <%
    Service lista = (Service) request.getAttribute("listaCursos");
%>

            <%@page contentType="text/html" pageEncoding="UTF-8"%>
                <!DOCTYPE html>
                <html>

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
                                        <div class="col total-col-5"></div>
                                        <div class="col total-col-5">Codigo</div>
                                        <div class="col total-col-5">Cursos</div>
                                        <div class="col total-col-5"></div>
                                        <div class="col total-col-5"><button class="table-btn" onclick="location.href = '/CursosLibres/agregarCursoShow'">Agregar</button></div>
                                    </li>
                                    <% if (lista.cursosList() != null) {%>
                                        <%for (Curso c : lista.cursosList()) {
                            String URLeditar = "/CursosLibres/editarCursoShow?idCurso=" + c.getCodigo();
                            String urlVer = "/CursosLibres/ListarGrupos?idCurso=" + c.getCodigo();
                    %>
                                            <li class="tabla-row">
                                                <div class="col total-col-5"><img src='/CursosLibres/image?nombre=<%=c.getNombre()%>' width="60" height="60"></div>
                                                <div class="col total-col-5"><%=c.getCodigo()%></div>
                                                <div class="col total-col-5"><%=c.getNombre()%></div>
                                                <div class="col total-col-5"><button onclick="location.href = '<%=urlVer%>'" class="table-btn">Ver Grupos</button></div>
                                                <div class="col total-col-5"><button class="table-btn" onclick="location.href = '<%=URLeditar%>'">Editar</button></div>
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