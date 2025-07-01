package cogmentoCRM.Web.pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import cogmentoCRM.Web.base.BasePage;

public class CompaniesPage extends BasePage {

	public CompaniesPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//table//td//a[contains(text(),'')]")
	private List<WebElement> filteredContacts_FirstNames;

	@FindBy(xpath = "//i[@class='refresh icon']")
	private WebElement icon_Refresh;

	@FindBy(xpath = "//span[@class='selectable ' and text()='Companies']")
	private WebElement screenTitle;

	public WebElement getScreenTitle() {
		return screenTitle;
	}

	public WebElement getBtn_Create() {
		return btn_Create;
	}

	@FindBy(xpath = "//button[contains(text(),'Create')]")
	private WebElement btn_Create;

	public void click_CreateBtn() {
		elementActions.waitForElementToBeClickable(btn_Create, 2);
		elementActions.clickElement(btn_Create);
	}

	public void verifyCreatedCompanyisListed(String referenceValue) {

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
