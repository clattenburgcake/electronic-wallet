package actuatorservice;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.time.LocalDate;
import java.util.Optional;

import static org.apache.commons.lang3.builder.ToStringStyle.*;

public class VoucherCode {

    private Recipient recipient;
    private Offer offer;
    private LocalDate expiryDate;
    private String uuid;
    private LocalDate dateRedeemed;

    public VoucherCode(String uuid, Recipient recipient, Offer offer, LocalDate expiryDate) {

        this.recipient = recipient;
        this.offer = offer;
        this.expiryDate = expiryDate;
        this.uuid = uuid;
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

    public String getUuid() {
        return this.uuid;
    }

    public Optional<LocalDate> getDateRedeemed() {
        return Optional.ofNullable(dateRedeemed);
    }

    public void redeem() {

        this.dateRedeemed = LocalDate.now();

    }

    @Override
    public String toString() {

        return new ToStringBuilder(this, JSON_STYLE)
                .append("recipient", recipient)
                .append("offer", offer)
                .append("expiryDate", expiryDate)
                .append("uuid", uuid)
                .toString();
    }
}
