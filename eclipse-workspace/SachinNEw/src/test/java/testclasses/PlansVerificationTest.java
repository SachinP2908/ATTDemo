package testclasses;

import org.testng.Assert;
import org.testng.annotations.Test;

import extendlisteners.Listners;

public class PlansVerificationTest extends Listners {

	@Test(priority = 1)
	public void buyOnlinePlans() {
//		bop.manage_iframe();
		test.info("selecting the insurance");
		bop.onlinPlans();
		test.info("selected the insurance as ");
	}

	@Test(priority = 2)
	public void verifyURL() {
		test.info("verifying url");
		String actualURL = bop.verifyUrl();
		String expectedURL = "insurance";
		boolean ispresent = actualURL.contains(expectedURL);
		Assert.assertTrue(ispresent);
//       Assert.fail("delibratly fail to check screenshot");
	}
}
