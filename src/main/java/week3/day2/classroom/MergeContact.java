package week3.day2.classroom;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.chrome.ChromeDriver;

public class MergeContact {

	public static void main(String[] args) throws InterruptedException, IOException {
		System.setProperty("webdriver.chrome.driver", "./drivers/Chromedriver/chromedriver.exe");
		ChromeDriver driver =new ChromeDriver();
		driver.manage().window().maximize();
		driver.navigate().to("http://leaftaps.com/opentaps/control/login");
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		driver.findElementById("username").sendKeys("demosalesmanager");
		driver.findElementById("password").sendKeys("crmsfa");
		driver.findElementByClassName("decorativeSubmit").click();
		driver.findElementByLinkText("CRM/SFA").click();
		driver.findElementByLinkText("Contacts").click();
		driver.findElementByLinkText("Merge Contacts").click();
		driver.findElementByXPath("(//img[@alt='Lookup'])[1]").click();
		Thread.sleep(2000);
		Set<String> windHandles = driver.getWindowHandles(); 
		//getwindwhandle will return current window handle only use getWindowHandles to get the new window's handle
		List<String> whandles= new ArrayList<String>(windHandles);
		driver.switchTo().window(whandles.get(1));
		Thread.sleep(5000);
		driver.findElementByXPath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId'])[1]/a").click();
		driver.switchTo().window(whandles.get(0));
		driver.findElementByXPath("(//img[@alt='Lookup'])[2]").click();
		Set<String> windHandles2 = driver.getWindowHandles();
		List<String> whandles2= new ArrayList<String>(windHandles2);
		driver.switchTo().window(whandles2.get(1));
		driver.findElementByXPath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId'])[2]/a").click();
		driver.switchTo().window(whandles2.get(0));
		driver.findElementByXPath("//a[text()='Merge']").click();
		driver.switchTo().alert().accept();
		System.out.println(driver.getTitle());
		//To verify the title  small snippet
		String firstWindowTitle = driver.getTitle();
		if(firstWindowTitle.contains("View Contact"))
		{
			System.out.println("Verified the title of the page");
		}
		File src=driver.getScreenshotAs(OutputType.FILE);
		File dest = new File("./snaps/mergeContactss.jpg");
		FileUtils.copyFile(src, dest);
	}

}
