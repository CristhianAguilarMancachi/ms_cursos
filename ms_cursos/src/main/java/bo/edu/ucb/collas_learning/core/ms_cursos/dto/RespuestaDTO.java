package bo.edu.ucb.collas_learning.core.ms_cursos.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import java.io.Serializable;

public class RespuestaDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private int codRespuesta;

    @NotBlank(message = "La respuesta no puede estar vacía.")
    private String respuesta;

    private boolean esCorrecta;

    @Min(value = 1, message = "El código de la pregunta debe ser mayor que 0.")
    private int preguntaCodPregunta;

    // Constructor sin parámetros
    public RespuestaDTO() {
    }

    // Constructor con parámetros
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

    @Override
    public String toString() {
        return "RespuestaDTO{" +
                "codRespuesta=" + codRespuesta +
                ", respuesta='" + respuesta + '\'' +
                ", esCorrecta=" + esCorrecta +
                ", preguntaCodPregunta=" + preguntaCodPregunta +
                '}';
    }
}
