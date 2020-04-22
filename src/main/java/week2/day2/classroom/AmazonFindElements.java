package week2.day2.classroom;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AmazonFindElements {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./drivers/Chromedriver/chromedriver.exe");
		ChromeDriver driver =new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.amazon.in/");
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		driver.findElementById("twotabsearchtextbox").sendKeys("USI punching bag",Keys.ENTER);
	//	Thread.sleep(2000);
		driver.findElementByXPath("(//i[@class='a-icon a-icon-checkbox'])[4]").click();
		//List<WebElement> bags = driver.findElementsByClassName("a-size-base-plus a-color-base a-text-normal");
		//cant use class nme dierectly since it has space.But in xpath find we can use the clssname
		List<WebElement> bags =  driver.findElementsByXPath("//span[@class='a-size-base-plus a-color-base a-text-normal']");
		System.out.println(bags.size());
		for (WebElement webElement : bags)
		{
			//System.out.println(webElement);
			System.out.println(webElement.getText());
			
		}
		driver.close();
	}

}
