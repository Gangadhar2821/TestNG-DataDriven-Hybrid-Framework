package cogmentoCRM.Web.actions;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public interface ElementAction {

	public abstract void clickElement(WebElement element);

	public abstract void jsClick(WebDriver driver, WebElement element);

	public abstract void inputText(WebElement element, String text);

	public abstract void clearText(WebElement element);

	public abstract void selectOption(WebElement element, String data);

	public abstract void switchToggle(WebElement element, String data);

	public abstract void inputRadio(WebElement element, String data);

	public abstract void inputCheckbox(WebElement element, String data);

	public abstract String getlabelText(WebElement element);

	public abstract boolean isDisplayed(WebElement element);

	public abstract boolean isEnabled(WebElement element);

	public abstract boolean isSelected(WebElement element);

	public abstract void hoverOverElement(WebElement element);

	public abstract void scrollToElement(WebElement element);

	public abstract void fileUpload(WebElement element, String filepath);

	public abstract void waitForElementToBeVisible(WebElement element, int timeoutInSeconds);

	public abstract void waitForElementsToBeVisible(List<WebElement> elements, int timeoutInSeconds);

	public abstract void waitForElementToBeClickable(WebElement element, int timeoutInSeconds);

	public abstract String getAttribute(WebElement element, String attribute);

	public abstract String getCssValue(WebElement element, String property);

	public abstract boolean isElementPresent(WebElement element);

	public abstract String getValue(WebElement element);

}
