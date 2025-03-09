/*package bo.edu.ucb.collas_learning.core.ms_cursos.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bo.edu.ucb.collas_learning.core.ms_cursos.entity.Curso;
import bo.edu.ucb.collas_learning.core.ms_cursos.repository.CursoRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CursoService {

    @Autowired
    private CursoRepository cursoRepository;

    // Método para obtener todos los cursos
    public List<Curso> obtenerTodosLosCursos() {
        return cursoRepository.findAll();
    }

    // Método para obtener un curso por su código (cod_curso)
    public Optional<Curso> obtenerCursoPorCodigo(Integer codCurso) {
        return cursoRepository.findByCodCurso(codCurso);
    }

    // Método para obtener cursos de un usuario
    public List<Curso> obtenerCursosPorUsuario(Integer usuarioCodUsuario) {
        return cursoRepository.findByUsuarioCodUsuario(usuarioCodUsuario);
    }

    // Método para obtener cursos activos
    public List<Curso> obtenerCursosActivos() {
        return cursoRepository.findByEstadoCurso(true);
    }

    // Método para crear un nuevo curso
    public Curso crearCurso(Curso curso) {
        return cursoRepository.save(curso);
    }

    // Método para actualizar un curso existente
    public Curso actualizarCurso(Curso curso) {
        if (cursoRepository.existsById(curso.getCodCurso())) {
            return cursoRepository.save(curso);
        } else {
            throw new IllegalArgumentException("El curso no existe");
        }
    }

    // Método para realizar el borrado lógico de un curso
    public void eliminarCursoLogico(Integer codCurso) {
        Optional<Curso> curso = cursoRepository.findById(codCurso);
        if (curso.isPresent()) {
            Curso cursoActualizado = curso.get();
            cursoActualizado.setEstadoCurso(false);  // Cambiar estado a false (borrado lógico)
            cursoRepository.save(cursoActualizado);  // Guardar el curso con el nuevo estado
        } else {
            throw new IllegalArgumentException("El curso no existe");
        }
    }
}
*/