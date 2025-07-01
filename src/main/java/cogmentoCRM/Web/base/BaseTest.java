package cogmentoCRM.Web.base;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import cogmentoCRM.Web.pageObjects.CalenderPage;
import cogmentoCRM.Web.pageObjects.CallsPage;
import cogmentoCRM.Web.pageObjects.CampaignsPage;
import cogmentoCRM.Web.pageObjects.CasesPage;
import cogmentoCRM.Web.pageObjects.CompaniesPage;
import cogmentoCRM.Web.pageObjects.ContactsPage;
import cogmentoCRM.Web.pageObjects.CreateNewCompanyPage;
import cogmentoCRM.Web.pageObjects.CreateNewContactPage;
import cogmentoCRM.Web.pageObjects.CreateNewDealPage;
import cogmentoCRM.Web.pageObjects.CreateNewEventPage;
import cogmentoCRM.Web.pageObjects.DealsPage;
import cogmentoCRM.Web.pageObjects.DocumentsPage;
import cogmentoCRM.Web.pageObjects.FormsPage;
import cogmentoCRM.Web.pageObjects.HomePage;
import cogmentoCRM.Web.pageObjects.LoginPage;
import cogmentoCRM.Web.pageObjects.TasksPage;
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
	protected CallsPage callsPage;
	protected CampaignsPage campaignsPage;
	protected CasesPage casesPage;
	protected CompaniesPage companiesPage;
	protected DocumentsPage documentsPage;
	protected FormsPage formsPage;
	protected TasksPage tasksPage;
	protected CreateNewCompanyPage createNewCompanyPage;

	@BeforeMethod(alwaysRun = true)
	public void setUp() {
		WebDriverFactory.initializeDriver();
		driver = WebDriverFactory.getDriver();
		log = new LoggerUtil();

		// Initialize page objects with the thread-safe driver
		loginPage = new LoginPage(driver);
		homePage = new HomePage(driver);
		createNewContactpage = new CreateNewContactPage(driver);
		contactsPage = new ContactsPage(driver);
		calenderPage = new CalenderPage(driver);
		createNewEventPage = new CreateNewEventPage(driver);
		dealsPage = new DealsPage(driver);
		createNewDealPage = new CreateNewDealPage(driver);
		callsPage = new CallsPage(driver);
		campaignsPage = new CampaignsPage(driver);
		casesPage = new CasesPage(driver);
		companiesPage = new CompaniesPage(driver);
		documentsPage = new DocumentsPage(driver);
		formsPage = new FormsPage(driver);
		tasksPage = new TasksPage(driver);
		createNewCompanyPage = new CreateNewCompanyPage(driver);

		// Perform login
		ConfigUtil.loadConfig();
		String username = ConfigUtil.get("username");
		String password = ConfigUtil.get("password");
		try {
			loginPage.enterEmail(username);
			loginPage.enterPassword(password);
			loginPage.clickLogin();
			log.info("Logged into the Application...!");
		} catch (Exception e) {
			log.error("Login Failed: " + e.getMessage());
			throw new RuntimeException("Login Failed", e);
		}
	}

	@AfterMethod(alwaysRun = true)
	public void tearDown() {
		// Attempt logout, then quit driver
		try {
			homePage.clickIcon_Settings();
			homePage.click_Logout();
			log.info("Logged Out of the Application...!");
		} catch (Exception e) {
			log.warn("Logout may have failed: " + e.getMessage());
		}
		WebDriverFactory.quitDriver();
	}
}
