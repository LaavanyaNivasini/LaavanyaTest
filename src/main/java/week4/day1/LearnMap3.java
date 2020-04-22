package week4.day1;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LearnMap3 {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "./drivers/Chromedriver/chromedriver.exe");
		ChromeDriver driver =new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://erail.in/");
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		driver.findElementById("chkSelectDateOnly").click();
		driver.findElementById("txtStationFrom").clear();
		driver.findElementById("txtStationFrom").sendKeys("MS",Keys.TAB);
		driver.findElementById("txtStationTo").clear();
		driver.findElementById("txtStationTo").sendKeys("Kodambakkam",Keys.TAB);
		WebDriverWait wait = new WebDriverWait(driver,40);
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElementByXPath
				("(//table[@class='DataTable TrainList TrainListHeader'])//tr[1]/td[1]/a")));
		Map<String,String> trains= new LinkedHashMap<String,String>();
		WebElement trainsTable = driver.findElementByXPath("//table[@class='DataTable TrainList TrainListHeader']");
		List<WebElement> rows = trainsTable.findElements(By.tagName("tr"));
		System.out.println(rows.size());
		for (int i = 1; i <= rows.size(); i++) 
		{
			String trainNo = driver.findElementByXPath
			("(//table[@class='DataTable TrainList TrainListHeader'])//tr[" +i+ "]/td[1]/a").getText();
			String trainName = driver.findElementByXPath
					("(//table[@class='DataTable TrainList TrainListHeader'])//tr[" +i+ "]/td[2]/a").getText();
			trains.put(trainNo, trainName);
		}
		System.out.println(trains);
		//Check how to proceed from here to get all train names starting with m alone
		for (Entry<String, String> train: trains.entrySet()) 
		{
			if(train.getValue().startsWith("M"))
			{
				System.out.println(train.getValue());
			}
			}
		}
		
	}


