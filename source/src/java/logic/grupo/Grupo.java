package logic.grupo;


public class Grupo {

    int codigo;
    int Curso_codigo;
    int profesor_idProfesor;
    String fecha;

    public Grupo() {
    }

    public Grupo(int codigo, int Curso_codigo, int profesor_idPreofesor, String fecha) {
        this.codigo = codigo;
        this.Curso_codigo = Curso_codigo;
        this.profesor_idProfesor = profesor_idPreofesor;
        this.fecha = fecha;
    }

    public Grupo(int codigo, int Curso_codigo) {
        this.codigo = codigo;
        this.Curso_codigo = Curso_codigo;
    }

    public Grupo(int codigo, int Curso_codigo,String fecha) {
        this.codigo = codigo;
        this.Curso_codigo = Curso_codigo;
        this.fecha = fecha;
    }

    public int getCodigo() {
        return codigo;
    }

    public int getCurso_codigo() {
        return Curso_codigo;
    }

    public int getProfesor_idProfesor() {
        return profesor_idProfesor;
    }

    public String getFecha() {
        return fecha;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public void setCurso_codigo(int Curso_codigo) {
        this.Curso_codigo = Curso_codigo;
    }

    public void setProfesor_idProfesor(int profesor_idProfesor) {
        this.profesor_idProfesor = profesor_idProfesor;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

}
