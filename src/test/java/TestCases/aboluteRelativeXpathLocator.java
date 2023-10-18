package TestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class aboluteRelativeXpathLocator {
		
	WebDriver driver;
	
		@BeforeTest
		 public void setup() 
		 {

		   WebDriverManager.chromedriver().setup();
			// open the browser
			driver = new ChromeDriver();
			// maximize window
			driver.manage().window().maximize();
			// navigate to url
			driver.get("https://www.saucedemo.com/");
		 }
		
		@Test
		public void login1()
		{
			driver.findElement(By.xpath("//input[@id='password']")).sendKeys("supriya");
			
			//absolute xpath
			driver.findElement(By.xpath("/html/body/div/div/div[2]/div[1]/div/div/form/div[1]/input")).sendKeys("supriya");
			System.out.println("entred usrname and password");
		}
		
		
		 @AfterTest
		 public void tearup() 
		 {
		driver.close();
		 }

}

