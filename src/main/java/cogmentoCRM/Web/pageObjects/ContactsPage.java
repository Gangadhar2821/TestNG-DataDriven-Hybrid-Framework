package cogmentoCRM.Web.pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import cogmentoCRM.Web.base.BasePage;

public class ContactsPage extends BasePage {

	public ContactsPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//table//td//a[contains(text(),'')]")
	private List<WebElement> filteredContacts_FirstNames;

	@FindBy(xpath = "//button[@class='ui linkedin button' and contains(text(),'Create')]")
	private WebElement btn_createContact;

	@FindBy(xpath = "//button[normalize-space()='Show Filters']")
	private WebElement btn_showfilter;

	@FindBy(xpath = "//input[@class='search']")
	private WebElement dd_search;

	@FindBy(xpath = "//div[@name='operator']")
	private WebElement dd_operator;

	@FindBy(xpath = "//input[@name='value']")
	private WebElement txt_value;

	@FindBy(xpath = "//i[@class='search small icon']/parent::button")
	private WebElement btn_applyFilter;

	@FindBy(xpath = "//div[@class='ui fitted read-only checkbox']")
	private WebElement ckb_selectRow;

	@FindBy(xpath = "//button[@class='ui icon button']//i[@class='edit icon']")
	private WebElement icon_editContact;

	@FindBy(xpath = "//i[@class='refresh icon']")
	private WebElement icon_Refresh;

	public WebElement getBtn_createContact() {
		return btn_createContact;
	}

	public void clickBtnCreateContact() {
		elementActions.clickElement(btn_createContact);

	}

	public void validateCreatedContact(String referenceValue) {
		elementActions.clickElement(icon_Refresh);
		try {
			String firstName = null;
			elementActions.waitForElementsToBeVisible(filteredContacts_FirstNames, 2);
			for (WebElement ele : filteredContacts_FirstNames) {
				if (ele.isDisplayed()) {
					firstName = ele.getText().trim();
					if (firstName.startsWith(referenceValue)) {
						Assert.assertTrue(true);
						break;
					}
				}
			}

		} catch (Exception e) {
			log.error(e.getMessage());
		}
	}
}
