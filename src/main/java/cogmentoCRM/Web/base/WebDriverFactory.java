package cogmentoCRM.Web.base;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import cogmentoCRM.Web.utilities.ConfigUtil;
import cogmentoCRM.Web.utilities.LoggerUtil;

public class WebDriverFactory {

	private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

	private WebDriverFactory() {
	}

	public static WebDriver getDriver() {
		return driver.get();
	}

	public static void initializeDriver() {
		try {
			LoggerUtil log = new LoggerUtil();
			log.info("--- Started the WebDriver ---");

			ConfigUtil.loadConfig();
			boolean isHeadless = Boolean.parseBoolean(ConfigUtil.get("headless"));

			String browser = ConfigUtil.get("browser").toUpperCase();
			String url = ConfigUtil.get("baseUrl");

			WebDriver localDriver;

			switch (browser) {
			case "CHROME":
				ChromeOptions chromeOptions = new ChromeOptions();
				if (isHeadless)
					chromeOptions.addArguments("--headless", "--disable-gpu", "--window-size=1920,1080");
				localDriver = new ChromeDriver(chromeOptions);
				log.info("Launched Chrome" + (isHeadless ? " in Headless Mode" : ""));
				break;

			case "FIREFOX":
				FirefoxOptions firefoxOptions = new FirefoxOptions();
				if (isHeadless)
					firefoxOptions.addArguments("-headless");
				localDriver = new FirefoxDriver(firefoxOptions);
				log.info("Launched Firefox" + (isHeadless ? " in Headless Mode" : ""));
				break;

			case "EDGE":
				EdgeOptions edgeOptions = new EdgeOptions();
				if (isHeadless)
					edgeOptions.addArguments("--headless", "--disable-gpu", "--window-size=1920,1080");
				localDriver = new EdgeDriver(edgeOptions);
				log.info("Launched Edge" + (isHeadless ? " in Headless Mode" : ""));
				break;

			default:
				throw new IllegalArgumentException("Unsupported browser: " + browser);
			}

			setDriver(localDriver);
			localDriver.manage().window().maximize();
			localDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
			localDriver.get(url);
			log.info("Maximized browser and navigated to URL");

		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("WebDriver initialization failed: " + e.getMessage());
		}
	}

	public static void setDriver(WebDriver driverInstance) {
		driver.set(driverInstance);
	}

	public static void quitDriver() {
		LoggerUtil log = new LoggerUtil();
		if (driver.get() != null) {
			driver.get().quit();
			log.info("--- Killed the WebDriver ---");
			driver.remove();
		}
	}
}
