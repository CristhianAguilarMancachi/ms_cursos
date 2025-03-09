package bo.edu.ucb.collas_learning.core.ms_cursos.controller;

import bo.edu.ucb.collas_learning.core.ms_cursos.dto.CursoDTO;
import bo.edu.ucb.collas_learning.core.ms_cursos.exception.InvalidInputException;
import bo.edu.ucb.collas_learning.core.ms_cursos.exception.NotFoundException;
import bo.edu.ucb.collas_learning.core.ms_cursos.service.ServiceUtil;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/cursos")
@Tag(name = "Curso", description = "REST API para cursos")
public class CursoController {

    private static final Logger LOGGER = LoggerFactory.getLogger(CursoController.class);
    private final ServiceUtil serviceUtil;

    @Autowired
    public CursoController(ServiceUtil serviceUtil) {
        this.serviceUtil = serviceUtil;
    }

    @Operation(summary = "Obtener todos los cursos", description = "Retorna una lista de cursos")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Cursos obtenidos correctamente",
                content = @Content(mediaType = "application/json", schema = @Schema(implementation = CursoDTO.class)))
    })
    @GetMapping(produces = "application/json")
    public List<CursoDTO> getAllCursos() {
        LOGGER.info("Obteniendo todos los cursos");

        // Simulación: se retornan dos cursos dummy
        List<CursoDTO> cursos = new ArrayList<>();
        cursos.add(new CursoDTO(1, "Curso Java", "Aprende Java desde cero"));
        cursos.add(new CursoDTO(2, "Curso Spring Boot", "Desarrollo de APIs REST con Spring Boot"));
        return cursos;
    }

    @Operation(summary = "Obtener un curso por ID", description = "Retorna el curso identificado por el ID")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Curso obtenido correctamente",
                content = @Content(mediaType = "application/json", schema = @Schema(implementation = CursoDTO.class))),
        @ApiResponse(responseCode = "400", description = "ID de curso inválido"),
        @ApiResponse(responseCode = "404", description = "Curso no encontrado")
    })
    @GetMapping(value = "/{id}", produces = "application/json")
    public CursoDTO getCursoById(
            @Parameter(description = "ID del curso a obtener", required = true)
            @PathVariable int id) {
        LOGGER.info("Obteniendo curso con id: {}", id);
        if (id < 1) {
            throw new InvalidInputException("ID de curso inválido: " + id);
        }
        // Simulación: si el ID es 999 se simula que no se encontró el curso
        if (id == 999) {
            throw new NotFoundException("No se encontró curso con id: " + id);
        }
        // Retornamos un curso dummy
        return new CursoDTO(id, "Curso Dummy " + id, "Descripción del curso dummy " + id);
    }

    @Operation(summary = "Crear un nuevo curso", description = "Crea y retorna el curso creado")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Curso creado correctamente",
                content = @Content(mediaType = "application/json", schema = @Schema(implementation = CursoDTO.class))),
        @ApiResponse(responseCode = "400", description = "Datos inválidos para el curso")
    })
    @PostMapping(consumes = "application/json", produces = "application/json")
    public CursoDTO createCurso(
            @io.swagger.v3.oas.annotations.parameters.RequestBody(
                description = "Datos del curso a crear",
                required = true,
                content = @Content(mediaType = "application/json", schema = @Schema(implementation = CursoDTO.class)))
            @Valid @RequestBody CursoDTO curso) {
        LOGGER.debug("Creando curso: {}", curso);
        // Simulación: se asigna un ID dummy (por ejemplo, 100) al curso creado.
        curso.setId(100);
        return curso;
    }

    @Operation(summary = "Actualizar un curso", description = "Actualiza y retorna el curso actualizado")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Curso actualizado correctamente",
                content = @Content(mediaType = "application/json", schema = @Schema(implementation = CursoDTO.class))),
        @ApiResponse(responseCode = "400", description = "Datos inválidos para la actualización"),
        @ApiResponse(responseCode = "404", description = "Curso no encontrado")
    })
    @PutMapping(value = "/{id}", consumes = "application/json", produces = "application/json")
    public CursoDTO updateCurso(
            @Parameter(description = "ID del curso a actualizar", required = true)
            @PathVariable int id,
            @io.swagger.v3.oas.annotations.parameters.RequestBody(
                description = "Datos del curso a actualizar",
                required = true,
                content = @Content(mediaType = "application/json", schema = @Schema(implementation = CursoDTO.class)))
            @Valid @RequestBody CursoDTO curso) {
        LOGGER.debug("Actualizando curso con id: {}", id);
        if (id < 1) {
            throw new InvalidInputException("ID de curso inválido: " + id);
        }
        // Simulación: si el ID es 999 se simula que no se encontró el curso
        if (id == 999) {
            throw new NotFoundException("No se encontró curso con id: " + id);
        }
        // Asignar el ID recibido al objeto curso y retornarlo simulando la actualización
        curso.setId(id);
        return curso;
    }

    @Operation(summary = "Eliminar un curso", description = "Elimina el curso con el ID especificado")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Curso eliminado correctamente"),
        @ApiResponse(responseCode = "400", description = "ID de curso inválido"),
        @ApiResponse(responseCode = "404", description = "Curso no encontrado")
    })
    @DeleteMapping("/{id}")
    public void deleteCurso(
            @Parameter(description = "ID del curso a eliminar", required = true)
            @PathVariable int id) {
        LOGGER.debug("Eliminando curso con id: {}", id);
        if (id < 1) {
            throw new InvalidInputException("ID de curso inválido: " + id);
        }
        // Simulación: si el ID es 999 se simula que no se encontró el curso
        if (id == 999) {
            throw new NotFoundException("No se encontró curso con id: " + id);
        }
        // En una implementación real se invocaría el servicio para eliminar el curso.
    }
}