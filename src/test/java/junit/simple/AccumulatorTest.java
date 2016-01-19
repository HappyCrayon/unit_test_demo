package junit.simple;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AccumulatorTest {
	Accumulator acc;

	@Before
	public void init(){
		acc = new Accumulator();
	}


	@Test
	public void should_retrun_1_if_input_is_1() throws NumberOutOfBoundException {


		int result = acc.accumulate(1);
		
		assertEquals("结果应该是1",1,result);
		
	}
	
	@Test
	public void should_return_5050_if_input_is_100() throws NumberOutOfBoundException{

		int result = acc.accumulate(100);
		
		assertEquals("结果应该是5050",5050,result);
	}

	@Test(expected=NumberOutOfBoundException.class)
	public void should_throw_Exception_if_input_is_10001() throws NumberOutOfBoundException{


		acc.accumulate(10001);



		
	}
	

}
