package actuatorservice;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import static org.apache.commons.lang3.builder.ToStringStyle.*;

public class Offer {

    private String name;
    private double percentageDiscount;

    public Offer(@JsonProperty("name") String name,
                 @JsonProperty("fixedPercentage") double percentageDiscount) {

        this.name = name;
        this.percentageDiscount = percentageDiscount;

    }

    public String getName() {
        return this.name;
    }

    public double getPercentageDiscount() {
        return this.percentageDiscount;
    }

    @Override
    public String toString(){
        return new ToStringBuilder(this, JSON_STYLE)
                .append("name",name)
                .append("fixedPercentage",percentageDiscount)
                .toString();
    }

}
