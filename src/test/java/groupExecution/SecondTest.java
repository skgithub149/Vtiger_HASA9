package groupExecution;

import org.testng.annotations.Test;

public class SecondTest {
	
	@Test(groups = "Sanity")
	public void test0() {
		System.out.println("test0");
	}
	
	@Test(groups = "Regression")
	public void test1() {
		System.out.println("test1");
	}
	
	@Test(groups = {"Sanity","Regression"})
	public void test2() {
		System.out.println("test2");
	}
}
