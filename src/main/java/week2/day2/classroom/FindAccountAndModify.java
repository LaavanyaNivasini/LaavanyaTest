package week2.day2.classroom;

//import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FindAccountAndModify {   //check thid code

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./drivers/Chromedriver/chromedriver.exe");
		ChromeDriver driver =new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://leaftaps.com/opentaps/control/login/");
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		driver.findElementById("username").sendKeys("demosalesmanager");
		driver.findElementById("password").sendKeys("crmsfa");
		driver.findElementByClassName("decorativeSubmit").click();
		driver.findElementByLinkText("CRM/SFA").click();
		driver.findElementByLinkText("Leads").click();
		driver.findElementByLinkText("Find Leads").click();;
		//driver.findElementByName("firstName").sendKeys("sam",Keys.ENTER);
		//driver.findElementByName("firstName").sendKeys("sam");//this cant be used as there are more than just one firstName in web pageto find this serach fr this name in DOM
		driver.findElementByXPath("(//input[@name='firstName'])[3]").sendKeys("Babu"); //searching with xpath alone agin will match only to first match of "firstName" hence give [3] to match ur need
		//driver.findElementByClassName("(//button[@class='x-btn-text'])[7]").click();
		driver.findElementByXPath("//button[text()='Find Leads']").click();
		Thread.sleep(2000);
		WebDriverWait wait = new WebDriverWait(driver,40); //since ourselenium version is 3.1.14 and not 4.0.0
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElementByXPath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a"))).click();
		//above line of code waits until the page gets loaded after "find leads" and presses the leadid of the first person with name "sam"
		Thread.sleep(2000);
		driver.findElementByXPath("//div[@class='frameSectionExtra']/a[3]").click();
		driver.findElementByXPath("//input[@id='updateLeadForm_firstName']").sendKeys(Keys.BACK_SPACE,"edited"); //does one backspace in 1st name
		//driver.findElementByXPath("//input[@id='updateLeadForm_firstName']").sendKeys("laavanya");
		driver.findElementByXPath("//input[@class='smallSubmit']").click();
		
	}

}
