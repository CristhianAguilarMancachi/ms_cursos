package bo.edu.ucb.collas_learning.core.ms_cursos.controller;

import bo.edu.ucb.collas_learning.core.ms_cursos.dto.LeccionDTO;
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
@RequestMapping("/lecciones")
@Tag(name = "Lección", description = "REST API para lecciones")
public class LeccionController {

    private static final Logger LOGGER = LoggerFactory.getLogger(LeccionController.class);
    private final ServiceUtil serviceUtil;

    @Autowired
    public LeccionController(ServiceUtil serviceUtil) {
        this.serviceUtil = serviceUtil;
    }

    @Operation(summary = "Obtener todas las lecciones de un curso", 
               description = "Retorna una lista de lecciones asociadas a un curso")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Lecciones obtenidas correctamente",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = LeccionDTO.class))),
            @ApiResponse(responseCode = "400", description = "ID de curso inválido"),
            @ApiResponse(responseCode = "404", description = "No se encontraron lecciones para el curso")
    })
    @GetMapping("/curso/{cursoId}")
    public List<LeccionDTO> getLeccionesByCurso(
            @Parameter(description = "ID del curso", required = true)
            @PathVariable int cursoId) {
        LOGGER.info("Obteniendo lecciones para el curso con id: {}", cursoId);
        if (cursoId < 1) {
            throw new InvalidInputException("ID de curso inválido: " + cursoId);
        }
        // Simulación: si cursoId es 999, se simula que no hay lecciones
        if (cursoId == 999) {
            throw new NotFoundException("No se encontraron lecciones para el curso con id: " + cursoId);
        }
        List<LeccionDTO> lecciones = new ArrayList<>();
        lecciones.add(new LeccionDTO(1, "Introducción", "Conceptos básicos de la lección", cursoId));
        lecciones.add(new LeccionDTO(2, "Desarrollo", "Contenido en profundidad de la lección", cursoId));
        return lecciones;
    }

    @Operation(summary = "Obtener una lección específica", 
               description = "Retorna la lección identificada por su ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Lección obtenida correctamente",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = LeccionDTO.class))),
            @ApiResponse(responseCode = "400", description = "ID de lección inválido"),
            @ApiResponse(responseCode = "404", description = "Lección no encontrada")
    })
    @GetMapping("/{id}")
    public LeccionDTO getLeccionById(
            @Parameter(description = "ID de la lección a obtener", required = true)
            @PathVariable int id) {
        LOGGER.info("Obteniendo lección con id: {}", id);
        if (id < 1) {
            throw new InvalidInputException("ID de lección inválido: " + id);
        }
        // Simulación: si id es 999 se simula que la lección no existe
        if (id == 999) {
            throw new NotFoundException("No se encontró lección con id: " + id);
        }
        return new LeccionDTO(id, "Lección Dummy " + id, "Descripción dummy de la lección " + id, 101);
    }

    @Operation(summary = "Crear una nueva lección", 
               description = "Crea y retorna la lección creada")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Lección creada correctamente",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = LeccionDTO.class))),
            @ApiResponse(responseCode = "400", description = "Datos inválidos para la lección")
    })
    @PostMapping(consumes = "application/json", produces = "application/json")
    public LeccionDTO createLeccion(
            @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    description = "Datos de la lección a crear",
                    required = true,
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = LeccionDTO.class)))
            @Valid @RequestBody LeccionDTO leccion) {
        LOGGER.debug("Creando lección: {}", leccion);
        // Simulación: asignar un ID dummy (por ejemplo, 100) a la lección creada.
        leccion.setId(100);
        return leccion;
    }

    @Operation(summary = "Actualizar una lección", 
               description = "Actualiza y retorna la lección editada")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Lección actualizada correctamente",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = LeccionDTO.class))),
            @ApiResponse(responseCode = "400", description = "Datos inválidos para la actualización"),
            @ApiResponse(responseCode = "404", description = "Lección no encontrada")
    })
    @PutMapping(value = "/{id}", consumes = "application/json", produces = "application/json")
    public LeccionDTO updateLeccion(
            @Parameter(description = "ID de la lección a actualizar", required = true)
            @PathVariable int id,
            @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    description = "Datos de la lección a actualizar",
                    required = true,
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = LeccionDTO.class)))
            @Valid @RequestBody LeccionDTO leccion) {
        LOGGER.debug("Actualizando lección con id: {}", id);
        if (id < 1) {
            throw new InvalidInputException("ID de lección inválido: " + id);
        }
        if (id == 999) {
            throw new NotFoundException("No se encontró lección con id: " + id);
        }
        // Simulación: asignar el ID recibido al objeto y retornar la lección actualizada.
        leccion.setId(id);
        return leccion;
    }

    @Operation(summary = "Eliminar una lección", 
               description = "Elimina la lección con el ID especificado")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Lección eliminada correctamente"),
            @ApiResponse(responseCode = "400", description = "ID de lección inválido"),
            @ApiResponse(responseCode = "404", description = "Lección no encontrada")
    })
    @DeleteMapping("/{id}")
    public void deleteLeccion(
            @Parameter(description = "ID de la lección a eliminar", required = true)
            @PathVariable int id) {
        LOGGER.debug("Eliminando lección con id: {}", id);
        if (id < 1) {
            throw new InvalidInputException("ID de lección inválido: " + id);
        }
        if (id == 999) {
            throw new NotFoundException("No se encontró lección con id: " + id);
        }
        // Simulación: se procede a eliminar la lección.
    }
}
