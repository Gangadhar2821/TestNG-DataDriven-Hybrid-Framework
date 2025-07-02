package cogmentoCRM.Web.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import cogmentoCRM.Web.base.BasePage;

public class ReportsPage extends BasePage {

	public ReportsPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//span[@class='selectable ']")
	private WebElement screenTitle;

	public WebElement getScreenTitle() {
		return screenTitle;
	}

	public WebElement getBtn_Create() {
		return btn_Create;
	}

	@FindBy(xpath = "//button[contains(text(),'Create')]")
	private WebElement btn_Create;

}
