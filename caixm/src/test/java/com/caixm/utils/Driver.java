package com.caixm.utils;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;

public class Driver {
	public static ChromeDriver chromeDriver = null;
	public static AndroidDriver  androidDriver = null;
	
	@Test
	public void initChromeDriver() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Administrator\\AppData\\Local\\Google\\Chrome\\Application\\chromedriver.exe");
		chromeDriver = new ChromeDriver();
		chromeDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	//@Test
	public void initAndroidDriver() throws MalformedURLException {
		DesiredCapabilities capabilities = new DesiredCapabilities();  
	       //capabilities.setCapability("udid", "192.168.1.145:5555");
	       capabilities.setCapability("deviceName","nubia Z11"); 
	     //capabilities.setCapability("deviceName", "test_device");
	     //capabilities.setCapability("deviceName", "test_device");
	       capabilities.setCapability("automationName","Appium");  
	       capabilities.setCapability("platformName","Android");  
	       capabilities.setCapability("platformVersion","6.0.1"); 
	       
	       capabilities.setCapability("appPackage", "com.zhiyi.cxm.caixm_dev");  
	       capabilities.setCapability("appActivity", "com.zhiyi.cxm.caixm.login.LoadingADActivity");  
	       capabilities.setCapability("sessionOverride", true);
	       capabilities.setCapability("unicodeKeyboard", true);
	       capabilities.setCapability("resetKeyboard", false);
	       androidDriver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);  
	       //driver = new AndroidDriver(new URL("http://127.0.0.1:4724/wd/hub"), capabilities);
	       androidDriver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);  
	}
	
}
