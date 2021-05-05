<%-- 
    Document   : agregar_grupo
    Created on : Apr 26, 2021, 3:44:40 PM
    Author     : josedf
--%>

    <%@page contentType="text/html" pageEncoding="UTF-8"%>
        <!DOCTYPE html>
        <html>

        <head>
            <meta charset="UTF-8">
            <meta http-equiv="X-UA-Compatible" content="IE=edge">
            <meta name="viewport" content="width=device-width, initial-scale=1.0">
            <link rel="stylesheet" href="/CursosLibres/css/styles.css">
            <link rel="stylesheet" href="/CursosLibres/css/navbar.css">
            <title>Agregar Grupo</title>
        </head>

        <body>
            <div class="main-container">
                <%@include file="/header.jsp" %>

                    <form class="formulario-container" method="POST" action="/CursosLibres/agregarGrupo">

                        <div class="formulario-form">
                            <table>
                                <tr>
                                    <td class="curso-izquierda">ID Curso:</td>
                                    <td class="curso-derecha">
                                        <input class="curso-derecha" name="idCurso" type="text">
                                    </td>
                                </tr>
                                <tr>
                                    <td class="curso-izquierda">ID Profesor:</td>
                                    <td class="curso-derecha ">
                                        <input class="curso-derecha" name="idProfesor" type="text">
                                    </td>
                                </tr>
                                <tr>
                                    <td class="curso-izquierda">Horario:</td>
                                    <td class="curso-derecha ">
                                        <input class="curso-derecha" name="fecha" type="text">
                                    </td>
                                </tr>
                            </table>
                        </div>
                        <div class="formulario-buttons">
                            <button type="submit" class="table-btn formulario-btn-primario" onclick="location.href = '/CursosLibres/agregarGrupo'">Guardar</button>
                        </div>

                    </form>
                    <div class="push"></div>
            </div>
            <%@ include file="/footer.jsp" %>
        </body>

        </html>