package com.Home;

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
			//Enter blank User Name
			driver.findElement(By.xpath("//*[@id='txtUserName']")).clear();
			
			//Enter blank Password
			driver.findElement(By.xpath("//*[@id='txtPassword']")).clear();
			
			//click Login button
			click("//*[@id='btnLogin']");
			
			//Assert message User name is required
			Assert.assertTrue(getText("//*[@id='validation-message-0']").contains("is required"),"failed to assert text"+"  is required");
			
			//Assert message Password is required
			Assert.assertTrue(getText("//*[@id='validation-message-3']").contains("is required"),"failed to assert text"+"  is required");
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
			//Enter blank User Name
			driver.findElement(By.xpath("//*[@id='txtUserName']")).clear();
			
			//Enter valid Password
			type("//*[@id='txtPassword']","Password1!");			
			
			//click Login button
			click("//*[@id='btnLogin']");
			
			//Assert message User name is required
			Assert.assertTrue(getText("//*[@id='validation-message-24']").contains("is required"),"failed to assert text"+"  is required");

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
			//type valid User Name
			type("//*[@id='txtUserName']","Shinto-Test");
			
			//Blank Password
			driver.findElement(By.xpath("//*[@id='txtPassword']")).clear();			
			
			//click Login button
			click("//*[@id='btnLogin']");
			
			//Assert message User name is required
			Assert.assertTrue(getText("//*[@id='validation-message-55']").contains("is required"),"failed to assert text"+"  is required");

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
			//clear username field
			driver.findElement(By.xpath("//*[@id='txtUserName']")).clear();
			
			//type invalid User Name
			type("//*[@id='txtUserName']","dfgbfbgbnf");
			
			//clear Password field
			driver.findElement(By.xpath("//*[@id='txtPassword']")).clear();	
			
			//Enter Invalid Password
			type("//*[@id='txtPassword']","dfdfdfdf");	
			
			//click Login button
			click("//*[@id='btnLogin']");
			
			Thread.sleep(2000);
			
			//Assert message User name is required
			Assert.assertTrue(getText("//*[@id='login-panel']/div/div[2]/div[1]").contains("Username was not found"),"failed to assert text"+"  Username was not found.");

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
			//clear username field
			driver.findElement(By.xpath("//*[@id='txtUserName']")).clear();
			
			//type Valid User Name
			type("//*[@id='txtUserName']","Shinto-Test");
			
			//clear Password field
			driver.findElement(By.xpath("//*[@id='txtPassword']")).clear();	
			
			//Enter Invalid Password
			type("//*[@id='txtPassword']","dfdfdfdf");	
			
			//click Login button
			click("//*[@id='btnLogin']");
			
			Thread.sleep(3000);
			
			//Assert message User name is required 
			Assert.assertTrue(getText("//*[@id='login-panel']/div/div[2]/div[1]").contains("Invalid username or password"),"failed to assert text"+"  Invalid username or password");

		} 
		catch (Exception e) 
		{
			Assert.fail(e.getMessage());
			e.printStackTrace();
		}
		
	}
	
	@Test(priority=8)	
	public void TCBA01009()
	{
		
		try
		{
			//clear username field
			driver.findElement(By.xpath("//*[@id='txtUserName']")).clear();
			
			//type Valid User Name
			type("//*[@id='txtUserName']","Shinto-Test");
			
			//clear Password field
			driver.findElement(By.xpath("//*[@id='txtPassword']")).clear();	
			
			//Enter Valid Password
			type("//*[@id='txtPassword']","Password1!");	
			
			//click Login button
			click("//*[@id='btnLogin']");
			
			Thread.sleep(3000);
			
			
		} 
		catch (Exception e) 
		{
			Assert.fail(e.getMessage());
			e.printStackTrace();
		}
		
	}

}
