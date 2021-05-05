<%@page import="logic.curso.CursoActual"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

    <%
        ArrayList<CursoActual> listaCursos = (ArrayList<CursoActual>) request.getAttribute("listaCursos");
        session.setAttribute("listaCursos", listaCursos);
    %>

    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
        <title>Cursos Actuales</title>
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
                        <div class="col total-col-4">Nombre del curso</div>
                        <div class="col total-col-4">Nombre del profesor</div>
                        <div class="col total-col-4">Horario</div>
                        <div class="col total-col-4">Nota</div>
                    </li>
                    <%for (CursoActual c : listaCursos) {%>
                    <li class="tabla-row">
                        <div class="col total-col-4">
                            <%=c.getNombre()%>
                        </div>
                        <div class="col total-col-4">
                            <%=c.getNombreProfesor()%>
                            <%=c.getApellidoProfesor()%>
                        </div>
                        <div class="col total-col-4">
                            <%=c.getHorario()%>
                        </div>
                        <div class="col total-col-4">
                            <%=c.getNota()%>
                        </div>
                    </li>
                    <%}%>
                </ul>
            </div>


            <div class="volver-btn">
                <button class="table-btn" onclick="location.href = '/CursosLibres/ImprimirHistorialAction'">Imprimir Historial</button>
            </div>
            <div class="push"></div>
        </div>
        <%@ include file="/footer.jsp" %>
    </body>

</html>