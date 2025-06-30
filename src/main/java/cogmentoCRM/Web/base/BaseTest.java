package cogmentoCRM.Web.base;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import cogmentoCRM.Web.pageObjects.CalenderPage;
import cogmentoCRM.Web.pageObjects.ContactsPage;
import cogmentoCRM.Web.pageObjects.CreateNewContactPage;
import cogmentoCRM.Web.pageObjects.CreateNewDealPage;
import cogmentoCRM.Web.pageObjects.CreateNewEventPage;
import cogmentoCRM.Web.pageObjects.DealsPage;
import cogmentoCRM.Web.pageObjects.HomePage;
import cogmentoCRM.Web.pageObjects.LoginPage;
import cogmentoCRM.Web.utilities.ConfigUtil;
import cogmentoCRM.Web.utilities.LoggerUtil;

public class BaseTest {

	protected WebDriver driver;
	protected LoggerUtil log;

	// Non-static, thread-safe page objects
	protected LoginPage loginPage;
	protected HomePage homePage;
	protected CreateNewContactPage createNewContactpage;
	protected ContactsPage contactsPage;
	protected CalenderPage calenderPage;
	protected CreateNewEventPage createNewEventPage;
	protected DealsPage dealsPage;
	protected CreateNewDealPage createNewDealPage;

	@BeforeClass(alwaysRun = true)
	public void setUp() {
		WebDriverFactory.initializeDriver();
		driver = WebDriverFactory.getDriver();
		log = new LoggerUtil();

		// Initialize page objects with thread-local driver
		loginPage = new LoginPage(driver);
		homePage = new HomePage(driver);
		createNewContactpage = new CreateNewContactPage(driver);
		contactsPage = new ContactsPage(driver);
		calenderPage = new CalenderPage(driver);
		createNewEventPage = new CreateNewEventPage(driver);
		dealsPage = new DealsPage(driver);
		createNewDealPage = new CreateNewDealPage(driver);
		login();
	}

	public void login() {
		// Login steps
		String username = ConfigUtil.get("username");
		String password = ConfigUtil.get("password");
		loginPage.enterEmail(username);
		loginPage.enterPassword(password);
		loginPage.clickLogin();
		log.info("Logged into the Application...!");
	}

	public void Logout() {
		try {
			homePage.getIcon_Settings().click();
			homePage.getBtn_Logout().click();
			log.info("Logged Out of the Application...!");
		} catch (Exception e) {
			log.error("Logout failed: " + e.getMessage());
		}
	}

	@AfterClass(alwaysRun = true)
	public void tearDown() {
		Logout();
		WebDriverFactory.quitDriver();
	}
}
