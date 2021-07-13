package marvelcomimcs.MC.ApiMArvel;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ApiMarvelData  {

    @JsonProperty("data")
    private ApiMarvelResults data;

    public ApiMarvelResults getData() {
        return data;
    }

    // ComicId, Título, Preço, Autores, o ISBN e Descrição


}

