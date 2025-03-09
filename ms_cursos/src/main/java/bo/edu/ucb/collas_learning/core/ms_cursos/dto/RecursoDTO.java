package bo.edu.ucb.collas_learning.core.ms_cursos.dto;

public class RecursoDTO {
    private int codRecurso;
    private String recurso;

    // Constructor
    public RecursoDTO(int codRecurso, String recurso) {
        this.codRecurso = codRecurso;
        this.recurso = recurso;
    }

    // Getters and Setters
    public int getCodRecurso() {
        return codRecurso;
    }

    public void setCodRecurso(int codRecurso) {
        this.codRecurso = codRecurso;
    }

    public String getRecurso() {
        return recurso;
    }

    public void setRecurso(String recurso) {
        this.recurso = recurso;
    }
}