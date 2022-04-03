package com.konasl.mbl.system.mblAdmin;

import static org.testng.Assert.assertTrue;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import com.konasl.mbl.system.admin.pages.*;
import com.konasl.mbl.utils.*;
import com.konasl.mbl.utils.SaveTestResultToExcelFile;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * @author humayun.ashik
 *
 */

public class ApprovalManagementTest extends BaseTest {

    public ApprovalManagementTest(String url){
        super(Constant.getUrl("admin"));
    }

    // Approval Management --> Approval Requests
    @Test(priority = 1, enabled = true)
    public void searchApprovalRequestWithTaskType() throws InterruptedException, IOException {
        page.getInstance(LoginPage.class).doLogin(Constant.getUserName("admin"), Constant.getPassword());
        CommonMethods.goToSpecifiedPage(driver, ApprovalManagementPage.getMenuName());
        CommonMethods.goToSpecifiedPage(driver, ApprovalManagementPage.getSubMenu1());
        CommonMethods.selectDropdownItemsByIndex(driver, "id", "taskType", 1);
        DatePicker.selectStartDate(driver, "createdFrom");
        CommonMethods.clickOnButton(driver,"id", "btnSearchId");
        String data = CommonMethods.getResultData(driver, "className", "card-body");
        Assert.assertTrue(data.contains("Create Date"));
        CommonMethods.writeTestResult(data, "Create Date", 0, "SYS_166");
        page.getInstance(LoginPage.class).doLogout();
    }
    @Test(priority=2, enabled = true)
    public void searchApprovalTaskWithCreatedDateRange() throws InterruptedException, IOException {
        page.getInstance(LoginPage.class).doLogin(Constant.getUserName("admin"), Constant.getPassword());
        CommonMethods.goToSpecifiedPage(driver, ApprovalManagementPage.getMenuName());
        CommonMethods.goToSpecifiedPage(driver, ApprovalManagementPage.getSubMenu1());
        CommonMethods.selectDropdownItemsByIndex(driver, "id", "taskType", 1);
        DatePicker.selectStartDate(driver, "createdFrom");
        DatePicker.selectEndDate(driver, "createdTo");
        CommonMethods.clickOnButton(driver,"id", "btnSearchId");
        String data = CommonMethods.getResultData(driver, "className", "card-body");
        Assert.assertTrue(data.contains("Create Date"));
        CommonMethods.writeTestResult(data, "Create Date", 0, "SYS_167");
        page.getInstance(LoginPage.class).doLogout();

    }
    @Test(priority=3, enabled = true)
    public void searchApprovalTaskWithApprovalDateRange() throws InterruptedException, IOException {
        page.getInstance(LoginPage.class).doLogin(Constant.getUserName("admin"), Constant.getPassword());
        CommonMethods.goToSpecifiedPage(driver, ApprovalManagementPage.getMenuName());
        CommonMethods.goToSpecifiedPage(driver, ApprovalManagementPage.getSubMenu1());
        CommonMethods.selectDropdownItemsByIndex(driver, "id", "taskType", 1);
        DatePicker.selectStartDate(driver, "approvedFrom");
        CommonMethods.clickOnButton(driver,"id", "btnSearchId");
        String data = CommonMethods.getResultData(driver, "className", "body");
        Assert.assertTrue(data.contains("Create Date"));
        CommonMethods.writeTestResult(data, "Create Date", 0, "SYS_168");
        page.getInstance(LoginPage.class).doLogout();

    }
    @Test(priority=1, enabled = true)
    public void viewDetailsOfApprovalTask() throws InterruptedException, IOException {
        page.getInstance(LoginPage.class).doLogin(Constant.getUserName("admin"), Constant.getPassword());
        CommonMethods.goToSpecifiedPage(driver, ApprovalManagementPage.getMenuName());
        CommonMethods.goToSpecifiedPage(driver, ApprovalManagementPage.getSubMenu1());
        CommonMethods.selectDropdownItemsByIndex(driver, "id", "taskType", 1);
        DatePicker.selectStartDate(driver, "approvedFrom");
        CommonMethods.clickOnButton(driver, "id", "btnSearchId");
        CommonMethods.clickOnButton(driver,"className", "from-group");
        Thread.sleep(2000);
        String data = CommonMethods.getResultData(driver, "className", "table");
        Assert.assertTrue(data.contains("Approval Line"));
        CommonMethods.writeTestResult(data, "Approval Line", 0, "SYS_169");
        Thread.sleep(2000);
        page.getInstance(LoginPage.class).doLogout();

    }


    // Approval Management --> Approval History
    @Test(priority=1, enabled = true)
    public void searchApprovalHistoryWithTaskType() throws InterruptedException, IOException {
        page.getInstance(LoginPage.class).doLogin(Constant.getUserName("admin"), Constant.getPassword());
        CommonMethods.goToSpecifiedPage(driver, ApprovalManagementPage.getMenuName());
        CommonMethods.goToSpecifiedPage(driver, ApprovalManagementPage.getSubMenu2());
        CommonMethods.selectDropdownItemsByIndex(driver, "id", "taskType", 3);
        DatePicker.selectStartDate(driver, "approvedFrom");
        CommonMethods.clickOnButton(driver,"id", "btnSearchId");
        String data = CommonMethods.getResultData(driver, "className", "table");
        Assert.assertTrue(data.contains("Create Date"));
        CommonMethods.writeTestResult(data, "Create Date", 0, "SYS_170");
        page.getInstance(LoginPage.class).doLogout();

    }

    @Test(priority=1, enabled = true)
    public void searchApprovalHistoryWithApprovalDateRange() throws InterruptedException, IOException {
        page.getInstance(LoginPage.class).doLogin(Constant.getUserName("admin"), Constant.getPassword());
        CommonMethods.goToSpecifiedPage(driver, ApprovalManagementPage.getMenuName());
        CommonMethods.goToSpecifiedPage(driver, ApprovalManagementPage.getSubMenu2());
        CommonMethods.selectDropdownItemsByIndex(driver, "id", "taskType", 3);
        DatePicker.selectStartDate(driver, "approvedFrom");
        CommonMethods.clickOnButton(driver,"id", "btnSearchId");
        String data = CommonMethods.getResultData(driver, "className", "table");
        Assert.assertTrue(data.contains("Create Date"));
        CommonMethods.writeTestResult(data, "Create Date", 0, "SYS_171");
        page.getInstance(LoginPage.class).doLogout();

    }
    @Test(priority=1, enabled = true)
    public void viewDetailsOfApprovalHistory() throws InterruptedException, IOException {
        page.getInstance(LoginPage.class).doLogin(Constant.getUserName("admin"), Constant.getPassword());
        CommonMethods.goToSpecifiedPage(driver, ApprovalManagementPage.getMenuName());
        CommonMethods.goToSpecifiedPage(driver, ApprovalManagementPage.getSubMenu2());
        CommonMethods.selectDropdownItemsByIndex(driver, "id", "taskType", 4);
        DatePicker.selectStartDate(driver, "approvedFrom");
        CommonMethods.clickOnButton(driver,"id", "btnSearchId");
        CommonMethods.clickOnButton(driver,"className", "from-group");
        Thread.sleep(2000);
        String data = CommonMethods.getResultData(driver, "className", "table");
        Assert.assertTrue(data.contains("Approval Line"));
        CommonMethods.writeTestResult(data, "Approval Line", 0, "SYS_172");
        page.getInstance(LoginPage.class).doLogout();

    }

    // Approval Management --> Waiting For Approval
    @Test(priority=1, enabled = true)
    public void verifyCountOfApprovalRequest() throws InterruptedException, IOException {
        page.getInstance(LoginPage.class).doLogin(Constant.getUserName("admin"), Constant.getPassword());
        CommonMethods.goToSpecifiedPage(driver, ApprovalManagementPage.getMenuName());
        CommonMethods.goToSpecifiedPage(driver, ApprovalManagementPage.getSubMenu3());

        Assert.assertEquals(Integer.parseInt(ApprovalManagementPage.getCountOfApprovalRequest(driver)), ApprovalManagementPage.getListCountOfApprovalRequest(driver));
        CommonMethods.writeTestResult(ApprovalManagementPage.getCountOfApprovalRequest(driver),Integer.toString(ApprovalManagementPage.getListCountOfApprovalRequest(driver)) , 0, "SYS_173");
        page.getInstance(LoginPage.class).doLogout();
    }

    @Test(priority=1, enabled = true)
    public void viewDetailsOfApprovalRequest() throws InterruptedException, IOException {
        page.getInstance(LoginPage.class).doLogin(Constant.getUserName("admin"), Constant.getPassword());
        CommonMethods.goToSpecifiedPage(driver, ApprovalManagementPage.getMenuName());
        CommonMethods.goToSpecifiedPage(driver, ApprovalManagementPage.getSubMenu3());
        CommonMethods.clickOnButton(driver,"id", ApprovalManagementPage.getRequestListElement());
        CommonMethods.clickOnButton(driver,"xpath", ApprovalManagementPage.getDetailsButtonXpath());
        String data = CommonMethods.getResultData(driver, "id", "btnApprove");
        System.out.println(data);
        Assert.assertTrue(data.contains("Approve"));
        CommonMethods.writeTestResult(data, "Approve", 0, "SYS_174");
        page.getInstance(LoginPage.class).doLogout();

    }
    @Test(priority=1, enabled = true)
    public void ApprovalRequest() throws InterruptedException, IOException {
        page.getInstance(LoginPage.class).doLogin(Constant.getUserName("admin"), Constant.getPassword());
        CommonMethods.goToSpecifiedPage(driver, ApprovalManagementPage.getMenuName());
        CommonMethods.goToSpecifiedPage(driver, ApprovalManagementPage.getSubMenu3());
        CommonMethods.clickOnButton(driver,"id", ApprovalManagementPage.getRequestListElement());
        CommonMethods.clickOnButton(driver,"xpath", ApprovalManagementPage.getDetailsButtonXpath());
        CommonMethods.clickOnButton(driver, "id", ApprovalManagementPage.getApproveButtonId());
        CommonMethods.clickOnButton(driver, "className", ApprovalManagementPage.getConfirmationYesButton());
        //Assert.assertTrue(CommonMethods.getToastMessage(driver).contains("Success"));
        CommonMethods.writeTestResult(CommonMethods.getToastMessage(driver), "Success", 0, "SYS_175");
        page.getInstance(LoginPage.class).doLogout();

    }
    @Test(priority=1, enabled = true)
    public void RejectRequest() throws InterruptedException, IOException {
        page.getInstance(LoginPage.class).doLogin(Constant.getUserName("admin"), Constant.getPassword());
        CommonMethods.goToSpecifiedPage(driver, ApprovalManagementPage.getMenuName());
        CommonMethods.goToSpecifiedPage(driver, ApprovalManagementPage.getSubMenu3());
        CommonMethods.clickOnButton(driver,"id", ApprovalManagementPage.getRequestListElement());
        CommonMethods.clickOnButton(driver,"xpath", ApprovalManagementPage.getDetailsButtonXpath());
        CommonMethods.clickOnButton(driver, "id", ApprovalManagementPage.getRejectButtonId());
        CommonMethods.clickOnButton(driver, "className", ApprovalManagementPage.getConfirmationYesButton());
        CommonMethods.clickOnButton(driver,"className", ApprovalManagementPage.getSelectOtherBox());
        ApprovalManagementPage.insertRejectionMessage(driver);
        CommonMethods.clickOnButton(driver, "id", ApprovalManagementPage.getSubmitButtonId());
        CommonMethods.writeTestResult(CommonMethods.getToastMessage(driver), "Success", 0, "SYS_176");
        page.getInstance(LoginPage.class).doLogout();
    }

    @Test(priority=1, enabled = true)
    public void View() throws InterruptedException, IOException {
        page.getInstance(LoginPage.class).doLogin(Constant.getUserName("admin"), Constant.getPassword());
        CommonMethods.goToSpecifiedPage(driver, ApprovalManagementPage.getMenuName());
        CommonMethods.goToSpecifiedPage(driver, ApprovalManagementPage.getSubMenu3());
        CommonMethods.clickOnButton(driver,"id", ApprovalManagementPage.getRequestListElement());
        CommonMethods.clickOnButton(driver,"xpath", ApprovalManagementPage.getDetailsButtonXpath());
        CommonMethods.clickOnButton(driver, "id", ApprovalManagementPage.getRejectButtonId());
        CommonMethods.clickOnButton(driver, "className", ApprovalManagementPage.getConfirmationYesButton());
        CommonMethods.clickOnButton(driver,"className", ApprovalManagementPage.getSelectOtherBox());
        ApprovalManagementPage.insertRejectionMessage(driver);
        CommonMethods.clickOnButton(driver, "id", ApprovalManagementPage.getSubmitButtonId());
        CommonMethods.writeTestResult(CommonMethods.getToastMessage(driver), "Success", 0, "SYS_176");
        page.getInstance(LoginPage.class).doLogout();
    }
    @Test(priority=1, enabled = true)
    public void contentOfApprovalRequestWhenNoRequest() throws InterruptedException, IOException {
        page.getInstance(LoginPage.class).doLogin(Constant.getUserName("admin"), Constant.getPassword());
        CommonMethods.goToSpecifiedPage(driver, ApprovalManagementPage.getMenuName());
        CommonMethods.goToSpecifiedPage(driver, ApprovalManagementPage.getSubMenu3());

        if(Integer.parseInt(ApprovalManagementPage.getCountOfApprovalRequest(driver)) == 0){
            CommonMethods.clickOnButton(driver,"id", ApprovalManagementPage.getRequestListElement());
            Assert.assertTrue(ApprovalManagementPage.getCollapseShowText(driver).contains("No content available."));

        }
        else{
            System.out.println("content available");
        }
        CommonMethods.writeTestResult(ApprovalManagementPage.getCollapseShowText(driver),"No content available." , 0, "SYS_177");
        page.getInstance(LoginPage.class).doLogout();
    }



}
