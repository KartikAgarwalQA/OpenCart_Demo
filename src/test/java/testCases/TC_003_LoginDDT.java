package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;
import utilities.DataProviders;

public class TC_003_LoginDDT extends BaseClass{

	@Test(dataProvider="LoginData",dataProviderClass=DataProviders.class) //add parameter data provider class as it is other class
	public void test_loginDDT(String email,String password ,String exp)
	{
		try 
		{
		
		
		logger.info("*****Starting TC_003_LoginDDT***** ");
		
		HomePage hp = new HomePage(driver);
		hp.clickMyAccount();
		logger.info("*******Clicked Myaccount *********** ");
		hp.clickLogin();
		logger.info("******Clicked login *********** ");
		LoginPage lp = new LoginPage(driver);
		
		
		lp.setEmail(email);
		logger.info("*******Entered email ***********");

		lp.setPassword(password);
		logger.info("***Entered password*****");
		
		lp.clickLogin();
		logger.info("Clicked login ");
		
		MyAccountPage maccp=new MyAccountPage(driver);
		boolean targetpage= maccp.isMyAccountPageExists();
		
		if(exp.equals("Valid"))
		{
			if(targetpage==true)
			{
				maccp.clickLogout();
				Assert.assertTrue(true);
			}
			else
			{
				Assert.fail();
			}
			
			
		}
		
		if(exp.equals("Invalid"))
		{
			if(targetpage==true)
			{
				maccp.clickLogout();
				Assert.assertTrue(false);
			}
			else
			{
				Assert.assertTrue(true);
			}
		}
	
		
		}
		catch (Exception e)
		{
			Assert.fail();
		}
		logger.info("*****Finsihed TC_003_LoginDDT***** ");
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}