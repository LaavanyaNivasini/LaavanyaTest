package week5.day2;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class CreateLead3 {

	public static ChromeDriver driver ; //= new ChromeDriver(); 
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
	@Test(invocationCount=1,timeOut=50000,threadPoolSize=4,dataProvider="passData" )  
	//am expecting the above linee to make 4 browsers to open parallely and each browser one lead creation should happen.
		//But the lead creation happens sequentially only.  Y? 
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
	
	@DataProvider(name = "passData")
	String[][] passDataToTestCase() throws IOException{
		return ReadExcel.fillTheArray("Myexcel");
		
	}
	
}
