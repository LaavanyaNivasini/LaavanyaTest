package week2.day2.classroom;

//import java.util.List;
import java.util.concurrent.TimeUnit;

//import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FindOppurtunities {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "./drivers/Chromedriver/chromedriver.exe");
		ChromeDriver driver =new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://leaftaps.com/opentaps/control/login/");
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		driver.findElementByXPath("//p[@class='top']/input").sendKeys("demosalesmanager");
		driver.findElementByXPath("//label[text()='Password']/following-sibling::input").sendKeys("crmsfa");
		driver.findElementByXPath("(//form[@id='login']//input)[3]").click();
		driver.findElementByLinkText("CRM/SFA").click();
		driver.findElementByXPath("(//li[@class='sectionTabButtonUnselected']//a)[6]").click();
		driver.findElementByXPath("(//ul[@class='shortcuts']//a)[3]").click();
		driver.findElementByXPath("//div[@class='x-grid3-hd-inner x-grid3-hd-salesOpportunityId']").click();
		if (driver.getTitle().contains("CRM")) {
			System.out.println("Title belongs to testleaf");
		}
		else {
			System.out.println("title doesnot have testleaf");
		}
		
	}

}
