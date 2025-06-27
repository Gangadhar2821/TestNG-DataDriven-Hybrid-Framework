package cogmentoCRM.Web.pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import cogmentoCRM.Web.base.BasePage;

public class DealsPage extends BasePage {

	public DealsPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//button[contains(text(),'Create')]")
	private WebElement btn_CreateDeal;

	@FindBy(xpath = "//i[@class='refresh icon']")
	private WebElement btn_refresh;

	@FindBy(xpath = "//td//a[contains(text(),'')]")
	private List<WebElement> allTableTitles;

	public void click_CreateBtn() {
		elementActions.clickElement(btn_CreateDeal);
	}

	public void validateCreatedDeal(String referenceValue) {
		elementActions.clickElement(btn_refresh);
		for (WebElement ele : allTableTitles) {
			String text = ele.getText().trim();
			if (ele.isDisplayed()) {
				if (text.contains(referenceValue)) {
					Assert.assertTrue(true);
					break;
				}
			}

		}
	}

}
