package bo.edu.ucb.collas_learning.core.ms_cursos.controller;

import bo.edu.ucb.collas_learning.core.ms_cursos.dto.RespuestaDTO;
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
@RequestMapping("/respuestas")
@Tag(name = "Respuesta", description = "REST API para opciones de respuesta de preguntas de opción múltiple")
public class RespuestaController {

    private static final Logger LOGGER = LoggerFactory.getLogger(RespuestaController.class);
    private final ServiceUtil serviceUtil;

    @Autowired
    public RespuestaController(ServiceUtil serviceUtil) {
        this.serviceUtil = serviceUtil;
    }

    @Operation(summary = "Obtener respuestas de una pregunta", 
               description = "Retorna una lista de respuestas asociadas a una pregunta")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Respuestas obtenidas correctamente",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = RespuestaDTO.class))),
            @ApiResponse(responseCode = "400", description = "ID de pregunta inválido"),
            @ApiResponse(responseCode = "404", description = "No se encontraron respuestas para la pregunta")
    })
    @GetMapping("/pregunta/{idPregunta}")
    public List<RespuestaDTO> getRespuestasByPregunta(
            @Parameter(description = "ID de la pregunta", required = true)
            @PathVariable int idPregunta) {
        LOGGER.info("Obteniendo respuestas para la pregunta con id: {}", idPregunta);
        if (idPregunta < 1) {
            throw new InvalidInputException("ID de pregunta inválido: " + idPregunta);
        }
        // Simulación: si idPregunta es 999 se simula que no existen respuestas
        if (idPregunta == 999) {
            throw new NotFoundException("No se encontraron respuestas para la pregunta con id: " + idPregunta);
        }
        List<RespuestaDTO> respuestas = new ArrayList<>();
        respuestas.add(new RespuestaDTO(1, "Respuesta A", true, idPregunta));
        respuestas.add(new RespuestaDTO(2, "Respuesta B", false, idPregunta));
        return respuestas;
    }

    @Operation(summary = "Agregar opciones de respuesta a una pregunta", 
               description = "Crea y retorna la respuesta creada")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Respuesta creada correctamente",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = RespuestaDTO.class))),
            @ApiResponse(responseCode = "400", description = "Datos inválidos para la respuesta")
    })
    @PostMapping(consumes = "application/json", produces = "application/json")
    public RespuestaDTO createRespuesta(
            @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    description = "Datos de la respuesta a crear",
                    required = true,
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = RespuestaDTO.class)))
            @Valid @RequestBody RespuestaDTO respuesta) {
        LOGGER.debug("Creando respuesta: {}", respuesta);
        // Simulación: asignar un ID dummy (por ejemplo, 100) a la respuesta creada.
        respuesta.setCodRespuesta(100);
        return respuesta;
    }

    @Operation(summary = "Editar una respuesta", 
               description = "Actualiza y retorna la respuesta editada")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Respuesta actualizada correctamente",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = RespuestaDTO.class))),
            @ApiResponse(responseCode = "400", description = "Datos inválidos para la actualización"),
            @ApiResponse(responseCode = "404", description = "Respuesta no encontrada")
    })
    @PutMapping(value = "/{id}", consumes = "application/json", produces = "application/json")
    public RespuestaDTO updateRespuesta(
            @Parameter(description = "ID de la respuesta a editar", required = true)
            @PathVariable int id,
            @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    description = "Datos de la respuesta a actualizar",
                    required = true,
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = RespuestaDTO.class)))
            @Valid @RequestBody RespuestaDTO respuesta) {
        LOGGER.debug("Actualizando respuesta con id: {}", id);
        if (id < 1) {
            throw new InvalidInputException("ID de respuesta inválido: " + id);
        }
        if (id == 999) {
            throw new NotFoundException("No se encontró respuesta con id: " + id);
        }
        // Simulación: asignar el ID recibido al objeto respuesta y retornarlo
        respuesta.setCodRespuesta(id);
        return respuesta;
    }

    @Operation(summary = "Eliminar una respuesta", 
               description = "Elimina la respuesta con el ID especificado")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Respuesta eliminada correctamente"),
            @ApiResponse(responseCode = "400", description = "ID de respuesta inválido"),
            @ApiResponse(responseCode = "404", description = "Respuesta no encontrada")
    })
    @DeleteMapping("/{id}")
    public void deleteRespuesta(
            @Parameter(description = "ID de la respuesta a eliminar", required = true)
            @PathVariable int id) {
        LOGGER.debug("Eliminando respuesta con id: {}", id);
        if (id < 1) {
            throw new InvalidInputException("ID de respuesta inválido: " + id);
        }
        if (id == 999) {
            throw new NotFoundException("No se encontró respuesta con id: " + id);
        }
        // Simulación: se procede a eliminar la respuesta.
    }
}
