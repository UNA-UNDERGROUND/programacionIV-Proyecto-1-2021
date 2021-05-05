package logic.usuario.profesor;

import java.util.ArrayList;
import java.util.List;

public class Service {

    List<Profesor> profesores;

    public Service() {
        profesores = new ArrayList<Profesor>();
    }

    public void profesoresAdd(Profesor curso) {
        profesores.add(curso);
    }

    public List<Profesor> profesoresList() {
        return profesores;
    }

}
