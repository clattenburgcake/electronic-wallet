package actuatorservice.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.ArrayList;
import java.util.List;

import static org.apache.commons.lang3.builder.ToStringStyle.JSON_STYLE;

public class Recipients {

    private List<Recipient> recipients;

    public Recipients(@JsonProperty("recipients") List<Recipient> recipients) {
        this.recipients = new ArrayList<>(recipients);
    }

    public List<Recipient> getRecipients() {
        return this.recipients;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, JSON_STYLE)
                .append("recipients", recipients)
                .toString();
    }

}
