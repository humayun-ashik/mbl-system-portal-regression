package com.konasl.mbl.system.admin.pages;

import org.apache.commons.lang3.RandomUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.konasl.mbl.utils.CommonMethods;

public class BranchManagementPage {
	private static String menuName = "Branch Management";
	private static String subMenu1 = "Generate Branch QR";
	private static String subMenu2 = "Search Branch";
	private static String subMenu3 = "Branch Registration";
	private static String branchNameToSearch = "NATORE";
	private static String branchMobileNoToSearch = "01719000001";
	private static String detailsButtonElement = "from-group";
	private static String registerButtonElement = "btn-primary";



	public static String getMenuName(){
		return menuName;
	}
	public static String getSubMenu1(){
		return subMenu1;
	}
	public static String getSubMenu2(){
		return subMenu2;
	}
	public static String getSubMenu3(){
		return subMenu3;
	}
	public static String getBranchNameToSearch(){
		return branchNameToSearch;
	}
	public static String getBranchMobileNoToSearch(){
		return branchMobileNoToSearch;
	}
	public static String getDetailsButtonElement(){
		return detailsButtonElement;
	}
	public static String getRegisterButtonElement(){
		return registerButtonElement;
	}

	public static WebDriver uploadFile(WebDriver driver, String path) throws InterruptedException {
		// TODO Auto-generated method stub
		System.out.println("Inside upload file function");
		WebElement uploadElement = driver.findElement(By.name("file"));
		
		//uploadElement.click();
		//System.out.println("Choose file button clicked");
		uploadElement.sendKeys(path);
		System.out.println("location sent ");
		driver.findElement(By.xpath("//*[@id=\"horizontal-form-layouts\"]/div[2]/div/div/div/div/form/div[2]/div/button")).click();
		System.out.println("Submit button clicked");
		Thread.sleep(5000);
		return driver;
		
	}
	public static void fillUpAccountInfo(WebDriver driver) {
		driver.findElement(By.id("merchantAccountNo")).sendKeys(CommonMethods.randomIDGenerator());
		driver.findElement(By.id("accountNo")).sendKeys(CommonMethods.randomMobileNoGenerator());
		CommonMethods.selectDropdownItemsByVisibleText(driver,"id", "mno","Grameenphone");
		driver.findElement(By.id("accountName")).sendKeys("asdf");
		driver.findElement(By.id("accountRoutingNo")).sendKeys("121");
	
		
	}
	public static void fillUpAccountInfoWithUsedMobileNo(WebDriver driver, String mobileNo) {

		driver.findElement(By.id("merchantAccountNo")).sendKeys(CommonMethods.randomIDGenerator());
		driver.findElement(By.id("accountNo")).sendKeys(mobileNo);
		CommonMethods.selectDropdownItemsByVisibleText(driver,"id", "mno","Grameenphone");
		driver.findElement(By.id("accountName")).sendKeys("asdf");
		driver.findElement(By.id("accountRoutingNo")).sendKeys("121");
	
		
	}
	public static void fillUpRegisteredAddress(WebDriver driver) {
		driver.findElement(By.id("orgRegisteredAddress")).sendKeys("Vill: qwe, P/O: asdf, Thana: zxccvv, District: fevfhfrhfr");

		CommonMethods.selectDropdownItemsByIndex(driver,"id", "registeredDivision",RandomUtils.nextInt(3, 6));
		CommonMethods.selectDropdownItemsByIndex(driver,"id", "registeredDistrict",RandomUtils.nextInt(3, 6));
		CommonMethods.selectDropdownItemsByIndex(driver,"id", "registeredThana",RandomUtils.nextInt(3, 6));
		driver.findElement(By.id("registeredPostCode")).sendKeys("1234");
		
	
		
	}
	public static void getDetailsOfTab(WebDriver driver, String detailButton, String tableElement) {
		driver.findElement(By.className("from-group")).click();
		driver.findElement(By.id("transactionTab")).click();
		String trxTabDetails = driver.findElement(By.className("card-body")).getText();
		
	}

}
