package marvelcomimcs.MC.ApiMArvel;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class ApiMarvelCreators {
    @JsonProperty("items")
    List<ApiMarvelCreatorItens> items;

    public List<ApiMarvelCreatorItens> getItems() {
        return items;
    }

    public void setItems(List<ApiMarvelCreatorItens> items) {
        this.items = items;
    }
}
