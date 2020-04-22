package week2.day1.classroom;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;

public class BasicSe {

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
		driver.findElementByClassName("smallSubmit").click();
		System.out.println(driver.getTitle());
		
	}

}
