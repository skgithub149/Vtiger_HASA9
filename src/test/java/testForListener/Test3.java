package testForListener;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import genericLibraries.BaseClass;

@Listeners(genericLibraries.ListenerImplementation.class)
public class Test3 extends BaseClass {
	
	@Test
	public void test3() {
		System.out.println("Test3");
		//Assert.fail();
	}

}
