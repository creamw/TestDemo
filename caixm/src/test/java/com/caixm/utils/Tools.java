package com.caixm.utils;


import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.CommandExecutor;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.Response;
import org.sikuli.script.FindFailed;
import org.sikuli.script.ImagePath;
import org.sikuli.script.Screen;

import com.caixm.elements.web.LoginPage;
import com.caixm.elements.web.SaleDataPage;
import com.caixm.script_app.StartApp;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.PerformsActions;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class Tools {
	public static AndroidDriver androidDriver = StartApp.driver;
	
	//@Test
	public void getWeb() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Administrator\\AppData\\Local\\Google\\Chrome\\Application\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://dev.api.caixm.cn/");
		driver.manage().window().maximize();
		driver.findElement(By.cssSelector("#username")).sendKeys("15666666666");
		driver.findElement(By.cssSelector("#password")).sendKeys("123456");
		driver.findElement(By.cssSelector(LoginPage.LOGIN)).click();
		driver.findElement(By.xpath(SaleDataPage.SALEDATABUTTON)).click();
		Thread.sleep(500);
		driver.findElement(By.xpath(SaleDataPage.SALEORDERMANAGE)).click();
		String serial = driver.findElement(By.xpath(SaleDataPage.FIRSTORDERSERIALNO)).getText();
		String time = driver.findElement(By.xpath(SaleDataPage.FIRSTORDERTIME)).getText();
		String buyer = driver.findElement(By.xpath(SaleDataPage.FIRSTORDERBUYER)).getText();
		String casher = driver.findElement(By.xpath(SaleDataPage.FIRSTORDERCASHER)).getText();
		String money = driver.findElement(By.xpath(SaleDataPage.FIRSTORDERMONEY)).getText();
		String state = driver.findElement(By.xpath(SaleDataPage.FIRSTORDERSTATE)).getText();
		WebElement element = driver.findElement(By.xpath(SaleDataPage.FIRSTORDERSTATE));
		File file = element.getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(file, new File("C:\\Users\\Administrator\\eclipse-workspace\\caixm\\res\\screenshot.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		
		System.out.println(serial+time+buyer+casher+money+state);
		Thread.sleep(4000);
		driver.quit();
		
	}
	
	@Test
	public void sikuliDemo() throws IOException, FindFailed {
		Screen s = new Screen();
		
		ImagePath.add("res");
		s.click("res\\eclipse-icon.png");

		
		
	}
	
	@Test
	public void getUUID() {
		
		
		AppiumServiceBuilder serviceBuilder = new AppiumServiceBuilder();
		DesiredCapabilities capabilities = new DesiredCapabilities();
		
		serviceBuilder.withCapabilities(capabilities);
		AppiumDriverLocalService service = serviceBuilder.build();
		
		service.start();
		
		
	}
	
	//@Test
	public void run() throws IOException, InterruptedException {
		//String string = "2018-11-26 14:45:21".substring(0, 16);
		//CommandExecutor executor = androidDriver.getCommandExecutor();
		 Runtime rt = Runtime.getRuntime();
		 //home
		 //rt.exec("adb shell input keyevent 3");
		 //rt.exec("adb shell input tap 661  827");
		 while(true) {
			 Thread.sleep(4000);
			 rt.exec("adb shell input tap 500 500");
			 //back
			 Thread.sleep(8000);
			 rt.exec("adb shell input swipe 500 1600 500 200 2000");
			 Thread.sleep(4000);
			 rt.exec("adb shell input keyevent 4");
			 Thread.sleep(2000);
			 rt.exec("adb shell input swipe 500 1200 500 500 2000");
		 }
		 
	}
}
