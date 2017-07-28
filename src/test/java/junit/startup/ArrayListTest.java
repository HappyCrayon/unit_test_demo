package junit.startup;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertSame;

public class ArrayListTest {


    @Test
    public void get_should_get_the_obj_when_added() throws Exception {
        final ArrayList<Object> objects = new ArrayList<>();

        final Object e = new Object();
        objects.add(e);

        final Object obj = objects.get(0);

        assertSame(e,obj);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void get_should_throw_exception() throws Exception {
        final ArrayList<Object> list = new ArrayList<>();

        list.get(0);
    }
}
