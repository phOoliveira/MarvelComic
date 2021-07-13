package marvelcomimcs.MC.Comics;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/comics")
    public class ComicsController {

    private final ComicsService comicsService;

    @Autowired
    public ComicsController(ComicsService comicsService){
        this.comicsService = comicsService;
    }

    @GetMapping(value = "/buscarComicUsuario/{usuarioId}")
    public List<Comics> getComicsporUsuario(@PathVariable Long usuarioId){
        return comicsService.getComicsbyUsuario(usuarioId);
    }




}
