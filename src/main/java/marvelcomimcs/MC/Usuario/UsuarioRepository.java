package marvelcomimcs.MC.Usuario;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    @Query("SELECT s FROM Usuario s WHERE s.email = ?1")
    Optional<Usuario> findUsuarioByEmail(String email);

    @Query("SELECT s FROM Usuario s WHERE s.cpf = ?1")
    Optional<Usuario> findUsuarioByCpf(String cpf);

    @Query("SELECT s FROM Usuario s WHERE s.id = ?1")
    Usuario findUsuarioById(Long id);
}
