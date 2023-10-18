package TestCases;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserStackSetup {

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
		driver.get("https://practicetestautomation.com/practice-test-login/");
	 }
		// finding webelements
		@Test
		public void login() throws InterruptedException {
			driver.findElement(By.id("username")).sendKeys("student");
			Thread.sleep(1000);
			System.out.println("username entered");
			driver.findElement(By.id("password")).sendKeys("Password123");
			Thread.sleep(1000);
			System.out.println("password entered");
			driver.findElement(By.id("submit")).click();
			Thread.sleep(1000);
			System.out.println("clicked button entered");
			System.out.println("on the new page");

			// Verify new page URL contains
			// practicetestautomation.com/logged-in-successfully/
			String originalUrl = "https://practicetestautomation.com/logged-in-successfully/";
			String currentURL = driver.getCurrentUrl();

			if (originalUrl.equals(currentURL)) {
				System.out.println("1.testcase passed");
			} else {
				System.out.println("1.testcase failed");
			}

			// Verify new page contains expected text ('Congratulations' or 'successfully
			// logged in')
			String originalText = "Congratulations student. You successfully logged in!";
			String Actaultext = driver.findElement(By.className("has-text-align-center")).getText();

			if (originalText.equals(Actaultext)) {
				System.out.println("2.testcase passed");
			} else {
				System.out.println("2.testcase failed");
			}

			System.out.println("text"+Actaultext);
			
			String originalTitle = "Logged In Successfully | Practice Test Automation";
			String ActaulTitle = driver.getTitle();
			System.out.println("title is : "+ActaulTitle);     
			

			if (originalTitle.equals(ActaulTitle)) {
				System.out.println("3.testcase passed");
			} else {
				System.out.println("3.testcase failed");
			}
			
			
			driver.findElement(By.linkText("Log out")).click();
			
			String originalUrl1 = "https://practicetestautomation.com/practice-test-login/";
			String currentURL1 = driver.getCurrentUrl();

			if (originalUrl1.equals(currentURL1)) {
				System.out.println("4.testcase passed");
			} else {
				System.out.println("4.testcase failed");
			}
			
			System.out.println("added the code changes");
			System.out.println("updating code to sub barnch from local repository or eclipse to github repository");
			
		}
		
		 @AfterTest
		 public void tearup() 
		 {
		driver.close();
		 }
	


}
