package groupexecution;

import org.testng.annotations.Test;

public class Test3 {

	@Test(groups = "system")
	public void demo1() {
		System.out.println("Test3 - demo1 - system");
	}
	
	@Test(groups = "regression")
	public void demo2() {
		System.out.println("Test3 - demo2 - regression");
	}
	
	@Test(groups = {"system", "regression"})
	public void demo3() {
		System.out.println("Test3 - demo3 - system and regression");
	}
}
