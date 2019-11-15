package actuatorservice;

import java.time.LocalDate;

public class VoucherCode {

    private Recipient recipient;
    private Offer offer;
    private LocalDate expiryDate;
    private long randomCode;

    public VoucherCode(long randomCode, Recipient recipient, Offer offer, LocalDate expiryDate) {

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

    public long getRandomCode() {
        return this.randomCode;
    }
}
