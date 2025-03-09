package bo.edu.ucb.collas_learning.core.ms_cursos.controller;


import bo.edu.ucb.collas_learning.core.ms_cursos.dto.EvaluacionDTO;
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
@RequestMapping("/evaluaciones")
@Tag(name = "Evaluacion", description = "REST API para evaluaciones")
public class EvaluacionController {

    private static final Logger LOGGER = LoggerFactory.getLogger(EvaluacionController.class);
    private final ServiceUtil serviceUtil;

    @Autowired
    public EvaluacionController(ServiceUtil serviceUtil) {
        this.serviceUtil = serviceUtil;
    }

    @Operation(summary = "Obtener todas las evaluaciones de un curso", 
               description = "Retorna una lista de evaluaciones asociadas a un curso")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Evaluaciones obtenidas correctamente",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = EvaluacionDTO.class))),
            @ApiResponse(responseCode = "400", description = "ID de curso inválido"),
            @ApiResponse(responseCode = "404", description = "No se encontraron evaluaciones para el curso")
    })
    @GetMapping("/curso/{idCurso}")
    public List<EvaluacionDTO> getEvaluacionesByCurso(
            @Parameter(description = "ID del curso", required = true)
            @PathVariable int idCurso) {
        LOGGER.info("Obteniendo evaluaciones para el curso con id: {}", idCurso);
        if (idCurso < 1) {
            throw new InvalidInputException("ID de curso inválido: " + idCurso);
        }
        // Simulación: Retornamos una lista dummy
        List<EvaluacionDTO> evaluaciones = new ArrayList<>();
        // Simulación: si el idCurso es 999 se simula que no hay evaluaciones
        if (idCurso == 999) {
            throw new NotFoundException("No se encontraron evaluaciones para el curso con id: " + idCurso);
        }
        evaluaciones.add(new EvaluacionDTO(1, "Evaluación final", 3, idCurso, 60));
        evaluaciones.add(new EvaluacionDTO(2, "Evaluación intermedia", 2, idCurso, 70));
        return evaluaciones;
    }

    @Operation(summary = "Obtener una evaluación específica", 
               description = "Retorna la evaluación identificada por su ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Evaluación obtenida correctamente",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = EvaluacionDTO.class))),
            @ApiResponse(responseCode = "400", description = "ID de evaluación inválido"),
            @ApiResponse(responseCode = "404", description = "Evaluación no encontrada")
    })
    @GetMapping("/{id}")
    public EvaluacionDTO getEvaluacionById(
            @Parameter(description = "ID de la evaluación a obtener", required = true)
            @PathVariable int id) {
        LOGGER.info("Obteniendo evaluación con id: {}", id);
        if (id < 1) {
            throw new InvalidInputException("ID de evaluación inválido: " + id);
        }
        // Simulación: si id es 999 se simula que la evaluación no existe
        if (id == 999) {
            throw new NotFoundException("No se encontró evaluación con id: " + id);
        }
        // Se retorna una evaluación dummy
        return new EvaluacionDTO(id, "Evaluación dummy", 3, 101, 65);
    }

    @Operation(summary = "Crear una nueva evaluación", 
               description = "Crea y retorna la evaluación creada")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Evaluación creada correctamente",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = EvaluacionDTO.class))),
            @ApiResponse(responseCode = "400", description = "Datos inválidos para la evaluación")
    })
    @PostMapping(consumes = "application/json", produces = "application/json")
    public EvaluacionDTO createEvaluacion(
            @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    description = "Datos de la evaluación a crear",
                    required = true,
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = EvaluacionDTO.class)))
            @Valid @RequestBody EvaluacionDTO evaluacion) {
        LOGGER.debug("Creando evaluación: {}", evaluacion);
        // Simulación: Se asigna un ID dummy (por ejemplo, 100) a la evaluación creada.
        evaluacion.setCodEvaluacion(100);
        return evaluacion;
    }

    @Operation(summary = "Editar una evaluación", 
               description = "Actualiza y retorna la evaluación editada")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Evaluación actualizada correctamente",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = EvaluacionDTO.class))),
            @ApiResponse(responseCode = "400", description = "Datos inválidos para la actualización"),
            @ApiResponse(responseCode = "404", description = "Evaluación no encontrada")
    })
    @PutMapping(value = "/{id}", consumes = "application/json", produces = "application/json")
    public EvaluacionDTO updateEvaluacion(
            @Parameter(description = "ID de la evaluación a editar", required = true)
            @PathVariable int id,
            @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    description = "Datos de la evaluación a actualizar",
                    required = true,
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = EvaluacionDTO.class)))
            @Valid @RequestBody EvaluacionDTO evaluacion) {
        LOGGER.debug("Actualizando evaluación con id: {}", id);
        if (id < 1) {
            throw new InvalidInputException("ID de evaluación inválido: " + id);
        }
        if (id == 999) {
            throw new NotFoundException("No se encontró evaluación con id: " + id);
        }
        // Simulación: Se asigna el ID recibido y se retorna el objeto actualizado.
        evaluacion.setCodEvaluacion(id);
        return evaluacion;
    }

    @Operation(summary = "Eliminar una evaluación", 
               description = "Elimina la evaluación con el ID especificado")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Evaluación eliminada correctamente"),
            @ApiResponse(responseCode = "400", description = "ID de evaluación inválido"),
            @ApiResponse(responseCode = "404", description = "Evaluación no encontrada")
    })
    @DeleteMapping("/{id}")
    public void deleteEvaluacion(
            @Parameter(description = "ID de la evaluación a eliminar", required = true)
            @PathVariable int id) {
        LOGGER.debug("Eliminando evaluación con id: {}", id);
        if (id < 1) {
            throw new InvalidInputException("ID de evaluación inválido: " + id);
        }
        if (id == 999) {
            throw new NotFoundException("No se encontró evaluación con id: " + id);
        }
        // Aquí se implementaría la lógica para eliminar la evaluación.
    }
}