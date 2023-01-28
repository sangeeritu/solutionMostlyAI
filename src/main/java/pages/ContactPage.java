package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ContactPage {
	
	By firstNameField = By.name("firstname");
	By lastNameField = By.name("lastname");
	By phoneField = By.name("mobilephone");
	By countryDropdown = By.name("country");
	By emailField = By.name("email");
	By companyName = By.name("company");
	By termButton = By.name("LEGAL_CONSENT.subscription_type_5594858");
	By howYouKnow = By.name("how_did_you_hear_about_mostly_ai_");
	By msgDesc = By.name("message");
	By submitBtn = By.xpath("//input[@value='SEND MESSAGE']");
	WebDriver driver;
	WebDriverWait wait;
	
	public ContactPage(WebDriver driver) {
		this.driver=driver;
		wait = new WebDriverWait(driver, 5);
	}
	public void enterFirstName(String firstName) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(firstNameField));
		driver.findElement(firstNameField).sendKeys(firstName);
	}
	
	public void enterLastName(String lastName) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(lastNameField));
		driver.findElement(lastNameField).sendKeys(lastName);
	}
	public void enterEmail(String email) {
		driver.findElement(emailField).clear();
		driver.findElement(emailField).sendKeys(email);
	}
	public void enterPhoneNumber(String phone) {
		driver.findElement(phoneField).clear();
		driver.findElement(phoneField).sendKeys(phone);
	}
	public void enterOrganization(String org) {
		driver.findElement(companyName).clear();
		driver.findElement(companyName).sendKeys(org);
	}

	public void selectCountry(String country) {
		new Select(driver.findElement(countryDropdown)).selectByValue(country);
	}

	public void selectHowKnow(String opt) {
		new Select(driver.findElement(howYouKnow)).selectByValue(opt);
	}
	public void enterDescription(String msg) {
		driver.findElement(msgDesc).clear();
		driver.findElement(msgDesc).sendKeys(msg);
	}

	public void selectTermCond() {
		driver.findElement(termButton).click();
	}
	public void hoverOnSendMsg() throws InterruptedException {
		new Actions(driver).moveToElement(driver.findElement(submitBtn)).perform();
	}


}
