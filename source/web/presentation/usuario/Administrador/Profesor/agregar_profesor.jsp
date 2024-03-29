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
        <title>Agregar Profesor</title>
    </head>

    <body>
        <div class="main-container">
            <%@include file="/header.jsp" %>

                <form class="formulario-container" method="POST" action="/CursosLibres/agregarProfesor">

                    <div class="formulario-form">
                        <table>
                            <tr>
                                <td class="curso-izquierda">Nombre:</td>
                                <td class="curso-derecha">
                                    <input class="curso-derecha" name="nombre" type="text">
                                </td>
                            </tr>
                            <tr>
                                <td class="curso-izquierda">Primer apellido:</td>
                                <td class="curso-derecha">
                                    <input class="curso-derecha" name="apellido1" type="text">
                                </td>
                            </tr>
                            <tr>
                                <td class="curso-izquierda">Segundo apellido:</td>
                                <td class="curso-derecha">
                                    <input class="curso-derecha" name="apellido2" type="text">
                                </td>
                            </tr>
                            <tr>
                                <td class="curso-izquierda">Cedula:</td>
                                <td class="curso-derecha ">
                                    <input class="curso-derecha" name="idProfesor" type="text">
                                </td>
                            </tr>
                            <tr>
                                <td class="curso-izquierda">Correo</td>
                                <td class="curso-derecha ">
                                    <input class="curso-derecha" name="correo" type="text">
                                </td>
                            </tr>
                            <tr>
                                <td class="curso-izquierda">Telefono</td>
                                <td class="curso-derecha ">
                                    <input class="curso-derecha" name="telefono" type="text">
                                </td>
                            </tr>
                            <tr>
                                <td class="curso-izquierda">Especialidad</td>
                                <td class="curso-derecha ">
                                    <input class="curso-derecha" name="especialidad" type="text">
                                </td>
                            </tr>
                            <tr>
                                <td class="curso-izquierda">Password</td>
                                <td class="curso-derecha ">
                                    <input class="curso-derecha" name="password" type="text">
                                </td>
                            </tr>
                        </table>
                    </div>

                    <div class="formulario-buttons">
                        <button type="submit" class="table-btn formulario-btn-primario">Guardar</button>
                    </div>
                </form>
                <div class="push"></div>
        </div>

        <%@ include file="/footer.jsp" %>
    </body>

    </html>