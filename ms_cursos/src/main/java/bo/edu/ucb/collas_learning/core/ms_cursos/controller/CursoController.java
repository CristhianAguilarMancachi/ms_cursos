package bo.edu.ucb.collas_learning.core.ms_cursos.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import bo.edu.ucb.collas_learning.core.ms_cursos.dto.CursoDTO;
import bo.edu.ucb.collas_learning.core.ms_cursos.exception.InvalidInputException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/v1/cursos")
@Tag(name = "Cursos", description = "REST API para cursos")
public class CursoController {

    private static final Logger LOGGER = LoggerFactory.getLogger(CursoController.class);

    // Constructor vacío, sin necesidad de servicio
    public CursoController() {
    }

    @Operation(summary = "Obtener todos los cursos", description = "Recupera todos los cursos registrados.")
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "Cursos encontrados correctamente."),
        @ApiResponse(responseCode = "404", description = "No se encontraron cursos.") })
    @GetMapping(produces = "application/json")
    public List<CursoDTO> obtenerTodosLosCursos() {
        LOGGER.info("Obteniendo todos los cursos.");
        
        // Datos ficticios de cursos para simular la consulta
        return List.of(
                new CursoDTO(1, "Curso 1", "Descripción del curso 1"),
                new CursoDTO(2, "Curso 2", "Descripción del curso 2")
        );
    }

    @Operation(summary = "Obtener un curso específico", description = "Recupera un curso por su ID.")
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "Curso encontrado correctamente."),
        @ApiResponse(responseCode = "400", description = "ID de curso inválido."),
        @ApiResponse(responseCode = "404", description = "No se encontró curso con el ID especificado.") })
    @GetMapping(value = "/{id}", produces = "application/json")
    public CursoDTO obtenerCursoPorCodigo(@Parameter(description = "ID del curso a obtener", required = true) 
                                          @PathVariable int id) {
        LOGGER.info("Obteniendo curso con ID: {}", id);

        if (id < 1) {
            throw new InvalidInputException("ID de curso inválido: " + id);
        }

        // Respuesta estática, simulando una consulta a base de datos
        return new CursoDTO(id, "Curso " + id, "Descripción del curso " + id);
    }

    @Operation(summary = "Crear un nuevo curso", description = "Registra un nuevo curso.")
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "Curso creado correctamente."),
        @ApiResponse(responseCode = "400", description = "Error en la creación del curso.") })
    @PostMapping(consumes = "application/json", produces = "application/json")
    public CursoDTO crearCurso(@io.swagger.v3.oas.annotations.parameters.RequestBody(description = "Datos del curso a crear", 
                                                                                          required = true) 
                               @RequestBody CursoDTO body) {
        LOGGER.debug("createCurso: body curso: {}", body);

        // Aquí iría la lógica para guardar el curso en la base de datos (simulada)
        return body;
    }

    @Operation(summary = "Actualizar un curso", description = "Actualiza los datos de un curso existente.")
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "Curso actualizado correctamente."),
        @ApiResponse(responseCode = "400", description = "ID de curso inválido."),
        @ApiResponse(responseCode = "404", description = "No se encontró curso con el ID especificado.") })
    @PutMapping(value = "/{id}", consumes = "application/json", produces = "application/json")
    public CursoDTO actualizarCurso(@Parameter(description = "ID del curso a actualizar", required = true) 
                                    @PathVariable int id,
                                    @RequestBody CursoDTO body) {
        LOGGER.debug("updateCurso: actualizando curso con ID: {}", id);

        if (id < 1) {
            throw new InvalidInputException("ID de curso inválido: " + id);
        }

        // Aquí iría la lógica de actualización del curso (simulada)
        return new CursoDTO(id, body.getNombre(), body.getDescripcion());
    }

    @Operation(summary = "Eliminar un curso", description = "Elimina un curso por su ID.")
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "Curso eliminado correctamente."),
        @ApiResponse(responseCode = "400", description = "ID de curso inválido."),
        @ApiResponse(responseCode = "404", description = "No se encontró curso con el ID especificado.") })
    @DeleteMapping(value = "/{id}")
    public void eliminarCurso(@Parameter(description = "ID del curso a eliminar", required = true) 
                              @PathVariable int id) {
        LOGGER.debug("deleteCurso: eliminando curso con ID: {}", id);

        if (id < 1) {
            throw new InvalidInputException("ID de curso inválido: " + id);
        }

        // Aquí se eliminaría el curso de la base de datos o se marcaría como eliminado (simulado)
        LOGGER.info("Curso con ID: {} eliminado", id);
    }
}
