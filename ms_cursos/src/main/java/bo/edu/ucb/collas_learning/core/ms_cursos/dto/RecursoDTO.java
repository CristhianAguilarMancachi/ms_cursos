package bo.edu.ucb.collas_learning.core.ms_cursos.dto;

import jakarta.validation.constraints.NotBlank;
import java.io.Serializable;

public class RecursoDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    // El ID generalmente es generado, por lo que no se valida
    private int codRecurso;

    @NotBlank(message = "El recurso no puede estar vacío.")
    private String recurso;

    // Constructor sin parámetros
    public RecursoDTO() {
    }

    // Constructor con parámetros
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

    @Override
    public String toString() {
        return "RecursoDTO{" +
                "codRecurso=" + codRecurso +
                ", recurso='" + recurso + '\'' +
                '}';
    }
}
