package unit.simple;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class AccumulatorTest {

    private Accumulator accumulator;

    @Before
    public void setUp() throws Exception {
        accumulator = new Accumulator();
    }

    @Test
    public void should_get_0_when_input_0() throws Exception {


        final int result = accumulator.accumulate(0);

        assertEquals(0,result);
    }

    @Test
    public void should_get_500500_when_input_10000() throws Exception {

    }
}