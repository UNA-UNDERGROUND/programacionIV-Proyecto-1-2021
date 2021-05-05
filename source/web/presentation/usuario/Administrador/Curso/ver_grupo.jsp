<%@page import="logic.grupo.GrupoDAO"%>
    <%@page import="java.util.ArrayList"%>
        <%@page import="logic.usuario.profesor.ProfesorDAO"%>
            <%@page import="logic.curso.CursoDAO"%>
                <%@page import="logic.curso.Curso"%>
                    <%@page import="logic.curso.Curso"%>
                        <%@page import="logic.grupo.Grupo"%>
                            <%@page import="logic.grupo.Service"%>
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
                                        <title>Ver Grupo</title>
                                    </head>



                                    <body>
                                        <div class="main-container">
                                            <%@include file="/header.jsp"%>
                                                <%
                String aux = request.getParameter("idGrupo");
                int id = Integer.parseInt(aux);

                Grupo gg = GrupoDAO.obtenerInstancia().recuperar(id);
                Curso c = new Curso();
                Profesor p = new Profesor();
                int id1 = gg.getCurso_codigo();
                int id2 = gg.getProfesor_idPreofesor();
                c = CursoDAO.obtenerInstancia().recuperar(id1);
                p = ProfesorDAO.obtenerInstancia().recuperar(id2);
                String nombreC = c.getNombre();
                int idC = c.getCodigo();


            %>
                                                    <div class="curso-container">

                                                        <div class="tabla-container-mini">
                                                            <ul class="tabla">
                                                                <li class="tabla-header">
                                                                    <div class="col total-col-1">Informacion del grupo</div>
                                                                </li>
                                                                <li class="tabla-row-mini">
                                                                    <div class="col total-col-2" data-label="Job Id">ID del curso:</div>
                                                                    <div class="col total-col-2" data-label="Customer Name">
                                                                        <%= idC%>
                                                                    </div>
                                                                </li>
                                                                <li class="tabla-row-mini">
                                                                    <div class="col total-col-2" data-label="Job Id">Nombre del curso:</div>
                                                                    <div class="col total-col-2" data-label="Customer Name">
                                                                        <%= nombreC%>
                                                                    </div>
                                                                </li>
                                                                <li class="tabla-row-mini">
                                                                    <div class="col total-col-2" data-label="Job Id">Nombre del Profesor:</div>
                                                                    <div class="col total-col-2" data-label="Customer Name">
                                                                        <%= p.getNombre() + " " + p.getApellido1()%>
                                                                    </div>
                                                                </li>
                                                                <li class="tabla-row-mini">
                                                                    <div class="col total-col-2" data-label="Job Id">Horaio:</div>
                                                                    <div class="col total-col-2" data-label="Customer Name">
                                                                        <%= gg.getFecha()%>
                                                                    </div>
                                                                </li>
                                                            </ul>
                                                        </div>
                                                    </div>
                                                    <div class="volver-btn">
                                                        <button class="table-btn" onclick="location.href = '/CursosLibres/ListarGrupos?idCurso=<%=idC%>'">Volver</button>
                                                    </div>
                                                    <div class="push"></div>
                                        </div>
                                        <%@ include file="/footer.jsp" %>

                                    </body>

                                    </html>