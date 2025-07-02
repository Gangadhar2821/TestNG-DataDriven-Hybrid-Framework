package cogmentoCRM.Web.pageObjects;

import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import cogmentoCRM.Web.base.BasePage;

public class CreateNewTaskPage extends BasePage {

	public CreateNewTaskPage(WebDriver driver) {
		super(driver);
	}

	public static String referenceValue;
	@FindBy(xpath = "//input[@name='title']")
	private WebElement txt_title;

	@FindBy(xpath = "//div[@role='listbox' and @name='type']")
	private WebElement dd_Type;

	@FindBy(xpath = "//label[normalize-space(text())='Due Date']/parent::div//input")
	private WebElement txt_DueDate;

	@FindBy(xpath = "//div[@class='ui fluid selection dropdown']")
	private WebElement dd_AssignedTo;

	@FindBy(xpath = "//label[normalize-space(text())='Close Date']/parent::div//input")
	private WebElement txt_CloseDate;

	@FindBy(xpath = "//textarea[@name='description']")
	private WebElement txtArea_Description;

	@FindBy(xpath = "//div[@role='listbox' and @name='status']")
	private WebElement dd_Status;

	public WebElement getTxt_title() {
		return txt_title;
	}

	public WebElement getDd_Type() {
		return dd_Type;
	}

	public WebElement getTxt_DueDate() {
		return txt_DueDate;
	}

	public WebElement getDd_AssignedTo() {
		return dd_AssignedTo;
	}

	public WebElement getTxt_CloseDate() {
		return txt_CloseDate;
	}

	public WebElement getTxtArea_Description() {
		return txtArea_Description;
	}

	public WebElement getDd_Status() {
		return dd_Status;
	}

	public WebElement getBtn_Save() {
		return btn_Save;
	}

	@FindBy(xpath = "//div[@role='listbox' and @name='status']")
	private WebElement btn_Save;

	public void createNewTask(Map<String, String> data) {
		elementActions.inputText(txt_title, data.get("title"));
		elementActions.selectOption(dd_AssignedTo, data.get("assignedTo"));
		elementActions.selectOption(dd_Type, data.get("Type"));
		elementActions.inputText(txt_DueDate, data.get("dueDate"));
		elementActions.inputText(txt_CloseDate, data.get("closeDate"));
		elementActions.inputText(txtArea_Description, data.get("description"));
		elementActions.selectOption(dd_Status, data.get("status"));
		referenceValue = elementActions.getValue(txt_title);
		elementActions.clickElement(btn_Save);
	}

	

}
