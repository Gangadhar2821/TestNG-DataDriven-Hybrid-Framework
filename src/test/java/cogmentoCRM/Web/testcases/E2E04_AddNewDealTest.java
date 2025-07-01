package cogmentoCRM.Web.testcases;

import java.util.Map;

import org.testng.annotations.Test;

import cogmentoCRM.Web.base.BaseTest;
import cogmentoCRM.Web.pageObjects.CreateNewDealPage;
import cogmentoCRM.Web.utilities.ExcelUtil;

public class E2E04_AddNewDealTest extends BaseTest {

	@Test(dataProvider = "ExcelTestData", dataProviderClass = ExcelUtil.class)
	public void createNewDeal(Map<String, String> data) {

		homePage.verifyHomePageIsDisplayed();
		homePage.clickIcon_Deals();
		dealsPage.click_CreateBtn();
		createNewDealPage.createDeal(data);
		homePage.clickIcon_Deals();
		dealsPage.validateCreatedDeal(CreateNewDealPage.referenceValue);

	}
}
