package parallel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test {

	WebDriver driver;

	@Parameters("browser")
	@BeforeTest
	public void setup(String browser) {

		if (browser.equalsIgnoreCase("chrome")) {

			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();

		} else if (browser.equalsIgnoreCase("edge")) {

			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();

		
	} else if (browser.equalsIgnoreCase("firefox")) {
		
		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
		
	}

	}

	@org.testng.annotations.Test
	public void browsertest() {

		driver.manage().window().maximize();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        System.out.println(driver.getTitle());
		String actualtitle = driver.getTitle();
		String ExpectedTitle = "OrangeHRM";
		Assert.assertEquals(ExpectedTitle, actualtitle, "Title is not match");

	}
	@org.testng.annotations.Test
	public void googletest() throws InterruptedException {
		
		
		driver.manage().window().maximize();
		driver.get("https://www.google.com");
        System.out.println(driver.getTitle());
		String actualtitle = driver.getTitle();
		String ExpectedTitle = "Google";
		Assert.assertEquals(ExpectedTitle, actualtitle, "Title is not match");	
		
		
        
       
	}
	
	
	
	@org.testng.annotations.Test
	public void titleTest() throws Exception {

		driver.manage().window().maximize();
		driver.get("https://www.facebook.com/");
        System.out.println(driver.getTitle());
		
		 Thread.sleep(4000);
	}
	
	 
	@AfterTest
	 void teardown() {

		driver.close();

	}

}
