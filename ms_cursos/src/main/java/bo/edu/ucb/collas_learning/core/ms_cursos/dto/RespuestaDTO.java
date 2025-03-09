package bo.edu.ucb.collas_learning.core.ms_cursos.dto;

public class RespuestaDTO {
    private int codRespuesta;
    private String respuesta;
    private boolean esCorrecta;
    private int preguntaCodPregunta;

    // Constructor
    public RespuestaDTO(int codRespuesta, String respuesta, boolean esCorrecta, int preguntaCodPregunta) {
        this.codRespuesta = codRespuesta;
        this.respuesta = respuesta;
        this.esCorrecta = esCorrecta;
        this.preguntaCodPregunta = preguntaCodPregunta;
    }

    // Getters and Setters
    public int getCodRespuesta() {
        return codRespuesta;
    }

    public void setCodRespuesta(int codRespuesta) {
        this.codRespuesta = codRespuesta;
    }

    public String getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(String respuesta) {
        this.respuesta = respuesta;
    }

    public boolean isEsCorrecta() {
        return esCorrecta;
    }

    public void setEsCorrecta(boolean esCorrecta) {
        this.esCorrecta = esCorrecta;
    }

    public int getPreguntaCodPregunta() {
        return preguntaCodPregunta;
    }

    public void setPreguntaCodPregunta(int preguntaCodPregunta) {
        this.preguntaCodPregunta = preguntaCodPregunta;
    }
}