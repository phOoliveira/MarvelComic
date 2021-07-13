package marvelcomimcs.MC.ApiMArvel;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@FeignClient(url= "http://gateway.marvel.com/v1/public/comics/" , name = "apiMarvel")
public interface ApiMarvelInterface {

    @GetMapping("{comicId}?ts=1&apikey=618b73024983edce6377a43309311189&hash=068f479816ae44380c9ac1368a492917")
    ApiMarvelData buscaComicPorId(@PathVariable("comicId") String comic);


}
