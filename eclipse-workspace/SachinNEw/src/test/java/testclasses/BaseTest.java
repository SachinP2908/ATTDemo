package testclasses;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import io.github.bonigarcia.wdm.WebDriverManager;
import pages.BuyOnlinePlans;

public class BaseTest {
	public static WebDriver driver;
	public BuyOnlinePlans bop;

	@BeforeSuite
	public void initDriver() throws IOException, Exception {
		WebDriverManager.chromedriver().setup();
//		WebDriverManager.chromedriver().clearDriverCache().setup();
//		WebDriverManager.chromedriver().clearResolutionCache().setup();
//		manager.clearResolutionCache(); manager.clearDriverCache();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--start-maximized");
		options.addArguments("--disable-notification");
//		options.addArguments("--incognito");
//		options.addArguments("--headless");
		driver = new ChromeDriver(options);
//		driver.manage().window().maximize();

		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "//config.properties");
		prop.load(fis);
		driver.get(prop.getProperty("testsiteurl"));
		Thread.sleep(2000);

	}

	@BeforeClass
	public void creatObjects() {
// class name
		bop = new BuyOnlinePlans(driver);
	}
}
