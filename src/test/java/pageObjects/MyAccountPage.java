package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends BasePage{

	public MyAccountPage(WebDriver driver) {
		super(driver);
		
	}
	
	//locators 
	
	@FindBy(xpath="//h2[text()='My Account']")
	WebElement myaccountheading;
	
	@FindBy(xpath="//div[@class='list-group']/a[13]")
	WebElement logout;
	
	
	
	// action methods
	
	public boolean ismypageexist()
	
	{
		try {
			
		 return myaccountheading.isDisplayed();
		
		}
		catch(Exception e)
		{
			return false;	
		}
		
		
		
		
		
	}
	
	
	public void clickmylogout()
	{
		logout.click();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
