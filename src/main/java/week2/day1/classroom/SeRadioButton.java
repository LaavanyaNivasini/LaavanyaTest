package week2.day1.classroom;

import org.openqa.selenium.chrome.ChromeDriver;

public class SeRadioButton {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","./drivers/Chromedriver/chromedriver.exe");
		ChromeDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://www.leafground.com/");
		driver.findElementByLinkText("Radio Button").click();
	//	driver.findElementByXPath("(//input[@type='radio']).[1]").click();
	//	driver.findElementByXPath("(//input[@id='yes']).[1]").click();
		Thread.sleep(2000);
		driver.findElementByXPath("//label[@for='yes']/input").click();
		System.out.println(driver.findElementByXPath("(//label[@for='Checked'])").getText());
		//Age part could have been done simply by using value attribute alone also ==> (//input[@value='0'])[3]
		int age=55;
		if(age >=1 && age <=20) {
		driver.findElementByXPath("//input[@type='radio' and @class='myradio' and @name='age' and @value='0']").click();
		}
		if(age >=21 && age <=40) {
			driver.findElementByXPath("//input[@type='radio' and @class='myradio' and @name='age' and @value='1']").click();
			}
		if(age > 40) {
			driver.findElementByXPath("//input[@type='radio' and @class='myradio' and @name='age' and @value='2']").click();
			}

}
}