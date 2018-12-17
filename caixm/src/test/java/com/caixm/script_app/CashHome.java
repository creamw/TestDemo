package com.caixm.script_app;

import java.io.IOException;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;

import com.caixm.elements.mobile.CashHomePage;

import io.appium.java_client.android.AndroidDriver;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class CashHome {
	public static AndroidDriver androidDriver = StartApp.driver;
	public static String[] str;
	
	/**测试项目数组*/
	public static String[] str_contents;
	
	/**
	 * 常规定装下单
	 * 每件6公斤
	 * 货款：8.22
	 * 力资：5.97
	 * 票费：1
	 * @throws InterruptedException 
	 * @throws IOException 
	 */
	@Test
	public void a_packageOrder() throws InterruptedException, IOException {
		androidDriver.findElement(By.xpath(CashHomePage.CASHHOMEBUTTOM)).click();
		//androidDriver.findElement(By.xpath(CashHomePage.FIRSTTRUCK)).click();
		WebElement firsttruck = androidDriver.findElement(By.xpath(CashHomePage.FIRSTTRUCK));
		Point point = firsttruck.getLocation();
		Runtime.getRuntime().exec("adb shell input tap "+point.x+" "+point.y);
		androidDriver.findElement(By.xpath(CashHomePage.FIRSTMENU)).click();
		
		androidDriver.findElement(By.xpath(CashHomePage.NUMBERPACKAGE)).click();
		androidDriver.findElement(By.xpath(CashHomePage.NO1)).click();
		androidDriver.findElement(By.xpath(CashHomePage.UNITPRICEPACKAGE)).click();
		androidDriver.findElement(By.xpath(CashHomePage.NO1)).click();
		androidDriver.findElement(By.xpath(CashHomePage.NODOT)).click();
		androidDriver.findElement(By.xpath(CashHomePage.NO3)).click();
		androidDriver.findElement(By.xpath(CashHomePage.NO7)).click();
		androidDriver.findElement(By.xpath(CashHomePage.POWERMONEYPACKAGE)).click();
		androidDriver.findElement(By.xpath(CashHomePage.NO5)).click();
		androidDriver.findElement(By.xpath(CashHomePage.NODOT)).click();
		androidDriver.findElement(By.xpath(CashHomePage.NO9)).click();
		androidDriver.findElement(By.xpath(CashHomePage.NO7)).click();
		androidDriver.findElement(By.xpath(CashHomePage.CONFIRM)).click();
		androidDriver.findElement(By.xpath(CashHomePage.FIRSTCUSTOMER)).click();
		androidDriver.findElement(By.xpath(CashHomePage.PUSHORDER)).click();
		Thread.sleep(2000);
		androidDriver.findElement(By.xpath(CashHomePage.CASHING)).click();
		
			
	}
	
	/**
	 * 生成历史赊欠及今日历史还款数据
	 * 定装：每件6公斤
	 * 货款：8.22
	 * 力资：5.97
	 * 票费：1
	 * @throws InterruptedException
	 */
	@Test
	public void b_creditOrder() throws InterruptedException {
		androidDriver.findElement(By.xpath(CashHomePage.CASHHOMEBUTTOM)).click();
		androidDriver.findElement(By.xpath(CashHomePage.FIRSTTRUCK)).click();
		androidDriver.findElement(By.xpath(CashHomePage.FIRSTMENU)).click();
		
		androidDriver.findElement(By.xpath(CashHomePage.NUMBERPACKAGE)).click();
		androidDriver.findElement(By.xpath(CashHomePage.NO1)).click();
		androidDriver.findElement(By.xpath(CashHomePage.UNITPRICEPACKAGE)).click();
		androidDriver.findElement(By.xpath(CashHomePage.NO1)).click();
		androidDriver.findElement(By.xpath(CashHomePage.NODOT)).click();
		androidDriver.findElement(By.xpath(CashHomePage.NO3)).click();
		androidDriver.findElement(By.xpath(CashHomePage.NO7)).click();
		androidDriver.findElement(By.xpath(CashHomePage.POWERMONEYPACKAGE)).click();
		androidDriver.findElement(By.xpath(CashHomePage.NO5)).click();
		androidDriver.findElement(By.xpath(CashHomePage.NODOT)).click();
		androidDriver.findElement(By.xpath(CashHomePage.NO9)).click();
		androidDriver.findElement(By.xpath(CashHomePage.NO7)).click();
		androidDriver.findElement(By.xpath(CashHomePage.CONFIRM)).click();
		androidDriver.findElement(By.xpath(CashHomePage.FIRSTCUSTOMER)).click();
		androidDriver.findElement(By.xpath(CashHomePage.PUSHORDER)).click();
		Thread.sleep(3000);
		androidDriver.findElement(By.xpath(CashHomePage.CREDIT)).click();
		androidDriver.findElement(By.xpath(CashHomePage.CREDITCONFITM)).click();
		
		//TODO 交账
		new CashStatistics().handBill();
		JUnitCore.runClasses(LoginApp.class);
		
	}
	
	/**
	 * 非定装补货，力资0，灌包1.5
	 */
	@Test
	public void c_patchGoods() {
		androidDriver.findElement(By.xpath(CashHomePage.CASHHOMEBUTTOM)).click();
		androidDriver.findElement(By.xpath(CashHomePage.FIRSTTRUCK)).click();
		androidDriver.findElement(By.xpath(CashHomePage.SECONDMENU)).click();
		androidDriver.findElement(By.xpath(CashHomePage.PATCHGOODS)).click();
		androidDriver.findElement(By.xpath(CashHomePage.PATHCHGOODSNUMMBER)).click();
		androidDriver.findElement(By.xpath(CashHomePage.NO1)).click();
		androidDriver.findElement(By.xpath(CashHomePage.PATCHKKG)).click();
		androidDriver.findElement(By.xpath(CashHomePage.NO1)).click();
		androidDriver.findElement(By.xpath(CashHomePage.PATHCHGOODSPACKAGE)).click();
		androidDriver.findElement(By.xpath(CashHomePage.NO1)).click();
		androidDriver.findElement(By.xpath(CashHomePage.NODOT)).click();
		androidDriver.findElement(By.xpath(CashHomePage.NO5)).click();
		androidDriver.findElement(By.xpath(CashHomePage.PATCHGOODSPOWER)).click();
		androidDriver.findElement(By.xpath(CashHomePage.NO0)).click();
		androidDriver.findElement(By.xpath(CashHomePage.CONFIRM)).click();
		androidDriver.findElement(By.xpath(CashHomePage.PUSHORDER)).click();
		androidDriver.findElement(By.xpath(CashHomePage.PATCHCONFIRM)).click();
		androidDriver.findElement(By.xpath(CashHomePage.CASHING)).click();
		
		
		
		str = new String[]{"17.56","2","12","2","1.56","17.56","15","16.44","9999","0"};
		str_contents = new String[] {"档口今日收益","开票费","力资费","灌包费","货款零差收益","档口N月累计收益","历史赊欠","档口今日销售货款","今日历史还款","在售车次"};
	}
	
	
}
