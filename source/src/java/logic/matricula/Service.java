package logic.matricula;

import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

public class Service {

    List<Matricula> matriculas;

    public Service() {
        matriculas = new ArrayList<Matricula>();
    }

    public void matriculaAdd(Matricula matricula) {
        matriculas.add(matricula);
    }

    public List<Matricula> matriculasList() {
        return matriculas;
    }

    public void matricular(HttpServletRequest request) throws Exception {
        logic.matricula.MatriculaDAO.obtenerInstancia().matricular(request);
    }

}
