package week3.day2.classroom;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.chrome.ChromeDriver;

public class LearnFrames {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./drivers/Chromedriver/chromedriver.exe");
		ChromeDriver driver =new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.w3schools.com/js/tryit.asp?filename=tryjs_prompt");
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		driver.switchTo().frame("iframeResult"); //iframe tag's id
		driver.findElementByXPath("//button[text()='Try it']").click();
		Alert alert = driver.switchTo().alert();
		Thread.sleep(2000);
		alert.sendKeys("Laavanya");
		alert.accept();
		String text = driver.findElementByXPath("//p[@id='demo']").getText();
		if (text.contains("laavanya")) {
			System.out.println("Text contains the word: Laavanya");
		}
		else {
			System.out.println("Given name is not found in the text");
		}
	}

}
