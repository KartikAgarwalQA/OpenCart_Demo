package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC_002_LoginTest extends BaseClass 
{
	
	@Test(groups= {"Sanity","Master"})
	public void test_login()
	{
		
		try
		{
		logger.info("*******Starting TC_002_LoginTest*********** ");
		
		HomePage hp = new HomePage(driver);
		hp.clickMyAccount();
		logger.info("*******Clicked Myaccount *********** ");
		hp.clickLogin();
		logger.info("******Clicked login *********** ");
		LoginPage lp = new LoginPage(driver);
		lp.setEmail(rb.getString("email"));
		logger.info("*******Entered email ***********");

		lp.setPassword(rb.getString("password"));
		logger.info("***Entered password*****");
		
		lp.clickLogin();
		logger.info("Clicked login ");
		
		MyAccountPage maccp=new MyAccountPage(driver);
		boolean targetpage= maccp.isMyAccountPageExists();
		Assert.assertEquals(targetpage, true ,"Invalid login data");
		}
		catch (Exception e)
		{
			Assert.fail();
		}
		
		logger.info("******Finished TC_002_LoginTest************ ");
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
