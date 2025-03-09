package bo.edu.ucb.collas_learning.core.ms_cursos.dto;

import java.security.Timestamp;

public class InscripcionDTO {
    private int codInscripcion;
    private Timestamp fechaInscripcion;
    private boolean estadoInscripcion;
    private int codUsuario;
    private int codCurso;

    public InscripcionDTO(int codInscripcion, Timestamp fechaInscripcion, boolean estadoInscripcion, int codUsuario, int codCurso) {
        this.codInscripcion = codInscripcion;
        this.fechaInscripcion = fechaInscripcion;
        this.estadoInscripcion = estadoInscripcion;
        this.codUsuario = codUsuario;
        this.codCurso = codCurso;
    }

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
}