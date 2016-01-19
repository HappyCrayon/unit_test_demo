package junit.startup;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

public class ArrayListTest {
	private List<Object>  list ;
	
	@Before
	public void init(){
		list = new ArrayList<Object>();
	}
	
	@Test
	public void should_contains_the_item_after_add_it(){
		Object obj = new Object();
		
		list.add(obj);
		
		assertEquals("size should be 1 after add an item",1,list.size());
		assertTrue(list.contains(obj));
		assertSame(obj,list.get(0));
	}
	
	@Test
	public void item_should_be_removed_after_call_remove(){
		Object obj = new Object();
		list.add(obj);
		
		list.remove(0);
		
		assertEquals(0,list.size());
		assertFalse(list.contains(obj));
	
	}

	@Test
	public void show_assert_that(){
		String[] strArra={"some","sample","just","like","this"};

		List<String> list = Arrays.asList(strArra);

		assertThat(list,hasItem("like"));

//		both(hasItem("like")).and(not(hasItem("a")));

		assertThat(list,hasItem("this"));


		assertThat("list 应该有'this' 和 'like' 元素",list,both(hasItem("like")).and(hasItem("this")));
		assertThat("list 应该有'like','this','just' 元素",list,allOf(hasItem("like"),hasItem("this"),hasItem("just")));

//		下面示例自定义 Matcher :
//		assertThat(list, new BaseMatcher(){
//
//			public boolean matches(Object arg0) {
//				List<String> myList = (List) arg0;
//				for(String item:myList){
//					if("like".equals(item))
//						return true;
//				}
//				return false;
//
//			}
//
//			public void describeTo(Description arg0) {
//				arg0.appendText("list should contain specified item");
//			}
//
//		});

	}

}
