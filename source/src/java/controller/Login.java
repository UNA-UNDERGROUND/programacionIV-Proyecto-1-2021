package controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import logic.usuario.Model;
import logic.usuario.Usuario;
import logic.usuario.administrador.AdministradorDAO;
import logic.usuario.estudiante.EstudianteDAO;
import logic.usuario.profesor.ProfesorDAO;

@WebServlet(name = "Login", urlPatterns = {"/Login", "/Logout", "/loginShow", "/Error"})
public class Login extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        Model model = new Model();
        request.setAttribute("model", model);
        String URL;

        switch (request.getServletPath()) {
            case "/Login": {
                URL = show(request, response);
                break;
            }
            case "/Logout": {
                URL = Logout(request);
                break;
            }
            case "/loginShow": {
                URL = loginShow(request);
                break;
            }
            case "/Error": {
                URL = loginError(request);
                break;
            }
            default:
                URL = "/index.jsp";
        }

        if (URL != null) {
            request.getRequestDispatcher(URL).forward(request, response);
        }

    }

    public String loginError(HttpServletRequest request) {

        Map<String, String> errores = null;
        try {
            errores = this.validar(request);
            if (errores.isEmpty()) {
                this.updateModel(request);
                return "/Login";
            } else {
                request.setAttribute("errores", errores);
                return "/Login";
            }
        } catch (Exception e) {
            request.setAttribute("errores", errores);
            return "/Login";
        }
    }

    public Map<String, String> validar(HttpServletRequest request) {
        Map<String, String> errores = new HashMap<>();

        if (request.getParameter("usernameText").isEmpty()) {
            errores.put("usernameText", "Cedula requerida");
        }

        if (request.getParameter("passwordText").isEmpty()) {
            errores.put("passwordText", "Clave requerida");
        }
        try {
            String a = request.getParameter("usernameText");
            int auz = Integer.parseInt(a);

        } catch (NumberFormatException ex) {
            errores.put("usernameText", "No se aceptan letras en el ID");
        }

        return errores;
    }

    public String loginShow(HttpServletRequest request) {
        return "/presentation/login/login.jsp";
    }

    public String show(HttpServletRequest request, HttpServletResponse response) {

        try {
            Map<String, String> errores = this.validar(request);
            if (errores.isEmpty()) {
                this.updateModel(request);
                return this.showAction(request, response);
            } else {
                request.setAttribute("errores", errores);
                return "/presentation/login/login.jsp";
            }
        } catch (Exception e) {
            return "/presentation/login/error.jsp";
        }

    }

    void updateModel(HttpServletRequest request) {
        Model model = (Model) request.getAttribute("model");

        String auxCedula = (String) request.getParameter("usernameText");
        int aux = Integer.parseInt(auxCedula);
        String auxPassword = (String) request.getParameter("passwordText");

        model.getUsr().setPassword(auxPassword);
        model.getUsr().setCedula(aux);

    }

    public String Logout(HttpServletRequest request) {
        return this.logoutAction(request);

    }

    public String logoutAction(HttpServletRequest request) {
        HttpSession session = request.getSession(true);
        session.removeAttribute("usr");
        session.invalidate();
        return "/CursoDisplay";
    }

    private String showAction(HttpServletRequest request, HttpServletResponse response) {

        try {
            Model model = (Model) request.getAttribute("model");
            Usuario DBuser;
            HttpSession session = request.getSession(true);

            DBuser = EstudianteDAO.obtenerInstancia().recuperar(model.getUsr().getCedula());
            if (DBuser != null) {
                String passA = DBuser.getPassword();
                String passB = model.getUsr().getPassword();
                if (passA.equals(passB)) {
                    session.setAttribute("usr", DBuser);
                    response.sendRedirect("/CursosLibres/CursoDisplay");

                } else {
                    DBuser = null;
                }
            } else {
                DBuser = AdministradorDAO.obtenerInstancia().recuperar(model.getUsr().getCedula());

                if (DBuser != null) {
                    if (DBuser.getPassword().equals(model.getUsr().getPassword())) {
                        session.setAttribute("usr", DBuser);
                        response.sendRedirect("/CursosLibres/CursoDisplay");

                    } else {
                        DBuser = null;
                    }
                } else {
                    DBuser = ProfesorDAO.obtenerInstancia().recuperar(model.getUsr().getCedula());
                    if (DBuser != null) {
                        if (DBuser.getPassword().equals(model.getUsr().getPassword())) {
                            session.setAttribute("usr", DBuser);
                            response.sendRedirect("/CursosLibres/CursoDisplay");

                        } else {
                            DBuser = null;
                        }
                    }
                }
            }
            if (DBuser == null) {
                throw new Exception("ex");
            }
        } catch (Exception ex) {
            Map<String, String> errores = new HashMap<>();
            request.setAttribute("errores", errores);
            errores.put("usernameText", "Usuario o clave incorrectos /solo numeros");
            errores.put("passwordText", "Usuario o clave incorrectos");
            return "/presentation/login/login.jsp";

        }

        return null;

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
