package com.konasl.mbl.system.mblAdmin;

import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import com.konasl.mbl.system.admin.pages.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.konasl.mbl.utils.CommonMethods;
import com.konasl.mbl.utils.Constant;

/**
 * @author humayun.ashik
 *
 */

public class BranchManagementTest extends BaseTest{

	public BranchManagementTest(String url) {
		super(Constant.getUrl("admin"));
	}
	// Branch Registration
	@Test(priority = 1, enabled = true)
	public void registerBranch() throws InterruptedException, IOException {
		page.getInstance(LoginPage.class).doLogin(Constant.getUserName("admin"), Constant.getPassword());
		CommonMethods.goToSpecifiedPage(driver, BranchManagementPage.getMenuName());
		CommonMethods.goToSpecifiedPage(driver, BranchManagementPage.getSubMenu3());
		BranchManagementPage.fillUpAccountInfo(driver);
		Thread.sleep(1000);
		BranchManagementPage.fillUpRegisteredAddress(driver);
		Thread.sleep(1000);
		CommonMethods.clickOnButton(driver, "className", BranchManagementPage.getRegisterButtonElement());
		String toastMessage = CommonMethods.getToastMessage(driver);	
		Thread.sleep(1000);
		CommonMethods.closeToastMessage(driver);
		Assert.assertTrue(toastMessage.contains("successful"));
		CommonMethods.writeTestResult(toastMessage, "successful", 0, "SYS_089");
		page.getInstance(LoginPage.class).doLogout();
	}
	@Test(priority = 1, enabled = true)
	public void registerBranchWithAlreadyUsedMobileNo() throws InterruptedException, IOException {

		page.getInstance(LoginPage.class).doLogin(Constant.getUserName("admin"), Constant.getPassword());
		String mobileNo = CommonMethods.getAlreadyUsedMobileNo(driver);
		CommonMethods.goToSpecifiedPage(driver, BranchManagementPage.getMenuName());
		CommonMethods.goToSpecifiedPage(driver, BranchManagementPage.getSubMenu1());
		BranchManagementPage.fillUpAccountInfoWithUsedMobileNo(driver, mobileNo);
		Thread.sleep(1000);
		BranchManagementPage.fillUpRegisteredAddress(driver);
		Thread.sleep(1000);
		CommonMethods.clickOnButton(driver, "className", BranchManagementPage.getRegisterButtonElement());
		Thread.sleep(2000);
		String toastMessage = CommonMethods.getToastMessage(driver);	
		Thread.sleep(1000);
		CommonMethods.closeToastMessage(driver);
		Assert.assertTrue(toastMessage.contains("Error"));
		CommonMethods.writeTestResult(toastMessage, "successful", 0, "SYS_088");
		page.getInstance(LoginPage.class).doLogout();
	}
	
	// Approve branch registration 
	
	
	// Generate Branch QR
	@Test(priority = 1, enabled = true)
	public void searchWithBranchName() throws InterruptedException, IOException {

		page.getInstance(LoginPage.class).doLogin(Constant.getUserName("admin"), Constant.getPassword());
		CommonMethods.goToSpecifiedPage(driver, BranchManagementPage.getMenuName());
		CommonMethods.goToSpecifiedPage(driver, BranchManagementPage.getSubMenu1());
		String data = CommonMethods.generalSearch(driver, BranchManagementPage.getBranchNameToSearch(), "id", "name");
		System.out.println("Result of search data with branch name: \n"+data);
		Assert.assertTrue(data.contains(BranchManagementPage.getBranchNameToSearch()), "Searched branch name is not found");
		CommonMethods.writeTestResult(data, BranchManagementPage.getBranchNameToSearch(), 0, "SYS_083");
		page.getInstance(LoginPage.class).doLogout();
	}
	
	@Test(priority = 1, enabled = true)
	public void searchWithMobileNum() throws InterruptedException, IOException {
		page.getInstance(LoginPage.class).doLogin(Constant.getUserName("admin"), Constant.getPassword());
		CommonMethods.goToSpecifiedPage(driver, BranchManagementPage.getMenuName());
		CommonMethods.goToSpecifiedPage(driver, BranchManagementPage.getSubMenu1());
		String data = CommonMethods.generalSearch(driver, BranchManagementPage.getBranchMobileNoToSearch(),"name", "accountNoModel");
		System.out.println("Result of saerch data with mobile number: \n"+data);
		Assert.assertTrue(data.contains(BranchManagementPage.getBranchMobileNoToSearch()), "Searched branch mobile no is not found");
		CommonMethods.writeTestResult(data, BranchManagementPage.getBranchMobileNoToSearch(), 0, "SYS_084");
		page.getInstance(LoginPage.class).doLogout();
	}
	
	@Test(priority = 1, enabled = true)
	public void generateBranchQrAllItems() throws InterruptedException, IOException {
		page.getInstance(LoginPage.class).doLogin(Constant.getUserName("admin"), Constant.getPassword());
		CommonMethods.goToSpecifiedPage(driver, BranchManagementPage.getMenuName());
		CommonMethods.goToSpecifiedPage(driver, BranchManagementPage.getSubMenu1());
		CommonMethods.selectAllCheckBox(driver);
		Thread.sleep(10000);
		CommonMethods.writeTestResult(CommonMethods.verifyDownloadWithFileName("BRANCH-QR.pdf").toString(), "true", 0, "SYS_081");
		page.getInstance(LoginPage.class).doLogout();
	}
	@Test(priority = 1, enabled = true)
	public void generateBranchQrSelectedItems() throws InterruptedException, IOException {
		page.getInstance(LoginPage.class).doLogin(Constant.getUserName("admin"), Constant.getPassword());
		CommonMethods.goToSpecifiedPage(driver, BranchManagementPage.getMenuName());
		CommonMethods.goToSpecifiedPage(driver, BranchManagementPage.getSubMenu1());
		CommonMethods.selectRandomCheckbox(driver);
		CommonMethods.clickOnButton(driver, "xpath", "");
		Thread.sleep(10000);
		CommonMethods.writeTestResult(CommonMethods.verifyDownloadWithFileName("BRANCH-QR.pdf").toString(), "true", 0, "SYS_082");
		page.getInstance(LoginPage.class).doLogout();
	}
	
	// Branch Registration --> Search Branch
	
	@Test(priority = 1, enabled = true)
	public void searchWithBranchNameFromSearchBranchPage() throws InterruptedException, IOException {
		page.getInstance(LoginPage.class).doLogin(Constant.getUserName("admin"), Constant.getPassword());
		CommonMethods.goToSpecifiedPage(driver, BranchManagementPage.getMenuName());
		CommonMethods.goToSpecifiedPage(driver, BranchManagementPage.getSubMenu2());
		String data = CommonMethods.generalSearch(driver, BranchManagementPage.getBranchNameToSearch(), "id", "accountName");
		System.out.println("Result of search data with branch name: \n"+data);
		Assert.assertTrue(data.contains(BranchManagementPage.getBranchNameToSearch()), "Searched branch name is not found");
		CommonMethods.writeTestResult(data, BranchManagementPage.getBranchNameToSearch(), 0, "SYS_083");
		page.getInstance(LoginPage.class).doLogout();
	}
	
	@Test(priority = 1, enabled = true)
	public void searchWithMobileNumFromSearchBranchPage() throws InterruptedException, IOException {
		page.getInstance(LoginPage.class).doLogin(Constant.getUserName("admin"), Constant.getPassword());
		CommonMethods.goToSpecifiedPage(driver, BranchManagementPage.getMenuName());
		CommonMethods.goToSpecifiedPage(driver, BranchManagementPage.getSubMenu2());
		String data = CommonMethods.generalSearch(driver, BranchManagementPage.getBranchMobileNoToSearch(),"name", "accountNo");
		System.out.println("Result of search data with mobile number: \n"+data);
		Assert.assertTrue(data.contains(BranchManagementPage.getBranchMobileNoToSearch()), "Searched branch mobile no is not found");
		CommonMethods.writeTestResult(data, BranchManagementPage.getBranchMobileNoToSearch(), 0, "SYS_084");
		page.getInstance(LoginPage.class).doLogout();
	}
	@Test(priority = 1, enabled = true)
	public void viewDetailsOfBranch() throws InterruptedException, IOException {
		page.getInstance(LoginPage.class).doLogin(Constant.getUserName("admin"), Constant.getPassword());
		CommonMethods.goToSpecifiedPage(driver, BranchManagementPage.getMenuName());
		CommonMethods.goToSpecifiedPage(driver, BranchManagementPage.getSubMenu2());
		CommonMethods.generalSearch(driver, BranchManagementPage.getBranchMobileNoToSearch(),"name", "accountNo");
		CommonMethods.clickOnButton(driver, "classname",BranchManagementPage.getDetailsButtonElement());
		String branchDetails = CommonMethods.getResultData(driver, "name", "myForm");
		Assert.assertTrue(branchDetails.contains(BranchManagementPage.getBranchMobileNoToSearch()), "Details is not Ok");
		CommonMethods.writeTestResult(branchDetails, BranchManagementPage.getBranchMobileNoToSearch(), 0, "SYS_085");
		page.getInstance(LoginPage.class).doLogout();
	}

	@Test(priority = 1, enabled = true)
	public void viewDetailsOfTransactionTabDefault() throws InterruptedException, IOException {
		page.getInstance(LoginPage.class).doLogin(Constant.getUserName("admin"), Constant.getPassword());
		CommonMethods.goToSpecifiedPage(driver, BranchManagementPage.getMenuName());
		CommonMethods.goToSpecifiedPage(driver, BranchManagementPage.getSubMenu2());
		CommonMethods.generalSearch(driver, BranchManagementPage.getBranchMobileNoToSearch(),"name", "accountNo");
		CommonMethods.clickOnButton(driver, "classname",BranchManagementPage.getDetailsButtonElement());
		CommonMethods.clickOnButton(driver, "id", "transactionTab");
		String trxTabDetails = CommonMethods.getResultData(driver, "className", "card-body");
		System.out.println(trxTabDetails);
		Assert.assertTrue(trxTabDetails.contains("৳"), "Details is not Ok");
		CommonMethods.writeTestResult(trxTabDetails, "৳", 0, "SYS_086");
		page.getInstance(LoginPage.class).doLogout();
	}
	
	@Test(priority = 1, enabled = true)
	public void viewDetailsOfApproval() throws InterruptedException, IOException {
		page.getInstance(LoginPage.class).doLogin(Constant.getUserName("admin"), Constant.getPassword());
		CommonMethods.goToSpecifiedPage(driver, BranchManagementPage.getMenuName());
		CommonMethods.goToSpecifiedPage(driver, BranchManagementPage.getSubMenu2());
		CommonMethods.generalSearch(driver, BranchManagementPage.getBranchMobileNoToSearch(),"name", "accountNo");
		CommonMethods.clickOnButton(driver, "classname",BranchManagementPage.getDetailsButtonElement());
		CommonMethods.clickOnButton(driver, "id", "approvalTab");
		Thread.sleep(1000);
		String approvalTabDetails = CommonMethods.getResultData(driver, "className", "card-body");
		System.out.println(approvalTabDetails);
		Assert.assertTrue(approvalTabDetails.contains("MBL-ADMIN"), "Details is not Ok");
		CommonMethods.writeTestResult(approvalTabDetails, "MBL-ADMIN", 0, "SYS_087");
		page.getInstance(LoginPage.class).doLogout();
	}

	

}
