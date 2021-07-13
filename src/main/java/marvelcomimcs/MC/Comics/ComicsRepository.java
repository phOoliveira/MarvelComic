package marvelcomimcs.MC.Comics;

import marvelcomimcs.MC.Usuario.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ComicsRepository extends JpaRepository<Comics, Long> {

    @Query("SELECT s FROM Comics s WHERE s.usuarioId = ?1")
    List<Comics> findComicByUsuarioId(Usuario usuarioId);

}
