package bo.edu.ucb.collas_learning.core.ms_cursos.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import java.io.Serializable;
import java.sql.Timestamp;

public class InscripcionDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    // El ID de inscripción normalmente es generado, por lo que no requiere validación.
    private int codInscripcion;

    @NotNull(message = "La fecha de inscripción no puede ser nula.")
    private Timestamp fechaInscripcion;

    // Campo boolean, no requiere validación adicional.
    private boolean estadoInscripcion;

    @Min(value = 1, message = "El código de usuario debe ser mayor que 0.")
    private int codUsuario;

    @Min(value = 1, message = "El código de curso debe ser mayor que 0.")
    private int codCurso;

    // Constructor por defecto
    public InscripcionDTO() {
    }

    // Constructor con parámetros
    public InscripcionDTO(int codInscripcion, Timestamp fechaInscripcion, boolean estadoInscripcion, int codUsuario, int codCurso) {
        this.codInscripcion = codInscripcion;
        this.fechaInscripcion = fechaInscripcion;
        this.estadoInscripcion = estadoInscripcion;
        this.codUsuario = codUsuario;
        this.codCurso = codCurso;
    }

    // Getters y Setters
    public int getCodInscripcion() {
        return codInscripcion;
    }

    public void setCodInscripcion(int codInscripcion) {
        this.codInscripcion = codInscripcion;
    }

    public Timestamp getFechaInscripcion() {
        return fechaInscripcion;
    }

    public void setFechaInscripcion(Timestamp fechaInscripcion) {
        this.fechaInscripcion = fechaInscripcion;
    }

    public boolean isEstadoInscripcion() {
        return estadoInscripcion;
    }

    public void setEstadoInscripcion(boolean estadoInscripcion) {
        this.estadoInscripcion = estadoInscripcion;
    }

    public int getCodUsuario() {
        return codUsuario;
    }

    public void setCodUsuario(int codUsuario) {
        this.codUsuario = codUsuario;
    }

    public int getCodCurso() {
        return codCurso;
    }

    public void setCodCurso(int codCurso) {
        this.codCurso = codCurso;
    }

    @Override
    public String toString() {
        return "InscripcionDTO{" +
                "codInscripcion=" + codInscripcion +
                ", fechaInscripcion=" + fechaInscripcion +
                ", estadoInscripcion=" + estadoInscripcion +
                ", codUsuario=" + codUsuario +
                ", codCurso=" + codCurso +
                '}';
    }
}
