package week5.day2;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class CreateLeadFromExcel {
		
		ChromeDriver driver; //declared as public for all following methods to be usble
	@Parameters({"url","username","password"})
	@BeforeMethod  //execute steps before the actual test case of create lead 
	public void login(String url,String username,String password) throws InterruptedException 
	{
		System.setProperty("webdriver.chrome.driver", "./drivers/Chromedriver/chromedriver.exe");
		 driver =new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		Thread.sleep(3000);
		driver.findElementByXPath("//p[@class='top']/input").sendKeys(username);
		driver.findElementByXPath("//label[text()='Password']/following-sibling::input").sendKeys(password);
		driver.findElementByXPath("(//form[@id='login']//input)[3]").click();
		driver.findElementByLinkText("CRM/SFA").click();

	}
	@Test(/*invocationCount=1*/timeOut=5000,/*threadPoolSize=2 */ dataProvider="passData" )  //not wrkig for invoc.count=2.Chck y?
	public void creatingLead(String cn,String fn,String ln) throws InterruptedException {		
		driver.findElementByLinkText("Create Lead").click();
		driver.findElementById("createLeadForm_companyName").sendKeys(cn);
		driver.findElementById("createLeadForm_firstName").clear();
		driver.findElementById("createLeadForm_firstName").sendKeys(fn);
		//driver.findElementById("createLeadForm_firstName").sendKeys(Keys.CLEAR,"testLeadNew");
		driver.findElementById("createLeadForm_lastName").sendKeys(ln);
		WebElement source = driver.findElementById("createLeadForm_dataSourceId");
		Select src = new Select(source);
		src.selectByVisibleText("Partner");
		driver.findElementById("createLeadForm_description").sendKeys("This is create lead");
		driver.findElementByXPath("//input[@value='Create Lead']").click();
	}
	
	@AfterMethod  //closes the browser opened even if create lead fails
	public void closebrowser() {
		//driver.close();
		System.out.println("create user is done");
	}
	
	@DataProvider (name="passData")
	public String[][] fetchData() throws IOException
	{
		//Before we construct an object array we need the size of the array for which we need the excel sheet 
		
		XSSFWorkbook wbook = new XSSFWorkbook("./data/testdatalatest.xlsx");
		XSSFSheet sheet = wbook.getSheet("Sheet1");
			int lastRowNum = sheet.getLastRowNum();
			int lastCellNum = sheet.getRow(0).getLastCellNum();
			
			//actual array of objects
			String data[][]= new String[lastRowNum][lastCellNum];
		for (int j = 1; j <=lastRowNum ; j++)   
			//weuse <= since getLastRowNum by default assumes we have header in frst line and ignores it& we start from index 1 since we dnt need the headings
			//get the above for loop logic clear..????
		{
			XSSFRow row = sheet.getRow(j);
			for (int i = 0; i < lastCellNum; i++)
			{
				XSSFCell cell = row.getCell(i);
				String stringCellValue = cell.getStringCellValue();
				System.out.println(stringCellValue);
				data[j-1][i] = stringCellValue;  
				//we read the data from excel and put it into the array.So if there is "j" simply -->[1][0] so the array will have NULL value at [0][0].Which is y we put it as [j-1][i]
				
			} 
			
		}
		return data;
		
	}
	}


