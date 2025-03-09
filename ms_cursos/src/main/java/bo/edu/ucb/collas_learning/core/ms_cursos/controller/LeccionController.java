package bo.edu.ucb.collas_learning.core.ms_cursos.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import bo.edu.ucb.collas_learning.core.ms_cursos.dto.LeccionDTO;
import bo.edu.ucb.collas_learning.core.ms_cursos.exception.InvalidInputException;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

import jakarta.validation.Valid;

@RestController
@RequestMapping(value = "/v1/leccion")
@Tag(name = "leccion", description = "REST API para leccion")
public class LeccionController {

    private static final Logger LOGGER = LoggerFactory.getLogger(LeccionController.class);

    // Constructor vacío, no es necesario el uso de un service en este caso, se está gestionando directamente aquí
    public LeccionController() {
    }

    @Operation(summary = "Obtener todas las leccion de un curso", description = "Recupera todas las leccion asociadas a un curso dado su ID.")
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "leccion encontradas correctamente."),
        @ApiResponse(responseCode = "400", description = "ID de curso inválido."),
        @ApiResponse(responseCode = "404", description = "No se encontraron leccion.") })
    @GetMapping(value = "/curso/{idCurso}", produces = "application/json")
    public List<LeccionDTO> getleccionByCursoId(@Parameter(description = "ID del curso al cual pertenecen las leccion", required = true) 
                                                    @PathVariable int idCurso) {
        LOGGER.info("Obteniendo leccion para el curso con ID: {}", idCurso);

        if (idCurso < 1) {
            throw new InvalidInputException("ID de curso inválido: " + idCurso);
        }

        // Ejemplo de respuesta estática. Este sería el lugar para realizar la consulta en base de datos.
        return List.of(
                new LeccionDTO(1, "Lección 1", "Descripción de lección 1", idCurso),
                new LeccionDTO(2, "Lección 2", "Descripción de lección 2", idCurso)
        );
    }

    @Operation(summary = "Obtener una lección específica", description = "Recupera una lección específica por su ID.")
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "Lección encontrada correctamente."),
        @ApiResponse(responseCode = "400", description = "ID de lección inválido."),
        @ApiResponse(responseCode = "404", description = "No se encontró lección con el ID especificado.") })
    @GetMapping(value = "/{id}", produces = "application/json")
    public LeccionDTO getLeccion(@Parameter(description = "ID de la lección a obtener", required = true) 
                                  @PathVariable int id) {
        LOGGER.info("Obteniendo lección con ID: {}", id);

        if (id < 1) {
            throw new InvalidInputException("ID de lección inválido: " + id);
        }

        // Respuesta estática para la lección. En producción aquí se realizaría una búsqueda real.
        return new LeccionDTO(id, "Lección " + id, "Descripción de lección " + id, 1);
    }

    @Operation(summary = "Crear una nueva lección", description = "Registra una nueva lección.")
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "Lección creada correctamente."),
        @ApiResponse(responseCode = "400", description = "Error en la creación de la lección.") })
    @PostMapping(consumes = "application/json", produces = "application/json")
    public LeccionDTO createLeccion(@io.swagger.v3.oas.annotations.parameters.RequestBody(description = "Datos de la lección a crear", 
                                                                                        required = true) 
                                    @RequestBody LeccionDTO body) {
        LOGGER.debug("createLeccion: body lección: {}", body);

        // En este punto se realizaría la lógica para guardar la lección en la base de datos.
        return body;
    }



    @Operation(summary = "Editar una lección", description = "Actualiza los datos de una lección existente.")
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "Lección actualizada correctamente."),
        @ApiResponse(responseCode = "400", description = "ID de lección inválido."),
        @ApiResponse(responseCode = "404", description = "No se encontró lección con el ID especificado.") })
    @PutMapping(value = "/{id}", consumes = "application/json", produces = "application/json")
    public LeccionDTO editLeccion(@Parameter(description = "ID de la lección a editar", required = true) 
                                  @PathVariable int id,
                                  @Valid @RequestBody LeccionDTO body) {
        LOGGER.debug("editLeccion: editando lección con ID: {}", id);

        if (id < 1) {
            throw new InvalidInputException("ID de lección inválido: " + id);
        }

        // Aquí realizaríamos la lógica de actualización de la lección.
        return new LeccionDTO(id, body.getNombre(), body.getDescripcion(), body.getCursoId());
    }

    @Operation(summary = "Eliminar una lección", description = "Elimina una lección por su ID.")
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "Lección eliminada correctamente."),
        @ApiResponse(responseCode = "400", description = "ID de lección inválido."),
        @ApiResponse(responseCode = "404", description = "No se encontró lección con el ID especificado.") })
    @DeleteMapping(value = "/{id}")
    public void deleteLeccion(@Parameter(description = "ID de la lección a eliminar", required = true) 
                              @PathVariable int id) {
        LOGGER.debug("deleteLeccion: eliminando lección con ID: {}", id);

        if (id < 1) {
            throw new InvalidInputException("ID de lección inválido: " + id);
        }

        // Aquí se eliminaría la lección o se marcaría como eliminada (borrado lógico).
        LOGGER.info("Lección con ID: {} eliminada", id);
    }
}