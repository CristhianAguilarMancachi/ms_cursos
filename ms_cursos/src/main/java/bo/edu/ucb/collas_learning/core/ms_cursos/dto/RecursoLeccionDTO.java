package bo.edu.ucb.collas_learning.core.ms_cursos.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import java.io.Serializable;

public class RecursoLeccionDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    // El ID de RecursoLeccion normalmente es generado, pero se puede validar si es requerido
    @Min(value = 1, message = "El código de recurso lección debe ser mayor que 0.")
    private int codRecursoLeccion;

    @NotBlank(message = "El tipo de recurso no puede estar vacío.")
    private String tipoRecurso;

    @Min(value = 1, message = "El código de recurso debe ser mayor que 0.")
    private int codRecurso;

    @Min(value = 1, message = "El código de lección debe ser mayor que 0.")
    private int codLeccion;

    // Constructor sin parámetros
    public RecursoLeccionDTO() {
    }

    // Constructor con parámetros
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
        return "RecursoLeccionDTO{" +
                "codRecursoLeccion=" + codRecursoLeccion +
                ", tipoRecurso='" + tipoRecurso + '\'' +
                ", codRecurso=" + codRecurso +
                ", codLeccion=" + codLeccion +
                '}';
    }
}
