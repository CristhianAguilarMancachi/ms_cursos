package bo.edu.ucb.collas_learning.core.ms_cursos.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public class CursoDTO {

    private int id;

    @NotNull(message = "El nombre del curso no puede ser nulo.")
    @NotEmpty(message = "El nombre del curso no puede estar vacío.")
    private String nombre;

    @NotNull(message = "La descripción del curso no puede ser nula.")
    @NotEmpty(message = "La descripción del curso no puede estar vacía.")
    private String descripcion;

    // Constructor sin parámetros
    public CursoDTO() {}

    // Constructor con parámetros
    public CursoDTO(int id, String nombre, String descripcion) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    // Getter y setter para id
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    // Getter y setter para nombre
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    // Getter y setter para descripcion
    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return "CursoDto{" +
                "id=" + id +
                ", nombre='" + nombre + "'" +
                ", descripcion='" + descripcion + "'" +
                '}';
    }
}