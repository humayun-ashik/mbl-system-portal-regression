package com.konasl.mbl.system.mblAdmin;


import java.io.IOException;
import java.util.concurrent.TimeUnit;

import com.konasl.mbl.system.admin.pages.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.konasl.mbl.utils.CommonMethods;
import com.konasl.mbl.utils.Constant;


/**
 * @author humayun.ashik
 *
 */

public class LocationManagementTest extends BaseTest{
	
	public LocationManagementTest() {

		super(Constant.getUrl("admin"));
	}
	
	@Test(priority = 1, enabled = true)
	public void atmLocationImportXcelFileSizeWithinLimit() throws InterruptedException, IOException {
		page.getInstance(LoginPage.class).doLogin(Constant.getUserName("admin"), Constant.getPassword());
		CommonMethods.goToSpecifiedPage(driver, LocationManagementPage.getMenuName());
		CommonMethods.goToSpecifiedPage(driver, LocationManagementPage.getSubMenu1());
		LocationManagementPage.uploadFile(driver, LocationManagementPage.getUploadFilePath("validAtmLocation"));
		String toastMessage = CommonMethods.getToastMessage(driver);
		CommonMethods.closeToastMessage(driver);
		Assert.assertTrue(toastMessage.contains("Success"));
		CommonMethods.writeTestResult(toastMessage, "Success", 0, "SYS_071");
		page.getInstance(LoginPage.class).doLogout();
	}
	
	@Test(priority = 1, enabled = true)
	public void atmLocationImportOtherTypeFile() throws InterruptedException, IOException {
		page.getInstance(LoginPage.class).doLogin(Constant.getUserName("admin"), Constant.getPassword());
		CommonMethods.goToSpecifiedPage(driver, LocationManagementPage.getMenuName());
		CommonMethods.goToSpecifiedPage(driver, LocationManagementPage.getSubMenu1());
		LocationManagementPage.uploadFile(driver, LocationManagementPage.getUploadFilePath("invalidtype"));
		String toastMessage = CommonMethods.getToastMessage(driver);	
		Thread.sleep(1000);
		CommonMethods.closeToastMessage(driver);
		Assert.assertTrue(toastMessage.contains("Error"));
		CommonMethods.writeTestResult(toastMessage, "Error", 0, "SYS_072");
		page.getInstance(LoginPage.class).doLogout();
	}
	
	@Test(priority = 1, enabled = true)
	public void atmLocationImportBeyondSizeLimit() throws InterruptedException, IOException {
		page.getInstance(LoginPage.class).doLogin(Constant.getUserName("admin"), Constant.getPassword());
		CommonMethods.goToSpecifiedPage(driver, LocationManagementPage.getMenuName());
		CommonMethods.goToSpecifiedPage(driver, LocationManagementPage.getSubMenu1());
		LocationManagementPage.uploadFile(driver, LocationManagementPage.getUploadFilePath("beyondsizelimit"));
		String toastMessage = CommonMethods.getToastMessage(driver);	
		Thread.sleep(1000);
		CommonMethods.closeToastMessage(driver);
		Assert.assertTrue(toastMessage.contains("Warning"));
		CommonMethods.writeTestResult(toastMessage, "Error", 0, "SYS_073");
		page.getInstance(LoginPage.class).doLogout();
	}
	
	
	// Location Management --> Branch Location Import
	
	@Test(priority = 1, enabled = true)
	public void branchLocationImportXcelFileSizeWithinLimit() throws InterruptedException, IOException {
		page.getInstance(LoginPage.class).doLogin(Constant.getUserName("admin"), Constant.getPassword());
		CommonMethods.goToSpecifiedPage(driver, LocationManagementPage.getMenuName());
		CommonMethods.goToSpecifiedPage(driver, LocationManagementPage.getSubMenu2());
		LocationManagementPage.uploadFile(driver, LocationManagementPage.getUploadFilePath("validBranchLocation"));
		String toastMessage = CommonMethods.getToastMessage(driver);
		CommonMethods.closeToastMessage(driver);
		Assert.assertTrue(toastMessage.contains("Success"));
		CommonMethods.writeTestResult(toastMessage, "Success", 0, "SYS_074");
		page.getInstance(LoginPage.class).doLogout();
	}
	
	@Test(priority = 1, enabled = true)
	public void branchLocationImportOtherTypeFile() throws InterruptedException, IOException {
		page.getInstance(LoginPage.class).doLogin(Constant.getUserName("admin"), Constant.getPassword());
		CommonMethods.goToSpecifiedPage(driver, LocationManagementPage.getMenuName());
		CommonMethods.goToSpecifiedPage(driver, LocationManagementPage.getSubMenu2());
		LocationManagementPage.uploadFile(driver,LocationManagementPage.getUploadFilePath("invalidtype"));
		String toastMessage = CommonMethods.getToastMessage(driver);	
		Thread.sleep(1000);
		CommonMethods.closeToastMessage(driver);
		Assert.assertTrue(toastMessage.contains("Error"));
		CommonMethods.writeTestResult(toastMessage, "Error", 0, "SYS_075");
		page.getInstance(LoginPage.class).doLogout();
	}
	
	@Test(priority = 1, enabled = true)
	public void branchLocationImportBeyondSizeLimit() throws InterruptedException, IOException {
		page.getInstance(LoginPage.class).doLogin(Constant.getUserName("admin"), Constant.getPassword());
		CommonMethods.goToSpecifiedPage(driver, LocationManagementPage.getMenuName());
		CommonMethods.goToSpecifiedPage(driver, LocationManagementPage.getSubMenu2());
		LocationManagementPage.uploadFile(driver,LocationManagementPage.getUploadFilePath("beyondsizelimit"));
		String toastMessage = CommonMethods.getToastMessage(driver);	
		Thread.sleep(1000);
		CommonMethods.closeToastMessage(driver);
		Assert.assertTrue(toastMessage.contains("Warning"));
		CommonMethods.writeTestResult(toastMessage, "Warning", 0, "SYS_076");
		page.getInstance(LoginPage.class).doLogout();
	}
	
	// Location Management --> Location Download
	
	@Test(priority = 1, enabled = true)
	public void branchLocationDownload() throws InterruptedException, IOException {
		page.getInstance(LoginPage.class).doLogin(Constant.getUserName("admin"), Constant.getPassword());
		CommonMethods.goToSpecifiedPage(driver, LocationManagementPage.getMenuName());
		CommonMethods.goToSpecifiedPage(driver, LocationManagementPage.getSubMenu3());
		CommonMethods.selectDropdownItemsByVisibleText(driver, "id", LocationManagementPage.getDropdownSelectionElement(), "Branch Location");
		CommonMethods.clickOnButton(driver, "className", LocationManagementPage.getDownloadButtonElement());
		CommonMethods.writeTestResult(CommonMethods.verifyDownloadWithFileName("Branch-Location.xlsx").toString(), "true", 0, "SYS_077");
		page.getInstance(LoginPage.class).doLogout();
	}
	
	@Test(priority = 1, enabled = true)
	public void atmLocationDownload() throws InterruptedException, IOException {
		page.getInstance(LoginPage.class).doLogin(Constant.getUserName("admin"), Constant.getPassword());
		CommonMethods.goToSpecifiedPage(driver, LocationManagementPage.getMenuName());
		CommonMethods.goToSpecifiedPage(driver, LocationManagementPage.getSubMenu3());
		CommonMethods.selectDropdownItemsByVisibleText(driver, "id", LocationManagementPage.getDropdownSelectionElement(), "ATM Location");
		CommonMethods.clickOnButton(driver, "className", LocationManagementPage.getDownloadButtonElement());
		CommonMethods.writeTestResult(CommonMethods.verifyDownloadWithFileName("ATM-Location.xlsx").toString(), "true", 0, "SYS_078");
		page.getInstance(LoginPage.class).doLogout();
	}
}
