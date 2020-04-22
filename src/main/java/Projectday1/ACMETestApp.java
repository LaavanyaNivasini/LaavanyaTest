package Projectday1;

import java.util.concurrent.TimeUnit;

//import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ACMETestApp {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","./drivers/Chromedriver/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.navigate().to("https://acme-test.uipath.com/account/login");
		driver.findElementById("email").sendKeys("kumar.testleaf@gmail.com",Keys.TAB);
		driver.findElementById("password").sendKeys("leaf@12",Keys.ENTER);
		driver.findElementById("buttonLogin").click();
		Thread.sleep(2000);
		//vendors hover
		WebElement vendors = driver.findElementByXPath("(//button[@class='btn btn-default btn-lg'])[4]");
		Actions doer= new Actions(driver);
		doer.moveToElement(vendors).perform();
		Thread.sleep(3000);
		//search for vendor
		WebElement searchForVendor = driver.findElementByLinkText("Search for Vendor");
		doer.click(searchForVendor).perform();
		Thread.sleep(2000);
		driver.findElementById("vendorName").sendKeys("Blue Lagoon",Keys.ENTER);
		driver.findElementById("buttonSearch").click();
		
		//webtable:
		//All 3 below are working xpaths
		//System.out.println(driver.findElementByXPath("//table[@class='table']/tbody/tr[2]/td[5]").getText());  
		//This works fine but its better to blue lagoon by text first and move to following sibling
		
		//To locate france starting from table:
			//table[@class='table']/tbody/tr[2]/td[text()='Blue Lagoon']/following-sibling::td[4]
		
		//Same can be done simply using td alone like below
		System.out.println(driver.findElementByXPath("//td[text()='Blue Lagoon']/following-sibling::td[4]").getText());
		driver.findElementByLinkText("Log Out").click();
		driver.close();
	}

}
