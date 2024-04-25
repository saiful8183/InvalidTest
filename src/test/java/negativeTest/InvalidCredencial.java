package negativeTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class InvalidCredencial {

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

	@Test
	public void TestPositiveTestCases() {

		System.setProperty("webdriver.Edge.driver",
				"C:\\Users\\Manha\\OneDrive\\Desktop\\Selenium&Driver\\msedgedriver.exe");
		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();

		driver.get("https://www.saucedemo.com/v1/index.html");
		WebElement username = driver.findElement(By.xpath("//input[@id='user-name']"));
		username.sendKeys("standard_user");
		WebElement password = driver.findElement(By.xpath("//input[@id='password']"));
		password.sendKeys("secret_sauce");

		driver.findElement(By.xpath("//input[@id='login-button']")).click();
		Assert.assertTrue(driver.findElement(By.className("product_label")).isDisplayed());

		driver.close();
	}

	@Test
	public void TestNegetiveTestCasesss() {

		System.setProperty("webdriver.Edge.driver",
				"C:\\Users\\Manha\\OneDrive\\Desktop\\Selenium&Driver\\msedgedriver.exe");
		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();

		driver.get("https://www.saucedemo.com/v1/index.html");
		WebElement username = driver.findElement(By.xpath("//input[@id='user-name']"));
		username.sendKeys("standard_us");
		WebElement password = driver.findElement(By.xpath("//input[@id='password']"));
		password.sendKeys("secret_sau");

		driver.findElement(By.xpath("//input[@id='login-button']")).click();

		Assert.assertTrue(
				driver.findElement(By.xpath("//*[@id=\"login_button_container\"]/div/form/h3")).isDisplayed());

		driver.close();
	}

	
	}


