package cogmentoCRM.Web.testcases;

import java.util.Map;

import org.testng.annotations.Test;

import cogmentoCRM.Web.base.BaseTest;
import cogmentoCRM.Web.pageObjects.CreateNewCasePage;
import cogmentoCRM.Web.utilities.ExcelUtil;

public class E2E07_AddNewCaseTest extends BaseTest {

	@Test(dataProvider = "ExcelTestData", dataProviderClass = ExcelUtil.class)
	public void createNewCase(Map<String, String> data) {
		homePage.verifyHomePageIsDisplayed();
		homePage.clickIcon_Cases();
		casesPage.clickBtn_Create();
		createNewCasePage.createNewCase(data);
		homePage.clickIcon_Cases();
		casesPage.validateCreatedContact(CreateNewCasePage.referenceValue);

	}

}
