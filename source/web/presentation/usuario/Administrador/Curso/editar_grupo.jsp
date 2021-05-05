<%-- 
    Document   : Editar_Curso
    Created on : Apr 25, 2021, 7:04:08 PM
    Author     : josedf
--%>
    <%@page import="logic.grupo.Grupo"%>
        <%@page contentType="text/html" pageEncoding="UTF-8"%>
            <!DOCTYPE html>
            <html>
            <%
        Grupo grupo = (Grupo) request.getAttribute("GrupoED");
        int codigo = grupo.getCodigo();
        int codigocurso = grupo.getCurso_codigo();
        int IDProfesor = grupo.getProfesor_idPreofesor();
        String fecha = grupo.getFecha();
        request.setAttribute("idGrupo", codigo);
    %>

                <head>
                    <meta charset="UTF-8">
                    <meta http-equiv="X-UA-Compatible" content="IE=edge">
                    <meta name="viewport" content="width=device-width, initial-scale=1.0">
                    <link rel="stylesheet" href="/CursosLibres/css/styles.css">
                    <link rel="stylesheet" href="/CursosLibres/css/navbar.css">
                    <title>Editar Grupo</title>
                </head>

                <body>
                    <div class="main-container">
                        <%@include file="/header.jsp" %>
                            <%
                String URL = "/CursosLibres/editarGrupoAction?idGrupo=" + codigo;
            %>
                                <form method="POST" action="<%=URL%>" class="formulario-container">
                                    <div class="formulario-form">
                                        <table>
                                            <tr>
                                                <td class="curso-izquierda">ID del curso:</td>
                                                <td class="curso-derecha" class="input-curso">
                                                    <input class="curso-derecha" name="idCurso" type="text" value="<%=codigocurso%>">
                                                </td>
                                            </tr>
                                            <tr>
                                                <td class="curso-izquierda">ID del Profesor:</td>
                                                <td class="curso-derecha" class=" input-curso">
                                                    <input class="curso-derecha" name="idProfesor" type="text" value="<%=IDProfesor%>">
                                                </td>
                                            </tr>
                                            <%--<tr>
                            <td class="curso-izquierda">Cantidad de alumnos:</td>
                            <td class="curso-derecha" class=" input-curso">
                                <input class = "curso-derecha" name="cantida-grupo" type="text" value="<%=codigocurso%>">
                                                </td>
                                                </tr>--%>
                                                <tr>
                                                    <td class="curso-izquierda">Fecha:</td>
                                                    <td class="curso-derecha" class=" input-curso">
                                                        <input class="curso-derecha" name="fecha" type="text" value="<%=fecha%>">
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