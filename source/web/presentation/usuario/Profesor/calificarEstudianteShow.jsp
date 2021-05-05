<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%
        String idGrupo = (String) request.getAttribute("idGrupo");
        Estudiante estudiante = (Estudiante) request.getAttribute("estudiante");

        String nombre = estudiante.getNombre();
        nombre = nombre + " " + estudiante.getApellido1();
        nombre = nombre + " " + estudiante.getApellido2();
        int nota = estudiante.getNota();
        int cedula = estudiante.getCedula();

        String URL = "/CursosLibres/Profesor/CalificarEstudianteAction?idGrupo=" + idGrupo
                + "&idEstudiante=" + cedula;
        String urlVolver = "/CursosLibres/Profesor/EstudiantesShow?idGrupo=" + idGrupo;


    %>
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="/CursosLibres/css/styles.css">
        <link rel="stylesheet" href="/CursosLibres/css/navbar.css">
        <link rel="stylesheet" href="/CursosLibres/css/style-table.css">
        <title>Eliminar Curso</title>
    </head>

    <body>
        <div class="main-container">
            <%@include file="/header.jsp"%>

            <form method="POST" action="<%=URL%>" class="formulario-container">
                <div class = "formulario-form">
                    <table>
                        <tr class="titulo-tabla">
                            <td class="curso-izquierda">Calificar estudiante: </td>
                            <td class="curso-derecha"><%=nombre%></td>
                        </tr>
                        <tr>
                            <td class="curso-izquierda">Nota: </td>
                            <td class="curso-derecha">
                                <input class = "curso-derecha" name="nota" type="text" value="<%=nota%>">
                            </td>
                        </tr>
                    </table>
                </div>
                <div class="formulario-buttons">
                    <button type="submit"class="table-btn formulario-btn-primario">Guardar</button>
                </div>
            </form>
            <div class="push"></div>
        </div>
        <%@ include file="/footer.jsp" %>
    </body>
</html>
