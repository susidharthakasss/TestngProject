package testcases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

/*
 * public class BaseClass {
 * 
 * WebDriver driver; private ThreadLocal<WebDriver> threadLocalDriver = new
 * ThreadLocal<>();
 * 
 * 
 * @BeforeMethod public void SetUp() {
 * 
 * // WebDriverManager.chromedriver().setup(); // driver = new ChromeDriver();
 * String DriverType = System.getProperty("Browser"); if
 * (DriverType.contains("firefox")) {
 * 
 * // WebDriverManager.firefoxdriver().setup(); driver = new FirefoxDriver();
 * 
 * } else if (DriverType.contains("edge")) {
 * 
 * // WebDriverManager.chromedriver().setup(); driver = new EdgeDriver(); } else
 * {
 * 
 * // WebDriverManager.chromedriver().setup(); driver = new ChromeDriver(); }
 * 
 * driver.get("https://simplilearn.com/");
 * 
 * driver.manage().window().maximize();
 * driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS); }
 * 
 * @AfterMethod public void TearDown() {
 * 
 * driver.close();
 * 
 * }
 * 
 * }
 */
public class BaseClass {

	WebDriver driver;
	
	private ThreadLocal<WebDriver> threadLocalDriver = new ThreadLocal<>();

	@BeforeMethod
	public void SetUp() {

		String DriverType = System.getProperty("Browser");
		if (DriverType.contains("firefox")) {

			//WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();

		} else {

			//WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		
		SetDriver(driver);
		GetDriver().get("https://simplilearn.com/");
		GetDriver().manage().window().maximize();
		GetDriver().manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
	}

	@AfterMethod
	public void TearDown() {

		GetDriver().close();

	}
	
	public void SetDriver(WebDriver driver) {

		threadLocalDriver.set(driver);

	}
	
	public WebDriver GetDriver() {

		return threadLocalDriver.get();

	}

}

