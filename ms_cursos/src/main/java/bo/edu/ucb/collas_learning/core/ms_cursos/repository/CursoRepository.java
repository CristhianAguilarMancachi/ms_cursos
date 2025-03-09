/* 
package bo.edu.ucb.collas_learning.core.ms_cursos.repository;

import org.springframework.stereotype.Repository;

import bo.edu.ucb.collas_learning.core.ms_cursos.entity.Curso;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.Optional;

@Repository
public interface CursoRepository extends JpaRepository<Curso, Integer> {

    // Método para encontrar un curso por su código (cod_curso)
    Optional<Curso> findByCodCurso(Integer codCurso);

    // Método para encontrar todos los cursos de un usuario (USUARIO_cod_usuario)
    List<Curso> findByUsuarioCodUsuario(Integer usuarioCodUsuario);

    // Método para encontrar todos los cursos activos
    List<Curso> findByEstadoCurso(Boolean estadoCurso);

    // Puedes agregar más métodos personalizados según lo que necesites, por ejemplo:
    // List<Curso> findByTituloCursoContainingIgnoreCase(String titulo);
}
*/