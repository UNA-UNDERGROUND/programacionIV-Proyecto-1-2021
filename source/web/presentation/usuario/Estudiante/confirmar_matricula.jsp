<%@page import="logic.curso.Curso"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

    <%
        Curso curso = (Curso) request.getAttribute("curso");
        String idGrupo = (String) request.getAttribute("idGrupo");

        String urlConfirmar = "/CursosLibres/MatricularAction?idGrupo=" + idGrupo;
        String urlCancelar = "/CursosLibres/GruposMatricularShow?idCurso=" + curso.getCodigo();
    %>

    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="/CursosLibres/css/styles.css">
        <link rel="stylesheet" href="/CursosLibres/css/navbar.css">
        <link rel="stylesheet" href="/CursosLibres/css/style-table.css">
        <title>Confirmar Matricula</title>
    </head>

    <body>
        <div class="main-container">
            <%@include file="/header.jsp"%>

            <div class="tabla-container">
                <ul class="tabla">
                    <li class="tabla-row">
                        <div class="col total-col-2">¿Desea matricular curso?:</div>
                        <div class="col total-col-2">
                            <%=curso.getNombre()%>
                        </div>
                    </li>
                </ul>
            </div>
            <div class="volver-btn">
                <button class="table-btn" onclick="location.href = '<%=urlConfirmar%>'">Aceptar</button>
            </div>
            <div class="enviar-btn">
                <button class="table-btn" onclick="location.href = '<%=urlCancelar%>'">Cancelar</button>
            </div>

        </div>


        <div class="push"></div>
    </div>
    <%@ include file="/footer.jsp" %>
</body>

</html>