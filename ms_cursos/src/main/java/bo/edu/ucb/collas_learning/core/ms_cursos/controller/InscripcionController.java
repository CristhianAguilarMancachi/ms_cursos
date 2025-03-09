package bo.edu.ucb.collas_learning.core.ms_cursos.controller;

import bo.edu.ucb.collas_learning.core.ms_cursos.dto.InscripcionDTO;
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

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/inscripciones")
@Tag(name = "Inscripcion", description = "REST API para inscripciones")
public class InscripcionController {

    private static final Logger LOGGER = LoggerFactory.getLogger(InscripcionController.class);
    private final ServiceUtil serviceUtil;

    @Autowired
    public InscripcionController(ServiceUtil serviceUtil) {
        this.serviceUtil = serviceUtil;
    }

    @Operation(summary = "Inscribir a un estudiante en un curso", 
               description = "Crea y retorna la inscripción creada")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Inscripción creada correctamente",
                content = @Content(mediaType = "application/json", schema = @Schema(implementation = InscripcionDTO.class))),
        @ApiResponse(responseCode = "400", description = "Datos inválidos para la inscripción")
    })
    @PostMapping(consumes = "application/json", produces = "application/json")
    public InscripcionDTO createInscripcion(
            @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    description = "Datos de la inscripción a crear",
                    required = true,
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = InscripcionDTO.class)))
            @Valid @RequestBody InscripcionDTO inscripcion) {
        LOGGER.debug("Creando inscripción: {}", inscripcion);
        // Simulación: asignar un ID dummy (por ejemplo, 100) a la inscripción creada.
        inscripcion.setCodInscripcion(100);
        return inscripcion;
    }

    @Operation(summary = "Obtener todos los cursos en los que está inscrito un usuario", 
               description = "Retorna una lista de inscripciones asociadas al usuario")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Inscripciones obtenidas correctamente",
                content = @Content(mediaType = "application/json", schema = @Schema(implementation = InscripcionDTO.class))),
        @ApiResponse(responseCode = "400", description = "ID de usuario inválido"),
        @ApiResponse(responseCode = "404", description = "No se encontraron inscripciones para el usuario")
    })
    @GetMapping("/usuario/{idUsuario}")
    public List<InscripcionDTO> getInscripcionesByUsuario(
            @Parameter(description = "ID del usuario", required = true)
            @PathVariable int idUsuario) {
        LOGGER.info("Obteniendo inscripciones para el usuario con id: {}", idUsuario);
        if (idUsuario < 1) {
            throw new InvalidInputException("ID de usuario inválido: " + idUsuario);
        }
        // Simulación: si idUsuario es 999, se simula que no hay inscripciones
        if (idUsuario == 999) {
            throw new NotFoundException("No se encontraron inscripciones para el usuario con id: " + idUsuario);
        }
        List<InscripcionDTO> inscripciones = new ArrayList<>();
        inscripciones.add(new InscripcionDTO(1, new Timestamp(System.currentTimeMillis()), true, idUsuario, 101));
        inscripciones.add(new InscripcionDTO(2, new Timestamp(System.currentTimeMillis()), true, idUsuario, 102));
        return inscripciones;
    }

    @Operation(summary = "Obtener todos los usuarios inscritos en un curso", 
               description = "Retorna una lista de inscripciones asociadas al curso")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Inscripciones obtenidas correctamente",
                content = @Content(mediaType = "application/json", schema = @Schema(implementation = InscripcionDTO.class))),
        @ApiResponse(responseCode = "400", description = "ID de curso inválido"),
        @ApiResponse(responseCode = "404", description = "No se encontraron inscripciones para el curso")
    })
    @GetMapping("/curso/{idCurso}")
    public List<InscripcionDTO> getInscripcionesByCurso(
            @Parameter(description = "ID del curso", required = true)
            @PathVariable int idCurso) {
        LOGGER.info("Obteniendo inscripciones para el curso con id: {}", idCurso);
        if (idCurso < 1) {
            throw new InvalidInputException("ID de curso inválido: " + idCurso);
        }
        // Simulación: si idCurso es 999, se simula que no hay inscripciones
        if (idCurso == 999) {
            throw new NotFoundException("No se encontraron inscripciones para el curso con id: " + idCurso);
        }
        List<InscripcionDTO> inscripciones = new ArrayList<>();
        inscripciones.add(new InscripcionDTO(3, new Timestamp(System.currentTimeMillis()), true, 201, idCurso));
        inscripciones.add(new InscripcionDTO(4, new Timestamp(System.currentTimeMillis()), true, 202, idCurso));
        return inscripciones;
    }

    @Operation(summary = "Cancelar la inscripción de un usuario en un curso", 
               description = "Elimina la inscripción con el ID especificado")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Inscripción eliminada correctamente"),
        @ApiResponse(responseCode = "400", description = "ID de inscripción inválido"),
        @ApiResponse(responseCode = "404", description = "Inscripción no encontrada")
    })
    @DeleteMapping("/{id}")
    public void deleteInscripcion(
            @Parameter(description = "ID de la inscripción a cancelar", required = true)
            @PathVariable int id) {
        LOGGER.debug("Eliminando inscripción con id: {}", id);
        if (id < 1) {
            throw new InvalidInputException("ID de inscripción inválido: " + id);
        }
        if (id == 999) {
            throw new NotFoundException("No se encontró inscripción con id: " + id);
        }
        // Simulación: se cancela la inscripción.
    }
}
