package cogmentoCRM.Web.testcases;

import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;

import cogmentoCRM.Web.base.BaseTest;
import cogmentoCRM.Web.pageObjects.CreateNewContactPage;
import cogmentoCRM.Web.utilities.ExcelUtil;

public class AddNewContactTest extends BaseTest {

	@Test(dataProvider = "ExcelTestData", dataProviderClass = ExcelUtil.class)
	public void createNewContact(Map<String, String> data) {
		try {
			Assert.assertTrue(homePage.getLogo_Username().isDisplayed(), "User is not on HomePage");
			homePage.clickIcon_Contacts();
			contactsPage.clickBtnCreateContact();
			Assert.assertTrue(createNewContactpage.getLogo_screenTitle().isDisplayed(),
					"User failed to navigate to the CreateContact Page");
			createNewContactpage.fillContactDetails(data);
			log.info("Created New Contact Successfully..!");
		} catch (Exception e) {
			log.error(e.getMessage());
		}
	}

	@Test(dependsOnMethods = "createNewContact")
	public void validateCreatedContact() {
		try {
			homePage.clickIcon_Contacts();
			contactsPage.validateCreatedContact(CreateNewContactPage.referenceValue);
			log.info("Validation of created contact is Successful..!");
		} catch (Exception e) {
			log.error(e.getMessage());
		}

	}
}
