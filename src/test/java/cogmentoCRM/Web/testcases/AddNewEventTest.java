package cogmentoCRM.Web.testcases;

import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;

import cogmentoCRM.Web.base.BaseTest;
import cogmentoCRM.Web.pageObjects.CreateNewEventPage;
import cogmentoCRM.Web.utilities.ExcelUtil;

public class AddNewEventTest extends BaseTest {

	@Test(priority = 1, dataProvider = "ExcelTestData", dataProviderClass = ExcelUtil.class)
	public void createNewEvent(Map<String, String> data) {
		try {
			Assert.assertTrue(homePage.getLogo_Username().isDisplayed(), "The User is not in the HomePage");
			homePage.clickIcon_Calender();
			calenderPage.clickonCreateBtn();
			createNewEventPage.addNewEvent(data);
			createNewEventPage.clickSaveBtn();
			log.info("Created New Event Successfully..!");
		} catch (Exception e) {
			log.error(e.getMessage());
		}
	}

	@Test(dependsOnMethods = "createNewEvent")
	public void validateCreatedEvent() {
		Assert.assertEquals(createNewEventPage.getLogo_calenderIcon().isDisplayed(), true);
		homePage.clickIcon_Calender();
		calenderPage.validateAddedEvent(CreateNewEventPage.referenceValue);
		log.info("Validation of Created Event is Successful..!");
	}
}
