package takesScreenshot;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.google.common.io.Files;

import dev.failsafe.internal.util.Durations;

public class Screenshot {

	public static void main(String[] args) throws Exception {

		System.setProperty("webdriver.Firefox.driver",
				"C:\\Users\\Manha\\OneDrive\\Desktop\\Selenium&Driver\\msedgedriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();

		driver.get("https://www.google.com");
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(15));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

		capturescreenshot(driver, CurrentTime());

		driver.close();

	}

	public static void capturescreenshot(WebDriver driver, String time) throws Exception {

		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

		Files.copy(src, new File(
				"C:\\Users\\Manha\\eclipse-workspace\\AutomationPractice\\Screenshot\\image_" + time + ".png"));

		System.out.println("Captured");

	}

	public static String CurrentTime() {

		Date date = new Date();
		return new SimpleDateFormat("YYYY_MM_hh_mm_ss").format(date);

	}

}
