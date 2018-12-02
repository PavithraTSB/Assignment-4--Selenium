package selenium;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Amazon {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		//implicit wait
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//Maximizing the window
		driver.manage().window().maximize();
		//navigate to the url
		driver.get("https://www.amazon.in/");
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Laptops");
		driver.findElement(By.xpath("//input[@class='nav-input']")).click();
		
		//Getting all the links in list
		List<WebElement> tags = driver.findElements(By.tagName("a"));
		//Printing total number of links
		System.out.println("Total number of Links =" +tags.size());
		//Iterating to all the links
		for(int i=1;i<tags.size();i++)
		{    
			//Printing all links and linktext
			System.out.println("Links are :"+tags.get(i).getText());
	        System.out.println("Link Text are :"+tags.get(i).getAttribute("href"));
		}
	
	
	}

}
