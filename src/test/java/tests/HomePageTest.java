package tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.LogStatus;
import pages.BasePage;
import pages.HomePage;

public class HomePageTest extends BasePage{
	@DataProvider(name="bookmarks")
	public Object[][] getData(){
		return new Object[][] {
				{"Platform"},{"Synthetic Data"},{"Resources"} ,{"Company"}
		};
	}
	@Test(priority=0, dataProvider="bookmarks",description = "Validating the menu items")
	public void verifyTheBookmarks(String menu) {
		HomePage homePage = new HomePage(driver);
		logger.log(LogStatus.INFO, "In Mostly AI Home page");
		Assert.assertTrue(homePage.checkBookmarks(menu));
		logger.log(LogStatus.PASS, "The Bookmark " +menu+" is Present in header.");
	}
	@Test(priority=1,description = "Validating the error message for incorrect Search")
	@Parameters({"searchError"})
	public void verifySearchResultError(String text) {
		HomePage homePage = new HomePage(driver);
		logger.log(LogStatus.INFO, "Validating the Search Result error");
		homePage.navToSearch();
		homePage.typeSearchText(text);
		Assert.assertTrue(homePage.searchResultCheck(text));
		logger.log(LogStatus.PASS, "Error is shown for improper search request");
	}
	@Test(priority=2)
	public void verifyNavToContactPage() {
		HomePage homePage = new HomePage(driver);
		homePage.selectCompanyTab();
		logger.log(LogStatus.INFO, "Selecting Company tab tab");
		Assert.assertTrue(homePage.selectContactUs());
	}

}
