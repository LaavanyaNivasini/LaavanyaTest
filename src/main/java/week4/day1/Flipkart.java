package week4.day1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Flipkart {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./drivers/Chromedriver/chromedriver.exe");
		ChromeDriver driver =new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.flipkart.com/");
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		driver.findElementByXPath("//button[text()='✕']").click();
		WebElement elmnt = driver.findElementByXPath("//span[text()='Electronics']"); //thislocates to electronics
		WebElement apple = driver.findElementByXPath("//a[text()='Apple']");
		//since here no search bioxes context is involved we rdoing only mouse hover on electronics and choosing apple from that we need actions class.
		
		Actions builder = new Actions(driver);
		builder.moveToElement(elmnt).perform();
		Thread.sleep(2000);
		builder.click(apple).perform();
		

	}

}
