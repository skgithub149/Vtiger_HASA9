package iRetryAnalyzer;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Test1 {
	
	@Test
	public void test1() {
		System.out.println("Test1");
		Assert.fail();
	}

}
