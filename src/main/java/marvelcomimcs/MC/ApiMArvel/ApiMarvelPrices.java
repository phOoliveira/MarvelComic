package marvelcomimcs.MC.ApiMArvel;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class ApiMarvelPrices {
    @JsonProperty("type")
    private String type;
    @JsonProperty("price")
    private Double price;

    public String getType() {
        return type;
    }

    public Double getPrice() {
        return price;
    }
}
