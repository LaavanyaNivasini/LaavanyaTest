package week5.framework;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DeleteLead {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./drivers/Chromedriver/chromedriver.exe");
		ChromeDriver driver =new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://leaftaps.com/opentaps/control/login/");
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		driver.findElementByXPath("//p[@class='top']/input").sendKeys("demosalesmanager");
		driver.findElementByXPath("//label[text()='Password']/following-sibling::input").sendKeys("crmsfa");
		driver.findElementByXPath("(//form[@id='login']//input)[3]").click();
		driver.findElementByLinkText("CRM/SFA").click();
		driver.findElementByLinkText("Leads").click();
		driver.findElementByLinkText("Find Leads").click();
		driver.findElementByXPath("(//input[@name='firstName'])[3]").sendKeys("testLead"); 
		driver.findElementByXPath("//button[text()='Find Leads']").click();
		Thread.sleep(2000);
		WebDriverWait wait = new WebDriverWait(driver,40); //since ourselenium version is 3.1.14 and not 4.0.0
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElementByXPath
				("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a"))).click();
		Thread.sleep(2000);
		driver.findElementByXPath("//div[@class='frameSectionExtra']/a[3]").click();
		driver.findElementByXPath("//input[@id='updateLeadForm_firstName']").clear();
		driver.findElementByXPath("//input[@id='updateLeadForm_firstName']").sendKeys("edited");
		//check y the CLEAR doesnt clear the entire text in the box 
		driver.findElementByXPath("//input[@class='smallSubmit']").click();
		driver.findElementByLinkText("Delete").click();

	}

}
