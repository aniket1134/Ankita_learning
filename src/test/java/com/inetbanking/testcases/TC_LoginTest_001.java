package com.inetbanking.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetbanking.PageObject.LoginPage;



public class TC_LoginTest_001 extends BaseClass {
	
	@Test
	public void logintest() throws IOException
	{
		driver.get(baseurl);
		logger.info("on login page");
		LoginPage lp=new LoginPage(driver);
		lp.setusername(userid);
		logger.info("entered userid");
		lp.setuserpassword(password);
		logger.info("entered password");
		lp.submitbutton();
		
		if (driver.getTitle().equalsIgnoreCase(" Guru99 Bank Home Page "))
		{
			
			Assert.assertTrue(true);
			logger.info("Logintest case passed");
		}
		else
		{
			captureScreen(driver,"logintest");
			Assert.assertFalse(false);
			logger.info("Logintest case failed");
		}
	}

}
