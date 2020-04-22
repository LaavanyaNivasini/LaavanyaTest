package week3.day2.classroom;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
//import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LearnWindows {

	public static void main(String[] args) throws IOException {
		System.setProperty("webdriver.chrome.driver", "./drivers/Chromedriver/chromedriver.exe");
		ChromeDriver driver =new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.irctc.co.in/nget/train-search");
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		driver.findElementByXPath("//span[text()='AGENT LOGIN']").click();
		driver.findElementByXPath("//a[text()='Contact Us']").click();
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> ls= new ArrayList<>(windowHandles);
		driver.switchTo().window(ls.get(1));
		System.out.println(driver.getTitle());
		//forsnapshot
		File ss = driver.getScreenshotAs(OutputType.FILE);
		File dest = new File("./snaps/img.png");
		FileUtils.copyFile(ss, dest);
		
	}

}
