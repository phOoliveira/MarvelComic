package marvelcomimcs.MC.ApiMArvel;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.apache.commons.io.IOUtils;

public class ApiMarvelCreatorItens {
    @JsonProperty("name")
    private String name;
    @JsonProperty("role")
    private String role;


    public String getName() {
        return name.toString();
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRole() {

        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

//    @Override
//    public String toString() {
//        return name.toString();
//    }
}
