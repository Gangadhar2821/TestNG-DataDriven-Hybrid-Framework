package cogmentoCRM.Web.pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import cogmentoCRM.Web.base.BasePage;

public class CalenderPage extends BasePage {

	public CalenderPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//button[@class='ui linkedin button' and  contains(text(),'Create')]")
	private WebElement btn_Create;

	@FindBy(xpath = "//button[text()='Clear']")
	private WebElement btn_clearFilter;

	@FindBy(xpath = "//div[@name='view']")
	private WebElement dd_tableView;

	@FindBy(xpath = "//div[@role='option' ]/span[text()='Default View']")
	private WebElement opt_tableViewType;

	@FindBy(xpath = "//button[@class='ui linkedin button' and contains(text(),'Events')]")
	private WebElement btn_Events;

	@FindBy(xpath = "//table[@class='ui celled definition sortable striped table custom-grid']//a[contains(text(),'')]")
	private List<WebElement> table_EventTitles;

	public WebElement getBtn_Create() {
		return btn_Create;
	}

	public void clickonCreateBtn() {
		elementActions.clickElement(btn_Create);
	}

	public WebElement getBtn_Events() {
		return btn_Events;
	}

	public void validateAddedEvent(String referenceValue) {
		elementActions.clickElement(btn_Events);
		elementActions.clickElement(btn_clearFilter);
		elementActions.clickElement(dd_tableView);
		elementActions.clickElement(opt_tableViewType);
		for (WebElement ele : table_EventTitles) {
			if (ele.isDisplayed()) {
				String eventtxt = ele.getText().trim();
				if (eventtxt.contains(referenceValue)) {
					Assert.assertTrue(true);
					break;
				}
			}

		}

	}

}
