package bo.edu.ucb.collas_learning.core.ms_cursos.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class LeccionDTO {

    private int id;

    @NotBlank(message = "El nombre de la lección no puede estar vacío.")
    private String nombre;

    @NotBlank(message = "La descripción de la lección no puede estar vacía.")
    private String descripcion;

    @NotNull(message = "El ID del curso asociado es obligatorio.")
    private Integer cursoId;

    public LeccionDTO() {
    }

    public LeccionDTO(int id, String nombre, String descripcion, Integer cursoId) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.cursoId = cursoId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Integer getCursoId() {
        return cursoId;
    }

    public void setCursoId(Integer cursoId) {
        this.cursoId = cursoId;
    }

    @Override
    public String toString() {
        return "LeccionDto{" +
                "id=" + id +
                ", nombre='" + nombre + "'" +
                ", descripcion='" + descripcion + "'" +
                ", cursoId=" + cursoId +
                '}';
    }
}