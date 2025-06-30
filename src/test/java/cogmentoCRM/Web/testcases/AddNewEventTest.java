package cogmentoCRM.Web.testcases;

import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;

import cogmentoCRM.Web.base.BaseTest;
import cogmentoCRM.Web.pageObjects.CreateNewEventPage;
import cogmentoCRM.Web.utilities.ExcelUtil;

public class AddNewEventTest extends BaseTest {

	@Test(dataProvider = "ExcelTestData", dataProviderClass = ExcelUtil.class)
	public void createNewEvent(Map<String, String> data) {
		Assert.assertTrue(homePage.getLogo_Username().isDisplayed(), "The User is not in the HomePage");
		homePage.clickIcon_Calender();
		calenderPage.clickonCreateBtn();
		createNewEventPage.addNewEvent(data);

	}

	@Test(dependsOnMethods = "createNewEvent")
	public void verifyCreatedEventinList() {
		homePage.clickIcon_Calender();
		calenderPage.validateAddedEvent(CreateNewEventPage.referenceValue);
	}

}
