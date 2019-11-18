package actuatorservice.dao;

import actuatorservice.domain.Offer;
import actuatorservice.domain.Recipient;
import actuatorservice.domain.VoucherCode;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

@Component
public class StubbedVoucherCodeDao implements VoucherCodeDao {

    private final Set<Recipient> recipients = new HashSet<>();
    private final Set<VoucherCode> voucherCodes = new HashSet<>();
    private final Set<Offer> offers = new HashSet<>();


    public StubbedVoucherCodeDao() {

        // Dummy Recipient Data
        this.recipients.add(new Recipient("Kevin de Bruyne", "kevindebruyne@mancity.com"));
        this.recipients.add(new Recipient("Mo Salah", "mosalah@liverpool.com"));
        this.recipients.add(new Recipient("Sadio Mane", "sadiomane@liverpool.com"));

        // Dummy Offer Data
        offers.add(new Offer("BOGOF", 50.00));
        offers.add(new Offer("TEN PERCENT", 10.00));
        offers.add(new Offer("TWENTY PERCENT", 20.00));

    }

    @Override
    public Set<VoucherCode> generateVoucherCodes(final String offerName, final LocalDate expirationDate) {

        final Set<VoucherCode> generatedVoucherCodes = new HashSet<>();

        for (Recipient recipient : recipients) {

            offers.stream().
                    filter(offer -> offer.getName().equals(offerName))
                    .map(offer -> new VoucherCode(UUID.randomUUID().toString(), recipient, offer, expirationDate))
                    .forEach(generatedVoucherCodes::add);
        }

        this.voucherCodes.addAll(generatedVoucherCodes);

        return generatedVoucherCodes;
    }

    @Override
    public Optional<Offer> getOffer(final String offerName, final LocalDate expiryDate, final String email) {

        return this.voucherCodes.stream()
                .filter(voucherCode -> voucherCode.getOffer().getName().equals(offerName))
                .filter(voucherCode -> voucherCode.getRecipient().getEmail().equals(email))
                .filter(voucherCode -> voucherCode.getExpiryDate().isAfter(expiryDate))
                .filter(voucherCode -> !voucherCode.getDateRedeemed().isPresent())
                .map(vc -> vc.getOffer())
                .findFirst();
    }

    @Override
    public Set<VoucherCode> getValidVoucherCodes(final String email) {

        return this.voucherCodes.stream()
                .filter(voucherCode -> voucherCode.getRecipient().getEmail().equals(email))
                .filter(voucherCode -> voucherCode.getExpiryDate().isAfter(LocalDate.now()))
                .filter(voucherCode -> !voucherCode.getDateRedeemed().isPresent())
                .collect(Collectors.toSet());
    }

    @Override
    public Set<VoucherCode> getAllVoucherCodes(final String email) {

        return this.voucherCodes.stream()
                .filter(voucherCode -> voucherCode.getRecipient().getEmail().equals(email))
                .collect(Collectors.toSet());
    }

    @Override
    public void redeemVoucherCode(final String voucherCodeUUID) {

        this.voucherCodes.stream().filter(voucherCode -> voucherCode.getUuid().equals(voucherCodeUUID))
                .forEach(voucherCode -> voucherCode.redeem());

    }

}
