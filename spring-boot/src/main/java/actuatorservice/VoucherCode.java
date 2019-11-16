package actuatorservice;

import java.time.LocalDate;
import java.util.Optional;
import java.util.UUID;

public class VoucherCode {

    private Recipient recipient;
    private Offer offer;
    private LocalDate expiryDate;
    private String randomCode;
    private LocalDate dateRedeemed;

    public VoucherCode(String randomCode, Recipient recipient, Offer offer, LocalDate expiryDate) {

        this.recipient = recipient;
        this.offer = offer;
        this.expiryDate = expiryDate;
        this.randomCode = randomCode;
    }

    public Recipient getRecipient() {
        return this.recipient;
    }

    public Offer getOffer() {
        return this.offer;
    }

    public LocalDate getExpiryDate() {
        return this.expiryDate;
    }

    public String getRandomCode() {
        return this.randomCode;
    }

    public Optional<LocalDate> rgetDateRedeemed() {
        return Optional.ofNullable(dateRedeemed);
    }
}
