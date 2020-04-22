package week2.day2.Assignments;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class CreateContact {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "./drivers/Chromedriver/chromedriver.exe");
		ChromeDriver driver =new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://leaftaps.com/opentaps/control/login/");
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		driver.findElementById("username").sendKeys("demosalesmanager");
		driver.findElementById("password").sendKeys("crmsfa");
		driver.findElementByClassName("decorativeSubmit").click();
		driver.findElementByLinkText("CRM/SFA").click();
		driver.findElementByLinkText("Contacts").click();
		driver.findElementByXPath("//a[contains(text(),'Create')]").click();
		driver.findElementById("firstNameField").sendKeys("User");
		driver.findElementById("lastNameField").sendKeys("Laavanya");
		driver.findElementById("createContactForm_firstNameLocal").sendKeys("UserLocal");
		driver.findElementById("createContactForm_lastNameLocal").sendKeys("LastNameLocal");
		driver.findElementById("createContactForm_departmentName").sendKeys("PKI");
		driver.findElementById("createContactForm_description").sendKeys("TestLeafPrgrm");
		driver.findElementById("createContactForm_primaryEmail").sendKeys("test@testleaf.com");
		WebElement states = driver.findElementById("createContactForm_generalStateProvinceGeoId");
		Select state = new Select(states);
		List<WebElement> options = state.getOptions();
		for (int i = 0; i < options.size(); i++) {
			if (options.get(i).getText().contentEquals("New York")) {
				state.selectByVisibleText("New York");
			}
		driver.findElementByName("submitButton").click();
		driver.findElementByLinkText("Edit").click();
		driver.findElementById("updateContactForm_description").clear();
		driver.findElementById("updateContactForm_importantNote").sendKeys("This user is modified by laavanya");
		driver.findElementByXPath("//input[@value='Update']").click();
		System.out.println(driver.getTitle());
		}
		
	}

}
