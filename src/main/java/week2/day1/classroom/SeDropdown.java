package week2.day1.classroom;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class SeDropdown { 
	

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "./drivers/Chromedriver/chromedriver.exe");
		ChromeDriver driver =new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://leaftaps.com/opentaps/control/login");
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		//driver is the object name in the above line
		//inspect the text field where we need to enter the data.ie.the textbox nextto the usrname field
		driver.findElementById("username").sendKeys("demosalesmanager");
		driver.findElementById("password").sendKeys("crmsfa");
		driver.findElementByClassName("decorativeSubmit").click();
		driver.findElementByLinkText("CRM/SFA").click();
		driver.findElementByLinkText("Leads").click();
		driver.findElementByLinkText("Create Lead").click();
		driver.findElementById("createLeadForm_companyName").sendKeys("Odyssey");
		driver.findElementById("createLeadForm_firstName").sendKeys("Laavanya");
		driver.findElementById("createLeadForm_lastName").sendKeys("testLeaf");
		
		WebElement source = driver.findElementById("createLeadForm_dataSourceId");
		Select dropdown = new Select(source);
		dropdown.selectByVisibleText("Employee");
		
		WebElement source2 = driver.findElementById("createLeadForm_marketingCampaignId");
		Select dropdown2 = new Select(source2);
		dropdown2.selectByValue("9001");
		
		WebElement source3 = driver.findElementById("createLeadForm_industryEnumId");
		Select dropdown3 = new Select(source3);
		List<WebElement> options = dropdown3.getOptions();
		dropdown3.selectByIndex(options.size()-2);
		
		WebElement source4 = driver.findElementById("createLeadForm_ownershipEnumId");
		Select dropdown4 = new Select(source4);
		//dropdown4.selectByIndex(6);
		List<WebElement> options2 = dropdown4.getOptions();
		dropdown4.selectByIndex(options2.size()-2);
		
		WebElement source5 = driver.findElementById("createLeadForm_generalCountryGeoId");
		Select dropdown5=new Select(source5);
		dropdown5.selectByVisibleText("India");
		
		driver.findElementByName("submitButton").click();
		System.out.println(driver.getTitle());
	}
	

}
