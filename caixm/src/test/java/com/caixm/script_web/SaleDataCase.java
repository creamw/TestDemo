package com.caixm.script_web;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import com.caixm.elements.web.SaleDataPage;
import com.caixm.script_app.OrderCenter;
import com.caixm.utils.Driver;

public class SaleDataCase {
	static ChromeDriver chromeDriver = Driver.chromeDriver;
	
	/**销售单管理销售单检查测试类*/
	public static class SaleOrderManage{
		
		/**检查销售单各项数据
		 * @throws InterruptedException */
		@Test
		public void checkSaleOrder() throws InterruptedException {
			boolean isPass = true;
			String[] content = new String[] {"流水号","时间","买家","收银员","金额","订单状态"}; 
			String[] str_web = getSaleOrderData();
			String[] str_app = new OrderCenter().getOrderInfo();
			for(int i = 0;i<str_web.length;i++) {
				if(str_web[i].equals(str_app[i])) {
					System.out.println(str_web[i]+"--"+str_app[i]+content[i]+"测试成功");
				}else {
					System.out.println(str_web[i]+"--"+str_app[i]+content[i]+"测试失败");
					isPass = false;
				}
			}
			if(!isPass) {
				assert false:"销售单管理页面测试失败";
			} 
		}
		
		
		/**获取销售单管理页面订单信息
		 * @return */
		public String[] getSaleOrderData() throws InterruptedException {
			chromeDriver.findElement(By.xpath(SaleDataPage.SALEDATABUTTON)).click();
			Thread.sleep(500);
			chromeDriver.findElement(By.xpath(SaleDataPage.SALEORDERMANAGE)).click();
			String serial = chromeDriver.findElement(By.xpath(SaleDataPage.FIRSTORDERSERIALNO)).getText();
			String time = chromeDriver.findElement(By.xpath(SaleDataPage.FIRSTORDERTIME)).getText();
			String buyer = chromeDriver.findElement(By.xpath(SaleDataPage.FIRSTORDERBUYER)).getText();
			String casher = chromeDriver.findElement(By.xpath(SaleDataPage.FIRSTORDERCASHER)).getText();
			String money = chromeDriver.findElement(By.xpath(SaleDataPage.FIRSTORDERMONEY)).getText();
			String status = chromeDriver.findElement(By.xpath(SaleDataPage.FIRSTORDERSTATE)).getText();
			String[] str = new String[] {serial,time,buyer,casher,money,status};
			return str;
		}
		
	}
	
	public static class SaleTableSerial{
		//@Test
		public void test2() {
			System.out.println("test2");
		}
	}
}
