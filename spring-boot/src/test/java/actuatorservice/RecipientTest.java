package actuatorservice;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class RecipientTest {

    private static final Recipient RECIPIENT = new Recipient("Kevin de Bruyne", "kevindebruyne@mancity.com");

    @Test
    public void gettersShouldReturnCorrectResults() {

        final String name = "Kevin de Bruyne";
        final String email = "kevindebruyne@mancity.com";

        assertThat(RECIPIENT.getName(), is(name));
        assertThat(RECIPIENT.getEmail(),is(email));

    }
}
