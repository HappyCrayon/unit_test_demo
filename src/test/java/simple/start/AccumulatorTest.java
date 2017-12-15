package simple.start;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class AccumulatorTest {

    private Accumulator accumulator;

    @Test
    public void should_get_500500_when_arg_1000() throws Exception {
        final int result = accumulator.accumulate(1000);
        assertThat(result).isEqualTo(500500);
    }

    @Test
    public void should_get_1_when_arg_is_1() throws Exception {
        final int result = accumulator.accumulate(1);
        assertThat(result).isEqualTo(1);
    }

    @Test(expected = NumberOutOfBoundException.class)
    public void should_throw_outofbould_exception_when_arg_is_1001() throws Exception {
        accumulator.accumulate(1001);
    }

    @Test(expected = NumberOutOfBoundException.class)
    public void should_throw_exception_when_arg_1() throws Exception {
        accumulator.accumulate(-1);
    }



    @Before
    public void setUp() throws Exception {
        accumulator = new Accumulator();
    }
}