<%@page import="logic.usuario.estudiante.Estudiante"%>
<%@page import="logic.usuario.estudiante.Service"%>

<% Service lista = (Service) request.getAttribute("estudiante");%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="/CursosLibres/css/styles.css">
        <link rel="stylesheet" href="/CursosLibres/css/navbar.css">
        <link rel="stylesheet" href="/CursosLibres/css/style-table.css">
        <title>Informacion Registro</title>
    </head>

    <body>
        <div class="main-container">
            <%@include file="/header.jsp"%>

            <div class="tabla-container">
                <ul class="tabla">
                    <li class="tabla-header">
                        <div class="col total-col-1">Contraseña temporal que debera ser cambiada desde la cuenta.</div>
                    </li>
                    <% if (lista.estudiantesList() != null) %>
                    <% for (Estudiante e : lista.estudiantesList()) {%>
                    <li class="tabla-row">
                        <div class="col total-col-2">Usuario:</div>
                        <div class="col total-col-2"><%= e.getCedula()%></div>
                    </li>
                    <li class="tabla-row">
                        <div class="col total-col-2">Password Temporal</div>
                        <div class="col total-col-2"><%= e.getPassword()%></div>
                    </li>
                    <%}%>
                </ul>
            </div>
            <div class="push"></div>
        </div>
        <%@ include file="/footer.jsp" %>
    </body>

</html>
