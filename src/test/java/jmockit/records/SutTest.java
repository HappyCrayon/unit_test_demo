package jmockit.records;

import mockit.Expectations;
import mockit.Mocked;
import mockit.Tested;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Yonggao.Dong on 16/9/14.
 */
public class SutTest {


    @Tested
    Sut sut;

    @Test
    public void should_get_abexception(@Mocked final DependencyAbc dependencyAbc) throws Exception {
        new Expectations(){{

            dependencyAbc.intReturningMethod();returns(3);
            dependencyAbc.stringReturningMethod();returns("a","b");result=new SomeCheckedException();

        }};

        String s = sut.doSomething();

        assertEquals("abexception",s);
    }
}