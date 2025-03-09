package bo.edu.ucb.collas_learning.core.ms_cursos.controller;

import bo.edu.ucb.collas_learning.core.ms_cursos.dto.PreguntaDTO;
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
@RequestMapping("/preguntas")
@Tag(name = "Pregunta", description = "REST API para preguntas de evaluación")
public class PreguntaController {

    private static final Logger LOGGER = LoggerFactory.getLogger(PreguntaController.class);
    private final ServiceUtil serviceUtil;

    @Autowired
    public PreguntaController(ServiceUtil serviceUtil) {
        this.serviceUtil = serviceUtil;
    }

    @Operation(summary = "Obtener preguntas de una evaluación", 
               description = "Retorna una lista de preguntas asociadas a una evaluación")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Preguntas obtenidas correctamente",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = PreguntaDTO.class))),
            @ApiResponse(responseCode = "400", description = "ID de evaluación inválido"),
            @ApiResponse(responseCode = "404", description = "No se encontraron preguntas para la evaluación")
    })
    @GetMapping("/evaluacion/{idEvaluacion}")
    public List<PreguntaDTO> getPreguntasByEvaluacion(
            @Parameter(description = "ID de la evaluación", required = true)
            @PathVariable int idEvaluacion) {
        LOGGER.info("Obteniendo preguntas para la evaluación con id: {}", idEvaluacion);
        if (idEvaluacion < 1) {
            throw new InvalidInputException("ID de evaluación inválido: " + idEvaluacion);
        }
        // Simulación: si idEvaluacion es 999 se simula que no hay preguntas
        if (idEvaluacion == 999) {
            throw new NotFoundException("No se encontraron preguntas para la evaluación con id: " + idEvaluacion);
        }
        List<PreguntaDTO> preguntas = new ArrayList<>();
        preguntas.add(new PreguntaDTO(1, "¿Cuál es la capital de Francia?", 10, idEvaluacion));
        preguntas.add(new PreguntaDTO(2, "¿En qué año se independizó Bolivia?", 10, idEvaluacion));
        return preguntas;
    }

    @Operation(summary = "Obtener una pregunta específica", 
               description = "Retorna la pregunta identificada por su ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Pregunta obtenida correctamente",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = PreguntaDTO.class))),
            @ApiResponse(responseCode = "400", description = "ID de pregunta inválido"),
            @ApiResponse(responseCode = "404", description = "Pregunta no encontrada")
    })
    @GetMapping("/{id}")
    public PreguntaDTO getPreguntaById(
            @Parameter(description = "ID de la pregunta a obtener", required = true)
            @PathVariable int id) {
        LOGGER.info("Obteniendo pregunta con id: {}", id);
        if (id < 1) {
            throw new InvalidInputException("ID de pregunta inválido: " + id);
        }
        // Simulación: si id es 999 se simula que la pregunta no existe
        if (id == 999) {
            throw new NotFoundException("No se encontró pregunta con id: " + id);
        }
        return new PreguntaDTO(id, "Pregunta dummy " + id, 10, 101);
    }

    @Operation(summary = "Agregar una pregunta a una evaluación", 
               description = "Crea y retorna la pregunta agregada")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Pregunta creada correctamente",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = PreguntaDTO.class))),
            @ApiResponse(responseCode = "400", description = "Datos inválidos para la pregunta")
    })
    @PostMapping(consumes = "application/json", produces = "application/json")
    public PreguntaDTO createPregunta(
            @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    description = "Datos de la pregunta a crear",
                    required = true,
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = PreguntaDTO.class)))
            @Valid @RequestBody PreguntaDTO pregunta) {
        LOGGER.debug("Creando pregunta: {}", pregunta);
        // Simulación: se asigna un ID dummy (por ejemplo, 100) a la pregunta creada.
        pregunta.setCodPregunta(100);
        return pregunta;
    }

    @Operation(summary = "Editar una pregunta", 
               description = "Actualiza y retorna la pregunta editada")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Pregunta actualizada correctamente",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = PreguntaDTO.class))),
            @ApiResponse(responseCode = "400", description = "Datos inválidos para la actualización"),
            @ApiResponse(responseCode = "404", description = "Pregunta no encontrada")
    })
    @PutMapping(value = "/{id}", consumes = "application/json", produces = "application/json")
    public PreguntaDTO updatePregunta(
            @Parameter(description = "ID de la pregunta a editar", required = true)
            @PathVariable int id,
            @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    description = "Datos de la pregunta a actualizar",
                    required = true,
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = PreguntaDTO.class)))
            @Valid @RequestBody PreguntaDTO pregunta) {
        LOGGER.debug("Actualizando pregunta con id: {}", id);
        if (id < 1) {
            throw new InvalidInputException("ID de pregunta inválido: " + id);
        }
        if (id == 999) {
            throw new NotFoundException("No se encontró pregunta con id: " + id);
        }
        // Simulación: asignar el ID recibido al objeto pregunta y retornarlo
        pregunta.setCodPregunta(id);
        return pregunta;
    }

    @Operation(summary = "Eliminar una pregunta", 
               description = "Elimina la pregunta con el ID especificado")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Pregunta eliminada correctamente"),
            @ApiResponse(responseCode = "400", description = "ID de pregunta inválido"),
            @ApiResponse(responseCode = "404", description = "Pregunta no encontrada")
    })
    @DeleteMapping("/{id}")
    public void deletePregunta(
            @Parameter(description = "ID de la pregunta a eliminar", required = true)
            @PathVariable int id) {
        LOGGER.debug("Eliminando pregunta con id: {}", id);
        if (id < 1) {
            throw new InvalidInputException("ID de pregunta inválido: " + id);
        }
        if (id == 999) {
            throw new NotFoundException("No se encontró pregunta con id: " + id);
        }
        // Simulación: se procede a eliminar la pregunta.
    }
}
