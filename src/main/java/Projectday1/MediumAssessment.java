package Projectday1;


import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;

public class MediumAssessment {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./drivers/Chromedriver/chromedriver.exe");
		ChromeDriver driver =new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.amazon.in/");
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		driver.findElementById("twotabsearchtextbox").sendKeys("oneplus 7 pro mobiles",Keys.ENTER);
		System.out.println(driver.findElementByXPath("//a[@class='a-size-base a-link-normal s-no-hover a-text-normal']").getText());
		driver.findElementByXPath("//img[@class='s-image']").click(); //Note the new tab opens at this step dont get confused handle it like a window itself
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> handlesList=new ArrayList<String>(windowHandles);
		driver.switchTo().window(handlesList.get(1));
		//To print customer ratings in  newpage
		System.out.println(driver.findElementById("acrCustomerReviewText").getText());
		Thread.sleep(5000);
		driver.findElementById("add-to-cart-button").click();
		String text = driver.findElementByXPath("//h4[@class='a-alert-heading']").getText();
		
		if(text.equalsIgnoreCase("added to cart"))
		{
			System.out.println("Product added to cart");
		}
		//Proceedto buy
		Thread.sleep(5000);
		driver.findElementByXPath("(//input[@class='a-button-input'])[5]").click();
		String title = driver.getTitle();
		if(title.equalsIgnoreCase("amazon sign in")) {
			
			System.out.println("You are currently in signi in page");
		}
		Thread.sleep(5000);
		driver.findElementById("continue").click();
		System.out.println(driver.findElementByXPath("(//div[@class='a-alert-content'])[2]").getText());
		driver.quit();
	}

}
