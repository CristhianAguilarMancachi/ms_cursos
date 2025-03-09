package bo.edu.ucb.collas_learning.core.ms_cursos.dto;

public class RecursoLeccionDTO {
    private int codRecursoLeccion;
    private String tipoRecurso;
    private int codRecurso;
    private int codLeccion;

    // Constructor
    public RecursoLeccionDTO(int codRecursoLeccion, String tipoRecurso, int codRecurso, int codLeccion) {
        this.codRecursoLeccion = codRecursoLeccion;
        this.tipoRecurso = tipoRecurso;
        this.codRecurso = codRecurso;
        this.codLeccion = codLeccion;
    }

    // Getters y Setters
    public int getCodRecursoLeccion() {
        return codRecursoLeccion;
    }

    public void setCodRecursoLeccion(int codRecursoLeccion) {
        this.codRecursoLeccion = codRecursoLeccion;
    }

    public String getTipoRecurso() {
        return tipoRecurso;
    }

    public void setTipoRecurso(String tipoRecurso) {
        this.tipoRecurso = tipoRecurso;
    }

    public int getCodRecurso() {
        return codRecurso;
    }

    public void setCodRecurso(int codRecurso) {
        this.codRecurso = codRecurso;
    }

    public int getCodLeccion() {
        return codLeccion;
    }

    public void setCodLeccion(int codLeccion) {
        this.codLeccion = codLeccion;
    }

    @Override
    public String toString() {
        return "RecursoLeccion [codRecursoLeccion=" + codRecursoLeccion + ", tipoRecurso=" + tipoRecurso 
                + ", codRecurso=" + codRecurso + ", codLeccion=" + codLeccion + "]";
    }
}