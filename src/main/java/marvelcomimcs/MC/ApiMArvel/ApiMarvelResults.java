package marvelcomimcs.MC.ApiMArvel;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class ApiMarvelResults {
    @JsonProperty("results")
    private List<ApiMarvel> results;

    public List<ApiMarvel> getResults() {
        return results;
    }
}
