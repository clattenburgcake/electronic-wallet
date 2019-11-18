package actuatorservice.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.ArrayList;
import java.util.List;

import static org.apache.commons.lang3.builder.ToStringStyle.JSON_STYLE;


public class Offers {

    private List<Offer> offers;

    public Offers(@JsonProperty("offers") List<Offer> offers) {

        this.offers = new ArrayList<>(offers);
    }


    public List<Offer> getOffers() {
        return this.offers;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, JSON_STYLE)
                .append("offers", offers)
                .toString();
    }
}
