package cogmentoCRM.Web.pageObjects;

import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import cogmentoCRM.Web.base.BasePage;

public class CreateNewEventPage extends BasePage {

	public CreateNewEventPage(WebDriver driver) {
		super(driver);
	}

	public static String referenceValue;

	public WebElement getPageTitle() {
		return pageTitle;
	}

	public WebElement getTxt_Title() {
		return txt_Title;
	}

	public WebElement getTxt_StartDate() {
		return txt_StartDate;
	}

	public WebElement getTxt_EndDate() {
		return txt_EndDate;
	}

	public WebElement getDd_Category() {
		return dd_Category;
	}

	public WebElement getTextArea_Description() {
		return textArea_Description;
	}

	public WebElement getTextArea_Location() {
		return textArea_Location;
	}

	public WebElement getTgl_AllDay() {
		return tgl_AllDay;
	}

	public WebElement getBtn_Save() {
		return btn_Save;
	}

	@FindBy(xpath = "//div[@class='ui header item mb5 light-black']//span")
	private WebElement pageTitle;

	@FindBy(xpath = "//input[@name='title']")
	private WebElement txt_Title;

	@FindBy(xpath = "//label[text()='Start Date']/parent::div//input")
	private WebElement txt_StartDate;

	@FindBy(xpath = "//label[text()='End Date']/parent::div//input")
	private WebElement txt_EndDate;

	@FindBy(xpath = "//div[@role='listbox' and @name='category']")
	private WebElement dd_Category;

	@FindBy(xpath = "//textarea[@name='description']")
	private WebElement textArea_Description;

	@FindBy(xpath = "//textarea[@name='location']")
	private WebElement textArea_Location;

	@FindBy(xpath = "//input[@name='all_day']")
	private WebElement tgl_AllDay;

	@FindBy(xpath = "//button[@class='ui linkedin button' and contains(text(),'Save')]")
	private WebElement btn_Save;

	@FindBy(xpath = "//input[@name='identifier']")
	private WebElement txt_Identifier;

	public WebElement getLogo_calenderIcon() {
		elementActions.waitForElementToBeVisible(logo_calenderIcon, 4);
		return logo_calenderIcon;
	}

	@FindBy(xpath = "//i[@class='calendar alternate outline icon']/ancestor::span[contains(@class,'selectable')]")
	private WebElement logo_calenderIcon;

	public WebElement getTxt_Identifier() {
		return txt_Identifier;
	}

	public void getCapturedText(WebElement txt_Title) {
		referenceValue = elementActions.getValue(txt_Title);

	}

	public void addNewEvent(Map<String, String> data) {
		elementActions.inputText(txt_Title, data.get("Title"));
		elementActions.clickElement(txt_StartDate);
		dateandTimePicker(data.get("Start Date"));
		elementActions.clickElement(txt_EndDate);
		dateandTimePicker(data.get("End Date"));
		elementActions.selectOption(dd_Category, data.get("Category"));
		elementActions.inputText(textArea_Description, data.get("Description"));
		elementActions.inputText(textArea_Location, data.get("Location"));
		elementActions.switchToggle(tgl_AllDay, data.get("All Day"));
		elementActions.inputText(txt_Identifier, data.get("Identifier"));
		clickSaveBtn();
		getCapturedText(txt_Title);
	}

	public void clickSaveBtn() {
		elementActions.clickElement(btn_Save);
	}
}
