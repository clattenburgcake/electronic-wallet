package actuatorservice.domain;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import actuatorservice.domain.Offer;
import org.junit.Test;

public class OfferTest {

    private static final Offer OFFER = new Offer("Kevin de Bruyne", 0.2d);

    @Test
    public void gettersShouldReturnCorrectResults() {

        final String name = "Kevin de Bruyne";
        final double percentageDiscount = 0.2d;

        assertThat(OFFER.getName(), is(name));
        assertThat(OFFER.getPercentageDiscount(), is(percentageDiscount));

    }

}
