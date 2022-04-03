package com.konasl.mbl.system.mblAdmin;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import com.konasl.mbl.system.admin.pages.*;
import com.konasl.mbl.utils.DatePicker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.konasl.mbl.utils.CommonMethods;
import com.konasl.mbl.utils.Constant;

public class MerchantManagementTest extends BaseTest{
    private static String data;

    public MerchantManagementTest(String url) {
        super(Constant.getUrl("admin"));
    }

    // Merchant Management --> Generate QR
    @Test(priority = 1, enabled = false)
    public void searchMerchantWithName() throws InterruptedException, IOException {
        page.getInstance(LoginPage.class).doLogin(Constant.getUserName("admin"), Constant.getPassword());
        CommonMethods.goToSpecifiedPage(driver, MerchantManagementPage.getMenuName());
        CommonMethods.goToSpecifiedPage(driver, MerchantManagementPage.getSubMenu1());
        data = CommonMethods.generalSearch(driver, MerchantManagementPage.getMerchantName("ecommerce"), "id", MerchantManagementPage.getNameFieldElement());
        System.out.println("Result of search data with merchant name: \n"+data);
        Assert.assertTrue(data.contains(MerchantManagementPage.getMerchantName("ecommerce")), "Searched merchant name is not found");
        CommonMethods.writeTestResult(data, MerchantManagementPage.getMerchantName("ecommerce"), 0, "SYS_142");
        page.getInstance(LoginPage.class).doLogout();

    }
    @Test(priority = 1, enabled = false)
    public void searchMerchantWithMobileNo() throws InterruptedException, IOException {
        page.getInstance(LoginPage.class).doLogin(Constant.getUserName("admin"), Constant.getPassword());
        CommonMethods.goToSpecifiedPage(driver, MerchantManagementPage.getMenuName());
        CommonMethods.goToSpecifiedPage(driver, MerchantManagementPage.getSubMenu1());
        data = CommonMethods.generalSearch(driver, MerchantManagementPage.getMerchantMobileNo(""), "name", MerchantManagementPage.getMerchantMobileNoElement());
        System.out.println("Result of search data with merchant mobile no: \n"+data);
        Assert.assertTrue(data.contains(MerchantManagementPage.getMerchantMobileNo("")), "Searched merchant mobile no is not found");
        CommonMethods.writeTestResult(data, MerchantManagementPage.getMerchantMobileNo(""), 0, "SYS_143");
        page.getInstance(LoginPage.class).doLogout();

    }
    @Test(priority = 1, enabled = false)
    public void searchMerchantWithMerchantCode() throws InterruptedException, IOException {
        page.getInstance(LoginPage.class).doLogin(Constant.getUserName("admin"), Constant.getPassword());
        CommonMethods.goToSpecifiedPage(driver, MerchantManagementPage.getMenuName());
        CommonMethods.goToSpecifiedPage(driver, MerchantManagementPage.getSubMenu1());
        data = CommonMethods.generalSearch(driver, MerchantManagementPage.getMerchantCode(""), "xpath", MerchantManagementPage.getMerchantCodeElement(""));
        System.out.println("Result of search data with merchant code - " + MerchantManagementPage.getMerchantCode("")+": \n"+data);
        Assert.assertTrue(data.contains(MerchantManagementPage.getMerchantCode("")), "Searched merchant mobile no is not found");
        CommonMethods.writeTestResult(data, MerchantManagementPage.getMerchantCode(""), 0, "SYS_144");
        page.getInstance(LoginPage.class).doLogout();

    }

    @Test(priority = 1, enabled = false)
    public void generateBranchQrAllItems() throws InterruptedException, IOException {
        page.getInstance(LoginPage.class).doLogin(Constant.getUserName("admin"), Constant.getPassword());
        CommonMethods.goToSpecifiedPage(driver, MerchantManagementPage.getMenuName());
        CommonMethods.goToSpecifiedPage(driver, MerchantManagementPage.getSubMenu1());
        MerchantManagementPage.selectAllCheckBox(driver);
        CommonMethods.clickOnButton(driver, "xpath", MerchantManagementPage.getGenerateQrButtonXpath());
        Thread.sleep(10000);
        CommonMethods.writeTestResult(CommonMethods.verifyDownloadWithFileName("MERCHANT-QR.pdf").toString(), "true", 0, "SYS_145");
        page.getInstance(LoginPage.class).doLogout();
    }

    @Test(priority = 1, enabled = false)
    public void generateSingleMerchantQR() throws InterruptedException, IOException {
        page.getInstance(LoginPage.class).doLogin(Constant.getUserName("admin"), Constant.getPassword());
        CommonMethods.goToSpecifiedPage(driver, MerchantManagementPage.getMenuName());
        CommonMethods.goToSpecifiedPage(driver, MerchantManagementPage.getSubMenu1());
        CommonMethods.generalSearch(driver, MerchantManagementPage.getMerchantMobileNo(""), "name", MerchantManagementPage.getMerchantMobileNoElement());
        Thread.sleep(1000);
        MerchantManagementPage.selectAllCheckBox(driver);
        CommonMethods.clickOnButton(driver, "xpath", MerchantManagementPage.getGenerateQrButtonXpath());
        Thread.sleep(10000);
        CommonMethods.writeTestResult(CommonMethods.verifyDownloadWithFileName("MERCHANT-QR.pdf").toString(), "true", 0, "SYS_146");
        page.getInstance(LoginPage.class).doLogout();
    }

    @Test(priority = 1, enabled = false)
    public void generateSelectedMerchantQR() throws InterruptedException, IOException {
        page.getInstance(LoginPage.class).doLogin(Constant.getUserName("admin"), Constant.getPassword());
        CommonMethods.goToSpecifiedPage(driver, MerchantManagementPage.getMenuName());
        CommonMethods.goToSpecifiedPage(driver, MerchantManagementPage.getSubMenu1());

        MerchantManagementPage.selectMultipleCheckBox(driver);
        CommonMethods.clickOnButton(driver, "xpath", MerchantManagementPage.getGenerateQrButtonXpath());
        Thread.sleep(10000);
        CommonMethods.writeTestResult(CommonMethods.verifyDownloadWithFileName("MERCHANT-QR.pdf").toString(), "true", 0, "SYS_147");
        page.getInstance(LoginPage.class).doLogout();
    }

    //Merchant Management --> search Biller Merchant
    @Test(priority = 1, enabled = false)
    public void searchBillerMerchantWithName() throws InterruptedException, IOException {
        page.getInstance(LoginPage.class).doLogin(Constant.getUserName("admin"), Constant.getPassword());
        CommonMethods.goToSpecifiedPage(driver, MerchantManagementPage.getMenuName());
        CommonMethods.goToSpecifiedPage(driver, MerchantManagementPage.getSubMenu2());

        data = CommonMethods.generalSearch(driver, MerchantManagementPage.getMerchantName("biller"), "id", MerchantManagementPage.getBillerMerchantNameField());
        System.out.println("Result of search data with merchant name: \n"+data);
        Assert.assertTrue(data.contains(MerchantManagementPage.getMerchantName("biller")), "Searched merchant name is not found");
        CommonMethods.writeTestResult(data, MerchantManagementPage.getMerchantName("biller"), 0, "SYS_148");
        page.getInstance(LoginPage.class).doLogout();
    }
    @Test(priority = 1, enabled = false)
    public void searchBillerMerchantWithMobileNo() throws InterruptedException, IOException {
        page.getInstance(LoginPage.class).doLogin(Constant.getUserName("admin"), Constant.getPassword());
        CommonMethods.goToSpecifiedPage(driver, MerchantManagementPage.getMenuName());
        CommonMethods.goToSpecifiedPage(driver, MerchantManagementPage.getSubMenu2());
        data = CommonMethods.generalSearch(driver, MerchantManagementPage.getMerchantMobileNo("biller"), "name", MerchantManagementPage.getBillerMerchantMobilenoElement());
        System.out.println("Result of search data with merchant mobile no: \n"+data);
        Assert.assertTrue(data.contains(MerchantManagementPage.getMerchantMobileNo("biller")), "Searched merchant mobile no is not found");
        CommonMethods.writeTestResult(data, MerchantManagementPage.getMerchantMobileNo("biller"), 0, "SYS_149");
        page.getInstance(LoginPage.class).doLogout();

    }
    @Test(priority = 1, enabled = false)
    public void searchBillerMerchantWithCode() throws InterruptedException, IOException {
        page.getInstance(LoginPage.class).doLogin(Constant.getUserName("admin"), Constant.getPassword());
        CommonMethods.goToSpecifiedPage(driver, MerchantManagementPage.getMenuName());
        CommonMethods.goToSpecifiedPage(driver, MerchantManagementPage.getSubMenu2());
        data = CommonMethods.generalSearch(driver, MerchantManagementPage.getMerchantCode("biller"), "name", MerchantManagementPage.getbillerMerchantCodeElement());
        System.out.println("Result of search data with merchant mobile no: \n"+data);
        Assert.assertTrue(data.contains(MerchantManagementPage.getMerchantCode("biller")), "Searched merchant mobile no is not found");
        CommonMethods.writeTestResult(data, MerchantManagementPage.getMerchantCode("biller"), 0, "SYS_150");
        page.getInstance(LoginPage.class).doLogout();

    }
    @Test(priority = 1, enabled = false)
    public void viewDetailsOfBillerMerchant() throws InterruptedException, IOException {
        page.getInstance(LoginPage.class).doLogin(Constant.getUserName("admin"), Constant.getPassword());
        CommonMethods.goToSpecifiedPage(driver, MerchantManagementPage.getMenuName());
        CommonMethods.goToSpecifiedPage(driver, MerchantManagementPage.getSubMenu2());
        CommonMethods.generalSearch(driver, MerchantManagementPage.getMerchantCode("biller"), "name", MerchantManagementPage.getbillerMerchantCodeElement());
        CommonMethods.clickOnButton(driver, "className", MerchantManagementPage.getDetailsButtonElement());
        String billerMerchantDetails = CommonMethods.getResultData(driver, "className", "content-wrapper");
        Assert.assertTrue(billerMerchantDetails.contains(MerchantManagementPage.getMerchantCode("biller")), "Details is not Ok");
        CommonMethods.writeTestResult(billerMerchantDetails, MerchantManagementPage.getMerchantCode("biller"), 0, "SYS_151");
        page.getInstance(LoginPage.class).doLogout();

    }
    // Merchant management --> Biller Merchant Registration

    @Test(priority = 1, enabled = false)
    public void registerBillerMerchant() throws InterruptedException, IOException {

        page.getInstance(LoginPage.class).doLogin(Constant.getUserName("admin"), Constant.getPassword());
        CommonMethods.goToSpecifiedPage(driver, MerchantManagementPage.getMenuName());
        CommonMethods.goToSpecifiedPage(driver, MerchantManagementPage.getSubMenu3());
        MerchantManagementPage.fillUpMerchantRegistrationInfo(driver, "biller");
        String toastMessage = CommonMethods.getToastMessage(driver);
        CommonMethods.closeToastMessage(driver);
        Assert.assertTrue(toastMessage.contains("Success"));
        CommonMethods.writeTestResult(toastMessage, "Success", 0, "SYS_152");
        page.getInstance(LoginPage.class).doLogout();

    }

    //Approve biller merchant reg request
    @Test(priority = 2, enabled = false)
    public void approveBillerMerchantRegistration() throws InterruptedException, IOException {
        page.getInstance(LoginPage.class).doLogin(Constant.getUserName("admin"), Constant.getPassword());
        CommonMethods.goToSpecifiedPage(driver, ApprovalManagementPage.getMenuName());
        CommonMethods.goToSpecifiedPage(driver, ApprovalManagementPage.getSubMenu3());
        CommonMethods.clickOnButton(driver,"id", ApprovalManagementPage.getRequestListElementForBillerMerchantReg());
        CommonMethods.clickOnButton(driver,"className", ApprovalManagementPage.getApproveButtonClass());

        CommonMethods.clickOnButton(driver, "className", ApprovalManagementPage.getConfirmationYesButton());
        CommonMethods.writeTestResult(CommonMethods.getToastMessage(driver), "updated", 0, "SYS_153");
        CommonMethods.closeToastMessage(driver);
        page.getInstance(LoginPage.class).doLogout();


    }

    // Merchant Management --> Search Merchant

    @Test(priority = 1, enabled = false)
    public void searchOtherMerchantWithName() throws InterruptedException, IOException {
        page.getInstance(LoginPage.class).doLogin(Constant.getUserName("admin"), Constant.getPassword());
        CommonMethods.goToSpecifiedPage(driver, MerchantManagementPage.getMenuName());
        CommonMethods.goToSpecifiedPage(driver, MerchantManagementPage.getSubMenu4());

        data = CommonMethods.generalSearch(driver, MerchantManagementPage.getMerchantName("other"), "id", MerchantManagementPage.getBillerMerchantNameField());
        System.out.println("Result of search data with merchant name: \n"+data);
        Assert.assertTrue(data.contains(MerchantManagementPage.getMerchantName("other")), "Searched merchant name is not found");
        CommonMethods.writeTestResult(data, MerchantManagementPage.getMerchantName("other"), 0, "SYS_154");
        page.getInstance(LoginPage.class).doLogout();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
    @Test(priority = 1, enabled = false)
    public void searchOtherMerchantWithMobileNo() throws InterruptedException, IOException {
        page.getInstance(LoginPage.class).doLogin(Constant.getUserName("admin"), Constant.getPassword());
        CommonMethods.goToSpecifiedPage(driver, MerchantManagementPage.getMenuName());
        CommonMethods.goToSpecifiedPage(driver, MerchantManagementPage.getSubMenu4());
        data = CommonMethods.generalSearch(driver, MerchantManagementPage.getMerchantMobileNo(""), "name", MerchantManagementPage.getBillerMerchantMobilenoElement());
        System.out.println("Result of search data with merchant mobile no: \n"+data);
        Assert.assertTrue(data.contains(MerchantManagementPage.getMerchantMobileNo("")), "Searched merchant mobile no is not found");
        CommonMethods.writeTestResult(data, MerchantManagementPage.getMerchantMobileNo(""), 0, "SYS_155");
        page.getInstance(LoginPage.class).doLogout();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
    @Test(priority = 1, enabled = false)
    public void searchMerchantWithCode() throws InterruptedException, IOException {
        page.getInstance(LoginPage.class).doLogin(Constant.getUserName("admin"), Constant.getPassword());
        CommonMethods.goToSpecifiedPage(driver, MerchantManagementPage.getMenuName());
        CommonMethods.goToSpecifiedPage(driver, MerchantManagementPage.getSubMenu4());
        data = CommonMethods.generalSearch(driver, MerchantManagementPage.getMerchantCode(""), "name", MerchantManagementPage.getMerchantCodeElement("other"));
        System.out.println("Result of search data with merchant code: "+ MerchantManagementPage.getMerchantCode("")+ "\n" +data);
        Assert.assertTrue(data.contains(MerchantManagementPage.getMerchantCode("")), "Searched merchant mobile no is not found");
        CommonMethods.writeTestResult(data, MerchantManagementPage.getMerchantCode(""), 0, "SYS_156");
        page.getInstance(LoginPage.class).doLogout();

    }
    @Test(priority = 1, enabled = false)
    public void viewDetailsTabOfMerchant() throws InterruptedException, IOException {
        page.getInstance(LoginPage.class).doLogin(Constant.getUserName("admin"), Constant.getPassword());
        CommonMethods.goToSpecifiedPage(driver, MerchantManagementPage.getMenuName());
        CommonMethods.goToSpecifiedPage(driver, MerchantManagementPage.getSubMenu4());
        CommonMethods.generalSearch(driver, MerchantManagementPage.getMerchantCode(""), "name", MerchantManagementPage.getMerchantCodeElement("other"));
        CommonMethods.clickOnButton(driver, "className", MerchantManagementPage.getDetailsButtonElement());
        String merchantDetails = CommonMethods.getResultData(driver, "className", "content-wrapper");
        Assert.assertTrue(merchantDetails.contains(MerchantManagementPage.getMerchantCode("")), "Details is not Ok");
        CommonMethods.writeTestResult(merchantDetails, MerchantManagementPage.getMerchantCode(""), 0, "SYS_157");
        page.getInstance(LoginPage.class).doLogout();

    }
    @Test(priority = 1, enabled = false)
    public void viewTransactionTabOfMerchant() throws InterruptedException, IOException {
        page.getInstance(LoginPage.class).doLogin(Constant.getUserName("admin"), Constant.getPassword());
        CommonMethods.goToSpecifiedPage(driver, MerchantManagementPage.getMenuName());
        CommonMethods.goToSpecifiedPage(driver, MerchantManagementPage.getSubMenu4());
        CommonMethods.generalSearch(driver, MerchantManagementPage.getMerchantName("other"), "id", MerchantManagementPage.getBillerMerchantNameField());
        CommonMethods.clickOnButton(driver, "className", MerchantManagementPage.getDetailsButtonElement());
        CommonMethods.clickOnButton(driver, "id",MerchantManagementPage.getTransactionTabElement() );
        String merchantDetails = CommonMethods.getResultData(driver, "id", "transactionTab-panel");
        Assert.assertTrue(merchantDetails.contains("AUTHORIZATION"), "Details is not Ok");
        CommonMethods.writeTestResult(merchantDetails, "AUTHORIZATION", 0, "SYS_158");
        page.getInstance(LoginPage.class).doLogout();

    }
    @Test(priority = 1, enabled = false)
    public void viewTransactionTabOfMerchantWithinDateRange() throws InterruptedException, IOException {
        page.getInstance(LoginPage.class).doLogin(Constant.getUserName("admin"), Constant.getPassword());
        CommonMethods.goToSpecifiedPage(driver, MerchantManagementPage.getMenuName());
        CommonMethods.goToSpecifiedPage(driver, MerchantManagementPage.getSubMenu4());
        CommonMethods.generalSearch(driver, MerchantManagementPage.getMerchantName("other"), "id", MerchantManagementPage.getBillerMerchantNameField());
        CommonMethods.clickOnButton(driver, "className", MerchantManagementPage.getDetailsButtonElement());
        CommonMethods.clickOnButton(driver, "id",MerchantManagementPage.getTransactionTabElement() );
        DatePicker.selectStartDate(driver, "startDateLabel");
        CommonMethods.clickOnButton(driver, "className", "searchButton");
        String merchantDetails = CommonMethods.getResultData(driver, "id", "transactionTab-panel");
        Assert.assertTrue(merchantDetails.contains("AUTHORIZATION"), "Details is not Ok");
        CommonMethods.writeTestResult(merchantDetails, "AUTHORIZATION", 0, "SYS_159");
        page.getInstance(LoginPage.class).doLogout();

    }
    @Test(priority = 1, enabled = false)
    public void viewApprovalTabOfMerchant() throws InterruptedException, IOException {
        page.getInstance(LoginPage.class).doLogin(Constant.getUserName("admin"), Constant.getPassword());
        CommonMethods.goToSpecifiedPage(driver, MerchantManagementPage.getMenuName());
        CommonMethods.goToSpecifiedPage(driver, MerchantManagementPage.getSubMenu4());
        CommonMethods.generalSearch(driver, MerchantManagementPage.getMerchantName("other"), "id", MerchantManagementPage.getBillerMerchantNameField());
        CommonMethods.clickOnButton(driver, "className", MerchantManagementPage.getDetailsButtonElement());
        CommonMethods.clickOnButton(driver, "id",MerchantManagementPage.getApprovalTabElement() );
        String merchantDetails = CommonMethods.getResultData(driver, "className", "personal-inf0");
        Assert.assertTrue(merchantDetails.contains("Approval Line"), "Details is not Ok");
        CommonMethods.writeTestResult(merchantDetails, "Approval Line", 0, "SYS_160");
        page.getInstance(LoginPage.class).doLogout();

    }

    //Merchant Management --> Merchant registration

    @Test(priority = 1, enabled = true)
    public void registerMerchant() throws InterruptedException, IOException {

        page.getInstance(LoginPage.class).doLogin(Constant.getUserName("admin"), Constant.getPassword());
        CommonMethods.goToSpecifiedPage(driver, MerchantManagementPage.getMenuName());
        CommonMethods.goToSpecifiedPage(driver, MerchantManagementPage.getSubMenu5());
        MerchantManagementPage.fillUpMerchantRegistrationInfo(driver, "");
        String toastMessage = CommonMethods.getToastMessage(driver);
        CommonMethods.closeToastMessage(driver);
        Assert.assertTrue(toastMessage.contains("Success"));
        CommonMethods.writeTestResult(toastMessage, "Success", 0, "SYS_161");
        page.getInstance(LoginPage.class).doLogout();

    }

}
