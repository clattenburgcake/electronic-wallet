package actuatorservice;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Recipient {

    private String name;
    private String email;

    public Recipient(@JsonProperty("name") String name,
                     @JsonProperty("email") String email) {
        this.name = name;
        this.email = email;
    }

    public String getName() {
        return this.name;
    }

    public String getEmail() {
        return this.email;
    }

}
