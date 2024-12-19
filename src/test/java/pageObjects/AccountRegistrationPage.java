package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountRegistrationPage extends BasePage{

	public AccountRegistrationPage(WebDriver driver) {
		super(driver);

	}//locators

	@FindBy(xpath="//input[@id='input-firstname']")

	WebElement txtfirname;

	@FindBy(xpath="//input[@id='input-lastname']")

	WebElement txtlaname;

   @FindBy(xpath="//input[@id='input-email']")

	WebElement txtemail;


    @FindBy(xpath="//input[@id='input-telephone']")

    WebElement txtphone;


    @FindBy(xpath="//input[@id='input-password']")

	WebElement txtpwd;

    @FindBy(xpath="//input[@id='input-confirm']")

	WebElement txtconpwd;


    @FindBy(xpath="//input[@name='agree']")

	WebElement chpolicy;


    @FindBy(xpath="//input[@value='Continue']")

	WebElement btcontinue;

    @FindBy(xpath="//h1[normalize-space()='Your Account Has Been Created!']")

	WebElement msgconfig;

    // action methods
    public void setfirstname(String fname)
    {
    	txtfirname.sendKeys(fname);
    }
    public void setlastname(String lname)
    {
    	txtlaname.sendKeys(lname);
    }

    public void setemail(String email)
    {
    	txtemail.sendKeys(email);
    }

    public void setphone(String phone)
    {
    	txtphone.sendKeys(phone);
    }

    public void setpassword(String pwd)
    {
    	txtpwd.sendKeys(pwd);
    }
    public void setconfirm(String cpwd)
    {
    	txtconpwd.sendKeys(cpwd);
    }

    public void clickmycheckbox()
    {
    	chpolicy.click();
    }

    public void clickmybtn()
    {
    	btcontinue.click();

    	//sol2
    	//btcontinue.submit();
    	//sol3
    	//Actions act = new Actions(driver);
    	//act.moveToElement(btcontinue).build().perform();
    	//sol4
    	//JavascriptExecutor js = (JavascriptExecutor)driver;
    	//js.executeScript("arguments[0].click();",btcontinue);
    	// sol5
    	//btcontinue.sendKeys(Keys.RETURN);
    	//sol6
    	//WebDriverWait mywait = new WebDriverWait(driver, Duration.ofSeconds(20));
    	//mywait.until(ExpectedConditions.elementToBeClickable(btcontinue)).click();
    }

    public String getconfirmmsg()
    {
    try {
     return 	msgconfig.getText();
    }catch(Exception e)
    {
     return   e.getMessage();
    }




    }

}
