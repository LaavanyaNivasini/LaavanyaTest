package week3.day1.classroom;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

//import org.openqa.selenium.By;
//import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LeafGroundWebTable {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "./drivers/Chromedriver/chromedriver.exe");
		ChromeDriver driver =new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://www.leafground.com/pages/table.html");
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		
//Hari sir's code:
		
	    List<WebElement> rows = driver.findElementsByXPath("//table[@id='table_id']//tr");
        System.out.println(rows.size());
       
          List<Integer> listPercent = new ArrayList<Integer>();
          
          for (int i = 2; i <=rows.size(); i++) 
          {
          String text =
         driver.findElementByXPath("//table[@id='table_id']//tr["+i+"]/td[2]").getText
          ();
          System.out.println(text);
          String strNumber = text.replaceAll("%", ""); 
          int intNumber =
          Integer.parseInt(strNumber); 
          listPercent.add(intNumber); 
             }
          
          System.out.println(listPercent); 
          Collections.sort(listPercent);
          System.out.println("Sorted list:" +listPercent);
          
          Integer least = listPercent.get(0);
          
          driver.findElementByXPath("(//td[contains(text(),'" +least+
          "')])/following-sibling::td/input").click();
    

		
		
		//My failed try:
		
		/*WebElement table = driver.findElementById("table_id");
		List<WebElement> rowlist = table.findElements(By.tagName("tr"));
		System.out.println(rowlist.size());
		List<WebElement> cols = table.findElements(By.tagName("td"));
		System.out.println(cols.size());
		WebElement row3 = rowlist.get(2);
		System.out.println(row3.getText());
		//System.out.println(row3.findElement(By.tagName("td")));
		List<WebElement> columns = row3.findElements(By.tagName("td"));
		System.out.println(columns.get(1).getText());
		List<Integer> progressvalues= new ArrayList<Integer>();
		//for (int i = 2; i < rowlist.size(); i++) 
		{	for (WebElement eachRow : rowlist)
			{  
			List<WebElement> allcells = eachRow.findElements(By.tagName("td"));
				//for (WebElement eachCell : allcells)
				//{
				//	WebElement progressValueInString =eachCell.get(1).findElement(By.tagName("td[2]"));
			
					System.out.println(allcells.get(0).getText());
					
					WebElement progressValueInString =allcells.get(1);
					String progressVal = progressValueInString.getText().replace('%', ' ');
					int parsedIntProgVal = Integer.parseInt(progressVal);
					progressvalues.add(parsedIntProgVal);
			//	}
			
			
			}
			 
		}
		System.out.println(progressvalues);
		Collections.sort(progressvalues);
		System.out.println("After sorting:"+progressvalues);
		*/
		
		
		
		
    }


		
	}


