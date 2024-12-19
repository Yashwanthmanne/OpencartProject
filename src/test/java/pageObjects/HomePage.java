package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

	public HomePage(WebDriver driver) {
		super(driver);

	}

	//locators
	@FindBy(xpath="//span[normalize-space()='My Account']")
	WebElement myaccount;

	@FindBy(xpath="//a[normalize-space()='Register']")
	WebElement Register;
	
	@FindBy(xpath="//a[text()='Login']")
	WebElement login;

// action methods

public void clickmyaccount()
{
	myaccount.click();

}
public void clickmyregister()
{
     Register.click();


}
public void clickmylogin()
{
login.click();	
}











}