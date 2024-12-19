package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{

	public LoginPage(WebDriver driver) {
		super(driver);
	}
		
 //locators 
		
    @FindBy(xpath="//input[@name='email']")
    WebElement txtloginemail;
		
		
    @FindBy(xpath="//input[@name='password']")
    WebElement txtloginpwd;
    
    @FindBy(xpath="//input[@type='submit'and@class='btn btn-primary']")
    WebElement loginbtn;
    
    // action methods
    
      public void setloginemail(String loginemail)
      {
      txtloginemail.sendKeys(loginemail);
    
		
      }
		
      public void setloginpwd(String loginpwd)
      {
      txtloginpwd.sendKeys(loginpwd);
    
		
      }
      
      public void clickloginbtn()
      {
      loginbtn.click();
    
		
      }

}
