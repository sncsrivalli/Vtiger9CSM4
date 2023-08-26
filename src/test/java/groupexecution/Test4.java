package groupexecution;

import org.testng.annotations.Test;

public class Test4 {

	@Test
	public void demo1() {
		System.out.println("Test4 - demo1");
	}
	
	@Test(groups = {"regression", "smoke", "functional", "system"})
	public void demo2() {
		System.out.println("Test4 - demo2 - regression and smoke and functional and system");
	}
	
	@Test(groups = {"system", "regression", "functional"})
	public void demo3() {
		System.out.println("Test4 - demo3 - system and regression and functional");
	}
}
