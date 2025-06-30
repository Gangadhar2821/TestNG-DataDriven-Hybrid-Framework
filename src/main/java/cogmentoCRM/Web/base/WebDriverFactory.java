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
	static LoggerUtil log;

	private WebDriverFactory() {
	}

	public static WebDriver getDriver() {
		return driver.get();
	}

	public static void initializeDriver() {
		log = new LoggerUtil();
		log.info("--- Started the WebDriver ---");

		ConfigUtil.loadConfig();
		boolean isHeadless = Boolean.parseBoolean(ConfigUtil.get("headless"));
		String browser = ConfigUtil.get("browser").toUpperCase();
		String url = ConfigUtil.get("baseUrl");

		WebDriver localDriver = null;

		switch (browser) {
		case "CHROME":
			ChromeOptions chromeOptions = new ChromeOptions();
			if (isHeadless) {
				chromeOptions.addArguments("--headless", "--disable-gpu", "--window-size=1920,1080");
			}
			localDriver = new ChromeDriver(chromeOptions);
			log.info("Launched the Chrome Browser" + (isHeadless ? " in Headless Mode..." : "..."));
			break;

		case "FIREFOX":
			FirefoxOptions firefoxOptions = new FirefoxOptions();
			if (isHeadless) {
				firefoxOptions.addArguments("-headless");
			}
			localDriver = new FirefoxDriver(firefoxOptions);
			log.info("Launched the Firefox Browser" + (isHeadless ? " in Headless Mode..." : "..."));
			break;

		case "EDGE":
			EdgeOptions edgeOptions = new EdgeOptions();
			if (isHeadless) {
				edgeOptions.addArguments("--headless", "--disable-gpu", "--window-size=1920,1080");
			}
			localDriver = new EdgeDriver(edgeOptions);
			log.info("Launched the Edge Browser" + (isHeadless ? " in Headless Mode..." : "..."));
			break;

		default:
			log.info("Invalid browser: " + browser);
			throw new IllegalArgumentException("Unsupported browser: " + browser);
		}

		setDriver(localDriver);

		localDriver.manage().window().maximize();
		localDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
		localDriver.get(url);
		log.info("Maximized the Browser and Navigated to the Test URL...");
	}

	public static void setDriver(WebDriver driverInstance) {
		driver.set(driverInstance);
	}

	public static void quitDriver() {
		if (driver.get() != null) {
			driver.get().quit();
			log.info("--- Killed the WebDriver ---");
			driver.remove();
		}
	}
}
