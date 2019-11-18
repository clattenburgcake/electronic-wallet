package actuatorservice.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.apache.commons.lang3.builder.ToStringBuilder;

import static org.apache.commons.lang3.builder.ToStringStyle.JSON_STYLE;

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

    @Override
    public String toString() {
        return new ToStringBuilder(this, JSON_STYLE)
                .append("name", name)
                .append("email", email)
                .toString();
    }

}
