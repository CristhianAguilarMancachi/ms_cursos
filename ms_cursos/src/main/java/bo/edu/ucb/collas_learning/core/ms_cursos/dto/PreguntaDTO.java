package bo.edu.ucb.collas_learning.core.ms_cursos.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import java.io.Serializable;

public class PreguntaDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private int codPregunta;

    @NotBlank(message = "La pregunta no puede estar vacía.")
    private String pregunta;

    @Min(value = 0, message = "La puntuación debe ser al menos 0.")
    private int puntuacion;

    @Min(value = 1, message = "El código de evaluación debe ser mayor que 0.")
    private int evaluacionCodEvaluacion;

    // Constructor sin parámetros
    public PreguntaDTO() {
    }

    // Constructor con parámetros
    public PreguntaDTO(int codPregunta, String pregunta, int puntuacion, int evaluacionCodEvaluacion) {
        this.codPregunta = codPregunta;
        this.pregunta = pregunta;
        this.puntuacion = puntuacion;
        this.evaluacionCodEvaluacion = evaluacionCodEvaluacion;
    }

    // Getters and Setters
    public int getCodPregunta() {
        return codPregunta;
    }

    public void setCodPregunta(int codPregunta) {
        this.codPregunta = codPregunta;
    }

    public String getPregunta() {
        return pregunta;
    }

    public void setPregunta(String pregunta) {
        this.pregunta = pregunta;
    }

    public int getPuntuacion() {
        return puntuacion;
    }

    public void setPuntuacion(int puntuacion) {
        this.puntuacion = puntuacion;
    }

    public int getEvaluacionCodEvaluacion() {
        return evaluacionCodEvaluacion;
    }

    public void setEvaluacionCodEvaluacion(int evaluacionCodEvaluacion) {
        this.evaluacionCodEvaluacion = evaluacionCodEvaluacion;
    }

    @Override
    public String toString() {
        return "PreguntaDTO{" +
                "codPregunta=" + codPregunta +
                ", pregunta='" + pregunta + '\'' +
                ", puntuacion=" + puntuacion +
                ", evaluacionCodEvaluacion=" + evaluacionCodEvaluacion +
                '}';
    }
}
