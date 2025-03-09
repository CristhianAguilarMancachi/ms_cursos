package bo.edu.ucb.collas_learning.core.ms_cursos.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.io.Serializable;
import java.sql.Timestamp;

public class CertificacionDTO implements Serializable {

    private int codCertificacion;

    @NotNull(message = "La fecha de certificación no puede ser nula.")
    private Timestamp fechaCertificacion;

    @NotBlank(message = "La URL del certificado no puede estar vacía.")
    private String urlCertificado;

    @Min(value = 1, message = "El código de usuario debe ser mayor que 0.")
    private int codUsuario;

    @Min(value = 1, message = "El código de curso debe ser mayor que 0.")
    private int codCurso;

    // Constructor por defecto
    public CertificacionDTO() {
    }

    // Constructor con todos los parámetros
    public CertificacionDTO(int codCertificacion, Timestamp fechaCertificacion, String urlCertificado, int codUsuario, int codCurso) {
        this.codCertificacion = codCertificacion;
        this.fechaCertificacion = fechaCertificacion;
        this.urlCertificado = urlCertificado;
        this.codUsuario = codUsuario;
        this.codCurso = codCurso;
    }

    public int getCodCertificacion() {
        return codCertificacion;
    }

    public void setCodCertificacion(int codCertificacion) {
        this.codCertificacion = codCertificacion;
    }

    public Timestamp getFechaCertificacion() {
        return fechaCertificacion;
    }

    public void setFechaCertificacion(Timestamp fechaCertificacion) {
        this.fechaCertificacion = fechaCertificacion;
    }

    public String getUrlCertificado() {
        return urlCertificado;
    }

    public void setUrlCertificado(String urlCertificado) {
        this.urlCertificado = urlCertificado;
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
        return "CertificacionDTO{" +
                "codCertificacion=" + codCertificacion +
                ", fechaCertificacion=" + fechaCertificacion +
                ", urlCertificado='" + urlCertificado + '\'' +
                ", codUsuario=" + codUsuario +
                ", codCurso=" + codCurso +
                '}';
    }
}
