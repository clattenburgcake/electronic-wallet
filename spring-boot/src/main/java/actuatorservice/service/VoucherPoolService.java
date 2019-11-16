package actuatorservice.service;

import actuatorservice.Offer;
import actuatorservice.VoucherCode;

import java.time.LocalDate;
import java.util.Optional;
import java.util.Set;

public interface VoucherPoolService {

    Set<VoucherCode> generateVoucherCodes (final String offerName, final LocalDate expirationDate);

    Optional<Offer> getOffer (final String offerName, final LocalDate expiryDate, final String email);

    Set<VoucherCode> getVoucherCodes (final String email);

    void redeemVoucherCode (final String voucherCode);
}
