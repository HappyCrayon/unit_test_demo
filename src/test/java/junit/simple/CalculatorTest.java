package junit.simple;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CalculatorTest {

    private Calculator calculator;

    @Before
    public void setUp() throws Exception {
        calculator = new Calculator();
    }

    @Test
    public void shoul_return_0_if_input_empty_string() throws Exception {

        final String result = calculator.add("");

        assertThat(result).isEqualTo("0");
    }

    @Test
    public void should_return_1_when_input_is_1() throws Exception {
        final String result = calculator.add("1");
        assertThat(result).isEqualTo("1");
    }

    @Test
    public void should_return_11_when_input_is_11() throws Exception {
        final String result = calculator.add("11");
        assertThat(result).isEqualTo("11");
    }

    @Test
    public void should_get_9_when_input_3comma6() throws Exception {
        final String result = calculator.add("3,6");
        assertThat(result).isEqualTo("9");
    }

    @Test
    public void should_get_3_when_input_1_comma_2() throws Exception {
        final String result = calculator.add("1,2");

        assertThat(result).isEqualTo("3");
    }

    @Test
    public void should_get_8_when_input_1comma2comma_5() throws Exception {
        final String add = calculator.add("1,2,5");
        assertThat(add).isEqualTo("8");
    }
}
