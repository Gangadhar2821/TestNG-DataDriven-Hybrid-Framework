package cogmentoCRM.Web.testcases;

import java.util.Map;

import org.testng.annotations.Test;

import cogmentoCRM.Web.base.BaseTest;
import cogmentoCRM.Web.pageObjects.CreateNewCompanyPage;
import cogmentoCRM.Web.utilities.ExcelUtil;

public class E2E05_AddNewCompanyTest extends BaseTest {

	@Test(dataProvider = "ExcelTestData", dataProviderClass = ExcelUtil.class)
	public void createNewCompany(Map<String, String> data) {
		homePage.verifyHomePageIsDisplayed();
		homePage.clickIcon_Companies();
		companiesPage.click_CreateBtn();
		createNewCompanyPage.verifyCreateNewComapanyPage();
		createNewCompanyPage.createNewCompany(data);
		homePage.clickIcon_Companies();
		companiesPage.verifyCreatedCompanyisListed(CreateNewCompanyPage.referenceValue);
	}
}
