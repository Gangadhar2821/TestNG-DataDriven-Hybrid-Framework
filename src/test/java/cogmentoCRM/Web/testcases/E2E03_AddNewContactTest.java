package cogmentoCRM.Web.testcases;

import java.util.Map;

import org.testng.annotations.Test;

import cogmentoCRM.Web.base.BaseTest;
import cogmentoCRM.Web.pageObjects.CreateNewContactPage;
import cogmentoCRM.Web.utilities.ExcelUtil;

public class E2E03_AddNewContactTest extends BaseTest {

	@Test(dataProvider = "ExcelTestData", dataProviderClass = ExcelUtil.class)
	public void createNewContact(Map<String, String> data) {
		homePage.verifyHomePageIsDisplayed();
		homePage.clickIcon_Contacts();
		contactsPage.clickBtnCreateContact();
		createNewContactpage.fillContactDetails(data);
		homePage.clickIcon_Contacts();
		contactsPage.validateCreatedContact(CreateNewContactPage.referenceValue);
	}

}
