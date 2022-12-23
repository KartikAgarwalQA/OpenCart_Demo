package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC_001_AccountRegistrationTest extends BaseClass{
	@Test(groups= {"Regression","Master"})
	public void test_account_Registration() throws InterruptedException
	
	{
		logger.debug("Application logs............");
		logger.info("*********Starting TC_001_AccountRegistrationTest**********");
		try
		{
		HomePage hp=new HomePage(driver);
		hp.clickMyAccount();
		logger.info("CLicked on My account");
		hp.clickRegister();
		logger.info("CLicked on Register");
		AccountRegistrationPage regpage=new AccountRegistrationPage(driver);
		
		regpage.setFirstName(randomeString().toUpperCase());
		logger.info("Entered first name.");
		
		regpage.setLastName(randomeString().toUpperCase());
		logger.info("Entered last name.");
		
		regpage.setEmail(randomeString()+"@gmail.com");// randomly generated the email
		logger.info("Entered E-mail.");
		
		
		String password=randomAlphaNumeric();
		regpage.setPassword(password);
		logger.info("Entered password.");
		
		regpage.setPrivacyPolicy();
		logger.info("Clicked Privacy policy.");
		
		regpage.clickContinue();
		logger.info("Clicked on Continue.");
		
		String confmsg=regpage.getConfirmationMsg();
		logger.info("Validating expected message.");
		Assert.assertEquals(confmsg, "Your Account Has Been Created!","Not getting expected message.");
		}
		catch(Exception e)
		{
			logger.error("test failed.");
			Assert.fail();
		}
	}
	
	
}
