package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testbase.BaseClass;

public class TC002_LoginTest extends BaseClass {
	
	@Test(groups= {"Sanity","Master"})
	public void verifylogin()
	{
		
			logger.info("***starting***");
			try {
		HomePage hp = new HomePage(driver);
		hp.clickmyaccount();
		hp.clickmylogin();
		
		LoginPage lp = new LoginPage(driver);
		lp.setloginemail(p.getProperty("email"));
		lp.setloginpwd(p.getProperty("password"));
		lp.clickloginbtn();
		Thread.sleep(3000);
		
		MyAccountPage map= new MyAccountPage(driver);
		
		boolean  targetfile =map.ismypageexist();
		Assert.assertEquals(targetfile,true,"login failed");
		Assert.assertTrue(targetfile);
		
		}
		catch (Exception e)
		{
		Assert.fail();	
		}
		
		
		       logger.info("***ending***");
		
	}
	

	
	
	
	
	
	
	
	
	

}
