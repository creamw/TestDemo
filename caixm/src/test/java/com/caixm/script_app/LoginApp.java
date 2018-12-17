package com.caixm.script_app;

import org.junit.Test;
import org.openqa.selenium.By;

import com.caixm.elements.mobile.LoginPage;
import com.caixm.utils.Driver;

import io.appium.java_client.android.AndroidDriver;
import mx4j.log.Log;

public class LoginApp {
	AndroidDriver  androidDriver = StartApp.driver;
	
	@Test
	public void loginApp() throws InterruptedException {
		/*androidDriver.findElementById(LoginPage.USERNAME).sendKeys("15666666666");
		androidDriver.findElementById(LoginPage.PASSWORD).sendKeys("123456");
		androidDriver.findElementById(LoginPage.LOGIN).click();*/
		
		androidDriver.findElement(By.id(LoginPage.USERNAME)).sendKeys("15927445425");
		androidDriver.findElement(By.id(LoginPage.PASSWORD)).sendKeys("123456");
		androidDriver.findElement(By.id(LoginPage.LOGIN)).click();
		Thread.sleep(15000);
	}
	
	

}
