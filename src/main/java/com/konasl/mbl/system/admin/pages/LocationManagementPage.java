package com.konasl.mbl.system.admin.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.konasl.mbl.utils.CommonMethods;

import java.io.File;

public class LocationManagementPage {

	private static String menuName = "Location Management";
	private static String subMenu1 = "ATM Location Import";
	private static String subMenu2 = "Branch Location Import";
	private static String subMenu3 = "Location Download";
	private static String uploadAtmLocationValidFilePath = "G:\\Automation\\qa-repo\\payment-project-automation\\resources\\ATM-Location.xlsx";
	private static String uploadInvalidFilePath = "G:\\Automation\\qa-repo\\payment-project-automation\\resources\\BRANCH-QR.pdf";
	private static String uploadBigFilePath = "G:\\Automation\\qa-repo\\payment-project-automation\\resources\\greaterThan5MB.xls";
	private static String uploadBranchLocationValidFilePath = "G:\\Automation\\qa-repo\\payment-project-automation\\resources\\Branch-Location.xlsx";
	private static String downloadButtonElement = "btn-raised";
	private static String dropdownSelectionElement = "transactionMti";


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
	public static String getUploadFilePath(String caseFile){
		File dir = new File("./");
		System.out.println(dir.getAbsolutePath());
		String path = null;
		if(caseFile == "validAtmLocation"){
			path = uploadAtmLocationValidFilePath;

		}
		else if(caseFile == "validBranchLocation"){
			path = uploadBranchLocationValidFilePath;

		}
		else if (caseFile == "invalidtype"){
			path = uploadInvalidFilePath;
		}
		else if(caseFile == "beyondsizelimit"){
			path = uploadBigFilePath;
		}

		return path;
	}
	public static String getDownloadButtonElement(){
		return downloadButtonElement;
	}
	public static String getDropdownSelectionElement(){
		return dropdownSelectionElement;
	}

	public static void goToSpecifiedPage(WebDriver driver, String menuName) {
		// TODO Auto-generated method stub
//		WebElement menu = driver.findElement(By.linkText("Location Management"));
//		menu.click();
		WebElement subMenu = driver.findElement(By.linkText(menuName));
		subMenu.click();
		System.out.println("Menu - " + menuName + " clicked");
		
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
	
	

}
