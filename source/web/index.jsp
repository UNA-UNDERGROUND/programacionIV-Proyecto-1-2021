<%@page import="logic.curso.Curso"%>
    <%@page import="logic.curso.Service"%>

        <%
    Service lista = (Service) request.getAttribute("listaCursos");
    String nombreCurso = (String) request.getAttribute("nombreCurso");
%>
            <%@page contentType="text/html" pageEncoding="UTF-8"%>
                <!DOCTYPE html>
                <html lang="es">

                <head>
                    <meta charset="utf-8">
                    <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
                    <title>CursosLibres</title>
                    <link rel="stylesheet" href="css/styles.css">
                    <link rel="stylesheet" href="css/my-styles.css">
                    <link rel="stylesheet" href="css/navbar.css">
                    <link rel="stylesheet" href="css/style-table.css">
                </head>

                <body>

                    <div class="main-container">
                        <%@ include file="header.jsp" %>
                            <%
                String URL = "/CursosLibres/GruposMatricularShow?idCurso=";
            %>

                                <div class="busqueda-wrapper">
                                    <form class="search_box" action="/CursosLibres/BuscarCursoAction" method="POST">
                                        <!--<button type="submit"class="search_btn"><i class="fas fa-search"></i></button>-->
                                        <%
                        if (nombreCurso != null) {%>
                                            <input name="nombreCurso" type="text" class="input_search" placeholder=<%=nombreCurso%>>
                                            <%} else {%>
                                                <input name="nombreCurso" type="text" class="input_search" placeholder="Buscar curso...">
                                                <%}
                    %>
                                    </form>
                                </div>

                                <div class="tabla-container">
                                    <ul class="tabla">
                                        <li class="tabla-header">
                                            <div class="col total-col-4"></div>
                                            <div class="col total-col-4">Curso</div>
                                            <div class="col total-col-4">Precio</div>
                                            <div class="col total-col-4"></div>
                                        </li>

                                        <% if (lista.cursosList() != null) {%>
                                            <%for (Curso c : lista.cursosList()) {%>
                                                <li class="tabla-row">
                                                    <div class="col total-col-4"><img src='/CursosLibres/image?nombre=<%=c.getNombre()%>' width="60" height="60"></div>
                                                    <div class="col total-col-4">
                                                        <%=c.getNombre()%>
                                                    </div>
                                                    <div class="col total-col-4">
                                                        <%=c.getCosto()%>
                                                    </div>
                                                    <div class="col total-col-4"><button type="button" onclick="location.href = '<%=URL%><%=c.getCodigo()%>'" class="table-btn">Ver</button></div>
                                                </li>
                                                <%}%>
                                                    <%}%>
                                    </ul>
                                </div>
                                <div class="push"></div>
                    </div>
                    <%@ include file="footer.jsp" %>
                </body>

                </html>