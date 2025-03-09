package bo.edu.ucb.collas_learning.core.ms_cursos.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;

public class CursoDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    // Se mapea a cod_curso (serial)
    private int codCurso;

    // Se mapea a titulo_curso
    @NotNull(message = "El título del curso no puede ser nulo.")
    @NotEmpty(message = "El título del curso no puede estar vacío.")
    private String tituloCurso;

    // Se mapea a descripcion_curso
    @NotNull(message = "La descripción del curso no puede ser nula.")
    @NotEmpty(message = "La descripción del curso no puede estar vacía.")
    private String descripcionCurso;

    // Se mapea a etiqueta_curso
    @NotNull(message = "La etiqueta del curso no puede ser nula.")
    @NotEmpty(message = "La etiqueta del curso no puede estar vacía.")
    private String etiquetaCurso;

    // Se mapea a fecha_creacion
    @NotNull(message = "La fecha de creación no puede ser nula.")
    private Timestamp fechaCreacion;

    // Se mapea a estado_curso
    private boolean estadoCurso;

    // Se mapea a precio_curso (money) y se utiliza BigDecimal para valores monetarios
    @NotNull(message = "El precio del curso no puede ser nulo.")
    private BigDecimal precioCurso;

    // Se mapea a RECURSO_cod_recurso
    @Min(value = 1, message = "El código de recurso debe ser mayor que 0.")
    private int recursoCodRecurso;

    // Se mapea a USUARIO_cod_usuario
    @Min(value = 1, message = "El código de usuario debe ser mayor que 0.")
    private int usuarioCodUsuario;

    // Constructor por defecto
    public CursoDTO() {
    }

    // Constructor con parámetros
    public CursoDTO(int codCurso, String tituloCurso, String descripcionCurso, String etiquetaCurso,
                    Timestamp fechaCreacion, boolean estadoCurso, BigDecimal precioCurso,
                    int recursoCodRecurso, int usuarioCodUsuario) {
        this.codCurso = codCurso;
        this.tituloCurso = tituloCurso;
        this.descripcionCurso = descripcionCurso;
        this.etiquetaCurso = etiquetaCurso;
        this.fechaCreacion = fechaCreacion;
        this.estadoCurso = estadoCurso;
        this.precioCurso = precioCurso;
        this.recursoCodRecurso = recursoCodRecurso;
        this.usuarioCodUsuario = usuarioCodUsuario;
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

    public BigDecimal getPrecioCurso() {
        return precioCurso;
    }

    public void setPrecioCurso(BigDecimal precioCurso) {
        this.precioCurso = precioCurso;
    }

    public int getRecursoCodRecurso() {
        return recursoCodRecurso;
    }

    public void setRecursoCodRecurso(int recursoCodRecurso) {
        this.recursoCodRecurso = recursoCodRecurso;
    }

    public int getUsuarioCodUsuario() {
        return usuarioCodUsuario;
    }

    public void setUsuarioCodUsuario(int usuarioCodUsuario) {
        this.usuarioCodUsuario = usuarioCodUsuario;
    }

    @Override
    public String toString() {
        return "CursoDTO{" +
                "codCurso=" + codCurso +
                ", tituloCurso='" + tituloCurso + '\'' +
                ", descripcionCurso='" + descripcionCurso + '\'' +
                ", etiquetaCurso='" + etiquetaCurso + '\'' +
                ", fechaCreacion=" + fechaCreacion +
                ", estadoCurso=" + estadoCurso +
                ", precioCurso=" + precioCurso +
                ", recursoCodRecurso=" + recursoCodRecurso +
                ", usuarioCodUsuario=" + usuarioCodUsuario +
                '}';
    }
}
