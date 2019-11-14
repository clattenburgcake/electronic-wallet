package actuatorservice;

import com.fasterxml.jackson.annotation.JsonProperty;

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

}
