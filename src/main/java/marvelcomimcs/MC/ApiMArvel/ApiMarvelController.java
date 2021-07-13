package marvelcomimcs.MC.ApiMArvel;

import marvelcomimcs.MC.Comics.Comics;
import marvelcomimcs.MC.Comics.ComicsRepository;
import marvelcomimcs.MC.Comics.ComicsService;
import marvelcomimcs.MC.Usuario.Usuario;
import marvelcomimcs.MC.Usuario.UsuarioRepository;
import marvelcomimcs.MC.Usuario.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;


@RestController
@RequestMapping("/api/v1/comics")
public class ApiMarvelController {

    @Autowired
    ApiMarvelInterface comicsdata;

    @Autowired
    private ComicsRepository comicsService;

    @Autowired
    private UsuarioService usuarioService;


    @GetMapping("/{comicId}")
    public Comics getComic(@PathVariable String comicId) {

        ApiMarvelData comic = comicsdata.buscaComicPorId(comicId);
        Comics revista = new Comics();
        revista.setTitulo(comic.getData().getResults().get(0).getTitle());
        revista.setIsbn(comic.getData().getResults().get(0).getIsbn());
        revista.setDescricao(comic.getData().getResults().get(0).getDescription());
        revista.setComicid(comic.getData().getResults().get(0).getId());
        Stream<ApiMarvelCreatorItens> criadores = comic.getData().getResults().get(0).getCreators().getItems()
                .stream()
                .filter(a -> {
                    return (a.getRole().equals("writer"));
                });
        List<String> autores = new ArrayList<>();
        criadores.forEach(name -> autores.add(name.getName()));
        revista.setAutores(String.join(", ", autores));
        Stream<ApiMarvelPrices> precos = comic.getData().getResults().get(0).getPrice().stream()
                .filter(b -> {
                    return (b.getType().equals("printPrice"));
                });
        List<Double> preco = new ArrayList<>();
        precos.forEach(pr -> preco.add(pr.getPrice()));
        revista.setPreco(preco.get(0));



        return revista; //!= null ? ResponseEntity.ok().body(comic) : ResponseEntity.notFound().build();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/incluir/{comicId}/{UsuarioId}")
    public Comics postComic(@PathVariable String comicId, @PathVariable Long UsuarioId){
        ApiMarvelData comic = comicsdata.buscaComicPorId(comicId);

        Comics revista = new Comics();
        revista.setTitulo(comic.getData().getResults().get(0).getTitle());
        revista.setIsbn(comic.getData().getResults().get(0).getIsbn());
        revista.setDescricao(comic.getData().getResults().get(0).getDescription());
        revista.setComicid(comic.getData().getResults().get(0).getId());
        Stream<ApiMarvelCreatorItens> criadores = comic.getData().getResults().get(0).getCreators().getItems()
                .stream()
                .filter(a -> {
                    return (a.getRole().equals("writer"));
                });
        List<String> autores = new ArrayList<>();
        criadores.forEach(name -> autores.add(name.getName()));
        revista.setAutores(String.join(", ", autores));
        Stream<ApiMarvelPrices> precos = comic.getData().getResults().get(0).getPrice().stream()
                .filter(b -> {
                    return (b.getType().equals("printPrice"));
                });
        List<Double> preco = new ArrayList<>();
        precos.forEach(pr -> preco.add(pr.getPrice()));
        revista.setPreco(preco.get(0));

        Usuario user = usuarioService.getUsuariobyId(UsuarioId);
        revista.setUsuarioId(user);

        comicsService.save(revista);

        return null;

    }
}
