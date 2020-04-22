package week2.day1.Assignments;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class CreateAcccount {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver",  "./drivers/Chromedriver/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("http://leaftaps.com/opentaps/control/login");
		driver.findElementById("username").sendKeys("demosalesmanager");
		driver.findElementById("password").sendKeys("crmsfa");
		driver.findElementByClassName("decorativeSubmit").click();
		driver.findElementByLinkText("CRM/SFA").click();
		driver.findElementByLinkText("Accounts").click();
		driver.findElementByLinkText("Create Account").click();
		driver.findElementByXPath("//input[@id='accountName']").sendKeys("Debit Limited Account");
		driver.findElementByXPath("//textarea[@name='description']").sendKeys("Selenium Automation Tester");
		driver.findElementByXPath("//input[@id='groupNameLocal']").sendKeys("local");
		driver.findElementByXPath("//input[@id='officeSiteName']").sendKeys("Chennai");
		driver.findElementByXPath("(//input[@class='inputBox'])[5]").sendKeys("10000");
		WebElement src = driver.findElementByName("industryEnumId");
		Select industry= new Select(src);
		industry.selectByIndex(2);
		WebElement ownid = driver.findElementByName("ownershipEnumId");
		Select own = new Select(ownid);
		own.selectByVisibleText("S-Corporation");
		WebElement srcids = driver.findElementById("dataSourceId");
		Select srcid = new Select(srcids);
		srcid.selectByValue("LEAD_EMPLOYEE");
		WebElement ids = driver.findElementById("marketingCampaignId");
		Select id= new Select(ids);
		List<WebElement> options = id.getOptions();
		id.selectByIndex(options.size()-3);
		WebElement states = driver.findElementByXPath("//select[@name='generalStateProvinceGeoId']");
		Select state= new Select(states);
		List<WebElement> options2 = state.getOptions();
		for (int i = 0; i < options2.size(); i++) {
			if(options2.get(i).getText().startsWith("T")) {
				state.selectByIndex(i);
			}
		}
		driver.findElementByXPath("//input[@class='smallSubmit']").click();
		
	}

}
