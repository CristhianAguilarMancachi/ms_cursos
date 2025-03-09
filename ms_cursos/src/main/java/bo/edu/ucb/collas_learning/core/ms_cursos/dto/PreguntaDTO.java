package bo.edu.ucb.collas_learning.core.ms_cursos.dto;

public class PreguntaDTO {
    private int codPregunta;
    private String pregunta;
    private int puntuacion;
    private int evaluacionCodEvaluacion;

    // Constructor
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
}