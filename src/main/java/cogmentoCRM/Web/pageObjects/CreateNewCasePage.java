package cogmentoCRM.Web.pageObjects;

import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import cogmentoCRM.Web.base.BasePage;

public class CreateNewCasePage extends BasePage {

	public CreateNewCasePage(WebDriver driver) {
		super(driver);
	}

	public static String referenceValue;

	@FindBy(name = "title")
	private WebElement txt_Title;

	@FindBy(xpath = "//label[normalize-space()='Assigned To']/parent::div//div[@role='listbox']")
	private WebElement dd_AssignedTo;

	@FindBy(xpath = "//label[normalize-space()='Type']/parent::div//div[@role='listbox']")
	private WebElement dd_Type;

	@FindBy(xpath = "//label[normalize-space()='Deadline']/parent::div//input")
	private WebElement txt_DeadlineDate;

	@FindBy(xpath = "//label[normalize-space()='Close Date']/parent::div//input")
	private WebElement txt_CloseDate;

	@FindBy(xpath = "//textarea[@name='description']")
	private WebElement txtArea_Description;

	@FindBy(xpath = "//div[@name='priority' and @role='listbox']")
	private WebElement dd_Priority;

	@FindBy(xpath = "//div[@name='status' and @role='listbox']")
	private WebElement dd_Status;

	@FindBy(xpath = "//button[normalize-space()='Save']")
	private WebElement btn_Save;

	@FindBy(xpath = "//button[normalize-space()='Cancel']")
	private WebElement btn_Cancel;

	public WebElement getTxt_Title() {
		return txt_Title;
	}

	public WebElement getDd_AssignedTo() {
		return dd_AssignedTo;
	}

	public WebElement getDd_Type() {
		return dd_Type;
	}

	public WebElement getTxt_DeadlineDate() {
		return txt_DeadlineDate;
	}

	public WebElement getTxt_CloseDate() {
		return txt_CloseDate;
	}

	public WebElement getTxtArea_Description() {
		return txtArea_Description;
	}

	public WebElement getDd_Priority() {
		return dd_Priority;
	}

	public WebElement getDd_Status() {
		return dd_Status;
	}

	public WebElement getBtn_Save() {
		return btn_Save;
	}

	public WebElement getBtn_Cancel() {
		return btn_Cancel;
	}

	public void createNewCase(Map<String, String> data) {
		elementActions.inputText(txt_Title, data.get("title"));
		elementActions.selectOption(dd_AssignedTo, data.get("aasignedTo"));
		elementActions.selectOption(dd_Type, data.get("type"));
		elementActions.inputText(txt_DeadlineDate, data.get("deadLineDate"));
		elementActions.inputText(txt_CloseDate, data.get("closeDate"));
		elementActions.inputText(txtArea_Description, data.get("description"));
		elementActions.selectOption(dd_Priority, data.get("priority"));
		elementActions.selectOption(dd_Status, data.get("status"));
		referenceValue = elementActions.getValue(txt_Title);
		elementActions.clickElement(btn_Save);
	}

}
