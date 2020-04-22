package week5.framework;

import java.util.concurrent.TimeUnit;

//import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class CreateLead {
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
	@Test(/*invocationCount=1*/timeOut=500,/*threadPoolSize=2 */ dataProvider="passData" )  //not wrkig for invoc.count=2.Chck y?
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
	public String[][] fetchData()
	{
		String [][] data = new String [1][3];
		data [0][0] = "Leaftaps";
		data[0][1]="NewSampleUser";
		data[0][2]="User";
		
		/*data[1][0]="IBM";
		data[1][1]="Aruna";
		data[1][2]="J";
		
		data[2][0]="CapGemini";
		data[2][1]="Preethi";
		data[2][2]="student";*/
		return data;
	}
	}
	


