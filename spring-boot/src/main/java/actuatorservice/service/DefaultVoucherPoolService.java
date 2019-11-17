package actuatorservice.service;

import actuatorservice.domain.Offer;
import actuatorservice.domain.VoucherCode;
import actuatorservice.dao.VoucherCodeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Optional;
import java.util.Set;

@Component
public class DefaultVoucherPoolService implements VoucherPoolService {

    private final VoucherCodeDao voucherCodeDao;

    @Autowired
    public DefaultVoucherPoolService(final VoucherCodeDao voucherCodeDao) {

        this.voucherCodeDao = voucherCodeDao;
    }


    @Override
    public Set<VoucherCode> generateVoucherCodes(final String offerName, final LocalDate expirationDate) {

        return voucherCodeDao.generateVoucherCodes(offerName, expirationDate);
    }

    @Override
    public Optional<Offer> getOffer(final String offerName, final LocalDate expiryDate, final String email) {

        return voucherCodeDao.getOffer(offerName, expiryDate, email);
    }

    @Override
    public Set<VoucherCode> getVoucherCodes(final String email, final boolean includeExpired) {

        if (includeExpired) {

            return voucherCodeDao.getAllVoucherCodes(email);

        } else {

            return voucherCodeDao.getValidVoucherCodes(email);
        }
    }

    @Override
    public void redeemVoucherCode(final String voucherCode) {

        voucherCodeDao.redeemVoucherCode(voucherCode);
    }
}
