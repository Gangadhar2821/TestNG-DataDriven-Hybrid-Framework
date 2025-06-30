package cogmentoCRM.Web.pageObjects;

import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import cogmentoCRM.Web.base.BasePage;

public class CreateNewContactPage extends BasePage {

	public CreateNewContactPage(WebDriver driver) {
		super(driver);
	}

	public static String referenceValue;

	@FindBy(xpath = "//input[@name='first_name']")
	private WebElement txt_firstName;

	@FindBy(xpath = "//div[@class='ui header item mb5 light-black']//span")
	private WebElement logo_screenTitle;

	@FindBy(xpath = "//input[@name='last_name']")
	private WebElement txt_lastName;

	@FindBy(xpath = "//input[@name='middle_name']")
	private WebElement txt_middleName;

	@FindBy(xpath = "//div[@role='listbox' and @name='category']")
	private WebElement dd_category;

	@FindBy(xpath = "//div[@name='company']//input[@type='text']")
	private WebElement txt_company;

	@FindBy(xpath = "//input[@placeholder='Number']")
	private WebElement txt_number;

	@FindBy(xpath = "//textarea[@name='description']")
	private WebElement txtarea_Description;

	@FindBy(xpath = "//div[@role='listbox' and @name='channel_type']")
	private WebElement dd_socialChannels;

	@FindBy(xpath = "//div[@role='listbox' and @name='status']")
	private WebElement dd_status;

	@FindBy(xpath = "//input[@placeholder='Email address']")
	private WebElement txt_EmailId;

	@FindBy(xpath = "//div[@name='timezone']//input[@type='text']")
	private WebElement txt_timeZone;

	@FindBy(xpath = "//input[@name='position']")
	private WebElement txt_position;
	@FindBy(xpath = "//div[@name='supervisor']//input[@type='text']")
	private WebElement txt_supervisor;

	@FindBy(xpath = "//div[@name='assistant']//input[@type='text']")
	private WebElement txt_assistant;

	@FindBy(xpath = "//input[@name='department']")
	private WebElement txt_department;

	@FindBy(xpath = "//div[@name='referred_by']//input[@type='text']")
	private WebElement txt_referredBy;

	@FindBy(xpath = "//div[@role='listbox' and @name='source']")
	private WebElement dd_source;

	@FindBy(xpath = "//input[@placeholder='Street Address']")
	private WebElement txt_address;

	@FindBy(xpath = "//button[@class='ui linkedin button']")
	private WebElement btn_save;

	@FindBy(xpath = "//input[contains(@placeholder,'profile link')]")
	private WebElement txt_socialChannelLink;

	@FindBy(xpath = "//input[@name='do_not_call']")
	private WebElement tgl_donotCall;

	@FindBy(xpath = "//input[@name='identifier']")
	private WebElement txt_identifier;

	@FindBy(xpath = "//button[@class='ui button']")
	private WebElement btn_cancel;

	@FindBy(xpath = "//input[@name='image']")
	private WebElement txt_imageUpload;

	public WebElement getTxt_firstName() {
		return txt_firstName;
	}

	public WebElement getLogo_screenTitle() {
		return logo_screenTitle;
	}

	public WebElement getTxt_lastName() {
		return txt_lastName;
	}

	public WebElement getTxt_middleName() {
		return txt_middleName;
	}

	public WebElement getDd_category() {
		return dd_category;
	}

	public WebElement getTxt_company() {
		return txt_company;
	}

	public WebElement getTxt_number() {
		return txt_number;
	}

	public WebElement getTxtarea_Description() {
		return txtarea_Description;
	}

	public WebElement getDd_socialChannels() {
		return dd_socialChannels;
	}

	public WebElement getDd_status() {
		return dd_status;
	}

	public WebElement getTxt_EmailId() {
		return txt_EmailId;
	}

	public WebElement getTxt_timeZone() {
		return txt_timeZone;
	}

	public WebElement getTxt_position() {
		return txt_position;
	}

	public WebElement getTxt_supervisor() {
		return txt_supervisor;
	}

	public WebElement getTxt_assistant() {
		return txt_assistant;
	}

	public WebElement getTxt_department() {
		return txt_department;
	}

	public WebElement getTxt_referredBy() {
		return txt_referredBy;
	}

	public WebElement getDd_source() {
		return dd_source;
	}

	public WebElement getTxt_address() {
		return txt_address;
	}

	public WebElement getBtn_save() {
		return btn_save;
	}

	public WebElement getTxt_socialChannelLink() {
		return txt_socialChannelLink;
	}

	public WebElement getTgl_donotCall() {
		return tgl_donotCall;
	}

	public WebElement getTxt_identifier() {
		return txt_identifier;
	}

	public WebElement getBtn_cancel() {
		return btn_cancel;
	}

	public WebElement getTxt_imageUpload() {
		return txt_imageUpload;
	}

	public void fillContactDetails(Map<String, String> data) {
		try {
			elementActions.inputText(txt_firstName, data.get("firstName"));
			elementActions.inputText(txt_lastName, data.get("lastName"));
			elementActions.inputText(txt_middleName, data.get("middleName"));
			elementActions.inputText(txt_company, data.get("company"));
			elementActions.inputText(txt_EmailId, data.get("email"));
			elementActions.selectOption(dd_category, data.get("category"));
			elementActions.selectOption(dd_status, data.get("status"));
			elementActions.inputText(txtarea_Description, data.get("description"));
			elementActions.selectOption(dd_socialChannels, data.get("social Channel"));
			elementActions.inputText(txt_socialChannelLink, data.get("channel link"));
			elementActions.inputText(txt_address, data.get("address"));
			elementActions.inputText(txt_number, data.get("number"));
			elementActions.inputText(txt_position, data.get("position"));
			elementActions.inputText(txt_department, data.get("department"));
			elementActions.inputText(txt_supervisor, data.get("supervisor"));
			elementActions.inputText(txt_supervisor, data.get("assistant"));
			elementActions.inputText(txt_referredBy, data.get("referred By"));
			elementActions.selectOption(dd_source, data.get("source"));
			elementActions.switchToggle(tgl_donotCall, data.get("Do not call"));
			elementActions.inputText(txt_identifier, data.get("identifier"));
			elementActions.fileUpload(txt_imageUpload, data.get("image"));
			referenceValue = elementActions.getValue(txt_firstName);
			elementActions.clickElement(btn_save);
		} catch (Exception e) {
			log.error(e.getMessage());
		}

	}

}
