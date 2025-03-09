package bo.edu.ucb.collas_learning.core.ms_cursos.controller;


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

import bo.edu.ucb.collas_learning.core.ms_cursos.dto.CertificacionDTO;
import bo.edu.ucb.collas_learning.core.ms_cursos.exception.InvalidInputException;
import bo.edu.ucb.collas_learning.core.ms_cursos.exception.NotFoundException;
import bo.edu.ucb.collas_learning.core.ms_cursos.service.ServiceUtil;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/certificaciones")
@Tag(name = "Certificacion", description = "REST API para certificaciones")
public class CertificacionController {

    private static final Logger LOGGER = LoggerFactory.getLogger(CertificacionController.class);
    private final ServiceUtil serviceUtil;

    @Autowired
    public CertificacionController(ServiceUtil serviceUtil) {
        this.serviceUtil = serviceUtil;
    }

    @Operation(summary = "Obtener las certificaciones de un usuario", description = "Retorna las certificaciones emitidas para un usuario")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Certificaciones obtenidas correctamente",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = CertificacionDTO.class))),
            @ApiResponse(responseCode = "400", description = "ID de usuario inválido"),
            @ApiResponse(responseCode = "404", description = "Certificaciones no encontradas para el usuario")
    })
    @GetMapping("/usuario/{idUsuario}")
    public List<CertificacionDTO> getCertificacionesByUsuario(
            @Parameter(description = "ID del usuario", required = true)
            @PathVariable int idUsuario) {
        LOGGER.info("Obteniendo certificaciones para el usuario con id: {}", idUsuario);
        if (idUsuario < 1) {
            throw new InvalidInputException("ID de usuario inválido: " + idUsuario);
        }
        // Simulación de datos: se retorna una lista dummy
        List<CertificacionDTO> certificaciones = new ArrayList<>();
        // Simulación: si idUsuario es 999 se simula que no se encontraron certificaciones
        if (idUsuario == 999) {
            throw new NotFoundException("No se encontraron certificaciones para el usuario con id: " + idUsuario);
        }
        certificaciones.add(new CertificacionDTO(1, new Timestamp(System.currentTimeMillis()), 
                "http://ejemplo.com/certificado/1", idUsuario, 101));
        certificaciones.add(new CertificacionDTO(2, new Timestamp(System.currentTimeMillis()), 
                "http://ejemplo.com/certificado/2", idUsuario, 102));
        return certificaciones;
    }

    @Operation(summary = "Obtener todas las certificaciones emitidas para un curso", description = "Retorna las certificaciones de un curso")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Certificaciones obtenidas correctamente",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = CertificacionDTO.class))),
            @ApiResponse(responseCode = "400", description = "ID de curso inválido"),
            @ApiResponse(responseCode = "404", description = "Certificaciones no encontradas para el curso")
    })
    @GetMapping("/curso/{idCurso}")
    public List<CertificacionDTO> getCertificacionesByCurso(
            @Parameter(description = "ID del curso", required = true)
            @PathVariable int idCurso) {
        LOGGER.info("Obteniendo certificaciones para el curso con id: {}", idCurso);
        if (idCurso < 1) {
            throw new InvalidInputException("ID de curso inválido: " + idCurso);
        }
        // Simulación de datos: se retorna una lista dummy
        List<CertificacionDTO> certificaciones = new ArrayList<>();
        // Simulación: si idCurso es 999 se simula que no se encontraron certificaciones
        if (idCurso == 999) {
            throw new NotFoundException("No se encontraron certificaciones para el curso con id: " + idCurso);
        }
        certificaciones.add(new CertificacionDTO(3, new Timestamp(System.currentTimeMillis()), 
                "http://ejemplo.com/certificado/3", 201, idCurso));
        certificaciones.add(new CertificacionDTO(4, new Timestamp(System.currentTimeMillis()), 
                "http://ejemplo.com/certificado/4", 202, idCurso));
        return certificaciones;
    }

    @Operation(summary = "Generar una certificación para un usuario", description = "Crea y retorna la certificación creada")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Certificación creada correctamente",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = CertificacionDTO.class))),
            @ApiResponse(responseCode = "400", description = "Datos inválidos para la certificación")
    })
    @PostMapping(consumes = "application/json", produces = "application/json")
    public CertificacionDTO createCertificacion(
            @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    description = "Datos de la certificación a crear",
                    required = true,
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = CertificacionDTO.class)))
            @Valid @RequestBody CertificacionDTO certificacion) {
        LOGGER.debug("Creando certificación: {}", certificacion);
        // En una implementación real, se persistiría el objeto en la base de datos.
        // Se simula asignando un ID generado (por ejemplo, 100) y retornando el objeto.
        certificacion.setCodCertificacion(100);
        return certificacion;
    }

    @Operation(summary = "Eliminar una certificación", description = "Elimina la certificación con el ID especificado")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Certificación eliminada correctamente"),
            @ApiResponse(responseCode = "400", description = "ID de certificación inválido"),
            @ApiResponse(responseCode = "404", description = "Certificación no encontrada")
    })
    @DeleteMapping("/{id}")
    public void deleteCertificacion(
            @Parameter(description = "ID de la certificación a eliminar", required = true)
            @PathVariable int id) {
        LOGGER.debug("Eliminando certificación con id: {}", id);
        if (id < 1) {
            throw new InvalidInputException("ID de certificación inválido: " + id);
        }
        // Simulación: si id es 999 se simula que la certificación no existe
        if (id == 999) {
            throw new NotFoundException("Certificación no encontrada con id: " + id);
        }
        // En una implementación real, se invocaría el servicio para eliminar la certificación.
    }
}