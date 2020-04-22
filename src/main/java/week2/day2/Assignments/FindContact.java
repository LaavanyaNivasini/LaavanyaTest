package week2.day2.Assignments;

import java.util.concurrent.TimeUnit;
//incomplete excercise
import org.openqa.selenium.chrome.ChromeDriver;

public class FindContact {

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
		driver.findElementByLinkText("Contacts").click();
		driver.findElementByXPath("//a[@href='/crmsfa/control/findContacts']").click();
		driver.findElementByXPath("(//span[@class='x-tab-strip-text '])[3]").click();
		driver.findElementByName("emailAddress").sendKeys("demo");
		driver.findElementByXPath("(//button[@class='x-btn-text'])[7]").click();
		Thread.sleep(2000);
		driver.findElementByXPath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a").click();
		System.out.println(driver.findElementByXPath("//span[text()='First name']").getText());
		System.out.println(driver.findElementById("viewContact_firstName_sp").getText());
	}

}
