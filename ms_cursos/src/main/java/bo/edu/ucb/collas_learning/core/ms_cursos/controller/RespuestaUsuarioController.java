package bo.edu.ucb.collas_learning.core.ms_cursos.controller;

import bo.edu.ucb.collas_learning.core.ms_cursos.dto.RespuestaUsuarioDTO;
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
@RequestMapping("/respuestas-usuario")
@Tag(name = "RespuestaUsuario", description = "REST API para respuestas de usuario en evaluaciones")
public class RespuestaUsuarioController {

    private static final Logger LOGGER = LoggerFactory.getLogger(RespuestaUsuarioController.class);
    private final ServiceUtil serviceUtil;

    @Autowired
    public RespuestaUsuarioController(ServiceUtil serviceUtil) {
        this.serviceUtil = serviceUtil;
    }

    @Operation(summary = "Guardar la respuesta de un usuario en una evaluación",
               description = "Crea y retorna la respuesta de usuario creada")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Respuesta de usuario guardada correctamente",
                content = @Content(mediaType = "application/json", schema = @Schema(implementation = RespuestaUsuarioDTO.class))),
        @ApiResponse(responseCode = "400", description = "Datos inválidos para la respuesta de usuario")
    })
    @PostMapping(consumes = "application/json", produces = "application/json")
    public RespuestaUsuarioDTO createRespuestaUsuario(
            @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    description = "Datos de la respuesta de usuario a guardar",
                    required = true,
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = RespuestaUsuarioDTO.class)))
            @Valid @RequestBody RespuestaUsuarioDTO respuestaUsuario) {
        LOGGER.debug("Guardando respuesta de usuario: {}", respuestaUsuario);
        // Simulación: asignar un ID dummy (por ejemplo, 100) a la respuesta de usuario creada.
        respuestaUsuario.setCodRespuetaUsuario(100);
        return respuestaUsuario;
    }

    @Operation(summary = "Obtener respuestas de un usuario en una evaluación",
               description = "Retorna una lista de respuestas de un usuario para una evaluación específica")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Respuestas obtenidas correctamente",
                content = @Content(mediaType = "application/json", schema = @Schema(implementation = RespuestaUsuarioDTO.class))),
        @ApiResponse(responseCode = "400", description = "IDs inválidos"),
        @ApiResponse(responseCode = "404", description = "No se encontraron respuestas para los IDs proporcionados")
    })
    @GetMapping("/evaluacion/{idEvaluacion}/usuario/{idUsuario}")
    public List<RespuestaUsuarioDTO> getRespuestasByEvaluacionAndUsuario(
            @Parameter(description = "ID de la evaluación", required = true)
            @PathVariable int idEvaluacion,
            @Parameter(description = "ID del usuario", required = true)
            @PathVariable int idUsuario) {
        LOGGER.info("Obteniendo respuestas para evaluación id: {} y usuario id: {}", idEvaluacion, idUsuario);
        if (idEvaluacion < 1 || idUsuario < 1) {
            throw new InvalidInputException("IDs inválidos para evaluación o usuario.");
        }
        // Simulación: si se utiliza un ID de evaluación o usuario específico, se simula que no se encuentran respuestas.
        if (idEvaluacion == 999 || idUsuario == 999) {
            throw new NotFoundException("No se encontraron respuestas para los IDs proporcionados.");
        }
        List<RespuestaUsuarioDTO> respuestas = new ArrayList<>();
        respuestas.add(new RespuestaUsuarioDTO(1, "Respuesta 1", true, 10, 20, 30, idUsuario));
        respuestas.add(new RespuestaUsuarioDTO(2, "Respuesta 2", false, 11, 20, 31, idUsuario));
        return respuestas;
    }

    @Operation(summary = "Obtener todas las respuestas de un usuario",
               description = "Retorna una lista de todas las respuestas de un usuario")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Respuestas obtenidas correctamente",
                content = @Content(mediaType = "application/json", schema = @Schema(implementation = RespuestaUsuarioDTO.class))),
        @ApiResponse(responseCode = "400", description = "ID de usuario inválido"),
        @ApiResponse(responseCode = "404", description = "No se encontraron respuestas para el usuario")
    })
    @GetMapping("/usuario/{idUsuario}")
    public List<RespuestaUsuarioDTO> getRespuestasByUsuario(
            @Parameter(description = "ID del usuario", required = true)
            @PathVariable int idUsuario) {
        LOGGER.info("Obteniendo respuestas para el usuario con id: {}", idUsuario);
        if (idUsuario < 1) {
            throw new InvalidInputException("ID de usuario inválido: " + idUsuario);
        }
        // Simulación: si idUsuario es 999 se simula que no existen respuestas.
        if (idUsuario == 999) {
            throw new NotFoundException("No se encontraron respuestas para el usuario con id: " + idUsuario);
        }
        List<RespuestaUsuarioDTO> respuestas = new ArrayList<>();
        respuestas.add(new RespuestaUsuarioDTO(3, "Respuesta A", true, 12, 22, 32, idUsuario));
        respuestas.add(new RespuestaUsuarioDTO(4, "Respuesta B", false, 13, 22, 33, idUsuario));
        return respuestas;
    }
}
