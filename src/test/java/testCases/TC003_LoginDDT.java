package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testbase.BaseClass;
import utilities.DataProviders;
//valid data -----  loginsucess ---- test passed ---logout
		 //                   loginfailed----- test failed

		 // invalid data -----loginsucess-----  test failed ---logout
		 //                    loginfailed ----- test passed
public class TC003_LoginDDT extends BaseClass{
	@Test(dataProvider="Logindata",dataProviderClass=DataProviders.class,groups="DataDriven")
	public void verifylogindata(String loginemail, String loginpwd,String lnexp)
	{
		logger.info("****started****");
		try{// home page
		HomePage hp = new HomePage(driver);
		hp.clickmyaccount();
		hp.clickmylogin();
		//Thread.sleep(3000);
		// Loginpage
		LoginPage lp = new LoginPage(driver);
		lp.setloginemail(loginemail);
		lp.setloginpwd(loginpwd);
		lp.clickloginbtn();
		//my account page
		 MyAccountPage map = new MyAccountPage(driver);
		boolean targetpage = map.ismypageexist();

		if(lnexp.equalsIgnoreCase("valid"))

		{
			if(targetpage==true)
			{
				map.clickmylogout();
				Assert.assertTrue(true);
			}
			else
			{
				Assert.assertTrue(false);
			}
		}

		 if (lnexp.equalsIgnoreCase("invalid"))

		 {
			 if(targetpage==true)
			 {
				 map.clickmylogout();
				 Assert.assertTrue(false);
			 }
			 else
			 {
				 Assert.assertTrue(true);
			 }


		 }

		}
		catch(Exception e)
		{
			Assert.fail();
		}

		 logger.info("***finished***");




	}




}
