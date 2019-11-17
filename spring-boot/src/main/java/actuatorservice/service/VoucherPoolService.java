package actuatorservice.service;

import actuatorservice.domain.Offer;
import actuatorservice.domain.VoucherCode;

import java.time.LocalDate;
import java.util.Optional;
import java.util.Set;

public interface VoucherPoolService {

    Set<VoucherCode> generateVoucherCodes (final String offerName, final LocalDate expirationDate);

    Optional<Offer> getOffer (final String offerName, final LocalDate expiryDate, final String email);

    Set<VoucherCode> getVoucherCodes (final String email, final boolean includeExpired);

    void redeemVoucherCode (final String voucherCode);
}
