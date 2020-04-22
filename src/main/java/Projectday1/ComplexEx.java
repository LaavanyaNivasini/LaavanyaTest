package Projectday1;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
//Get all the commented doubts clarified in this code
public class ComplexEx {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./drivers/Chromedriver/chromedriver.exe");
		ChromeDriver driver =new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.zoomcar.com/chennai/");
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		driver.findElementByLinkText("Start your wonderful journey").click();
		driver.findElementByXPath("//div[@class='items'][2]").click();
		driver.findElementByXPath("//button[text()='Next']").click();
		//Tried to collect the days in list and choose one day from it:
		
		/*List<WebElement> chooseDays = driver.findElementsByXPath("//div[@class='days']");
		//System.out.println(chooseDays.get(0).getText());
		WebElement daysrow = chooseDays.get(0);
		List<WebElement> cols = daysrow.findElements(By.xpath("//div[@class='text']"));
		System.out.println(cols.get(0).getText());*/
		
		//proper code:
		/*WebElement startDate = driver.findElementByXPath("//div[text()='day picked ']");
		startDate.click();
		driver.findElementByXPath("//button[text()='Next']").click();*/    
		//This will choose only one day and the requiremnt is to choose next day dynamically based on the day we run this code
		Date date=new Date();
		DateFormat sdf= new SimpleDateFormat("dd");
		String today=sdf.format(date);
		int nextDay = Integer.parseInt(today)+1;
		System.out.println(nextDay);
		Thread.sleep(2000);
		driver.findElementByXPath("//div[contains(text(),'"+nextDay+"')]").click();
		driver.findElementByXPath("//button[text()='Next']").click();
		String confirmDate = driver.findElementByXPath("//div[@class='label time-label']").getText();
		System.out.println(confirmDate);
	//	System.out.println(confirmDate.split(" ")); //know wat this is returning
		String confirmDate1 = confirmDate.substring(4,6);
		System.out.println(confirmDate1);  //y not 4,5 here 
		int parsedDate = Integer.parseInt(confirmDate1);
		if (nextDay==parsedDate)
		{
			System.out.println("Both the dates match");
		}
		else
		{
			System.out.println("Dates doesnot match");
		}
		driver.findElementByXPath("//button[text()='Done']").click();
		Thread.sleep(3000);
		List<WebElement> noOfCarsListed = driver.findElementsByXPath("//div[@class='car-listing']");
		System.out.println(noOfCarsListed.size());
		List<WebElement> carPriceList = driver.findElementsByXPath("//div[@class='price']");
		List<Integer> carPrices = new ArrayList<Integer>();
		for (WebElement eachPrice : carPriceList)
		{
			String price = eachPrice.getText();
			String actualPrice = price.replaceAll("[^0-9]", ""); //y replace method is not working?
			System.out.println(actualPrice);
			carPrices.add(Integer.parseInt(actualPrice)); // if i incude "," in regex[^0-9,]-- in this parse step its getting affected.Know y?
		}
		System.out.println("Price list before sorting:" + carPrices);
		Collections.sort(carPrices);
		System.out.println("After Sorting prices:" +carPrices);
		Integer highestPrice = carPrices.get(carPrices.size()-1);
		driver.findElementByXPath("(//div[contains(text(),'"+highestPrice+"')]/following-sibling::button").click();  
		//here due to 1154 in op and actual value is 1,154 am not getting output know y...
		Thread.sleep(2000);
		driver.close();
		}
	}


