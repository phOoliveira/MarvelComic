package marvelcomimcs.MC.Comics;

import marvelcomimcs.MC.Usuario.Usuario;
import marvelcomimcs.MC.Usuario.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.List;

@Service
public class ComicsService {

    private final ComicsRepository comicsRepository;

    @Autowired
    public ComicsService(ComicsRepository comicsRepository){

        this.comicsRepository = comicsRepository;
    }

    @Autowired
    private UsuarioService usuarioService;

    public List<Comics> getComics(){

        return comicsRepository.findAll();
    }

    public List<Comics> getComicsbyUsuario(Long usuarioID){
        Usuario usuario = usuarioService.getUsuariobyId(usuarioID);
        List<Comics> comics = comicsRepository.findComicByUsuarioId(usuario);
        for (int i =0; i < comics.size(); i++){
            if (!comics.get(i).getIsbn().isEmpty()){
                switch (comics.get(i).getIsbn().substring(comics.get(i).getIsbn().length()-1,
                                                  comics.get(i).getIsbn().length())){
                    case "0":
                    case "1":
                        comics.get(i).setDiaDesconto(DayOfWeek.MONDAY);
                        break;
                    case "2":
                    case "3":
                        comics.get(i).setDiaDesconto(DayOfWeek.TUESDAY);
                        break;
                    case "4":
                    case "5":
                        comics.get(i).setDiaDesconto(DayOfWeek.WEDNESDAY);
                        break;
                    case "6":
                    case "7":
                        comics.get(i).setDiaDesconto(DayOfWeek.THURSDAY);
                        break;
                    case "8":
                    case "9":
                        comics.get(i).setDiaDesconto(DayOfWeek.FRIDAY);
                        break;
                }
            }
        }

        for (int i = 0; i < comics.size(); i++){
            if(comics.get(i).getDiaDesconto() == DayOfWeek.from(LocalDate.now())){
                comics.get(i).setDescontoAtivo(true);
            }else comics.get(i).setDescontoAtivo(false);
        }

        for (int i = 0; i < comics.size(); i++){
            if (comics.get(i).getDescontoAtivo()){
                comics.get(i).setPreco(comics.get(i).getPreco()*0.90);
            }
        }


        return comics;
    }






}
