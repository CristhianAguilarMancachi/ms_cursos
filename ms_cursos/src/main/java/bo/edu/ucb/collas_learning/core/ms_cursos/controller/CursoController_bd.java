/* 
package bo.edu.ucb.collas_learning.core.ms_cursos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import bo.edu.ucb.collas_learning.core.ms_cursos.entity.Curso;
import bo.edu.ucb.collas_learning.core.ms_cursos.service.CursoService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/cursos")
public class CursoController_bd {

    @Autowired
    private CursoService cursoService;

    // Obtener todos los cursos
    @GetMapping
    public List<Curso> obtenerTodosLosCursos() {
        return cursoService.obtenerTodosLosCursos();
    }

    // Obtener un curso por su código
    @GetMapping("/{codCurso}")
    public ResponseEntity<Curso> obtenerCursoPorCodigo(@PathVariable Integer codCurso) {
        Optional<Curso> curso = cursoService.obtenerCursoPorCodigo(codCurso);
        return curso.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Crear un nuevo curso
    @PostMapping
    public ResponseEntity<Curso> crearCurso(@RequestBody Curso curso) {
        Curso cursoGuardado = cursoService.crearCurso(curso);
        return ResponseEntity.status(201).body(cursoGuardado);
    }

    // Actualizar un curso existente
    @PutMapping("/{codCurso}")
    public ResponseEntity<Curso> actualizarCurso(@PathVariable Integer codCurso, @RequestBody Curso curso) {
        curso.setCodCurso(codCurso);
        Curso cursoActualizado = cursoService.actualizarCurso(curso);
        return ResponseEntity.ok(cursoActualizado);
    }

    // Eliminar un curso de forma lógica
    @DeleteMapping("/{codCurso}")
    public ResponseEntity<Void> eliminarCursoLogico(@PathVariable Integer codCurso) {
        try {
            cursoService.eliminarCursoLogico(codCurso);
            return ResponseEntity.noContent().build();
        } catch (IllegalArgumentException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
*/