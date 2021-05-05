<%@page import="logic.usuario.profesor.Profesor"%>
<%@page import="logic.usuario.profesor.Service"%>

<%
    Service lista = (Service) request.getAttribute("listaProfesores");
    String nombreProfe = (String) request.getAttribute("nombreProfe");
%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
        <title>Administrar Profesores</title>
        <link rel="stylesheet" href="/CursosLibres/css/styles.css">
        <link rel="stylesheet" href="/CursosLibres/css/navbar.css">
        <link rel="stylesheet" href="/CursosLibres/css/style-table.css">
    </head>

    <body>
        <div class="main-container">
            <%@ include file="/header.jsp" %>

            <div class="busqueda-wrapper">
                <form class="search_box" action="/CursosLibres/BuscarProfeAction" method="POST">
                    <%
                            if (nombreProfe != null) {%>
                    <input name="nombreProfe" type="text" class="input_search" placeholder=<%=nombreProfe%>>
                    <%} else {%>
                    <input name="nombreProfe" type="text" class="input_search" placeholder="Buscar Profesor...">
                    <%}
                    %>
                </form>
            </div>
            <div class="tabla-container">
                <ul class="tabla">
                    <li class="tabla-header">
                        <div class="col total-col-4">Profesores</div>
                        <div class="col total-col-4"></div>
                        <div class="col total-col-4"></div>
                        <div class="col total-col-4"><button class="table-btn" onclick="location.href = '/CursosLibres/agregarProfesorShow'">Agregar</button></div>
                    </li>
                    <% if (lista.profesoresList() != null) {
                            for (Profesor c : lista.profesoresList()) {
                                String URLeditar = "/CursosLibres/editarProfeShow?idProfesor=" + c.getCedula();
                                String URLeliminar = "/CursosLibres/eliminarProfeShow?idProfesor=" + c.getCedula();
                                String URLver = "/CursosLibres/verProfeShow?idProfesor=" + c.getCedula();

                                String nombre = c.getNombre() + " " + c.getApellido1();
                    %>
                    <li class="tabla-row">
                        <div class="col total-col-4" data-label="Job Id"><%=nombre%></div>
                        <div class="col total-col-4" data-label="Customer Name"><button type="button" onclick="location.href = '<%=URLver%>'" class="table-btn">Ver informacion</button></div>
                        <div class="col total-col-4"><button type="button" class="table-btn" onclick="location.href = '<%=URLeditar%>'">Editar</button></div>
                        <div class="col total-col-4"><button type="button" class="table-btn" onclick="location.href = '<%=URLeliminar%>'" >Eliminar</button></div>
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
