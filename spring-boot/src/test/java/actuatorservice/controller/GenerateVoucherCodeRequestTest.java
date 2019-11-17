package actuatorservice.controller;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.time.LocalDate;

import static java.time.LocalDate.*;

public class GenerateVoucherCodeRequestTest {

    private static final GenerateVoucherCodeRequest VOUCHER_CODE_REQUEST = new GenerateVoucherCodeRequest("BOGOF", of(2019, 10, 31));

    @Test
    public void gettersShouldReturnCorrectResults() {

        final String bogof = "BOGOF";
        final LocalDate expirationDate = LocalDate.of(2019, 10, 31);

        assertThat(VOUCHER_CODE_REQUEST.getOfferName(), is(bogof));
        assertThat(VOUCHER_CODE_REQUEST.getExpirationDate(), is(expirationDate));

    }

}
