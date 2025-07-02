package cogmentoCRM.Web.testcases;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import cogmentoCRM.Web.base.BaseTest;

public class E2E01_MenusNavigationTest extends BaseTest {

	@Test(priority = 1)
	public void navigateMenusAndVerifyLanding() {

		homePage.verifyHomePageIsDisplayed();
		homePage.clickIcon_Calender();
		assertTrue(calenderPage.getScreenTitle().getText().equalsIgnoreCase("Calendar"));
		homePage.clickIcon_Contacts();
		assertTrue(contactsPage.getScreenTitle().getText().equalsIgnoreCase("contacts"));
		homePage.clickIcon_Companies();
		assertTrue(companiesPage.getScreenTitle().getText().equalsIgnoreCase("companies"));
		homePage.clickIcon_Deals();
		assertTrue(dealsPage.getScreenTitle().getText().equalsIgnoreCase("deals"));
		homePage.clickIcon_Tasks();
		assertTrue(tasksPage.getScreenTitle().getText().equalsIgnoreCase("tasks"));
		homePage.clickIcon_Cases();
		assertTrue(casesPage.getScreenTitle().getText().equalsIgnoreCase("cases"));
		homePage.clickIcon_Calls();
		assertTrue(callsPage.getScreenTitle().getText().equalsIgnoreCase("calls"));
		homePage.clickIcon_Documents();
		assertTrue(documentsPage.getScreenTitle().getText().equalsIgnoreCase("documents"));
		homePage.clickIcon_Email();
		assertTrue(emailPage.getScreenTitle().getText().equalsIgnoreCase("Inbox"));
		homePage.clickIcon_Campaigns();
		assertTrue(campaignsPage.getScreenTitle().getText().equalsIgnoreCase("campaigns"));
		homePage.clickIcon_Forms();
		assertTrue(formsPage.getScreenTitle().getText().equalsIgnoreCase("forms"));
		homePage.clickIcon_Reports();
		assertTrue(reportsPage.getScreenTitle().getText().equalsIgnoreCase("Reports"));
		homePage.clickIcon_Home();
		homePage.verifyHomePageIsDisplayed();
	}
}
