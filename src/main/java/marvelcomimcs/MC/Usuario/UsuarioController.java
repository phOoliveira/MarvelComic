package marvelcomimcs.MC.Usuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/usuarios")
public class UsuarioController {

    private  final UsuarioService usuarioService;

    @Autowired
    public UsuarioController(UsuarioService usuarioService) {

        this.usuarioService = usuarioService;
    }


    @GetMapping(value = "/buscarPorId/{id}")
    public Usuario getUsuarios(@PathVariable Long id) {

        return usuarioService.getUsuariobyId(id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(value = "/cadastrar")
    public void cadastrarNovoUsuario(@RequestBody  Usuario usuario){

        usuarioService.addNewUsuario (usuario);
    }

}
