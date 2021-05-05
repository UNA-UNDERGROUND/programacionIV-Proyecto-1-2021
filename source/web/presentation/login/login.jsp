<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="logic.usuario.Model"%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html class="html-login">

    <% Model model = (Model) request.getAttribute("model"); %>
    <% Map<String, String> errores = (Map<String, String>) request.getAttribute("errores"); %>
    <% Map<String, String[]> form = (errores == null) ? this.getForm(model) : request.getParameterMap();%>
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
        <title>Login</title>
        <link rel="stylesheet" href="/CursosLibres/css/login.css">
        <link rel="stylesheet" href="/CursosLibres/css/styles.css">
        <link rel="stylesheet" href="/CursosLibres/css/navbar.css">
        <link rel="stylesheet" href="/CursosLibres/css/style-table.css">

    </head>
    <body>
        <div class="main-container">
            <%@ include file="/header.jsp" %>
            <div class="login-wrap">
                <div class="login-html">
                    <input id="tab-1" type="radio" name="tab" class="sign-in" checked><label for="tab-1" class="tab">Iniciar sesion</label>
                    <input id="tab-2" type="radio" name="tab" class="sign-up"><label for="tab-2" class="tab">Registrarse</label>
                    <div class="login-form">


                        <form action="/CursosLibres/Login" method="post" class="sign-in-htm">
                            <div class="group">
                                <label for="user" class="label">Cedula</label>
                                <input id="user" class="input <%=erroneo("usernameText", errores)%>" type="text" name="usernameText" 
                                       value="<%=form.get("usernameText")[0]%>" title="<%=title("usernameText", errores)%>" required>
                            </div>
                            <div class="group">
                                <label for="pass" class="label">Password</label>
                                <input id="pass" data-type="password" class="input <%=erroneo("passwordText", errores)%>" type="password" name="passwordText" 
                                       value="<%=form.get("passwordText")[0]%>" title="<%=title("passwordText", errores)%>"required>
                            </div>
                            <div class="group">
                                <input type="submit" class="button" value="Iniciar Sesion">
                            </div>
                        </form>


                        <form class="sign-up-htm" name="regristro" action="/CursosLibres/signup" method="POST">
                            <div class="group">
                                <label for="cedula" class="label">Cedula</label>
                                <input id="cedula" class="input" type="text" name="idEstudiante">
                            </div>
                            <div class="group">
                                <label for="nombre" class="label">Nombre</label>
                                <input id="nombre" type="text" name="nombre" class="input" name="nombre">
                            </div>
                            <div class="group">
                                <label for="pass" class="label">Primer Apellido</label>
                                <input id="pass" type="text" name="apellido1" class="input">
                            </div>
                            <div class="group">
                                <label for="apellido2" class="label">Segundo apellido</label>
                                <input id="apellido2" type="text" name="apellido2" class="input">
                            </div>
                            <div class="group">
                                <label for="correo" class="label">Correo</label>
                                <input id="correo" type="text" name="correo" class="input">
                            </div>
                            <div class="group">
                                <label for="telefono" class="label">Telefono</label>
                                <input id="telefono" type="text" name="telefono" class="input">
                            </div>
                            <div class="group">
                                <label for="direccion" class="label">Direccion</label>
                                <input id="direccion" type="text" name="direccion" class="input">
                            </div>
                            <div class="group">
                                <input type="submit" class="button" value="Registrarse">
                            </div>

                        </form>
                    </div>
                </div>
            </div>
            <div class="push"></div>              

        </div>
        <%@ include file="/footer.jsp" %>
    </body>

</html>


<%!
    private String erroneo(String campo, Map<String, String> errores) {
        if ((errores != null) && (errores.get(campo) != null)) {
            return "is-invalid";
        } else {
            return "";
        }
    }

    private String title(String campo, Map<String, String> errores) {
        if ((errores != null) && (errores.get(campo) != null)) {
            return errores.get(campo);
        } else {
            return "";
        }
    }

    private Map<String, String[]> getForm(Model model) {
        Map<String, String[]> values = new HashMap<>();

        String aux = Integer.toString(model.getUsr().getCedula());
        if (!aux.equals(0)) {

            values.put("usernameText", new String[]{""});
            values.put("passwordText", new String[]{""});
        } else {
            values.put("usernameText", new String[]{aux});
            values.put("passwordText", new String[]{model.getUsr().getPassword()});

        }
        return values;
    }

%> 



