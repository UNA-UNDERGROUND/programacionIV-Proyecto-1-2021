<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

    <%
        Profesor profesor = (Profesor) request.getAttribute("Profemostrar");
        String nombre = profesor.getNombre();
        String apellido1 = profesor.getApellido1();
        String apellido2 = profesor.getApellido2();
        nombre = nombre + " " + apellido1 + " " + (apellido2 == null ? "" : apellido2);
        int cedula = profesor.getCedula();
    %>

    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="/CursosLibres/css/styles.css">
        <link rel="stylesheet" href="/CursosLibres/css/navbar.css">
        <link rel="stylesheet" href="/CursosLibres/css/style-table.css">
        <title>Eliminar Profesor</title>
    </head>

    <body>
        <div class="main-container">
            <%@include file="/header.jsp"%>

            <div class="curso-container">
                
                <div class="tabla-container">
                    <ul class="tabla">
                        <li class="tabla-row">
                            <div class="col total-col-2">¿Desea eliminar profesor?</div>
                            <div class="col total-col-2">
                                <%=nombre%>
                            </div>
                        </li>
                    </ul>
                </div>

            </div>

            <div class="volver-btn">
                <button class="table-btn" onclick="location.href = '/CursosLibres/eliminarProfeAction?idProfesor=<%=cedula%>'">Aceptar</button>
            </div>
            <div class="enviar-btn">
                <button class="table-btn" onclick="location.href = '/CursosLibres/mostrarProfesor'">Cancelar</button>
            </div>
            <div class="push"></div>
        </div>
        <%@ include file="/footer.jsp" %>
    </body>

</html>