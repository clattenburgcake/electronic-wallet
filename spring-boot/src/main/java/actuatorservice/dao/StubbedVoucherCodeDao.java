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

@Component
public class StubbedVoucherCodeDao implements VoucherCodeDao {

    private final Set<Recipient> recipients = new HashSet<>();
    private final Set<VoucherCode> voucherCodes = new HashSet<>();
    private final Set<Offer> offers = new HashSet<>();


    public StubbedVoucherCodeDao() {

        // Dummy Recipient Data
        this.recipients.add(new Recipient("Kevin de Bruyne","kevindebruyne@mancity.com" ));
        this.recipients.add(new Recipient("Mo Salah","mosalah@liverpool.com" ));
        this.recipients.add(new Recipient("Sadio Mane","sadiomane@liverpool.com" ));

        // Dummy Offer Data
        offers.add(new Offer("BOGOF", 50.00));
        offers.add(new Offer("TEN PERCENT", 10.00));
        offers.add(new Offer("TWENTY PERCENT", 20.00));

        // Generate Voucher Codes
        for (Recipient recipient : recipients) {

            for (Offer offer : offers) {

                this.voucherCodes.add(new VoucherCode(UUID.randomUUID().toString(), recipient, offer, LocalDate.now()));
            }
        }

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
}
