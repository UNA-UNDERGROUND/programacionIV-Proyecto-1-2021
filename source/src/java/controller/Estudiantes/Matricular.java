package controller.Estudiantes;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import logic.curso.Curso;
import logic.curso.CursoDAO;
import logic.curso.Service;
import logic.grupo.Grupo;
import logic.grupo.GrupoDAO;
import logic.usuario.Usuario;
import logic.usuario.estudiante.Estudiante;
import logic.usuario.profesor.Profesor;
import logic.usuario.profesor.ProfesorDAO;

@WebServlet(name = "Matricular", urlPatterns = {
    "/MatricularShow",
    "/MatricularAction",
    "/GruposMatricularShow",
    "/InfoGrupoShow",
    "/MatricularAction",
    "/MatriculaConfirmacionShow"
})
public class Matricular extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String URL = "";

        switch (request.getServletPath()) {
            case "/MatricularShow": {
                URL = matricularShow(request);
                break;
            }
            case "/GruposMatricularShow": {
                URL = GruposMatricularShow(request);
                break;
            }
            case "/InfoGrupoShow": {
                URL = InfoGrupoShow(request);
                break;
            }
            case "/MatricularAction": {
                URL = matricularAction(request);
                break;
            }
            case "/MatriculaConfirmacionShow": {
                URL = matriculaConfirmacionShow(request);
                break;
            }

        }

        request.getRequestDispatcher(URL).forward(request, response);
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

    private String matricularShow(HttpServletRequest request) {
        try {
            if (validarEstudiante(request)) {
                Service service = CursoDAO.obtenerInstancia().listarCursos();
                request.setAttribute("listaCursos", service);
                return "/presentation/usuario/Estudiante/matricularShow.jsp";
            }
            throw new Exception("Debe iniciar session como estudiante");
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
            return "/loginShow";
        }
    }

    private boolean validarEstudiante(HttpServletRequest request) {
        HttpSession session = request.getSession();
        Usuario usr = (Usuario) session.getAttribute("usr");
        return usr.getClass().getSimpleName().equals("Estudiante");

    }

    private String GruposMatricularShow(HttpServletRequest request) {
        try {
            if (validarEstudiante(request)) {
                String cursoID = request.getParameter("idCurso");
                GrupoDAO dao = GrupoDAO.obtenerInstancia();
                logic.grupo.Service service = dao.listarGrupos(cursoID);
                if (service != null) {
                    request.setAttribute("listaGrupos", service);
                    return "/presentation/usuario/Estudiante/listaGruposShow.jsp";
                }
                throw new Exception("Error recuperando de base de datos");
            }
            throw new Exception("Debe iniciar sesion como estudiante para poder matricular");
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
            return "/loginShow";
        }
    }

    private String InfoGrupoShow(HttpServletRequest request) {
        try {
            if (validarEstudiante(request)) {
                //Obtener grupo

                String grupoID = request.getParameter("idGrupo");
                int grupoIdInt = Integer.parseInt(grupoID);
                Grupo grupo = GrupoDAO.obtenerInstancia().recuperar(grupoIdInt);
                if (grupo != null) {
                    int cursoID = grupo.getCurso_codigo();
                    Curso curso = CursoDAO.obtenerInstancia().recuperar(cursoID);

                    if (curso != null) {
                        //Utilizar el ID del grupo para obtener el profesor
                        int idProfesor = grupo.getProfesor_idProfesor();
                        Profesor profesor = ProfesorDAO.obtenerInstancia().recuperar(idProfesor);
                        if (profesor != null) {
                            request.setAttribute("cursoID", cursoID);
                            request.setAttribute("nombreCurso", curso.getNombre());
                            request.setAttribute("nombreProfesor", profesor.getNombre() + " " + profesor.getApellido1());
                            request.setAttribute("horario", grupo.getFecha());

                            return "/presentation/usuario/Estudiante/informacionGrupoShow.jsp";
                        }
                        throw new Exception("Error recuperando de base de datos");
                    }
                    throw new Exception("Error recuperando de base de datos");
                }
                throw new Exception("Error recuperando de base de datos");

            }
            throw new Exception("Debe iniciar sesion como estudiante para poder matricular");
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
            return "/loginShow";
        }
    }

    private String matricularAction(HttpServletRequest request) {
        try {
            if (validarEstudiante(request)) {
                String idGrupo = request.getParameter("idGrupo");
                int idGrupoInt = Integer.parseInt(idGrupo);
                Estudiante estudiante = (Estudiante) request.getSession().getAttribute("usr");
                GrupoDAO.obtenerInstancia().matricular(idGrupoInt, estudiante.getCedula());
                return "/MatricularShow";
            }
            throw new Exception("Debe iniciar sesion como estudiante para poder matricular");
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
            return "/loginShow";
        }

    }

    private String matriculaConfirmacionShow(HttpServletRequest request) {
        try {
            if (validarEstudiante(request)) {
                String idGrupo = request.getParameter("idGrupo");
                String idCurso = request.getParameter("idCurso");
                int idCursoInt = Integer.parseInt(idCurso);
                Curso curso = CursoDAO.obtenerInstancia().recuperar(idCursoInt);

                request.setAttribute("idGrupo", idGrupo);
                request.setAttribute("curso", curso);

                return "/presentation/usuario/Estudiante/confirmar_matricula.jsp";
            }
            throw new Exception("Debe iniciar sesion como estudiante para poder matricular");
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
            return "/loginShow";
        }
    }

}
