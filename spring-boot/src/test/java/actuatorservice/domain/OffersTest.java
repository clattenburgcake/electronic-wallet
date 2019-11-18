package actuatorservice.domain;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

import java.io.File;

import static java.nio.charset.Charset.defaultCharset;
import static java.util.Arrays.asList;
import static org.apache.commons.io.FileUtils.readFileToString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;


public class OffersTest {

    private static final Offers OFFERS = new Offers(asList(new Offer("BOGOF", 50.00d),
            new Offer("TEN PERCENT", 10.0d), new Offer("TWENTY PERCENT", 20.00d)));

    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    @Test
    public void gettersShouldReturnCorrectResults() {

        final String offerOne = "BOGOF";
        final String offerTwo = "TEN PERCENT";
        final String offerThree = "TWENTY PERCENT";

        final Offer bogof = OFFERS.getOffers().get(0);
        assertThat(bogof.getName(), is(offerOne));
        assertThat(bogof.getPercentageDiscount(), is(50.0d));
        final Offer tenPercent = OFFERS.getOffers().get(1);
        assertThat(tenPercent.getName(), is(offerTwo));
        assertThat(tenPercent.getPercentageDiscount(), is(10.0d));

        final Offer twentyPercent = OFFERS.getOffers().get(2);
        assertThat(twentyPercent.getName(), is(offerThree));
        assertThat(twentyPercent.getPercentageDiscount(), is(20.0d));

    }

    @Test
    public void shouldUnmarshallCorrectly() throws Exception {

        final String json = readFileToString(new File("src/main/resources/offers.json"),
                defaultCharset());

        final Offers expected = OBJECT_MAPPER.readValue(json, Offers.class);

        final String actualString = OFFERS.toString();
        final String expectedString = expected.toString();

        assertThat(actualString, is(expectedString));

    }

}