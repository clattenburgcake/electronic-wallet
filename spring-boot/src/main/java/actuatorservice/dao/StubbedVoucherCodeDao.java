package actuatorservice.dao;

import actuatorservice.Offer;
import actuatorservice.Recipient;
import actuatorservice.VoucherCode;
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
    public Set<VoucherCode> generateVoucherCode(String offerName, LocalDate expirationDate) {

        final Set<VoucherCode> generatedVoucherCodes = new HashSet<>();

        // Generate Voucher Codes
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
                .filter(vc -> vc.getOffer().getName().equals(offerName))
                .filter(vc -> vc.getRecipient().getEmail().equals(email))
                .filter(vc -> vc.getExpiryDate().isBefore(expiryDate))
                .filter(vc -> !vc.rgetDateRedeemed().isPresent())
                .map(vc -> vc.getOffer())
                .findFirst();
    }

    @Override
    public Set<VoucherCode> getVoucherCodes(String email) {

        return this.voucherCodes.stream()
                .filter(vc -> vc.getRecipient().getEmail().equals(email))
                .filter(vc -> vc.getExpiryDate().isBefore(LocalDate.now()))
                .filter(vc -> !vc.rgetDateRedeemed().isPresent())
                .collect(Collectors.toSet());
    }


}
