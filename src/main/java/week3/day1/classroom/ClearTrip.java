package week3.day1.classroom;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ClearTrip {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "./drivers/Chromedriver/chromedriver.exe");
		ChromeDriver driver =new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.cleartrip.com/");
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		driver.findElementById("RoundTrip").click();
		driver.findElementByXPath("//span[@class='span24 clearField']//input").sendKeys("chennai",Keys.TAB);
		driver.findElementByXPath("//span[@class='span24 clearField']/input[@id='ToTag']").sendKeys("NewYork",Keys.TAB);
		driver.findElementByXPath("//div[@class='span span15 datePicker']/input[@title='Depart date']").click();
		WebDriverWait wait = new WebDriverWait(driver,40); //since ourselenium version is 3.1.14 and not 4.0.0
		//from below lines exception occurscheck it
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElementByXPath("//td[@class=' ui-datepicker-days-cell-over  startDate range selected']/a"))).click();
		
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElementByXPath("//td[@class='  endDate range selected']/a"))).click();
		WebElement src = driver.findElementById("Adults");
		Select dropdwn = new Select(src);
		dropdwn.selectByVisibleText("2");
		WebElement children = driver.findElementById("Childrens");
		Select drpdwn2 = new Select(children);
		drpdwn2.selectByVisibleText("1");
		WebElement infants = driver.findElementById("Infants");
		Select dropdwn3=new Select(infants);
		dropdwn3.selectByVisibleText("1");
		driver.findElementById("MoreOptionsLink").click();
		WebElement travelclass = driver.findElementById("Class");
		Select drpdwn= new Select(travelclass);
		drpdwn.selectByVisibleText("Premium Economy");
		driver.findElementByXPath("//span[@class='span span24 clearField']/input[@placeholder='Airline name']").sendKeys("Emirates",Keys.TAB);
		driver.findElementByXPath("//input[@id='SearchBtn']").click();
	}

}
