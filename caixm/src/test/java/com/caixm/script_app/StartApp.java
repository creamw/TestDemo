package com.caixm.script_app;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.junit.runners.Parameterized;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.caixm.elements.mobile.LoginPage;

import io.appium.java_client.android.AndroidDriver;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
//@RunWith(Parameterized.class)
public class StartApp {
	public static AndroidDriver  driver;
	
	@Test
	public void a_boot() throws MalformedURLException, InterruptedException{
       DesiredCapabilities capabilities = new DesiredCapabilities();  
       //capabilities.setCapability("udid", "192.168.1.145:5555");
       //capabilities.setCapability("clearSystemFiles", true);
       capabilities.setCapability("deviceName","EA07HD14E075"); 
       //capabilities.setCapability("deviceName", "test_device");
       //capabilities.setCapability("deviceName", "test_device");
       capabilities.setCapability("automationName","Appium");  
       capabilities.setCapability("platformName","Android");  
       capabilities.setCapability("platformVersion","6.0.1"); 
       
       capabilities.setCapability("appPackage", "com.zhiyi.cxm.caixm_dev");  
       //capabilities.setCapability("appActivity", "com.zhiyi.cxm.caixm.login.LoadingADActivity");
       capabilities.setCapability("appActivity", "cn.caixm.stall.login.MainActivity");
       capabilities.setCapability("sessionOverride", true);
       capabilities.setCapability("unicodeKeyboard", true);
       capabilities.setCapability("resetKeyboard", false);
       driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);  
       //driver = new AndroidDriver(new URL("http://127.0.0.1:4724/wd/hub"), capabilities);
       driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);  
       //Thread.sleep(5000);   
       
	}
	
	//@Test
	public void b_login() throws InterruptedException {
		driver.findElementById(LoginPage.USERNAME).sendKeys("15666666666");
		driver.findElementById(LoginPage.PASSWORD).sendKeys("123456");
		driver.findElementById(LoginPage.LOGIN).click();
		//driver.findElementById(loginPage.getAllow()).click();
	}
}
