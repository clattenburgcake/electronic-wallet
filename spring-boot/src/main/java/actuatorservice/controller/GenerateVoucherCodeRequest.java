package actuatorservice.controller;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDate;

public class GenerateVoucherCodeRequest {

    private final String offerName;

    private final LocalDate expirationDate;

    public GenerateVoucherCodeRequest(@JsonProperty("offerName") final String offerName, @JsonProperty("expirationDate") final LocalDate expirationDate) {

        this.offerName = offerName;
        this.expirationDate = expirationDate;
    }

    public String getOfferName() {
        return offerName;
    }

    public LocalDate getExpirationDate() {
        return expirationDate;
    }
}
