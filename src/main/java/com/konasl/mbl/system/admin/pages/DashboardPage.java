package com.konasl.mbl.system.admin.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DashboardPage {
	static String element;
	public static String getRegCountElement() {
		element = "count-numbers";
		return element;
		
	}
	public static String getActiveUserCountElement() {
		element = "/html/body/app-root/app-full-layout/div/div[2]/div/div/div/app-dashboard1/div/div[1]/div/div[2]/div/span[1]";
		return element;
		
	}
	public static String getBillPayCountElement() {
		element = "/html/body/app-root/app-full-layout/div/div[2]/div/div/div/app-dashboard1/div/div[2]/div[1]/div/div/ul/li[1]/span[2]";
		return element;
		
	}
	public static String getBillPayAmountElement() {
		element = "/html/body/app-root/app-full-layout/div/div[2]/div/div/div/app-dashboard1/div/div[2]/div[1]/div/div/ul/li[2]/span[2]";
		return element;
		
	}
	public static String getW2WCountElement() {
		element = "/html/body/app-root/app-full-layout/div/div[2]/div/div/div/app-dashboard1/div/div[2]/div[2]/div/div/ul/li[1]/span[2]";
		return element;
		
	}
	public static String getW2WAmountElement() {
		element = "/html/body/app-root/app-full-layout/div/div[2]/div/div/div/app-dashboard1/div/div[2]/div[2]/div/div/ul/li[2]/span[2]";
		return element;
	}
	public static String getA2ACountElement() {
		element = "/html/body/app-root/app-full-layout/div/div[2]/div/div/div/app-dashboard1/div/div[2]/div[3]/div/div/ul/li[1]/span[2]";
		return element;
		
	}
	public static String getA2AAmountElement() {
		element = "/html/body/app-root/app-full-layout/div/div[2]/div/div/div/app-dashboard1/div/div[2]/div[3]/div/div/ul/li[2]/span[2]";
		return element;
	}
	
	public static String getMerchantPayCountElement() {
		element = "/html/body/app-root/app-full-layout/div/div[2]/div/div/div/app-dashboard1/div/div[2]/div[4]/div/div/ul/li[1]/span[2]";
		return element;
		
	}
	public static String getMerchantPayAmountElement() {
		element = "/html/body/app-root/app-full-layout/div/div[2]/div/div/div/app-dashboard1/div/div[2]/div[4]/div/div/ul/li[2]/span[2]";
		return element;
	}
	
	public static String getBEFTNCountElement() {
		element = "/html/body/app-root/app-full-layout/div/div[2]/div/div/div/app-dashboard1/div/div[2]/div[5]/div/div/ul/li[1]/span[2]";
		return element;
		
	}
	public static String getBEFTNAmountElement() {
		element = "/html/body/app-root/app-full-layout/div/div[2]/div/div/div/app-dashboard1/div/div[2]/div[5]/div/div/ul/li[2]/span[2]";
		return element;
	}
	
	public static String getMobileRechargeCountElement() {
		element = "/html/body/app-root/app-full-layout/div/div[2]/div/div/div/app-dashboard1/div/div[2]/div[6]/div/div/ul/li[1]/span[2]";
		return element;
		
	}
	public static String getMobileRechargeAmountElement() {
		element = "/html/body/app-root/app-full-layout/div/div[2]/div/div/div/app-dashboard1/div/div[2]/div[6]/div/div/ul/li[2]/span[2]";
		return element;
	}
	
	public static String getA2WCountElement() {
		element = "/html/body/app-root/app-full-layout/div/div[2]/div/div/div/app-dashboard1/div/div[2]/div[7]/div/div/ul/li[1]/span[2]";
		return element;
		
	}
	public static String getA2WAmountElement() {
		element = "/html/body/app-root/app-full-layout/div/div[2]/div/div/div/app-dashboard1/div/div[2]/div[7]/div/div/ul/li[2]/span[2]";
		return element;
	}
	
	public static String getW2ACountElement() {
		element = "/html/body/app-root/app-full-layout/div/div[2]/div/div/div/app-dashboard1/div/div[2]/div[8]/div/div/ul/li[1]/span[2]";

		return element;
		
	}
	public static String getW2AAmountElement() {
		element = "/html/body/app-root/app-full-layout/div/div[2]/div/div/div/app-dashboard1/div/div[2]/div[8]/div/div/ul/li[2]/span[2]";
		return element;
	}
	
	public static String getCreditCardBillPayCountElement() {
		element = "/html/body/app-root/app-full-layout/div/div[2]/div/div/div/app-dashboard1/div/div[2]/div[9]/div/div/ul/li[1]/span[2]";

		return element;
		
	}
	public static String getCreditCardBillPayAmountElement() {
		element = "/html/body/app-root/app-full-layout/div/div[2]/div/div/div/app-dashboard1/div/div[2]/div[9]/div/div/ul/li[2]/span[2]";
		return element;
	}
	public static String getBranchQrWithdrawalCountElement() {
		element = "/html/body/app-root/app-full-layout/div/div[2]/div/div/div/app-dashboard1/div/div[2]/div[10]/div/div/ul/li[1]/span[2]";
		return element;
	}
	public static String getBranchQrWithdrawalAmountElement() {
		element = "/html/body/app-root/app-full-layout/div/div[2]/div/div/div/app-dashboard1/div/div[2]/div[10]/div/div/ul/li[2]/span[2]";
		return element;
	}
	public static String getEcomPayCountElement() {
		element = "/html/body/app-root/app-full-layout/div/div[2]/div/div/div/app-dashboard1/div/div[2]/div[11]/div/div/ul/li[1]/span[2]";
		return element;
	}
	public static String getEcomPaylAmountElement() {
		element = "/html/body/app-root/app-full-layout/div/div[2]/div/div/div/app-dashboard1/div/div[2]/div[11]/div/div/ul/li[2]/span[2]";
		return element;
	}


}
