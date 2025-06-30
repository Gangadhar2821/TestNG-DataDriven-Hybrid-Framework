package cogmentoCRM.Web.testcases;

import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;

import cogmentoCRM.Web.base.BaseTest;
import cogmentoCRM.Web.pageObjects.CreateNewDealPage;
import cogmentoCRM.Web.utilities.ExcelUtil;

public class AddNewDealTest extends BaseTest {

	@Test(dataProvider = "ExcelTestData", dataProviderClass = ExcelUtil.class)
	public void createNewDeal(Map<String, String> data) {

		Assert.assertTrue(homePage.getLogo_Username().isDisplayed());
		homePage.clickIcon_Deals();
		dealsPage.click_CreateBtn();
		createNewDealPage.createDeal(data);

	}

	@Test(dependsOnMethods = "createNewDeal")
	public void verifyCreatedDealinList() {
		try {
			homePage.clickIcon_Deals();
			dealsPage.validateCreatedDeal(CreateNewDealPage.referenceValue);
		} catch (Exception e) {
			log.error("Failed to verify the created Deal " + e.getMessage());
		}
	}
}
