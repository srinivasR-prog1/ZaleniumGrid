package testCases;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class LoginTest {

	RemoteWebDriver driver;
	DesiredCapabilities dc;

	@Parameters("browser")
	@BeforeTest
	public void setUp(String browserName) throws MalformedURLException {

		dc = new DesiredCapabilities();
		ChromeOptions options = new ChromeOptions();
	//	options.addArguments("--headless");
	//	options.addArguments("--disable-gpu");
		options.addArguments("--disable-dev-shm-usage");

		if (browserName.contains("chrome")) {
			dc.setCapability(CapabilityType.BROWSER_NAME, BrowserType.CHROME);
			dc.setCapability(CapabilityType.PLATFORM_NAME, Platform.LINUX);
			dc.setCapability(ChromeOptions.CAPABILITY, options);

		} else if (browserName.contains("firefox")) {

			dc.setCapability(CapabilityType.BROWSER_NAME, BrowserType.FIREFOX);
			dc.setCapability(CapabilityType.PLATFORM_NAME, Platform.LINUX);

		}
		URL url = new URL("http://172.18.144.1:4444/wd/hub");
		
		
		driver = new RemoteWebDriver(url, dc);
		driver.manage().window().maximize();
		driver.get("https://demo.guru99.com/v4/index.php");

	}

	@Test
	public void loginTest() throws InterruptedException {

		driver.findElement(By.name("uid")).sendKeys("mngr362501");
		driver.findElement(By.name("password")).sendKeys("byjEmyr");
		driver.findElement(By.name("btnLogin")).click();
		Thread.sleep(5000);
		Assert.assertEquals(driver.getTitle(), "Guru99 Bank Manager HomePage");
		driver.findElement(By.xpath("//a[text()='Log out']")).click();

	}

	@AfterTest
	public void tearDown() {

		driver.quit();

	}

}
