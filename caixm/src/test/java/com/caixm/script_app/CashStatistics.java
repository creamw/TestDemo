package com.caixm.script_app;

import org.junit.Test;
import org.openqa.selenium.By;

import com.caixm.elements.mobile.CashStatisticsPage;

import io.appium.java_client.android.AndroidDriver;

public class CashStatistics {
	public static AndroidDriver androidDriver = StartApp.driver;
	
	/**
	 * 交账操作
	 */
	@Test
	public void handBill() {
		androidDriver.findElement(By.xpath(CashStatisticsPage.CashStatisticsBUTTON)).click();
		androidDriver.findElement(By.xpath(CashStatisticsPage.HANDBILL)).click();
		androidDriver.findElement(By.xpath(CashStatisticsPage.CONFIRM)).click();
		try {
			androidDriver.findElement(By.xpath(CashStatisticsPage.PUSHORDERCONFITM)).click();
		} catch (Exception e) {
			androidDriver.findElement(By.xpath(CashStatisticsPage.NOTZEROBUTTON)).click();
			androidDriver.findElement(By.xpath(CashStatisticsPage.CANCLE)).click();
			e.printStackTrace();
		}
	}
}
