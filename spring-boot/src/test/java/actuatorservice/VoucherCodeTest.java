package actuatorservice;

import org.junit.Test;

import java.time.LocalDate;

public class VoucherCodeTest {

    private static final VoucherCode VOUCHER_CODE = new VoucherCode(12345678, new Recipient("Kevin de Bruyne","kevindebruyne@mancity.com"),
            new Offer("Kevin de Bruyne",0.2d), LocalDate.now());

    @Test
    public void gettersShouldReturnCorrectResults() {

    }
}
