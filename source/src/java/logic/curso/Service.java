package logic.curso;

import java.util.ArrayList;
import java.util.List;

public class Service {

    List<Curso> cursos;

    public Service() {
        cursos = new ArrayList<Curso>();
    }

    public void cursosAdd(Curso curso) {
        cursos.add(curso);
    }

    public List<Curso> cursosList() {
        return cursos;
    }

}
