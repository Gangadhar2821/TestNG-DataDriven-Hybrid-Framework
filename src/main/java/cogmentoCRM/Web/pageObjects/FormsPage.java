package cogmentoCRM.Web.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import cogmentoCRM.Web.base.BasePage;

public class FormsPage extends BasePage {

	public FormsPage(WebDriver driver) {
		super(driver);
	}

	public WebElement getScreenTitle() {
		return screenTitle;
	}

	public WebElement getBtn_Add() {
		return btn_Add;
	}

	@FindBy(xpath = "//span[@class='selectable ']")
	private WebElement screenTitle;

	@FindBy(xpath = "//button[contains(text(),'Add')]")
	private WebElement btn_Add;

}
