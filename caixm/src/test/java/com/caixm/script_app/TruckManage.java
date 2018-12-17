package com.caixm.script_app;

import java.io.IOException;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.mobile.AddNetworkConnection;

import com.caixm.elements.mobile.TruckManagePage;
import com.caixm.utils.ChineseName;

import io.appium.java_client.android.AndroidDriver;

public class TruckManage {
	public static AndroidDriver androidDriver = StartApp.driver;
	
	
	/**
	 * 售罄所有车次
	 */
	//@Test
	public void sellALL() {
		
		try {
			while (true) {
				androidDriver.findElement(By.xpath(TruckManagePage.TRUCKMANAGEBUTTON)).click();
				androidDriver.findElement(By.xpath(TruckManagePage.FIRSTTRUCKNO)).click();
				androidDriver.findElement(By.id(TruckManagePage.SELLFINISH)).click();
				androidDriver.findElement(By.id(TruckManagePage.SELLFINISHCONFIRM)).click();
				androidDriver.findElement(By.id(TruckManagePage.SELLFINISHSUCCESS)).click();
			} 
		} catch (Exception e) {
			System.out.println("所有车次售罄完毕");
		}
		
	}
	
	/**
	 * 随机增加一个货主
	 * @throws IOException
	 * @throws InterruptedException 
	 */
	@Test
	public void addTrunck() throws IOException, InterruptedException {
		//新增货主
		androidDriver.findElement(By.xpath(TruckManagePage.TRUCKMANAGEBUTTON)).click();
		
		/*WebElement shipper = androidDriver.findElement(By.xpath(TruckManagePage.SHIPPER));
		System.out.println(shipper.getText());*/
		androidDriver.findElement(By.id("com.zhiyi.cxm.caixm_dev:id/tv_supplier_list")).click();
		androidDriver.findElement(By.xpath(TruckManagePage.ADDSHIPPER)).click();
		androidDriver.findElement(By.xpath(TruckManagePage.SHIPPERNAME)).sendKeys(ChineseName.getRandomName());
		WebElement chooseplace = androidDriver.findElement(By.xpath(TruckManagePage.CHOOSEPLACE));
		Point point = chooseplace.getLocation();
		System.out.println(point.x+"--"+point.y);
		Runtime.getRuntime().exec("adb shell input swipe "+point.x+" "+(point.y+100)+" "+point.x+" "+point.y+" "+1000);
		Thread.sleep(2500);
		androidDriver.findElement(By.xpath(TruckManagePage.SAVE)).click();
		
		//新增车次
		androidDriver.findElement(By.id(TruckManagePage.TRUCKNO_ID)).click();
		androidDriver.findElement(By.xpath(TruckManagePage.ADDTRUCKNO)).click();
		androidDriver.findElement(By.xpath(TruckManagePage.CHOOSESHIPPER)).click();
		androidDriver.findElement(By.xpath(TruckManagePage.SAVING_TRUCK)).click();
		androidDriver.findElement(By.xpath(TruckManagePage.FIRSTBATCH)).click();
		androidDriver.findElement(By.xpath(TruckManagePage.TICKETTRUCK)).click();
		
		//新增菜品
		androidDriver.findElement(By.xpath(TruckManagePage.TICKETTRUCK)).click();
		androidDriver.findElement(By.xpath(TruckManagePage.ADDFOOD)).click();
		androidDriver.findElement(By.xpath(TruckManagePage.FOODNAME)).sendKeys(ChineseName.getRandomName());
		androidDriver.findElement(By.xpath(TruckManagePage.PACKAGE)).click();
		androidDriver.findElement(By.xpath(TruckManagePage.PACKAGESPEC)).sendKeys("6");
		androidDriver.findElement(By.xpath(TruckManagePage.PACKAGENUMBER)).sendKeys("1");
		androidDriver.findElement(By.xpath(TruckManagePage.PACKAGETICKET)).sendKeys("1");
		androidDriver.findElement(By.xpath(TruckManagePage.PACKAGESAVE)).click();
		
	}
}
