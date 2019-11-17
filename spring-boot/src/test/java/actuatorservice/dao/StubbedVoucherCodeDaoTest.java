package actuatorservice.dao;

import actuatorservice.domain.VoucherCode;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class StubbedVoucherCodeDaoTest {

    private static final VoucherCodeDao VOUCHER_CODE_DAO = new StubbedVoucherCodeDao();

    @Test
    public void gettersShouldReturnCorrectResultsIfOfferExists() {

        VOUCHER_CODE_DAO.generateVoucherCodes("BOGOF",LocalDate.of(2019,10,31));

        final List<VoucherCode> voucherCodeKdb = new ArrayList<>(VOUCHER_CODE_DAO.getAllVoucherCodes("kevindebruyne@mancity.com"));
        final List<VoucherCode> voucherCodeMoSalah = new ArrayList<>(VOUCHER_CODE_DAO.getAllVoucherCodes("mosalah@liverpool.com"));
        final List<VoucherCode> voucherCodeSadioMane = new ArrayList<>(VOUCHER_CODE_DAO.getAllVoucherCodes("sadiomane@liverpool.com"));

        assertThat(voucherCodeKdb.size(), is(1));
        assertThat(voucherCodeMoSalah.size(), is(1));
        assertThat(voucherCodeSadioMane.size(), is(1));

    }

    @Test
    public void gettersShouldReturnCorrectResultsIfNoOfferExists(){

        VOUCHER_CODE_DAO.generateVoucherCodes("November Sales",LocalDate.of(2019,11,30));

        final List<VoucherCode> voucherCodeKdb = new ArrayList<>(VOUCHER_CODE_DAO.getAllVoucherCodes("kevindebruyne@mancity.com"));
        final List<VoucherCode> voucherCodeMoSalah = new ArrayList<>(VOUCHER_CODE_DAO.getAllVoucherCodes("mosalah@liverpool.com"));
        final List<VoucherCode> voucherCodeSadioMane = new ArrayList<>(VOUCHER_CODE_DAO.getAllVoucherCodes("sadiomane@liverpool.com"));

        assertThat(voucherCodeKdb.size(),is(0));
        assertThat(voucherCodeMoSalah.size(), is(0));
        assertThat(voucherCodeSadioMane.size(), is(0));

    }



}
