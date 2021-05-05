package logic.usuario.estudiante;

import java.util.ArrayList;
import java.util.List;

public class Service {

    List<Estudiante> estudiantes;

    public Service() {
        estudiantes = new ArrayList();
    }

    public void estudiantesAdd(Estudiante curso) {
        estudiantes.add(curso);
    }

    public List<Estudiante> estudiantesList() {
        return estudiantes;
    }

}
