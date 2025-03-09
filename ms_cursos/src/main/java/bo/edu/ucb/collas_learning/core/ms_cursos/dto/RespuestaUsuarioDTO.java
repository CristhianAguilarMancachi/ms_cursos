package bo.edu.ucb.collas_learning.core.ms_cursos.dto;

public class RespuestaUsuarioDTO {
    private int codRespuetaUsuario;
    private String respuestaTexto;
    private boolean esCorrecta;
    private int codPregunta;
    private int codEvaluacion;
    private int codRespuesta;
    private int codUsuario;

    // Constructor
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
        return "RespuestaUsuario [codRespuetaUsuario=" + codRespuetaUsuario + ", respuestaTexto=" + respuestaTexto 
                + ", esCorrecta=" + esCorrecta + ", codPregunta=" + codPregunta + ", codEvaluacion=" + codEvaluacion 
                + ", codRespuesta=" + codRespuesta + ", codUsuario=" + codUsuario + "]";
    }
}