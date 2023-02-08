package testForListener;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import genericLibraries.BaseClass;

//@Listeners(genericLibraries.ListenerImplementation.class)
public class Test1 extends BaseClass {
	
	@Test
	public void test1() {
		System.out.println("Test1");
		//Assert.fail();
	}

}
