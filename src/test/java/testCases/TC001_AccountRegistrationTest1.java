package testCases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testbase.BaseClass;

public class TC001_AccountRegistrationTest1 extends BaseClass{
	@Test(groups={"Regression","Master"})
	public void accountregestrationtest()
	 {
		logger.info("starting");
		try {
		HomePage hp = new HomePage(driver);
		hp.clickmyaccount();
		logger.info("cliked my account");
		hp.clickmyregister();
        logger.info("clickedmyregister");
        logger.info("providing details");
		AccountRegistrationPage acp = new AccountRegistrationPage(driver);
		acp.setfirstname(randomename().toUpperCase());
		acp.setlastname(randomename().toUpperCase());
		 acp.setemail(randomename()+"@gmail.com");
		 acp.setphone(randomenumber());

		 String pwd = alphanumeric();
		 acp.setpassword(pwd);
		 acp.setconfirm(pwd);
		 acp.clickmycheckbox();
		 acp.clickmybtn();
		 String valid=acp.getconfirmmsg();
		 if (valid.equals("Your Account Has Been Created!!"))
		 {
			Assert.assertTrue(true); 
		 }
		 else
		 {
			 logger.error("test failed");
			 logger.debug("debug fail");
		 }
		 
		 Assert.assertEquals(valid,"Your Account Has Been Created!");
		}
		catch(Exception e)
		{
		Assert.fail();
		}
		logger.info("ending");
	 }
}
