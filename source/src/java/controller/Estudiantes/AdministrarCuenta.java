
package controller.Estudiantes;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import logic.usuario.Usuario;
import logic.usuario.estudiante.EstudianteDAO;
import logic.usuario.estudiante.Service;


@WebServlet(name = "AdministrarCuenta", urlPatterns = {"/AdministrarCuenta", "/signup", "/updateEstudiante"})
public class AdministrarCuenta extends HttpServlet {

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String opcion = request.getServletPath();
        String URL = "";
        switch (opcion) {
            case "/signup": {
                URL = Singup(request, response);
                break;
            }
            case "/updateEstudiante": {
                URL = updatePassword(request);
                break;
            }
            default:
                break;
        }
        if (URL != null)
            request.getRequestDispatcher(URL).forward(request, response);
    }
    
    public String Singup(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String URL = "index.jsp";
        try {
            EstudianteDAO.obtenerInstancia().crear(request);
            URL = muesttatemporal(request);
            return URL;
        } catch (Exception ex) {
            if (ex.getMessage().equals("duplicado")) {
                response.sendRedirect("/CursosLibres/loginShow");
            }
        }
        return null;
    }
    
    public String updatePassword(HttpServletRequest request) {
        
         if (validarUsr(request)) {
            String cedulaString = request.getParameter("idEstudiante");
            int cedula = Integer.parseInt(cedulaString);
//            String nombre = request.getParameter("nombre");
//            String apellido1 = request.getParameter("apellido1");
//            String apellido2 = request.getParameter("apellido2");
            String correo = request.getParameter("correo");
            String telefono = request.getParameter("telefono");
            String dirrecion = request.getParameter("dirrecion");
            String password = request.getParameter("password");

            logic.usuario.estudiante.Estudiante p = new  logic.usuario.estudiante.Estudiante(cedula, "", "", "", correo, telefono, dirrecion, password);

            try {
                EstudianteDAO.obtenerInstancia().actualizar(p);
                Usuario DBuser;
                HttpSession session = request.getSession(true);
                DBuser = EstudianteDAO.obtenerInstancia().recuperar(cedula);
                session.setAttribute("usr", DBuser);
                return "/MatricularShow";
                
            } catch (Exception ex) {
                return "/editarInfoShow";
            }
        }
        return "/CursoDisplay";
        
        
//        String URL = "index.jsp";
//        try {
//            EstudianteDAO.obtenerInstancia().crear(request);
//
//        } catch (Exception ex) {
//            if (ex.getMessage().equals("duplicado")) {
//                URL = "/presentation/usuario/Estudiante/Signin.jsp";
//            }
//            Logger.getLogger(Estudiante.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        return URL;
    }

    public String muesttatemporal(HttpServletRequest request) {
        
        int id = Integer.parseInt(request.getParameter("idEstudiante"));
        Service srv = new Service();

        logic.usuario.estudiante.Estudiante aux = EstudianteDAO.obtenerInstancia().recuperar(id);
        srv.estudiantesAdd(aux);
        request.setAttribute("estudiante", srv);
        return "/presentation/login/informacion_registro.jsp";
    }
    
    
     private Boolean validarUsr(HttpServletRequest request) {
        HttpSession session = request.getSession(true);
        Usuario usr = (Usuario) session.getAttribute("usr");
        if (usr != null) {
            String tipoUsuario = usr.getClass().getSimpleName();
            return tipoUsuario.equals("Estudiante");
        }
        return false;

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
    }// </editor-fold>

}
