package bo.edu.ucb.collas_learning.core.ms_cursos.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import java.io.Serializable;

public class EvaluacionDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    // El ID normalmente es generado, por lo que puede quedar sin validación
    private int codEvaluacion;

    @NotBlank(message = "La descripción de la evaluación no puede estar vacía.")
    private String descripcionEvaluacion;

    @Min(value = 1, message = "El número de intentos debe ser al menos 1.")
    private int numeroIntentosEvaluacion;

    @Min(value = 1, message = "El código de curso debe ser mayor que 0.")
    private int codCurso;

    @Min(value = 0, message = "La nota de aprobación no puede ser negativa.")
    private int notaAprobacion;

    // Constructor con parámetros
    public EvaluacionDTO(int codEvaluacion, String descripcionEvaluacion, int numeroIntentosEvaluacion, int codCurso, int notaAprobacion) {
        this.codEvaluacion = codEvaluacion;
        this.descripcionEvaluacion = descripcionEvaluacion;
        this.numeroIntentosEvaluacion = numeroIntentosEvaluacion;
        this.codCurso = codCurso;
        this.notaAprobacion = notaAprobacion;
    }

    // Constructor sin parámetros
    public EvaluacionDTO() {
    }

    // Getters y Setters
    public int getCodEvaluacion() {
        return codEvaluacion;
    }

    public void setCodEvaluacion(int codEvaluacion) {
        this.codEvaluacion = codEvaluacion;
    }

    public String getDescripcionEvaluacion() {
        return descripcionEvaluacion;
    }

    public void setDescripcionEvaluacion(String descripcionEvaluacion) {
        this.descripcionEvaluacion = descripcionEvaluacion;
    }

    public int getNumeroIntentosEvaluacion() {
        return numeroIntentosEvaluacion;
    }

    public void setNumeroIntentosEvaluacion(int numeroIntentosEvaluacion) {
        this.numeroIntentosEvaluacion = numeroIntentosEvaluacion;
    }

    public int getCodCurso() {
        return codCurso;
    }

    public void setCodCurso(int codCurso) {
        this.codCurso = codCurso;
    }

    public int getNotaAprobacion() {
        return notaAprobacion;
    }

    public void setNotaAprobacion(int notaAprobacion) {
        this.notaAprobacion = notaAprobacion;
    }

    @Override
    public String toString() {
        return "EvaluacionDTO{" +
                "codEvaluacion=" + codEvaluacion +
                ", descripcionEvaluacion='" + descripcionEvaluacion + '\'' +
                ", numeroIntentosEvaluacion=" + numeroIntentosEvaluacion +
                ", codCurso=" + codCurso +
                ", notaAprobacion=" + notaAprobacion +
                '}';
    }
}
