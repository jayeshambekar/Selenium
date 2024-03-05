package commonUtils;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

public class Base {
	
	public WebDriver d;
	PropertyFileUtil putil = new PropertyFileUtil();
	WebDriverUtil wutil = new WebDriverUtil();
	
	@BeforeSuite
	public void BS()
	{
				
		System.out.println("Connect to Data Base");
		
	}
	
	@BeforeClass
	public void BC() throws IOException
	{
		
		//BeforeClass is used to launch application
		String URL = putil.getDataFromPropertyFile("Url");
		
		//To launch browser
        WebDriver d = new ChromeDriver();
		
		//To maximize the window 
		wutil.maximize(d);
		
		//To apply the wait for  for findelement()
		wutil.implicitewait(d);
		
		//To launch the application
		d.get(URL);
		
	}
	@BeforeMethod
	public void BM() throws IOException
	{
		//@BeforeMethod is used to login the application
		
		String USERNAME = putil.getDataFromPropertyFile("Username");
		String PASSWORD = putil.getDataFromPropertyFile("Password");
		
		//Login to application
				d.findElement(By.name("user_name")).sendKeys(USERNAME);
				d.findElement(By.name("user_password")).sendKeys(PASSWORD);
				d.findElement(By.id("submitButton")).click();
		
	}
	@AfterMethod
	public void AM() throws InterruptedException
	{
		Thread.sleep(2000);
		   //Mouse hover on image
	    WebElement image = d.findElement(By.cssSelector("img[src='themes/softed/images/user.PNG']"));

	    wutil.mouseHover(d, image);
	    
	    d.findElement(By.xpath("//a[text()='Sign Out']")).click();
		
	}
	@AfterClass
	public void AC()
	{
		//@AfteClass is used to close the browser
		d.quit();
		
	}
	@AfterSuite
	public void AS()
	{
		System.out.println("Dis-Connect to Data Base");
		
	}
}

