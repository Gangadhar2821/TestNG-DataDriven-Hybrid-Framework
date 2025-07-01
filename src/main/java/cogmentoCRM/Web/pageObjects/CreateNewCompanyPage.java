package cogmentoCRM.Web.pageObjects;

import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import cogmentoCRM.Web.base.BasePage;

public class CreateNewCompanyPage extends BasePage {

	public CreateNewCompanyPage(WebDriver driver) {
		super(driver);
	}

	public static String referenceValue;

	@FindBy(xpath = "//*[@id='main-content']/div/div[2]/form/div[1]/div[1]/div/div/div/input")
	private WebElement txt_Name;

	@FindBy(xpath = "//span[@class='selectable ']")
	private WebElement screenTitle;

	public WebElement getTxt_Name() {
		return txt_Name;
	}

	public WebElement getTxt_StreetAddress() {
		return txt_StreetAddress;
	}

	public WebElement getTxt_PostCode() {
		return txt_PostCode;
	}

	public WebElement getTxt_PhNumber() {
		return txt_PhNumber;
	}

	public WebElement getTxt_EmailId() {
		return txt_EmailId;
	}

	public WebElement getTxtArea_Description() {
		return txtArea_Description;
	}

	public WebElement getTxt_NoOfEmployees() {
		return txt_NoOfEmployees;
	}

	public WebElement getTxt_AnnualRevenue() {
		return txt_AnnualRevenue;
	}

	public WebElement getDd_Category() {
		return dd_Category;
	}

	public WebElement getBtn_Save() {
		return btn_Save;
	}

	public WebElement getBtn_Cancel() {
		return btn_Cancel;
	}

	@FindBy(xpath = "//input[@placeholder='Street Address']")
	private WebElement txt_StreetAddress;

	@FindBy(xpath = "//input[@placeholder='Post Code']")
	private WebElement txt_PostCode;

	@FindBy(xpath = "//input[@placeholder='Number']")
	private WebElement txt_PhNumber;

	@FindBy(xpath = "//input[@placeholder='Email address']")
	private WebElement txt_EmailId;

	@FindBy(xpath = "//textarea[@name='description']")
	private WebElement txtArea_Description;

	@FindBy(xpath = "//input[@name='num_employees']")
	private WebElement txt_NoOfEmployees;

	@FindBy(xpath = "//input[@name='annual_revenue']")
	private WebElement txt_AnnualRevenue;

	@FindBy(xpath = "//div[@name='category' and @role='listbox']")
	private WebElement dd_Category;

	@FindBy(xpath = "//button[normalize-space()='Save']")
	private WebElement btn_Save;

	@FindBy(xpath = "//button[normalize-space()='Cancel']")
	private WebElement btn_Cancel;

	public void createNewCompany(Map<String, String> data) {
		elementActions.inputText(txt_Name, data.get("name"));
		elementActions.inputText(txt_StreetAddress, data.get("streetAddress"));
		elementActions.inputText(txt_PostCode, data.get("postCode"));
		elementActions.inputText(txt_PhNumber, data.get("phNumber"));
		elementActions.inputText(txt_EmailId, data.get("emailId"));
		elementActions.inputText(txtArea_Description, data.get("description"));
		elementActions.inputText(txt_NoOfEmployees, data.get("NumOfEmployees"));
		elementActions.inputText(txt_AnnualRevenue, data.get("annualRevenue"));
		elementActions.selectOption(dd_Category, data.get("category"));
		referenceValue = elementActions.getValue(txt_Name);
		elementActions.clickElement(btn_Save);
	}

	public void verifyCreateNewComapanyPage() {
		Assert.assertEquals(driver.getCurrentUrl(), "https://ui.cogmento.com/companies/new");

	}

}
