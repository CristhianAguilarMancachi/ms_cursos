package bo.edu.ucb.collas_learning.core.ms_cursos.entity;
import java.security.Timestamp;

public class Curso {
    private int codCurso;
    private String tituloCurso;
    private String descripcionCurso;
    private String etiquetaCurso;
    private Timestamp fechaCreacion;
    private boolean estadoCurso;
    private double precioCurso;
    private int codRecurso;
    private int codUsuario;



    // Constructores
    public Curso() {
    }

    public Curso(int codCurso, String tituloCurso, String descripcionCurso, String etiquetaCurso, Timestamp fechaCreacion, boolean estadoCurso, double precioCurso, int codRecurso, int codUsuario) {
        this.codCurso = codCurso;
        this.tituloCurso = tituloCurso;
        this.descripcionCurso = descripcionCurso;
        this.etiquetaCurso = etiquetaCurso;
        this.fechaCreacion = fechaCreacion;
        this.estadoCurso = estadoCurso;
        this.precioCurso = precioCurso;
        this.codRecurso = codRecurso;
        this.codUsuario = codUsuario;
    }

    // Getters y Setters
    public int getCodCurso() {
        return codCurso;
    }

    public void setCodCurso(int codCurso) {
        this.codCurso = codCurso;
    }

    public String getTituloCurso() {
        return tituloCurso;
    }

    public void setTituloCurso(String tituloCurso) {
        this.tituloCurso = tituloCurso;
    }

    public String getDescripcionCurso() {
        return descripcionCurso;
    }

    public void setDescripcionCurso(String descripcionCurso) {
        this.descripcionCurso = descripcionCurso;
    }

    public String getEtiquetaCurso() {
        return etiquetaCurso;
    }

    public void setEtiquetaCurso(String etiquetaCurso) {
        this.etiquetaCurso = etiquetaCurso;
    }

    public Timestamp getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Timestamp fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public boolean isEstadoCurso() {
        return estadoCurso;
    }

    public void setEstadoCurso(boolean estadoCurso) {
        this.estadoCurso = estadoCurso;
    }

    public double getPrecioCurso() {
        return precioCurso;
    }

    public void setPrecioCurso(double precioCurso) {
        this.precioCurso = precioCurso;
    }

    public int getCodRecurso() {
        return codRecurso;
    }

    public void setCodRecurso(int codRecurso) {
        this.codRecurso = codRecurso;
    }

    public int getCodUsuario() {
        return codUsuario;
    }

    public void setCodUsuario(int codUsuario) {
        this.codUsuario = codUsuario;
    }
}
