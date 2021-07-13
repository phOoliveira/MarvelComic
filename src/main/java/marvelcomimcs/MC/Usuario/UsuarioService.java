package marvelcomimcs.MC.Usuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;


import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {
    private final UsuarioRepository usuarioRepository;
    private HttpStatus httpStatus;

    @Autowired
    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }



    public List<Usuario> getUsuarios() {
        return usuarioRepository.findAll();

    }

    public Usuario getUsuariobyId(Long id){

        return usuarioRepository.findUsuarioById(id);
    }



    public void addNewUsuario(Usuario usuario) {
        if (usuario == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Não foram informados dados do usuário");
        }

        if (usuario.getCpf().isEmpty() || usuario.getEmail().isEmpty() || usuario.getDtn() == null || usuario.getName().isEmpty()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Preencha todos os campos de formulário");
        }

        Optional<Usuario> usuarioEmail = usuarioRepository.findUsuarioByEmail(usuario.getEmail());
        if (usuarioEmail.isPresent()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Existe outro usuário cadastrado com este e-mail");
        }

        Optional<Usuario> usuarioCPF = usuarioRepository.findUsuarioByCpf(usuario.getCpf());
        if (usuarioCPF.isPresent()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Existe outro usuário cadastrado com este CPF");
        }

        usuarioRepository.save(usuario);


    }

}

