package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {
	By bookmarks = By.className("oxy-header-container");
	By searchBtn = By.className("oxy-header-search_open-icon");
	By searchTab = By.className("oxy-header-search_search-field");
	By sError = By.id("div_block-273-1315");
	By companyTab = By.xpath("//span[contains(.,'Company')]");
	By contactTab = By.id("text_block-3671-16");
	By cookieBtn = By.id("CookieBoxSaveButton");
	WebDriver driver;
	WebDriverWait wait;
	
	public HomePage(WebDriver driver) {
		this.driver=driver;
		wait = new WebDriverWait(driver, 5);
	}
	public boolean selectContactUs() {
		wait.until(ExpectedConditions.elementToBeClickable(contactTab));
		driver.findElement(contactTab).click();
		wait.until(ExpectedConditions.urlContains("https://mostly.ai/contact/"));
		return driver.getTitle().contains("Contact a synthetic data expert -");
	}
	public boolean checkBookmarks(String menu) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(bookmarks));
		return driver.findElement(bookmarks).getText().contains(menu);
}
	public boolean searchResultCheck(String text) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(sError));
		System.out.println(driver.findElement(sError).getText());
		String Error= "Sorry, no results for:\n" +
				"sythetic";
		return driver.findElement(sError).getText().contains(Error);
	}
	public void navToSearch() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(cookieBtn));
		driver.findElement(cookieBtn).click();
		wait.until(ExpectedConditions.elementToBeClickable(searchBtn));
		driver.findElement(searchBtn).click();
	}
	public void typeSearchText(String sText) {
		driver.findElement(searchTab).sendKeys(sText);
		new Actions(driver).sendKeys(Keys.ENTER).perform();
	}
	public void selectCompanyTab() {
		wait.until(ExpectedConditions.elementToBeClickable(companyTab));
		driver.findElement(companyTab).click();

	}
}
