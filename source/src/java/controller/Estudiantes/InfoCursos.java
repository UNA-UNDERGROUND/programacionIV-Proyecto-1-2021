
package controller.Estudiantes;

import com.itextpdf.io.font.constants.StandardFonts;
import com.itextpdf.io.image.ImageData;
import com.itextpdf.io.image.ImageDataFactory;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Image;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.pdfa.PdfADocument;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import logic.curso.CursoActual;
import logic.curso.CursoDAO;
import logic.curso.Service;
import logic.usuario.Usuario;
import logic.usuario.estudiante.Estudiante;


@WebServlet(name = "InfoCursos", urlPatterns = {"/ListaCursosShow", "/ImprimirHistorialAction"})
public class InfoCursos extends HttpServlet {


    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String URL = "";

        switch (request.getServletPath()) {
            case "/ListaCursosShow": {
                URL = listaCursosShow(request);
                break;
            }

            case "/ImprimirHistorialAction": {
                URL = imprimirHistorialAction(request, response);
                break;
            }

        }
        if (URL != null) {
            request.getRequestDispatcher(URL).forward(request, response);
        }
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

    private String listaCursosShow(HttpServletRequest request) {
        try {
            if (validarEstudiante(request)) {

                List<CursoActual> listaCursos;

                Estudiante estudiante = (Estudiante) request.getSession().getAttribute("usr");
                int idEstudiante = estudiante.getCedula();

                listaCursos = (ArrayList<CursoActual>) CursoDAO.obtenerInstancia().listarCursosActuales(idEstudiante);

                if (listaCursos != null) {
                    request.setAttribute("listaCursos", listaCursos);
                    return "/presentation/usuario/Estudiante/cursosActualesShow.jsp";
                }

                throw new Exception("Error al recuperar de la base de datos");
            }
        } catch (Exception ex) {
            return "/CursoDisplay";
        }
        return "";
    }

    private boolean validarEstudiante(HttpServletRequest request) {
        HttpSession session = request.getSession();
        Usuario usr = (Usuario) session.getAttribute("usr");
        return usr != null;

    }

    private String imprimirHistorialAction(HttpServletRequest request, HttpServletResponse response) {
        try {
            if (validarEstudiante(request)) {
                try {
                    HttpSession session = request.getSession(true);

                    PdfDocument pdf = new PdfDocument(new PdfWriter(response.getOutputStream()));
                    Document doc = new Document(pdf, PageSize.A4.rotate());

                    PdfFont font = PdfFontFactory.createFont(StandardFonts.HELVETICA);

                    ArrayList<CursoActual> listaCursos = (ArrayList<CursoActual>) session.getAttribute("listaCursos");
                    for (CursoActual c : listaCursos) {

                        doc.add(new Paragraph("Curso: " + c.getNombre()));
                        doc.add(new Paragraph("Profesor: " + c.getNombreProfesor() + c.getApellidoProfesor()));
                        doc.add(new Paragraph("Horario: " + c.getHorario()));
                        doc.add(new Paragraph("Nota: " + c.getNota()));
                        ImageData data = ImageDataFactory.create("C:/images/" + c.getNombre());
                        Image img = new Image(data);
                        doc.add(img);
                        doc.add(new Paragraph(""));

                        
                    }
                   
                    response.setContentType("application/pdf");
                    response.addHeader("Content-disposition", "inline");
                    doc.close();
                    
                    return null;

                } catch (Exception ex) {
                    return "/ListaCursosShow";
                }
            }
        } catch (Exception e) {
            
            return "/ListaCursosShow";
        }
        return "/ListaCursosShow";

    }

}
