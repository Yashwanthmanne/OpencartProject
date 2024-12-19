package testbase;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class BaseClass {
	
	
	public static WebDriver driver;
    public Logger logger;
    public Properties p;
	@BeforeClass(groups= {"Sanity","Regression","Master"})
	@Parameters({"browser","os"})
	public void setup(String br,String os) throws IOException, InterruptedException
	{
		FileInputStream file= new FileInputStream("./src//test//resources//config.properties"); 
		
		p=new Properties();
		p.load(file);
		
		logger=LogManager.getLogger(this.getClass());
		
		switch(br.toLowerCase())
		{
		case "chrome":  driver = new ChromeDriver();break;
		case "edge":    driver = new EdgeDriver();break;
		case "firefox": driver = new FirefoxDriver();break;
		default:System.out.println("invalid browser");return;
		}
		
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		
		driver.get(p.getProperty("appurl"));
		driver.manage().window().maximize();
		Thread.sleep(3000);
		

	}
	@AfterClass(groups= {"Sanity","Regression","Master"})
	 public void teardown()
	 {

		 driver.close();
	 }

	public String randomename()
	{
		String name=RandomStringUtils.randomAlphabetic(5);
		return name;
	}
	public String randomenumber()
	{
		String num=RandomStringUtils.randomNumeric(10);
		return num;
	}

	public String alphanumeric()
	{
		String name=RandomStringUtils.randomAlphabetic(3);
		String num = RandomStringUtils.randomNumeric(3);
		return (name+"@"+num);
	}
	public String captureScreen(String tname) {
		
		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		TakesScreenshot takesscreenshot = (TakesScreenshot)driver;
		File sourceFile = takesscreenshot.getScreenshotAs(OutputType.FILE);
		String targetFilePath = System.getProperty("user.dir")+"\\screenshots\\" + tname+" _ "+timeStamp +".png";
		File targetFile = new File(targetFilePath);
		sourceFile.renameTo(targetFile);
		
		return targetFilePath;
		
		
	}
	
	}

