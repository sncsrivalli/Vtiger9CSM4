package listenersTestng;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(listenersTestng.ListenerImplementation.class)
public class TestClass extends BaseClass {

	@Test
	public void testMethod1() {
		System.out.println("Test1");
		Assert.fail();
	}
	
	@Test(dependsOnMethods = "testMethod1")
	public void testMethod2() {
		System.out.println("Test2");
	}
}
