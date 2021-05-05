package logic.grupo;

import java.util.ArrayList;
import java.util.List;

public class Service {

    List<Grupo> grupos;

    public Service() {
        grupos = new ArrayList<Grupo>();
    }

    public void gruposAdd(Grupo grupo) {
        grupos.add(grupo);
    }

    public List<Grupo> gruposList() {
        return grupos;
    }

}
