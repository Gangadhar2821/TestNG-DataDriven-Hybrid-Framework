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
		Assert.assertTrue(homePage.getLogo_Username().isDisplayed(), "User is not on HomePage");
		homePage.clickIcon_Contacts();
		contactsPage.clickBtnCreateContact();
		createNewContactpage.fillContactDetails(data);
	}

	@Test(dependsOnMethods = "createNewContact")
	public void verifyCreatedContactinList() {
		homePage.clickIcon_Contacts();
		contactsPage.validateCreatedContact(CreateNewContactPage.referenceValue);

	}

}
