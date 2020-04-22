package week2.day1.classroom;

//import java.util.List;

//import org.openqa.selenium.By;
//import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.support.ui.Select;
public class SeCheckbox {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","./drivers/Chromedriver/chromedriver.exe");
		ChromeDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://www.leafground.com/");
		driver.findElementByXPath("(//h5[@class='wp-categories-title'])[7]").click();
		Thread.sleep(3000);
		driver.findElementByXPath("//label[@for='java']/following-sibling::div/input").click();
		driver.findElementByXPath("(//label[@for='java']/following-sibling::div/input)[3]").click();
		//System.out.println(driver.findElementByXPath("//input[@type='checkbox']").getText());
		System.out.println(driver.findElementByXPath("(//input[@type='checkbox'])[6]").isSelected());
		Thread.sleep(3000);
		driver.findElementByXPath("(//input[@type='checkbox'])[8]").click();
		Thread.sleep(3000);
		driver.findElementByXPath("(//input[@type='checkbox'])[9]").click();
		driver.findElementByXPath("(//input[@type='checkbox'])[10]").click();
		driver.findElementByXPath("(//input[@type='checkbox'])[11]").click();
		driver.findElementByXPath("(//input[@type='checkbox'])[12]").click();
		driver.findElementByXPath("(//input[@type='checkbox'])[13]").click();
	}

}
