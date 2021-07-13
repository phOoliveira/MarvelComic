package marvelcomimcs.MC.ApiMArvel;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;


@JsonIgnoreProperties(ignoreUnknown = true)
public class ApiMarvel {
    @JsonProperty("id")
    private Long id;
    @JsonProperty("title")
    private String title;
    @JsonProperty("description")
    private String description;
    @JsonProperty("isbn")
    private String isbn;
    @JsonProperty("prices")
    private List<ApiMarvelPrices> price;
    @JsonProperty("creators")
    private ApiMarvelCreators creators;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public List<ApiMarvelPrices> getPrice() {
        return price;
    }

    public void setPrice(List<ApiMarvelPrices> price) {
        this.price = price;
    }

    public ApiMarvelCreators getCreators() {
        return creators;
    }

    public void setCreators(ApiMarvelCreators creators) {
        this.creators = creators;
    }
}
