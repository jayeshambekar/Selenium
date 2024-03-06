package vtigercrm;

import java.io.IOException;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import commonUtils.ExcelUtil;
import commonUtils.JavaUtil;
import commonUtils.ListenerImplementation;
import commonUtils.PropertyFileUtil;
import commonUtils.WebDriverUtil;

@Listeners(ListenerImplementation.class)
public class Contact {
		
		
		//Object Creation
		PropertyFileUtil putil = new PropertyFileUtil();
		WebDriverUtil wutil = new WebDriverUtil();
		ExcelUtil eutil = new ExcelUtil();
//		JavaUtil jutil = new JavaUtil();
	
		@Test
	public void contactTest() throws IOException, InterruptedException
	{
		//To launch browser
        WebDriver d = new ChromeDriver();
		
		//To maximize the window 
		wutil.maximize(d);
		
		//To apply the wait for  for findelement()
		wutil.implicitewait(d);
		
		//To read data from PropertyFile
				String URL = putil.getDataFromPropertyFile("Url");
				String USERNAME = putil.getDataFromPropertyFile("Username");
				String PASSWORD = putil.getDataFromPropertyFile("Password");
				
				//To read data from Excel File
				String FIRSTNAME = eutil.getDataFromExcel("Contact", 0, 1);
				String LASTNAME = eutil.getDataFromExcel("Contact", 1, 1);
				String Group = eutil.getDataFromExcel("Contact", 2, 1);
				String ORGNAME = eutil.getDataFromExcel("Contact", 3, 1);
				
				//To launch the application
				d.get(URL);
				
				//Login to application
				d.findElement(By.name("user_name")).sendKeys(USERNAME);
				d.findElement(By.name("user_password")).sendKeys(PASSWORD)
				;
				d.findElement(By.id("submitButton")).click();
				
				
				//To click on Contact
				d.findElement(By.xpath("//a[text()='Contacts']")).click();
				
				//To Click on Create Contact...(+)
				d.findElement(By.cssSelector("img[alt='Create Contact...']")).click();
				
				//Enter FirstName
				d.findElement(By.name("firstname")).sendKeys(FIRSTNAME);
				
				//Enter LastName
				d.findElement(By.name("lastname")).sendKeys(LASTNAME);
				
				//To fail the testscript
				String actualurl = d.getCurrentUrl();
				String expectedurl = "http://localhost:8888/index.php?module=Contacts&action=EditView&return_action=DetailView&parenttab=Marketing";
				Assert.assertEquals(actualurl, expectedurl);
				
				//Click On Group Radio Icon
				d.findElement(By.xpath("(//input[@name='assigntype'])[2]")).click();
				
			//In the dropdown select Team Selling
				WebElement  dropdown = d.findElement(By.name("assigned_group_id"));
//				wutil.handleDropDown(dropdown, Group);

				 // OR
				wutil.handleDropDown(dropdown, "Team Selling");
				
				
				//Click On Select(+) in Organization Name text field
				d.findElement(By.xpath("(//img[@alt='Select'])[1]")).click();
		
				//Transfer the Driver control from Parent window to Child window
			      wutil.switchWindow(d, "http://localhost:8888/index.php?module=Accounts&action=Popup&popuptype=specific_contact_account_address&form=TasksEditView&form_submit=false&fromlink=&recordid=");
			      
			      //To enter Organization name in searchtf
			      d.findElement(By.id("search_txt")).sendKeys(ORGNAME);
			      
			      //To click on search now button
			      d.findElement(By.name("search")).click();
			      
			      //To click on Organization name
			      d.findElement(By.xpath("//a[text()='MrJay1']")).click();
			      
			      //Transfer the driver control from child window to parent window
			        wutil.switchWindow(d, "http://localhost:8888/index.php?module=Contacts&action=EditView&return_action=DetailView&parenttab=Marketing");
			      
			        Thread.sleep(2000);
			        
			       //To Take Screenshot of Contact
			      wutil.screenShot(d, "Contact");
			      
			      //Click On Save Button
			      d.findElement(By.xpath("(//input[@name='button'])[1]")).click();
			      
			       Thread.sleep(2000);
				  
			       //Mouse hover on image
				    WebElement image = d.findElement(By.cssSelector("img[src='themes/softed/images/user.PNG']"));

				    wutil.mouseHover(d, image);
				    
				    //Click On Sign-Out
				    d.findElement(By.xpath("//a[text()='Sign Out']")).click();
		}
		
	}

