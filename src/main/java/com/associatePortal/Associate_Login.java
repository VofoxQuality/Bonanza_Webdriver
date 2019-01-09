package com.associatePortal;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.Library.UtilityClass;

public class Associate_Login extends UtilityClass
{
	
	@Test(priority=0)
	public void TCBA01001()
	{
		try
		{
			String title=driver.getTitle();			
			Assert.assertEquals(title,"Log In | 5-15");
			
			//Enter blank User Name
			driver.findElement(By.xpath("//*[@id='txtUserName']")).clear();
			
			//Enter blank Password
			driver.findElement(By.xpath("//*[@id='txtPassword']")).clear();
			
			//click on Login button
			click("//*[@id='btnLogin']");
			
			//Assert message User name is required
			String U1=getText("//*[@id='rwUserName']/label");
			String U2=getText("//*[@id='rwUserName']/label/following::p[1]");
			Assert.assertEquals(U1+U2,"User Nameis required");
			
			//Assert message Password is required
			String P1=getText("//*[@id='rwPassword']/label");
			String P2=getText("//*[@id='rwPassword']/label/following::p[1]");
			Assert.assertEquals(P1+P2,"Passwordis required");
			
			
		} 
		catch (Exception e)
		{
			Assert.fail(e.getMessage());
			e.printStackTrace();
		}

	}

	@Test(priority=1)	
	public void TCBA01002()
	{
		
		try
		{
			
			//Enter valid Password
			type("//*[@id='txtPassword']","Password1!");			
			
			//click Login button
			click("//*[@id='btnLogin']");
			
			//Assert message User name is required
			String U1=getText("//*[@id='rwUserName']/label");
			String U2=getText("//*[@id='rwUserName']/label/following::p[1]");
			Assert.assertEquals(U1+U2,"User Nameis required");

		} 
		catch (Exception e) 
		{
			Assert.fail(e.getMessage());
			e.printStackTrace();
		}
		
	}
	
	@Test(priority=2)	
	public void TCBA01003()
	{
		
		try
		{
			//type valid User Name
			type("//*[@id='txtUserName']","Shinto-Test");
			
			//Blank Password
			driver.findElement(By.xpath("//*[@id='txtPassword']")).clear();			
			
			//click Login button
			click("//*[@id='btnLogin']");
			
			//Assert message Password is required
			String P1=getText("//*[@id='rwPassword']/label");
			String P2=getText("//*[@id='rwPassword']/label/following::p[1]");
			Assert.assertEquals(P1+P2,"Passwordis required");

		} 
		catch (Exception e) 
		{
			Assert.fail(e.getMessage());
			e.printStackTrace();
		}
		
	}
	
	@Test(priority=3)	
	public void TCBA01004()
	{
		
		try
		{
			
			//type invalid User Name
			type("//*[@id='txtUserName']","dfgbfbgbnf");
		
			//Enter Invalid Password
			type("//*[@id='txtPassword']","dfdfdfdf");	
			
			//click Login button
			click("//*[@id='btnLogin']");
			
			Thread.sleep(2000);
			
			//Assert message Username was not found
			Assert.assertEquals(getText("//*[@id='login-panel']/div/div[2]/div[1]"), "Username was not found."," Username was not found-message not found");		
			

		} 
		catch (Exception e) 
		{
			Assert.fail(e.getMessage());
			e.printStackTrace();
		}
		
	}
	
	@Test(priority=4)	
	public void TCBA01005()
	{
		
		try
		{
			
			//type Valid User Name
			type("//*[@id='txtUserName']","Shinto-Test");
			
			
			//Enter Invalid Password
			type("//*[@id='txtPassword']","dfdfdfdf");	
			
			//click Login button
			click("//*[@id='btnLogin']");
			
			Thread.sleep(3000);			
			
			//Assert message Invalid username or password
			Assert.assertEquals(getText("//div[@class='text-danger au-target']"), "Invalid username or password."," Invalid username or password.-message not found");
			
		} 
		catch (Exception e) 
		{
			Assert.fail(e.getMessage());
			e.printStackTrace();
		}
		
	}
	
	@Test(priority=5)	
	public void TCBA01006()
	{
		
		try
		{
			
			//type InValid User Name
			type("//*[@id='txtUserName']","fgfgfgfgf");
			
			
			//Enter Invalid Password
			type("//*[@id='txtPassword']","dfdfdfdf");	
			
			//click Login button
			click("//*[@id='btnLogin']");
			
			Thread.sleep(3000);			
			
			//Assert message Username was not found
			Assert.assertEquals(getText("//div[@class='text-danger au-target']"), "Username was not found."," Username was not found.-message not found");
			
		} 
		catch (Exception e) 
		{
			Assert.fail(e.getMessage());
			e.printStackTrace();
		}
		
	}
	
	@Test(priority=6)	
	public void TCBA01007()
	{
		
		try {
			
			//type Valid User Name
			type("//*[@id='txtUserName']","Shinto-Test2");
			
			
			//Enter Invalid Password
			type("//*[@id='txtPassword']","Password1232222");
			
			//click Login button correct user name and invalid password after three or more login attempt.]
			click("//*[@id='btnLogin']");			
			Thread.sleep(3000);
			click("//*[@id='btnLogin']");
			Thread.sleep(3000);
			click("//*[@id='btnLogin']");
			Thread.sleep(3000);
			
			//To verify the validation message "You have been locked out. Please contact support." 
            String Blk_msg="You have been locked out. Please contact support.";
			Assert.assertEquals(getText("//*[@id='login-panel']/div/div[2]/div[1]"),Blk_msg);
		} 
		
		catch (Exception e)
		{
			Assert.fail(e.getMessage());
			e.printStackTrace();
		}

	   
	}	
	@Test(priority=7)	
	public void TCBA01008()
	{
		
		try
		{
			
			//type Valid User Name
			type("//*[@id='txtUserName']","Shinto-Test");
			
			//Enter Valid Password
			type("//*[@id='txtPassword']","Password1!");	
			
			//click Login button
			JavaScriptclick("//*[@id='btnLogin']");
			
			Thread.sleep(3000);
			
			// Assert the logout button is displayed in the dashboard
			Assert.assertTrue(driver.findElement(By.xpath("//*[@id='navbar']/ul/li[4]/div/a/span[1]")).isDisplayed());						
			
		} 
		catch (Exception e) 
		{
			Assert.fail(e.getMessage());
			e.printStackTrace();
		}
		
	}

}
