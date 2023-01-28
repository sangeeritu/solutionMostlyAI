package tests;

import com.relevantcodes.extentreports.LogStatus;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;
import pages.BasePage;
import pages.ContactPage;
import java.io.FileReader;
import java.io.IOException;

public class ContactTest extends BasePage{
String fName,lName,email,phNo,org,country,opt,msg;
    public ContactTest() throws IOException, ParseException {
        JSONParser parser = new JSONParser();
        Object obj = parser.parse(new FileReader("../Mostly-AISolution/TestData.json"));
        JSONObject jsonObject = (JSONObject) obj;
        fName  = (String) jsonObject.get("firstName");
        lName  = (String) jsonObject.get("lName");
        email  = (String) jsonObject.get("email");
        phNo  = (String) jsonObject.get("phNo");
        org  = (String) jsonObject.get("org");
        country=(String) jsonObject.get("country");
        opt=(String) jsonObject.get("option");
        msg=(String) jsonObject.get("desc");
    }
	@Test(priority=0)
	public void enterPersonalDetails() throws InterruptedException {
		ContactPage contactPage = new ContactPage(driver);
        contactPage.enterFirstName(fName);
		logger.log(LogStatus.INFO, "Entering first name in the First Name field");
        contactPage.enterLastName(lName);
        logger.log(LogStatus.INFO, "Entering last name in the Last Name field");
        contactPage.enterEmail(email);
        logger.log(LogStatus.INFO, "Entering email in the Email field");
        contactPage.enterPhoneNumber(phNo);
		logger.log(LogStatus.INFO, "Entering phone number in the Phone field");
        contactPage.enterOrganization(org);
        logger.log(LogStatus.INFO, "Entering organization detail in the Organization field");
        contactPage.selectCountry(country);
		logger.log(LogStatus.INFO, "Entering country in the country field");
        contactPage.selectHowKnow(opt);
        logger.log(LogStatus.INFO, "Entering How you know");
        contactPage.enterDescription(msg);
		logger.log(LogStatus.INFO, "Entering description");
        contactPage.selectTermCond();
        logger.log(LogStatus.INFO, "Selecting terms and condition");
        contactPage.hoverOnSendMsg();
        logger.log(LogStatus.INFO, "Hovering on the Send message button");
	}
}
