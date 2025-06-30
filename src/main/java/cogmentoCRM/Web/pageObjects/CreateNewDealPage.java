package cogmentoCRM.Web.pageObjects;

import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import cogmentoCRM.Web.base.BasePage;

public class CreateNewDealPage extends BasePage {

	public static String referenceValue;

	public CreateNewDealPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//input[@name='title']")
	private WebElement txt_title;

	public WebElement getTxt_title() {
		return txt_title;
	}

	public WebElement getTxt_company() {
		return txt_company;
	}

	public WebElement getTxt_closeDate() {
		return txt_closeDate;
	}

	public WebElement getTxtArea_description() {
		return txtArea_description;
	}

	public WebElement getTxt_probability() {
		return txt_probability;
	}

	public WebElement getTxt_amount() {
		return txt_amount;
	}

	public WebElement getDd_source() {
		return dd_source;
	}

	@FindBy(xpath = "//div[@name='company']//input[@type='text']")
	private WebElement txt_company;

	@FindBy(xpath = "//div[@name='type'and @role='listbox']")
	private WebElement dd_type;

	@FindBy(xpath = "//input[@class='calendarField']")
	private WebElement txt_closeDate;

	@FindBy(xpath = "//textarea[@name='description']")
	private WebElement txtArea_description;

	@FindBy(xpath = "//input[@name='probability']")
	private WebElement txt_probability;

	@FindBy(xpath = "//input[@name='amount']")
	private WebElement txt_amount;

	@FindBy(xpath = "//div[@name='source'and @role='listbox']")
	private WebElement dd_source;

	@FindBy(xpath = "//i[@class='save icon']")
	private WebElement btn_save;

	public void createDeal(Map<String, String> data) {
		elementActions.inputText(txt_title, data.get("title"));
		elementActions.inputText(txt_company, data.get("company"));
		elementActions.clickElement(txt_closeDate);
		dateandTimePicker(data.get("closedate"));
		elementActions.inputText(txtArea_description, data.get("description"));
		elementActions.inputText(txt_probability, data.get("probability"));
		elementActions.inputText(txt_amount, data.get("amount"));
		elementActions.selectOption(dd_type, data.get("type"));
		elementActions.selectOption(dd_source, data.get("source"));
		referenceValue = elementActions.getValue(txt_title);

	}

	public void clickSaveBtn() {
		elementActions.waitForElementToBeClickable(btn_save, 2);
		elementActions.clickElement(btn_save);
	}
}
