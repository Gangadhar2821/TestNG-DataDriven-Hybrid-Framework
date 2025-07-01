package cogmentoCRM.Web.testcases;

import java.util.Map;

import org.testng.annotations.Test;

import cogmentoCRM.Web.base.BaseTest;
import cogmentoCRM.Web.pageObjects.CreateNewEventPage;
import cogmentoCRM.Web.utilities.ExcelUtil;

public class E2E02_AddNewEventTest extends BaseTest {

	@Test(dataProvider = "ExcelTestData", dataProviderClass = ExcelUtil.class)
	public void createNewEvent(Map<String, String> data) {
		homePage.verifyHomePageIsDisplayed();
		homePage.clickIcon_Calender();
		calenderPage.clickonCreateBtn();
		createNewEventPage.addNewEvent(data);
		homePage.clickIcon_Calender();
		calenderPage.validateAddedEvent(CreateNewEventPage.referenceValue);

	}

}
