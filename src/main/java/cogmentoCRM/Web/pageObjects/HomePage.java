package cogmentoCRM.Web.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import cogmentoCRM.Web.base.BasePage;

public class HomePage extends BasePage {

	public HomePage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//span[@class='user-display']")
	private WebElement logo_Username;

	@FindBy(xpath = "//i[@class='home icon']")
	private WebElement icon_Home;

	@FindBy(xpath = "//i[@class='tasks icon']")
	private WebElement icon_Tasks;

	@FindBy(xpath = "//i[@class='users icon']/parent::a")
	private WebElement icon_Contacts;

	@FindBy(xpath = "//i[@class='building icon']")
	private WebElement icon_Companies;

	@FindBy(xpath = "//i[@class='comments icon']")
	private WebElement icon_Cases;

	@FindBy(xpath = "//i[@class='settings icon' ]/parent::div")
	private WebElement icon_Settings;

	@FindBy(xpath = "//i[@class='settings icon']/parent::a")
	private WebElement btn_Settings;

	@FindBy(xpath = "//a[@role='option']/span[contains(text(),'Out')]")
	private WebElement btn_Logout;

	@FindBy(xpath = "//i[@class='calendar icon']")
	private WebElement icon_Calender;

	public WebElement getIcon_Tasks() {
		return icon_Tasks;
	}

	public WebElement getIcon_Companies() {
		return icon_Companies;
	}

	public WebElement getIcon_Cases() {
		return icon_Cases;
	}

	public WebElement getIcon_Calls() {
		return icon_Calls;
	}

	public WebElement getIcon_Documents() {
		return icon_Documents;
	}

	public WebElement getIcon_Campaigns() {
		return icon_Campaigns;
	}

	public WebElement getIcon_Forms() {
		return icon_Forms;
	}

	@FindBy(xpath = "//i[@class='money icon']")
	private WebElement icon_Deals;

	@FindBy(xpath = "//i[@class='phone icon']")
	private WebElement icon_Calls;

	@FindBy(xpath = "//i[@class='file icon']")
	private WebElement icon_Documents;

	@FindBy(xpath = "//i[@class='target icon']")
	private WebElement icon_Campaigns;

	@FindBy(xpath = "//i[@class='wpforms icon']")
	private WebElement icon_Forms;

	@FindBy(xpath = "//i[@class='mail outline icon']")
	private WebElement icon_Email;

	@FindBy(xpath = "//i[@class='line chart icon']")
	private WebElement icon_Reports;

	public WebElement getBtn_Settings() {
		return btn_Settings;
	}

	public WebElement getIcon_Email() {
		return icon_Email;
	}

	public WebElement getIcon_Reports() {
		return icon_Reports;
	}

	public WebElement getIcon_Calender() {
		return icon_Calender;
	}

	public WebElement getIcon_Deals() {
		return icon_Deals;
	}

	public void clickIcon_Deals() {
		elementActions.clickElement(icon_Deals);
	}

	public WebElement getLogo_Username() {
		elementActions.waitForElementToBeVisible(logo_Username, 2);
		return logo_Username;
	}

	public WebElement getIcon_Home() {
		return icon_Home;
	}

	public WebElement getIcon_Contacts() {
		return icon_Contacts;
	}

	public WebElement getIcon_Settings() {
		return icon_Settings;
	}

	public WebElement getBtn_Logout() {
		return btn_Logout;
	}

	public void click_Logout() {
		elementActions.scrollToElement(btn_Logout);
		elementActions.jsClick(driver, btn_Logout);
	}

	public void clickIcon_Contacts() {
		elementActions.waitForElementToBeVisible(icon_Contacts, 2);
		elementActions.jsClick(driver, icon_Contacts);
	}

	public void clickIcon_Settings() {
		elementActions.scrollToElement(icon_Settings);
		elementActions.waitForElementToBeClickable(icon_Settings, 3);
		elementActions.jsClick(driver, icon_Settings);
	}

	public void clickIcon_Calender() {
		elementActions.waitForElementToBeVisible(icon_Contacts, 2);
		elementActions.jsClick(driver, icon_Calender);
	}

	public void clickIcon_Campaigns() {
		elementActions.waitForElementToBeVisible(icon_Campaigns, 2);
		elementActions.jsClick(driver, icon_Campaigns);
	}

	public void clickIcon_Cases() {
		elementActions.waitForElementToBeVisible(icon_Cases, 2);
		elementActions.jsClick(driver, icon_Cases);
	}

	public void clickIcon_Documents() {
		elementActions.waitForElementToBeVisible(icon_Documents, 2);
		elementActions.jsClick(driver, icon_Documents);
	}

	public void clickIcon_Forms() {
		elementActions.waitForElementToBeVisible(icon_Forms, 2);
		elementActions.jsClick(driver, icon_Forms);
	}

	public void clickIcon_Tasks() {
		elementActions.waitForElementToBeVisible(icon_Tasks, 2);
		elementActions.jsClick(driver, icon_Tasks);
	}

	public void clickIcon_Companies() {
		elementActions.waitForElementToBeVisible(icon_Companies, 2);
		elementActions.jsClick(driver, icon_Companies);
	}

	public void clickIcon_Calls() {
		elementActions.waitForElementToBeVisible(icon_Calls, 2);
		elementActions.jsClick(driver, icon_Calls);
	}

	public void clickIcon_Home() {
		elementActions.waitForElementToBeVisible(icon_Home, 2);
		elementActions.jsClick(driver, icon_Home);
	}

	public void clickIcon_Setting_icon() {
		elementActions.waitForElementToBeVisible(icon_Settings, 2);
		elementActions.jsClick(driver, icon_Settings);
	}

	public void clickBtn_Settings() {
		elementActions.waitForElementToBeVisible(btn_Settings, 2);
		elementActions.jsClick(driver, btn_Settings);
	}

	public void clickIcon_Email() {
		elementActions.waitForElementToBeVisible(icon_Email, 2);
		elementActions.jsClick(driver, icon_Email);
	}

	public void clickIcon_Reports() {
		elementActions.waitForElementToBeVisible(icon_Reports, 2);
		elementActions.jsClick(driver, icon_Reports);
	}

	public void verifyHomePageIsDisplayed() {
		clickIcon_Home();
		Assert.assertEquals(driver.getCurrentUrl(), "https://ui.cogmento.com/home");
	}
}
