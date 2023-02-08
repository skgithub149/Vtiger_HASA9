package testForListener;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import genericLibraries.BaseClass;

@Listeners(genericLibraries.ListenerImplementation.class)
public class Test2 extends BaseClass {
	
	@Test
	public void test2() {
		System.out.println("Test2");
		//Assert.fail();
	}

}
