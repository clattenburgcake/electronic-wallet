package actuatorservice.domain;


import actuatorservice.domain.Recipient;
import actuatorservice.domain.Recipients;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

import java.io.File;
import java.util.List;

import static java.nio.charset.Charset.defaultCharset;
import static org.apache.commons.io.FileUtils.readFileToString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static java.util.Arrays.*;

public class RecipientsTest {

    private static final Recipients RECIPIENTS = new Recipients(asList(new Recipient("Kevin de Bruyne", "kevindebruyne@mancity.com"),
            new Recipient("Mo Salah", "mosalah@liverpool.com"),
            new Recipient("Sadio Mane", "sadiomane@liverpool.com")));

    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    @Test
    public void gettersShouldReturnCorrectResults() {

        final String recipientOneName = "Kevin de Bruyne";
        final String recipientOneEmail = "kevindebruyne@mancity.com";

        final String recipientTwoName = "Mo Salah";
        final String recipientTwoEmail = "mosalah@liverpool.com";

        final String recipientThreeName = "Sadio Mane";
        final String recipientThreeEmail = "sadiomane@liverpool.com";

        final List<Recipient> recipients = RECIPIENTS.getRecipients();

        final Recipient recipientOne = recipients.get(0);
        assertThat(recipientOne.getName(), is(recipientOneName));
        assertThat(recipientOne.getEmail(), is(recipientOneEmail));

        final Recipient recipientTwo = recipients.get(1);
        assertThat(recipientTwo.getName(), is(recipientTwoName));
        assertThat(recipientTwo.getEmail(), is(recipientTwoEmail));

        final Recipient recipientThree = recipients.get(2);
        assertThat(recipientThree.getName(), is(recipientThreeName));
        assertThat(recipientThree.getEmail(), is(recipientThreeEmail));

    }

    @Test
    public void shouldUnmarshallCorrectly() throws Exception {

        final String json = readFileToString(new File("src/main/resources/recipients.json"),
                defaultCharset());

        final Recipients expectedRecipients = OBJECT_MAPPER.readValue(json, Recipients.class);

        final String actual = RECIPIENTS.toString();
        final String expected = expectedRecipients.toString();

        assertThat(actual, is(expected));

    }

}