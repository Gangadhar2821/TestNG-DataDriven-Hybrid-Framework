package cogmentoCRM.Web.testcases;

import java.util.Map;

import org.testng.annotations.Test;

import cogmentoCRM.Web.base.BaseTest;
import cogmentoCRM.Web.pageObjects.CreateNewTaskPage;
import cogmentoCRM.Web.utilities.ExcelUtil;

public class E2E06_AddNewTaskTest extends BaseTest {

	@Test(dataProvider = "ExcelTestData", dataProviderClass = ExcelUtil.class)
	public void createNewTask(Map<String, String> data) {
		homePage.verifyHomePageIsDisplayed();
		homePage.clickIcon_Tasks();
		tasksPage.clickBtn_Create();
		createNewTaskPage.createNewTask(data);
		homePage.clickIcon_Tasks();
		tasksPage.verifyIsTaskListed(CreateNewTaskPage.referenceValue);
	}

}
