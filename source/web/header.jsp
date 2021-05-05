<%@page import="logic.usuario.Usuario"%>
<%@page import="logic.usuario.estudiante.Estudiante"%>
<%@page import="logic.usuario.profesor.Profesor"%>
<%@page import="logic.usuario.administrador.Administrador"%>

<header class="header-container">

    <h1 class="header-h1">CursosLibres.com</h1>
    <nav class="header-nav">
        <ul class="header-ul">
            <li class="header-li"><a href="/CursosLibres/CursoDisplay">Inicio</a></li>

            <% Usuario usuario = (Usuario) session.getAttribute("usr"); %>

            <% if (usuario != null) { %>

            <% String tipoUsr = usuario.getClass().getSimpleName(); %>
            <% if (usuario.getClass().getSimpleName().equals("Estudiante")) { %>
            <li class="header-li"><a href="/CursosLibres/MatricularShow">Matricular</a></li>
            <li class="header-li"><a href="/CursosLibres/ListaCursosShow">Historial</a></li>
            <li class="header-li">
                <a href="#0">Cuenta</a>
                <ul class="header-ul">
                    <li class="header-li"><a href="/CursosLibres/presentation/usuario/Estudiante/editarInfoShow.jsp">Actualizar Perfil</a></li>
                    <li class="header-li"><a href="/CursosLibres/Logout">Logout</a></li>
                </ul>
            </li>
            <% } %>
            <% if (tipoUsr.equals("Profesor")) {%>
            <li class="header-li"><a href="/CursosLibres/Profesor/CursosShow">Grupos y cursos</a></li>
            <li class="header-li"><a href="/CursosLibres/Logout">Logout</a></li>


            <% }%>  
            <% if (tipoUsr.equals("Administrador")) {%>

            <li class="header-li"><a href="/CursosLibres/Cursos">Administrar Cursos y Grupos</a></li>
            <li class="header-li"><a href="/CursosLibres/mostrarProfesor">Administrar Profesores</a></li>
            <li class="header-li"><a href="/CursosLibres/Logout">Logout</a></li>



            <% }%>  
            <% } else {%> 
            <li class="header-li"><a href="/CursosLibres/loginShow">Login</a></li>
                <% }%>
        </ul>
    </nav>




</header>