package com.caixm.script_web;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import com.caixm.elements.web.LoginPage;
import com.caixm.utils.Driver;

public class Login {
	ChromeDriver chromeDriver = Driver.chromeDriver;
	
	@Test
	public void login() {
		chromeDriver.manage().window().maximize();
		chromeDriver.get("https://dev.api.caixm.cn/");
		chromeDriver.findElement(By.cssSelector(LoginPage.USERNAME)).sendKeys("15927445425");
		chromeDriver.findElement(By.cssSelector(LoginPage.PASSWORD)).sendKeys("123456");
		chromeDriver.findElement(By.cssSelector(LoginPage.LOGIN)).click();
		//chromeDriver.findElementByXPath(LoginPage.LOGIN).click();
	}
}
