package com.inetbanking.PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	WebDriver ldriver;
	
	public LoginPage(WebDriver rdriver)
	{
		
		ldriver=rdriver;
		PageFactory.initElements(rdriver,this);
				
	}

	@FindBy(name="uid")
    WebElement textusername;
	
	@FindBy(name="password")
	WebElement textuserpassword;
	
	@FindBy(name="btnLogin")
	WebElement btnLogin;
	
	public void setusername(String uname)
	{
		textusername.sendKeys(uname);
	}
	
	public void setuserpassword(String upass)
	{
		textuserpassword.sendKeys(upass);
	}
	
	public void submitbutton()
	{
		btnLogin.click();
		
	}
	
}
