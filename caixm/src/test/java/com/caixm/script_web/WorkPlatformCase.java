package com.caixm.script_web;

import java.awt.AWTException;
import java.awt.Robot;
import java.io.IOException;
import java.math.BigDecimal;
import java.net.MalformedURLException;
import java.text.Bidi;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import com.caixm.elements.web.WorkPlatform;
import com.caixm.script_app.CashHome;
import com.caixm.script_app.CashStatistics;
import com.caixm.script_app.LoginApp;
import com.caixm.script_app.OrderCenter;
import com.caixm.script_app.StartApp;
import com.caixm.utils.Driver;

import io.appium.java_client.android.AndroidDriver;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class WorkPlatformCase {
	ChromeDriver chromeDriver = Driver.chromeDriver;
	//public static AndroidDriver androidDriver = StartApp.driver;
	/**
	 * 检查档口当日收益，数据是否同步（单菜品，单收银员）
	 * @throws InterruptedException
	 * @throws AWTException 
	 * @throws IOException 
	 */
	@Test
	public void a_checkStallProfit() throws InterruptedException, AWTException, IOException {
		
		//JUnitCore.runClasses(StartApp.class,LoginApp.class,CashHome.class,OrderCenter.class);
		StartApp startApp = new StartApp();
		startApp.a_boot();
		new LoginApp().loginApp();
		new CashStatistics().handBill();
		String[] str = checkDate();
		
		
		//startApp.driver.findElement(By.xpath("//android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.RelativeLayout[1]/android.widget.RelativeLayout[1]/android.widget.LinearLayout[1]/android.widget.TextView[2]"));

		//定位任意登录后的app页面元素，判断交账后是否退出app
		try {
			startApp.driver.findElement(By.xpath("//android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.RelativeLayout[1]/android.widget.RelativeLayout[1]/android.widget.LinearLayout[1]/android.widget.TextView[2]"));
		} catch (Exception e) {
			new LoginApp().loginApp();
			e.printStackTrace();
		}
		new CashHome().a_packageOrder();
		new CashHome().b_creditOrder();
		new CashHome().c_patchGoods();
		new OrderCenter().repay();
		
		
		new Robot().keyPress(java.awt.event.KeyEvent.VK_F5);
		Thread.sleep(2000);
		String[] str_latest = checkDate();
		String[] fail = new String[10];
		boolean isPass = true;
		int i = 0;
		while(i<str.length) {
			//new BigDecimal(str[i]).add(new BigDecimal(CashHome.str[i])) == new BigDecimal(str_latest[i])
			if(new BigDecimal(str[i]).add(new BigDecimal(CashHome.str[i])).compareTo(new BigDecimal(str_latest[i]))==0) {
				System.out.println(str[i]+"--"+CashHome.str[i]+"--"+str_latest[i]+CashHome.str_contents[i]+"测试成功");
				//assert true:"数据测试pass";
			}else {
				System.out.println(str[i]+"--"+CashHome.str[i]+"--"+str_latest[i]+CashHome.str_contents[i]+"测试失败");
				//assert false:"数据测试fail";
				fail[i] = CashHome.str_contents[i];
				isPass = false;
			}
			i++;
		}
		if(!isPass) {
			for (String string : fail) {
				if(string!=null) {
					System.out.println(string+"测试失败");
				}
			}
			assert false:"失败项目："+fail;
			//chromeDriver.quit();
		}
	}
	
	/**
	 * 获取工作台页面各项数据
	 * @return 
	 */
	public String[] checkDate() {
		//档口今日收益数据
		String l = chromeDriver.findElement(By.xpath(WorkPlatform.MyWorkPlatform.STALLPROFIT)).getText().replaceAll(",", "");
		String l1 = l.substring(8,l.length());
		System.out.println("档口今日收益："+l1);
		//开票费
		String l2 = chromeDriver.findElement(By.xpath(WorkPlatform.MyWorkPlatform.BILLCOST)).getText().replaceAll(",", "");
		System.out.println("开票费："+l2);
		//力资费
		String l3 = chromeDriver.findElement(By.xpath(WorkPlatform.MyWorkPlatform.STALLFEE)).getText().replaceAll(",", "");
		System.out.println("力资费："+l3);
		//灌包费
		String l4 = chromeDriver.findElement(By.xpath(WorkPlatform.MyWorkPlatform.PACKAGEFEE)).getText().replaceAll(",", "");
		System.out.println("灌包费："+l4);
		//货款零差收益
		String l5 = chromeDriver.findElement(By.xpath(WorkPlatform.MyWorkPlatform.GOODSZDPROFIT)).getText().replaceAll(",", "");
		System.out.println("货款零差收益："+l5);
		//力资零差收益
		//String l6 = chromeDriver.findElement(By.xpath(WorkPlatform.MyWorkPlatform.STALLZDPROFIT)).getText().replaceAll(",", "");
		//System.out.println("力资零差收益："+l6);
		//灌包零差收益
		//String l7 = chromeDriver.findElement(By.xpath(WorkPlatform.MyWorkPlatform.PACKAGEZDPROFIT)).getText().replaceAll(",", "");
		//System.out.println("灌包零差收益："+l7);
		//档口n月累计收益
		String l8 = chromeDriver.findElement(By.xpath(WorkPlatform.MyWorkPlatform.STALLACCUMLATIVE)).getText().split(":")[1].trim().replaceAll(",", "");
		System.out.println("档口n月累计收益："+l8);
		//历史赊欠
		String l9 = chromeDriver.findElement(By.xpath(WorkPlatform.MyWorkPlatform.HISTORYOWE)).getText().replaceAll(",", "");
		System.out.println("历史赊欠："+l9);
		//档口今日销售货款
		String l10 = chromeDriver.findElement(By.xpath(WorkPlatform.MyWorkPlatform.STALLTODAYTRUCKFEE)).getText().replaceAll(",", "");
		System.out.println("档口今日销售货款："+l10);
		//今日历史还款
		String l11 = chromeDriver.findElement(By.xpath(WorkPlatform.MyWorkPlatform.TODAYHISTORYREPAY)).getText().replaceAll(",", "");
		System.err.println("今日历史还款："+l11);
		//在售车次
		String l12 = chromeDriver.findElement(By.xpath(WorkPlatform.MyWorkPlatform.SELLINGTRUCK)).getText().replaceAll(",", "");
		System.err.println("在售车次："+l12);
		//销售额趋势
		//String l13 = chromeDriver.findElement(By.xpath(WorkPlatform.MyWorkPlatform.SELLTREND)).getText().replaceAll(",", "");
		//System.out.println("销售额趋势："+l13);
		String[] str = new String[] {l1,l2,l3,l4,l5,l8,l9,l10,l11,l12};
		return str;
	}
	
	//@Test
	public void add() {
		//System.out.println(new BigDecimal("14.22").add(new BigDecimal("1.56").com));
		System.out.println(new BigDecimal("2").compareTo(new BigDecimal("1")));
		
	}
}
