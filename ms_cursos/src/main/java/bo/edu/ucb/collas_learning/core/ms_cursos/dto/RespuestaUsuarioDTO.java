package bo.edu.ucb.collas_learning.core.ms_cursos.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import java.io.Serializable;

public class RespuestaUsuarioDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    // Generalmente generado, por lo que no se valida
    private int codRespuetaUsuario;

    @NotBlank(message = "El texto de la respuesta no puede estar vacío.")
    private String respuestaTexto;

    // Campo boolean, no requiere validación adicional
    private boolean esCorrecta;

    @Min(value = 1, message = "El código de la pregunta debe ser mayor que 0.")
    private int codPregunta;

    @Min(value = 1, message = "El código de la evaluación debe ser mayor que 0.")
    private int codEvaluacion;

    @Min(value = 1, message = "El código de la respuesta debe ser mayor que 0.")
    private int codRespuesta;

    @Min(value = 1, message = "El código de usuario debe ser mayor que 0.")
    private int codUsuario;

    // Constructor sin parámetros
    public RespuestaUsuarioDTO() {
    }

    // Constructor con parámetros
    public RespuestaUsuarioDTO(int codRespuetaUsuario, String respuestaTexto, boolean esCorrecta, 
                                int codPregunta, int codEvaluacion, int codRespuesta, int codUsuario) {
        this.codRespuetaUsuario = codRespuetaUsuario;
        this.respuestaTexto = respuestaTexto;
        this.esCorrecta = esCorrecta;
        this.codPregunta = codPregunta;
        this.codEvaluacion = codEvaluacion;
        this.codRespuesta = codRespuesta;
        this.codUsuario = codUsuario;
    }

    // Getters y Setters
    public int getCodRespuetaUsuario() {
        return codRespuetaUsuario;
    }

    public void setCodRespuetaUsuario(int codRespuetaUsuario) {
        this.codRespuetaUsuario = codRespuetaUsuario;
    }

    public String getRespuestaTexto() {
        return respuestaTexto;
    }

    public void setRespuestaTexto(String respuestaTexto) {
        this.respuestaTexto = respuestaTexto;
    }

    public boolean isEsCorrecta() {
        return esCorrecta;
    }

    public void setEsCorrecta(boolean esCorrecta) {
        this.esCorrecta = esCorrecta;
    }

    public int getCodPregunta() {
        return codPregunta;
    }

    public void setCodPregunta(int codPregunta) {
        this.codPregunta = codPregunta;
    }

    public int getCodEvaluacion() {
        return codEvaluacion;
    }

    public void setCodEvaluacion(int codEvaluacion) {
        this.codEvaluacion = codEvaluacion;
    }

    public int getCodRespuesta() {
        return codRespuesta;
    }

    public void setCodRespuesta(int codRespuesta) {
        this.codRespuesta = codRespuesta;
    }

    public int getCodUsuario() {
        return codUsuario;
    }

    public void setCodUsuario(int codUsuario) {
        this.codUsuario = codUsuario;
    }

    @Override
    public String toString() {
        return "RespuestaUsuarioDTO{" +
                "codRespuetaUsuario=" + codRespuetaUsuario +
                ", respuestaTexto='" + respuestaTexto + '\'' +
                ", esCorrecta=" + esCorrecta +
                ", codPregunta=" + codPregunta +
                ", codEvaluacion=" + codEvaluacion +
                ", codRespuesta=" + codRespuesta +
                ", codUsuario=" + codUsuario +
                '}';
    }
}
