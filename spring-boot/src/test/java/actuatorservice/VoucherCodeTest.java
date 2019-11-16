package actuatorservice;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.time.LocalDate;

public class VoucherCodeTest {

    private static final VoucherCode VOUCHER_CODE = new VoucherCode("12345678", new Recipient("Kevin de Bruyne", "kevindebruyne@mancity.com"),
            new Offer("Kevin de Bruyne", 0.2d), LocalDate.of(2019, 11, 1));

    @Test
    public void gettersShouldReturnCorrectResults() {

        final String randomCode = "12345678";
        final String recipientName = "Kevin de Bruyne";
        final String email = "kevindebruyne@mancity.com";

        final double percentageDiscount = 0.2d;

        final LocalDate novemberFirstTwentyNineteen = LocalDate.of(2019, 11, 1);

        assertThat(VOUCHER_CODE.getRandomCode(), is(randomCode));

        assertThat(VOUCHER_CODE.getRecipient().getName(), is(recipientName));
        assertThat(VOUCHER_CODE.getRecipient().getEmail(), is(email));

        assertThat(VOUCHER_CODE.getOffer().getName(), is(recipientName));
        assertThat(VOUCHER_CODE.getOffer().getPercentageDiscount(), is(percentageDiscount));

        assertThat(VOUCHER_CODE.getExpiryDate(), is(novemberFirstTwentyNineteen));

    }

}
