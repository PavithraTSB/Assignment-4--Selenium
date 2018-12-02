package selenium;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Datatables {

	static int tvalue,totalvalue;
	
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.get("https://datatables.net/");
		
		//Traverse to the rows
		List<WebElement>rows=driver.findElements(By.xpath("//table[@id='example']/tbody/tr"));
		int rowcount=rows.size();
		//when clicking we have another row as salary
		int fullrow=rowcount*2;
		System.out.println("row count: " + rowcount);
		
		//Traverse to the column
		List<WebElement>cols=driver.findElements(By.xpath("//table[@id='example']/tbody/tr/td"));
		int colcount=cols.size();
		System.out.println("column count: " + colcount);

		//Iterating to click each row
		for(int i=1;i<fullrow;i++)
		{
			WebElement singlerow=driver.findElement(By.xpath("//*[@id='example']/tbody/tr[" + i + "]/td[1]"));
			singlerow.click();
		}
		     //Iterating the row
			for(int salrow=1;salrow<=fullrow;salrow++)
			{
			   //Need a salary on each row & salary is in even row
				if(salrow%2==0)
				{
					WebElement salaryamount=driver.findElement(By.xpath("//*[@id=\"example\"]/tbody/tr["+ salrow + "]/td[1]/ul/li/span[2]"));
					//Getting all the salaries
					String salaryvalue=salaryamount.getText();
					System.out.println(salaryvalue);
					//calling method reg
					Datatables.reg(salaryvalue);
					//Adding all the values in the list
					List<Integer> list=new ArrayList<Integer>();
					list.add(tvalue);
					for(int l=0;l<list.size();l++)
					{
						//adding all the salaries
						totalvalue=totalvalue+list.get(l);
						
					}
					
				}
				
			}

			
			System.out.println("Total value is: " + totalvalue);
			
		
}
	//Converting String into char then to integer to add the salaries
	public static void reg(String value)
	{
		
		String svalue="";
		
	for(int s=0;s<value.length();s++)
	{
		char ch=value.charAt(s);
		if(Character.isDigit(ch))
		{
			svalue=svalue + Character.toString(ch);
			
		}
		
	}
	tvalue=Integer.parseInt(svalue);
	System.out.println(tvalue);
	}
}
