package bo.edu.ucb.collas_learning.core.ms_cursos.dto;

public class EvaluacionDTO {
    private int codEvaluacion;
    private String descripcionEvaluacion;
    private int numeroIntentosEvaluacion;
    private int codCurso;
    private int notaAprobacion;

    public EvaluacionDTO(int codEvaluacion, String descripcionEvaluacion, int numeroIntentosEvaluacion, int codCurso, int notaAprobacion) {
        this.codEvaluacion = codEvaluacion;
        this.descripcionEvaluacion = descripcionEvaluacion;
        this.numeroIntentosEvaluacion = numeroIntentosEvaluacion;
        this.codCurso = codCurso;
        this.notaAprobacion = notaAprobacion;
    }

    public int getCodEvaluacion() {
        return codEvaluacion;
    }

    public void setCodEvaluacion(int codEvaluacion) {
        this.codEvaluacion = codEvaluacion;
    }

    public String getDescripcionEvaluacion() {
        return descripcionEvaluacion;
    }

    public void setDescripcionEvaluacion(String descripcionEvaluacion) {
        this.descripcionEvaluacion = descripcionEvaluacion;
    }

    public int getNumeroIntentosEvaluacion() {
        return numeroIntentosEvaluacion;
    }

    public void setNumeroIntentosEvaluacion(int numeroIntentosEvaluacion) {
        this.numeroIntentosEvaluacion = numeroIntentosEvaluacion;
    }

    public int getCodCurso() {
        return codCurso;
    }

    public void setCodCurso(int codCurso) {
        this.codCurso = codCurso;
    }

    public int getNotaAprobacion() {
        return notaAprobacion;
    }

    public void setNotaAprobacion(int notaAprobacion) {
        this.notaAprobacion = notaAprobacion;
    }
}