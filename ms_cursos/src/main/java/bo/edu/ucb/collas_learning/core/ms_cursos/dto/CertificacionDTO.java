package bo.edu.ucb.collas_learning.core.ms_cursos.dto;

import java.security.Timestamp;

public class CertificacionDTO {
    private int codCertificacion;
    private Timestamp fechaCertificacion;
    private String urlCertificado;
    private int codUsuario;
    private int codCurso;

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
}