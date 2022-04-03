package com.konasl.mbl.utils;

import org.apache.commons.lang3.RandomUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.konasl.mbl.system.admin.pages.BranchManagementPage;

import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.util.Random;
import com.konasl.mbl.utils.SaveTestResultToExcelFile;

public class CommonMethods {
	static String data;
	public static String downloadPath = "C:\\Users\\Ashik\\Downloads";
	public static Boolean isCountValid(int status) {
		if(status >= 0) {
			return true;
		}
		
		return false;
		
	}
	
	public static Boolean isAmountValid(float f) {
		if(f >= 0) {
			return true;
		}
		
		return false;
		
	}
	public static String randomMobileNoGenerator() {
		Random generator = new Random();
		String set1, mobileNo;
		set1 = "01";
		int num2 = RandomUtils.nextInt(3, 9);
		int num3 = generator.nextInt(99999999)+10000000;
		mobileNo = set1 + Integer.toString(num2) + Integer.toString(num3);
		return mobileNo;
		
	}
	public static String randomIDGenerator() {
		Random generator = new Random();
		int num1 = generator.nextInt(999999999);
		int num2 = generator.nextInt(999999999);
		String id = Integer.toString(num1) + Integer.toString(num2);
		return id;
		
	}
	public static void goToSpecifiedPage(WebDriver driver, String menuName) throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText(menuName)));
		WebElement subMenu = driver.findElement(By.linkText(menuName));
		subMenu.click();
		System.out.println("Menu - " + menuName + " clicked");
		Thread.sleep(2000);

	}
	
	public static Boolean getNoOfTrxStatus(String path, WebDriver driver) {
		WebElement NoOfTrx = driver.findElement(By.xpath(path));
		System.out.println("Count of Transaction: "+ Integer.parseInt(NoOfTrx.getText()));
		Boolean countNoOfTrxStatus = isCountValid(Integer.parseInt(NoOfTrx.getText()));
		return countNoOfTrxStatus;
		
	}
	public static Boolean getTotalTrxAmountStatus(String path, WebDriver driver) {
		WebElement elementText = driver.findElement(By.xpath(path));		
		String amountValue = elementText.getText();
		amountValue = amountValue.replaceAll("[^0-9.]", "");  
		System.out.println("Amount of transaction : "+ amountValue);
		Boolean amountValueStatus = isAmountValid(Float.parseFloat(amountValue));	
		return amountValueStatus;
		
	}
	
	public static String getToastMessage(WebDriver driver) {
		
		try {
			return driver.findElement(By.id("toast-container")).getText();
			
		}catch(Exception e) {
			System.out.println("Loading took too much time");
			return e.getMessage();
		}
	}
	public static void closeToastMessage(WebDriver driver) {
		driver.findElement(By.className("toast-close-button")).click();
	}

	public static void selectDropdownItemsByVisibleText(WebDriver driver, String identifier, String element, String dropDownValue) {
		Select dropdownItem = null;
		if(identifier == "id") {
			dropdownItem = new Select(driver.findElement(By.id(element)));

		}
		else if(identifier == "name") {
			dropdownItem = new Select(driver.findElement(By.name(element)));
		}
		else if(identifier == "className") {
			dropdownItem = new Select(driver.findElement(By.className(element)));
		}
		else if(identifier == "linkText") {
			dropdownItem = new Select(driver.findElement(By.linkText(element)));

		}
		else if(identifier == "partialLinkText") {
			dropdownItem = new Select(driver.findElement(By.partialLinkText(element)));

		}
		else if(identifier == "tagName") {
			dropdownItem = new Select(driver.findElement(By.tagName(element)));

		}
		else if(identifier == "cssSelector") {
			dropdownItem = new Select(driver.findElement(By.cssSelector(element)));

		}
		else if(identifier == "xpath") {
			dropdownItem = new Select(driver.findElement(By.xpath(element)));

		}
		
		dropdownItem.selectByVisibleText(dropDownValue);
		

	}
	public static void selectDropdownItemsByIndex(WebDriver driver, String identifier, String element, int dropDownIndex) {
		Select dropdownItem = null;
		if(identifier == "id") {
			dropdownItem = new Select(driver.findElement(By.id(element)));

		}
		else if(identifier == "name") {
			dropdownItem = new Select(driver.findElement(By.name(element)));
		}
		else if(identifier == "className") {
			dropdownItem = new Select(driver.findElement(By.className(element)));
		}
		else if(identifier == "linkText") {
			dropdownItem = new Select(driver.findElement(By.linkText(element)));

		}
		else if(identifier == "partialLinkText") {
			dropdownItem = new Select(driver.findElement(By.partialLinkText(element)));

		}
		else if(identifier == "tagName") {
			dropdownItem = new Select(driver.findElement(By.tagName(element)));

		}
		else if(identifier == "cssSelector") {
			dropdownItem = new Select(driver.findElement(By.cssSelector(element)));

		}
		else if(identifier == "xpath") {
			dropdownItem = new Select(driver.findElement(By.xpath(element)));

		}
		
		dropdownItem.selectByIndex(dropDownIndex);
		

	}
	public static boolean isFileDownloaded(String downloadPath, String fileName) {
		boolean flag = false;
	    File dir = new File(downloadPath);
	    File[] dir_contents = dir.listFiles();
	  	    
	    for (int i = 0; i < dir_contents.length; i++) {
	        if (dir_contents[i].getName().contains(fileName))
	            return flag=true;
	            }

	    return flag;
	}
	
	public static Boolean verifyDownloadWithFileName(String fileName) {

		Assert.assertTrue(isFileDownloaded(downloadPath, fileName), "Failed to download Expected document");
		return isFileDownloaded(downloadPath, fileName);
	}
	public static String generalSearch(WebDriver driver, String searchKey, String identifier, String element) throws InterruptedException {
		System.out.println(searchKey);
		if(identifier == "id") {
			driver.findElement(By.id(element)).sendKeys(searchKey);
			Thread.sleep(1000);
			
		}
		else if(identifier == "name") {
			driver.findElement(By.name(element)).sendKeys(searchKey);
		}
		driver.findElement(By.className("searchButton")).click();
		return driver.findElement(By.tagName("table")).getText();
	}
	public static void selectAllCheckBox(WebDriver driver) throws InterruptedException {
		new WebDriverWait(driver, 40).until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"hoverable-rows\"]/div[2]/div/div[2]/div[2]/div/app-common-table-advanced/table/thead/tr/th[5]"))).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id=\"hoverable-rows\"]/div[2]/div/div[2]/div[2]/div/div[2]/button")).click();
		
	}
	public static void selectRandomCheckbox(WebDriver driver) throws InterruptedException {
		driver.findElement(By.id("selectCheckBoxDiv0")).click();
		driver.findElement(By.id("selectCheckBoxDiv2")).click();
		driver.findElement(By.id("selectCheckBoxDiv4")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id=\"hoverable-rows\"]/div[2]/div/div[2]/div[2]/div/div[2]/button")).click();
	}
	public static String getAlreadyUsedMobileNo(WebDriver driver) throws InterruptedException {
		goToSpecifiedPage(driver, "Branch Management");
		Thread.sleep(2000);
		goToSpecifiedPage(driver, "Generate Branch QR");
		Thread.sleep(2000);
		return driver.findElement(By.xpath("//*[@id=\"hoverable-rows\"]/div[2]/div/div[2]/div[2]/div/app-common-table-advanced/table/tbody/tr[2]/td[2]")).getText();
	}
	public static void writeTestResult(String actualData, String expectedData, int sheetIndex, String cellContent) throws IOException {
		if(actualData.contains(expectedData)){
			new SaveTestResultToExcelFile(sheetIndex, cellContent,"PASS");

		}
		else{
			new SaveTestResultToExcelFile(sheetIndex,cellContent,"FAIL");
		}
	}
	public static void clickOnButton(WebDriver driver, String identifier, String element) throws InterruptedException {
		if(identifier == "id"){
			driver.findElement(By.id(element)).click();
		}
		else if(identifier == "className"){
			driver.findElement(By.className(element)).click();
		}
		else if(identifier == "name"){
			driver.findElement(By.name(element)).click();
		}
		else if(identifier == "linkText") {
			driver.findElement(By.linkText(element)).click();

		}
		else if(identifier == "partialLinkText") {
			driver.findElement(By.partialLinkText(element)).click();

		}
		else if(identifier == "tagName") {
			driver.findElement(By.tagName(element)).click();

		}
		else if(identifier == "cssSelector") {
			driver.findElement(By.cssSelector(element)).click();

		}
		else if(identifier == "xpath") {
			driver.findElement(By.xpath(element)).click();

		}
		Thread.sleep(2000);

	}
	public static String getResultData(WebDriver driver, String identifier, String element) throws InterruptedException {
		String result = null;
		if(identifier == "id"){
			result = driver.findElement(By.id(element)).getText();
		}
		else if(identifier == "className"){
			result = driver.findElement(By.className(element)).getText();
		}
		else if(identifier == "name"){
			result = driver.findElement(By.name(element)).getText();
		}
		else if(identifier == "linkText") {
			result = driver.findElement(By.linkText(element)).getText();

		}
		else if(identifier == "partialLinkText") {
			result = driver.findElement(By.partialLinkText(element)).getText();

		}
		else if(identifier == "tagName") {
			result = driver.findElement(By.tagName(element)).getText();

		}
		else if(identifier == "cssSelector") {
			result = driver.findElement(By.cssSelector(element)).getText();

		}
		else if(identifier == "xpath") {
			result = driver.findElement(By.xpath(element)).getText();

		}

		return result;

	}



}
