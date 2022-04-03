package com.konasl.mbl.system.mblAdmin;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.konasl.mbl.system.admin.pages.DashboardPage;
import com.konasl.mbl.system.admin.pages.HomePage;
import com.konasl.mbl.system.admin.pages.LoginPage;
import com.konasl.mbl.utils.CommonMethods;
import com.konasl.mbl.utils.Constant;


/**
 * @author humayun.ashik
 *
 */


public class AdminDashboard extends BaseTest{
	Boolean countSuccessStatus;

	public AdminDashboard(String url) {
		super(Constant.getUrl("admin"));
	}
	
	@Test(priority = 1, enabled = true)
	public void registrationCountCheck() throws IOException {
		page.getInstance(LoginPage.class).doLogin(Constant.getUserName("admin"), Constant.getPassword());
		WebElement regCount = driver.findElement(By.className(DashboardPage.getRegCountElement()));
		int regSuccess = Integer.parseInt(regCount.getText());
		System.out.println("no of registration today: "+regSuccess);
		countSuccessStatus = CommonMethods.isCountValid(regSuccess);
		Assert.assertTrue(countSuccessStatus);
		CommonMethods.writeTestResult(countSuccessStatus.toString(), "true", 0, "SYS_059");
		page.getInstance(LoginPage.class).doLogout();
				
	}

	@Test(priority = 1, enabled = true)
	public void activeUserCountCheck() throws IOException, InterruptedException {
		page.getInstance(LoginPage.class).doLogin(Constant.getUserName("admin"), Constant.getPassword());
		WebElement activeUserCount = driver.findElement(By.xpath(DashboardPage.getActiveUserCountElement()));
		int activeUserSuccess = Integer.parseInt(activeUserCount.getText());
		System.out.println("no of active user today: "+ activeUserSuccess);
		countSuccessStatus = CommonMethods.isCountValid(activeUserSuccess);
		Assert.assertTrue(countSuccessStatus);
		CommonMethods.writeTestResult(countSuccessStatus.toString(), "true", 0, "SYS_060");
		page.getInstance(LoginPage.class).doLogout();
		
		
	}

	@Test(priority = 1, enabled = true)
	public void BillPayStatisticsCheck() throws IOException {
		page.getInstance(LoginPage.class).doLogin(Constant.getUserName("admin"), Constant.getPassword());
		System.out.println("Bill Pay Statistics\n===================================================\n");
		Boolean countNoOfTrxStatus = CommonMethods.getNoOfTrxStatus(DashboardPage.getBillPayCountElement(), driver);		
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS); 		
		Boolean amountValueStatus = CommonMethods.getTotalTrxAmountStatus(DashboardPage.getBillPayAmountElement(), driver);
		Boolean combinedStatus = countNoOfTrxStatus&amountValueStatus;
		Assert.assertTrue(combinedStatus);
		CommonMethods.writeTestResult((combinedStatus).toString(), "true", 0, "SYS_061");
		page.getInstance(LoginPage.class).doLogout();
	}
	
	
	@Test(priority = 1, enabled = true)
	public void FundTransferW2WStatisticsCheck() throws IOException {
		page.getInstance(LoginPage.class).doLogin(Constant.getUserName("admin"), Constant.getPassword());
		System.out.println("Fund Transfer (W2W)  Statistics\n ===================================================\n");
		Boolean countNoOfTrxStatus = CommonMethods.getNoOfTrxStatus(DashboardPage.getW2WCountElement(), driver);		
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS); 		
		Boolean amountValueStatus = CommonMethods.getTotalTrxAmountStatus(DashboardPage.getW2WAmountElement(), driver);
		Boolean combinedStatus = countNoOfTrxStatus & amountValueStatus;
		Assert.assertTrue(combinedStatus);
		CommonMethods.writeTestResult(combinedStatus.toString(), "true", 0, "SYS_062");
		page.getInstance(LoginPage.class).doLogout();
		
		
	}
	
//checked
	
	@Test(priority = 1, enabled = true)
	public void FundTransferA2AStatisticsCheck() throws IOException {
		page.getInstance(LoginPage.class).doLogin(Constant.getUserName("admin"), Constant.getPassword());
		System.out.println("Fund Transfer (A2A)  Statistics\n ===================================================\n");
		Boolean countNoOfTrxStatus = CommonMethods.getNoOfTrxStatus(DashboardPage.getA2ACountElement(), driver);		
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS); 		
		Boolean amountValueStatus = CommonMethods.getTotalTrxAmountStatus(DashboardPage.getA2AAmountElement(), driver);
		Boolean combinedStatus = countNoOfTrxStatus & amountValueStatus;
		Assert.assertTrue(combinedStatus);
		CommonMethods.writeTestResult(combinedStatus.toString(), "true", 0, "SYS_063");
		page.getInstance(LoginPage.class).doLogout();
		
		
	}

	@Test(priority = 1, enabled = true)
	public void FundTransferA2WStatisticsCheck() throws IOException {
		page.getInstance(LoginPage.class).doLogin(Constant.getUserName("admin"), Constant.getPassword());
		System.out.println("Fund Transfer(A2W) Statistics\n ===================================================\n");
		Boolean countNoOfTrxStatus = CommonMethods.getNoOfTrxStatus(DashboardPage.getA2WCountElement(), driver);
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		Boolean amountValueStatus = CommonMethods.getTotalTrxAmountStatus(DashboardPage.getA2WAmountElement(), driver);
		Boolean combinedStatus = countNoOfTrxStatus & amountValueStatus;
		Assert.assertTrue(combinedStatus);
		CommonMethods.writeTestResult(combinedStatus.toString(), "true", 0, "SYS_064");
		page.getInstance(LoginPage.class).doLogout();


	}

	@Test(priority = 1, enabled = true)
	public void FundTransferW2AStatisticsCheck() throws IOException {
		page.getInstance(LoginPage.class).doLogin(Constant.getUserName("admin"), Constant.getPassword());
		System.out.println("Fund Transfer(W2A) Statistics\n ===================================================\n");
		Boolean countNoOfTrxStatus = CommonMethods.getNoOfTrxStatus(DashboardPage.getW2ACountElement(), driver);
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		Boolean amountValueStatus = CommonMethods.getTotalTrxAmountStatus(DashboardPage.getW2AAmountElement(), driver);
		Boolean combinedStatus = countNoOfTrxStatus & amountValueStatus;
		Assert.assertTrue(combinedStatus);
		CommonMethods.writeTestResult(combinedStatus.toString(), "true", 0, "SYS_065");
		page.getInstance(LoginPage.class).doLogout();


	}
	
	@Test(priority = 1, enabled = true)
	public void MerchantPaytatisticsCheck() throws IOException {
		page.getInstance(LoginPage.class).doLogin(Constant.getUserName("admin"), Constant.getPassword());
		System.out.println("Merchant Pay Statistics\n ===================================================\n");
		Boolean countNoOfTrxStatus = CommonMethods.getNoOfTrxStatus(DashboardPage.getMerchantPayCountElement(), driver);		
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS); 		
		Boolean amountValueStatus = CommonMethods.getTotalTrxAmountStatus(DashboardPage.getMerchantPayAmountElement(), driver);
		Boolean combinedStatus = countNoOfTrxStatus & amountValueStatus;
		Assert.assertTrue(combinedStatus);
		CommonMethods.writeTestResult(combinedStatus.toString(), "true", 0, "SYS_066");
		page.getInstance(LoginPage.class).doLogout();
		
		
	}
	
	
	@Test(priority = 1, enabled = true)
	public void BEFTNStatisticsCheck() throws IOException {
		page.getInstance(LoginPage.class).doLogin(Constant.getUserName("admin"), Constant.getPassword());
		System.out.println("BEFTN Statistics\n ===================================================\n");
		Boolean countNoOfTrxStatus = CommonMethods.getNoOfTrxStatus(DashboardPage.getBEFTNCountElement(), driver);		
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS); 		
		Boolean amountValueStatus = CommonMethods.getTotalTrxAmountStatus(DashboardPage.getBEFTNAmountElement(), driver);
		Boolean combinedStatus = countNoOfTrxStatus & amountValueStatus;
		Assert.assertTrue(combinedStatus);
		CommonMethods.writeTestResult(combinedStatus.toString(), "true", 0, "SYS_067");
		page.getInstance(LoginPage.class).doLogout();
		
		
	}
	
	
	@Test(priority = 1, enabled = true)
	public void MobileRechargeStatisticsCheck() throws IOException {
		page.getInstance(LoginPage.class).doLogin(Constant.getUserName("admin"), Constant.getPassword());
		System.out.println("Mobile Recharge Statistics\n ===================================================\n");
		Boolean countNoOfTrxStatus = CommonMethods.getNoOfTrxStatus(DashboardPage.getMobileRechargeCountElement(), driver);		
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS); 		
		Boolean amountValueStatus = CommonMethods.getTotalTrxAmountStatus(DashboardPage.getMobileRechargeAmountElement(), driver);
		Boolean combinedStatus = countNoOfTrxStatus & amountValueStatus;
		Assert.assertTrue(combinedStatus);
		CommonMethods.writeTestResult(combinedStatus.toString(), "true", 0, "SYS_068");
		page.getInstance(LoginPage.class).doLogout();
		
		
	}

	
	@Test(priority = 1, enabled = true)
	public void CreditCardBillPayStatisticsCheck() throws IOException {
		page.getInstance(LoginPage.class).doLogin(Constant.getUserName("admin"), Constant.getPassword());
		System.out.println("Credit Card Bill Pay Statistics\n ===================================================\n");
		Boolean countNoOfTrxStatus = CommonMethods.getNoOfTrxStatus(DashboardPage.getCreditCardBillPayCountElement(), driver);		
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS); 		
		Boolean amountValueStatus = CommonMethods.getTotalTrxAmountStatus(DashboardPage.getCreditCardBillPayAmountElement(), driver);
		Boolean combinedStatus = countNoOfTrxStatus & amountValueStatus;
		Assert.assertTrue(combinedStatus);
		CommonMethods.writeTestResult(combinedStatus.toString(), "true", 0, "SYS_069");
		page.getInstance(LoginPage.class).doLogout();
	}

	@Test(priority = 1, enabled = true)
	public void BranchQrWithdrawalStatisticsCheck() throws IOException {
		page.getInstance(LoginPage.class).doLogin(Constant.getUserName("admin"), Constant.getPassword());
		System.out.println("Branch QR Withdrawal Statistics\n ===================================================\n");
		Boolean countNoOfTrxStatus = CommonMethods.getNoOfTrxStatus(DashboardPage.getBranchQrWithdrawalCountElement(), driver);
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		Boolean amountValueStatus = CommonMethods.getTotalTrxAmountStatus(DashboardPage.getBranchQrWithdrawalAmountElement(), driver);
		Boolean combinedStatus = countNoOfTrxStatus & amountValueStatus;
		Assert.assertTrue(combinedStatus);
		CommonMethods.writeTestResult(combinedStatus.toString(), "true", 0, "SYS_069_1");
		page.getInstance(LoginPage.class).doLogout();
	}
	@Test(priority = 1, enabled = true)
	public void EcomMerchantPayStatisticsCheck() throws IOException {
		page.getInstance(LoginPage.class).doLogin(Constant.getUserName("admin"), Constant.getPassword());
		System.out.println("Ecom Merchant Pay Statistics\n ===================================================\n");
		Boolean countNoOfTrxStatus = CommonMethods.getNoOfTrxStatus(DashboardPage.getEcomPayCountElement(), driver);
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		Boolean amountValueStatus = CommonMethods.getTotalTrxAmountStatus(DashboardPage.getEcomPaylAmountElement(), driver);
		Boolean combinedStatus = countNoOfTrxStatus & amountValueStatus;
		Assert.assertTrue(combinedStatus);
		CommonMethods.writeTestResult(combinedStatus.toString(), "true", 0, "SYS_069_2");
		page.getInstance(LoginPage.class).doLogout();
	}

	


}
