package calculator;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class BasicCalculatorTest {

    private static final BasicCalculator BASIC_CALCULATOR = new BasicCalculator(3, 5);

    @Test
    public void shouldReturnCorrectResult() {

        assertThat(BASIC_CALCULATOR.calculate(), is(3));

    }

}