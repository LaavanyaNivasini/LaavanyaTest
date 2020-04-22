package week3.day1.classroom;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ErailUnique {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./drivers/Chromedriver/chromedriver.exe");
		ChromeDriver driver =new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://erail.in/");
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		driver.findElementById("chkSelectDateOnly").click();
		driver.findElementById("txtStationFrom").clear();
		driver.findElementById("txtStationFrom").sendKeys("MS",Keys.TAB);
		driver.findElementById("txtStationTo").clear();
		driver.findElementById("txtStationTo").sendKeys("MDU",Keys.TAB);
		Thread.sleep(2000);
		WebDriverWait wait = new WebDriverWait(driver,40);
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElementByXPath("(//table[@class='DataTable TrainList TrainListHeader'])//tr[1]/td[1]/a")));
		List<String> allTrainnames = new ArrayList<String>();
		List<WebElement> findrowsByXPath = driver.findElementsByXPath("(//table[@class='DataTable TrainList TrainListHeader'])//tr/td[2]/a");
		for (int i = 0; i < findrowsByXPath.size(); i++) {
			String eachtrainName = findrowsByXPath.get(i).getText();
			allTrainnames.add(eachtrainName);
	}
		System.out.println(allTrainnames.size());
		Set<String> trainNamesInSet = new LinkedHashSet<String>(allTrainnames);
		for (String eachName : trainNamesInSet) {
			System.out.println(eachName);
		}
		//System.out.println(trainNamesInSet); //prints the outpt as list of names--[names]
	System.out.println(trainNamesInSet.size());
	}
}
