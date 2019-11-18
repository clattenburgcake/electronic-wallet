package actuatorservice.dao;

import actuatorservice.domain.Offer;
import actuatorservice.domain.VoucherCode;

import java.time.LocalDate;
import java.util.Optional;
import java.util.Set;

public interface VoucherCodeDao {

    Set<VoucherCode> generateVoucherCodes (final String offerName, final LocalDate expirationDate);

    Optional<Offer> getOffer (final String offerName, final LocalDate expiryDate, final String email);

    Set<VoucherCode> getValidVoucherCodes(final String email);

    Set<VoucherCode> getAllVoucherCodes(final String email);

    void redeemVoucherCode (final String voucherCode);
}
