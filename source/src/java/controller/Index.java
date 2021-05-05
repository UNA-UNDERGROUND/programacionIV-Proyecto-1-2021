
package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import logic.curso.CursoDAO;
import logic.curso.Service;


@WebServlet(name = "CursoDisplay", urlPatterns = {"/CursoDisplay", "/BuscarCursoAction"})
public class Index extends HttpServlet {

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String URL = "";
        switch (request.getServletPath()) {
            case "/CursoDisplay": {
                URL = display(request);
                break;
            }

            case "/BuscarCursoAction": {
                URL = buscarCursoAction(request);
                break;
            }
            default:
                URL = "/CursosLibres/index.jsp";
                break;
        }

        response.setContentType("text/html;charset=UTF-8");
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

    public String display(HttpServletRequest request) {

        CursoDAO dao = CursoDAO.obtenerInstancia();
        Service listaCursos = dao.listarCursosEnOferta();

        request.setAttribute("listaCursos", listaCursos);

        return "/index.jsp";

    }

    private String buscarCursoAction(HttpServletRequest request) {
        
        CursoDAO dao = CursoDAO.obtenerInstancia();
        String nombreCurso = request.getParameter("nombreCurso");
        Service listaCursos = dao.buscarPorNombre(nombreCurso);
                
        request.setAttribute("listaCursos", listaCursos);
        request.setAttribute("nombreCurso", nombreCurso);

        return "/index.jsp";
    }

}
