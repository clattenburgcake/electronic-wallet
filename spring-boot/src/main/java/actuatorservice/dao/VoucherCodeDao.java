package actuatorservice.dao;

import actuatorservice.Offer;

import java.time.LocalDate;
import java.util.Optional;

public interface VoucherCodeDao {

    Optional<Offer> getOffer (final String offerName, final LocalDate expiryDate, final String email);
}
