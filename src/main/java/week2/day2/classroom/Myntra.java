package week2.day2.classroom;

import java.util.List;
import java.util.concurrent.TimeUnit;
//check this code
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Myntra {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "./drivers/Chromedriver/chromedriver.exe");
		ChromeDriver driver =new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.myntra.com/");
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		driver.findElementByXPath("//div[@class='desktop-query']/input").sendKeys("Shirt",Keys.ENTER);
		driver.findElementByXPath("//*[@id=\"mountRoot\"]/div/main/div[3]/div[1]/section/div/div[4]/ul/li[8]/label/div").click();
		driver.findElementByXPath("//div[@class='sort-sortBy']");
		driver.findElementByXPath("((//label[@class='sort-label '])[1]").click();
		@SuppressWarnings("unchecked")
		List<WebElement> prices = (List<WebElement>) driver.findElementByXPath("(//span[@class='product-discountedPrice'])[1]");
		for (WebElement price : prices) {
			System.out.println(price.getText());
			
		}
	}

}
