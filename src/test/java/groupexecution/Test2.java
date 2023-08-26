package groupexecution;

import org.testng.annotations.Test;

public class Test2 {

	@Test(groups = "functional")
	public void demo1() {
		System.out.println("Test2 - demo1 - functional");
	}
	
	@Test(groups = "regression")
	public void demo2() {
		System.out.println("Test2 - demo2 - regression");
	}
	
	@Test(groups = {"functional", "regression"})
	public void demo3() {
		System.out.println("Test2 - demo3 - functional and regression");
	}
}
