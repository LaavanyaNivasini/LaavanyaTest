package week3.day1.classroom;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

//import javax.swing.text.TabableView;

//import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ErailSort {
	public static void main(String[] args) 
	{
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
		WebDriverWait wait = new WebDriverWait(driver,40);
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElementByXPath("(//table[@class='DataTable TrainList TrainListHeader'])//tr[1]/td[1]/a")));
		/*WebElement table = driver.findElementByXPath("//table[@class='DataTable TrainList TrainListHeader']");
		List<WebElement> tablerows = table.findElements(By.tagName("tr"));  
		//above provides collection of rows - note that we are using object 'table' here and not driver like usual
		//tablerows here is a collection --> LIST
		System.out.println(tablerows.size());
		for (int i = 0; i < tablerows.size() ; i++) {
			//System.out.println(tablerows.get(i));
			WebElement rowElement = tablerows.get(i);
			List<WebElement> rowElementCols = rowElement.findElements(By.tagName("td"));
			//above is a colletion of columns from every individual row that is referenced by i
			System.out.println(rowElementCols.get(1).getText());
			*/
		
			//Using Xpath:
			List<WebElement> findrowsByXPath = driver.findElementsByXPath("(//table[@class='DataTable TrainList TrainListHeader'])//tr/td[2]/a");
			List<String> trainnames = new ArrayList<String>();
			for (int i = 0; i < findrowsByXPath.size(); i++) {
				String trainName = findrowsByXPath.get(i).getText();
				trainnames.add(trainName);
			}
				Collections.sort(trainnames);
				System.out.println(trainnames);
			//my output comes in sorted order but in single line [1,2...] check y? --> use foreach to print lst elements in seperate line
			}
		}
		
	
