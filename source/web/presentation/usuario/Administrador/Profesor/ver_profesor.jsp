<%@page import="logic.usuario.profesor.Profesor" %>
    <%@page contentType="text/html" pageEncoding="UTF-8"%>
        <!DOCTYPE html>
        <html>

        <%
        Profesor profesor = (Profesor) request.getAttribute("profesor");
    %>

            <head>
                <meta charset="UTF-8">
                <meta http-equiv="X-UA-Compatible" content="IE=edge">
                <meta name="viewport" content="width=device-width, initial-scale=1.0">
                <link rel="stylesheet" href="/CursosLibres/css/styles.css">
                <link rel="stylesheet" href="/CursosLibres/css/navbar.css">
                <link rel="stylesheet" href="/CursosLibres/css/style-table.css">
                <title>Ver Profesor</title>
            </head>

            <body>
                <div class="main-container">
                    <%@include file="/header.jsp"%>

                        <div class="tabla-container-mini">
                            <ul class="tabla">
                                <li class="tabla-header">
                                    <div class="col total-col-1">Informacion del profesor</div>
                                </li>
                                <li class="tabla-row-mini">
                                    <div class="col total-col-2" data-label="Job Id">Cedula</div>
                                    <div class="col total-col-2" data-label="Customer Name">
                                        <%=profesor.getCedula()%>
                                    </div>
                                </li>
                                <li class="tabla-row-mini">
                                    <div class="col total-col-2" data-label="Job Id">Nombre:</div>
                                    <div class="col total-col-2" data-label="Customer Name">
                                        <%=profesor.getNombre()%>
                                    </div>
                                </li>
                                <li class="tabla-row-mini">
                                    <div class="col total-col-2" data-label="Job Id">Primer apellido</div>
                                    <div class="col total-col-2" data-label="Customer Name">
                                        <%=profesor.getApellido1()%>
                                    </div>
                                </li>
                                <li class="tabla-row-mini">
                                    <div class="col total-col-2" data-label="Job Id">Segundo apellido</div>
                                    <%if (profesor.getApellido2() != null) {%>
                                        <div class="col total-col-2" data-label="Customer Name">
                                            <%=profesor.getApellido2()%>
                                        </div>
                                        <%} else {%>
                                            <div class="col total-col-2" data-label="Customer Name"></div>
                                            <%}
                        %>
                                </li>
                                <li class="tabla-row-mini">
                                    <div class="col total-col-2" data-label="Job Id">Correo:</div>
                                    <div class="col total-col-2" data-label="Customer Name">
                                        <%=profesor.getCorreo()%>
                                    </div>
                                </li>
                                <li class="tabla-row-mini">
                                    <div class="col total-col-2" data-label="Job Id">Telefono:</div>
                                    <div class="col total-col-2" data-label="Customer Name">
                                        <%=profesor.getNumero()%>
                                    </div>
                                </li>
                                <li class="tabla-row-mini">
                                    <div class="col total-col-2" data-label="Job Id">Especialidad:</div>
                                    <div class="col total-col-2" data-label="Customer Name">
                                        <%=profesor.getEspecialidad()%>
                                    </div>
                                </li>
                            </ul>
                        </div>
                        <div class="push"></div>
                </div>
                <%@ include file="/footer.jsp" %>
            </body>

        </html>