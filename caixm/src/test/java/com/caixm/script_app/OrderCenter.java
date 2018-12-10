package com.caixm.script_app;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;

import com.caixm.elements.mobile.OrderCenterPage;

import io.appium.java_client.android.AndroidDriver;

public class OrderCenter {
	public static AndroidDriver androidDriver = StartApp.driver;
	
	
	/**
	 * 首个赊账单，还款1元
	 * @throws IOException 
	 */
	//@Test
	public void repay() throws IOException {
		androidDriver.findElement(By.xpath(OrderCenterPage.ORDERCENTERBUTTON)).click();
		androidDriver.findElement(By.xpath(OrderCenterPage.CREDITBUTTON)).click();
		androidDriver.findElement(By.xpath(OrderCenterPage.ALLCREDIT)).click();
		androidDriver.findElement(By.xpath(OrderCenterPage.FIRSTCREDITORDER)).click();
		//androidDriver.findElement(By.xpath(OrderCenterPage.REPAYBUTTON)).click();
		//androidDriver.findElement(By.id(OrderCenterPage.REPAYBUTTONID));
		WebElement element = androidDriver.findElementById(OrderCenterPage.REPAYBUTTONID);
		Point point = element.getLocation();
		Runtime.getRuntime().exec("adb shell input tap "+point.x+" "+point.y);
		androidDriver.findElement(By.xpath(OrderCenterPage.CASH)).click();
		androidDriver.findElement(By.xpath(OrderCenterPage.NO1)).click();
		androidDriver.findElement(By.xpath(OrderCenterPage.CASHING)).click();
		
		new CashStatistics().handBill();
	}
	
	@Test
	public String[] getOrderInfo() {
		androidDriver.findElement(By.xpath(OrderCenterPage.ORDERCENTERBUTTON)).click();
		androidDriver.findElement(By.xpath(OrderCenterPage.FINISHIED)).click();
		androidDriver.findElement(By.xpath(OrderCenterPage.FIRSTFINISHORDER)).click();
		
		String serial = androidDriver.findElement(By.xpath(OrderCenterPage.ORDERSERIAL)).getText().replace("No.", "");
		String time = androidDriver.findElement(By.xpath(OrderCenterPage.CASHINGTIME)).getText().substring(0, 16);
		String buyer = androidDriver.findElement(By.xpath(OrderCenterPage.BUYER)).getText();
		String casher = androidDriver.findElement(By.xpath(OrderCenterPage.CASHER)).getText().replace("开单员:", "");
		String money = androidDriver.findElement(By.xpath(OrderCenterPage.MONEY)).getText().replace("总金额￥ ", "");
		String status;
		try {
			androidDriver.findElement(By.xpath(OrderCenterPage.HISTORYREPAY));
			System.out.println("找到历史还款订单的欠\\\"欠款金额\\\"控件，判定为历史还款订单\"");
			status = "";
		} catch (Exception e) {
			System.out.println("未找到历史还款订单的欠\\\"欠款金额\\\"控件，判定为已付款订单\"");
			status = "已付款";
		}
		
		String[] str = new String[] {serial,time,buyer,casher,money,status}; 	
		
		return str;
	}
}
