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

public class NotificationManagementTest extends BaseTest{
    public NotificationManagementTest(String url) {
        super(Constant.getUrl("admin"));
    }
    String data;

    @Test(priority = 1, enabled = true)
    public void sendEmergencyNotice() throws InterruptedException, IOException {
        page.getInstance(LoginPage.class).doLogin(Constant.getUserName("admin"), Constant.getPassword());
        CommonMethods.goToSpecifiedPage(driver, NotificationManagementPage.getMenuName());
        CommonMethods.goToSpecifiedPage(driver, NotificationManagementPage.getSubMenu1());

        NotificationManagementPage.sendNotification(driver, "emergency", "User", "All");
        data = CommonMethods.getToastMessage(driver);
        Assert.assertTrue(data.contains("Success"), "Notification sent failed ");
        CommonMethods.closeToastMessage(driver);
        CommonMethods.writeTestResult(data, "Success", 0, "SYS_183");
        page.getInstance(LoginPage.class).doLogout();

    }
    @Test(priority = 1, enabled = true)
    public void sendMarketingNotice() throws InterruptedException, IOException {
        page.getInstance(LoginPage.class).doLogin(Constant.getUserName("admin"), Constant.getPassword());
        CommonMethods.goToSpecifiedPage(driver, NotificationManagementPage.getMenuName());
        CommonMethods.goToSpecifiedPage(driver, NotificationManagementPage.getSubMenu1());

        NotificationManagementPage.sendNotification(driver, "marketing", "User", "All");
        data = CommonMethods.getToastMessage(driver);
        Assert.assertTrue(data.contains("Success"), "Notification sent failed ");
        CommonMethods.closeToastMessage(driver);
        CommonMethods.writeTestResult(data, "Success", 0, "SYS_184");
        page.getInstance(LoginPage.class).doLogout();

    }
    @Test(priority = 1, enabled = true)
    public void sendEventNotice() throws InterruptedException, IOException {
        page.getInstance(LoginPage.class).doLogin(Constant.getUserName("admin"), Constant.getPassword());
        CommonMethods.goToSpecifiedPage(driver, NotificationManagementPage.getMenuName());
        CommonMethods.goToSpecifiedPage(driver, NotificationManagementPage.getSubMenu1());

        NotificationManagementPage.sendNotification(driver, "event", "User", "All");
        data = CommonMethods.getToastMessage(driver);
        Assert.assertTrue(data.contains("Success"), "Notification sent failed ");
        CommonMethods.closeToastMessage(driver);
        CommonMethods.writeTestResult(data, "Success", 0, "SYS_185");
        page.getInstance(LoginPage.class).doLogout();

    }
    @Test(priority = 1, enabled = true)
    public void sendSystemNotice() throws InterruptedException, IOException {
        page.getInstance(LoginPage.class).doLogin(Constant.getUserName("admin"), Constant.getPassword());
        CommonMethods.goToSpecifiedPage(driver, NotificationManagementPage.getMenuName());
        CommonMethods.goToSpecifiedPage(driver, NotificationManagementPage.getSubMenu1());

        NotificationManagementPage.sendNotification(driver, "system", "User", "All");
        data = CommonMethods.getToastMessage(driver);
        Assert.assertTrue(data.contains("Success"), "Notification sent failed ");
        CommonMethods.closeToastMessage(driver);
        CommonMethods.writeTestResult(data, "Success", 0, "SYS_186");
        page.getInstance(LoginPage.class).doLogout();

    }

    @Test(priority = 1, enabled = true)
    public void sendNoticeToDevice() throws InterruptedException, IOException {
        page.getInstance(LoginPage.class).doLogin(Constant.getUserName("admin"), Constant.getPassword());
        CommonMethods.goToSpecifiedPage(driver, NotificationManagementPage.getMenuName());
        CommonMethods.goToSpecifiedPage(driver, NotificationManagementPage.getSubMenu1());

        NotificationManagementPage.sendNotification(driver, "system", "Device", "All");
        data = CommonMethods.getToastMessage(driver);
        Assert.assertTrue(data.contains("Success"), "Notification sent failed ");
        CommonMethods.closeToastMessage(driver);
        CommonMethods.writeTestResult(data, "Success", 0, "SYS_188");
        page.getInstance(LoginPage.class).doLogout();

    }
    @Test(priority = 1, enabled = true)
    public void sendNoticeToCustomer() throws InterruptedException, IOException {
        page.getInstance(LoginPage.class).doLogin(Constant.getUserName("admin"), Constant.getPassword());
        CommonMethods.goToSpecifiedPage(driver, NotificationManagementPage.getMenuName());
        CommonMethods.goToSpecifiedPage(driver, NotificationManagementPage.getSubMenu1());

        NotificationManagementPage.sendNotification(driver, "system", "Device", "Customer");
        data = CommonMethods.getToastMessage(driver);
        Assert.assertTrue(data.contains("Success"), "Notification sent failed ");
        CommonMethods.closeToastMessage(driver);
        CommonMethods.writeTestResult(data, "Success", 0, "SYS_190");
        page.getInstance(LoginPage.class).doLogout();

    }
    @Test(priority = 1, enabled = true)
    public void sendNoticeToMerchant() throws InterruptedException, IOException {
        page.getInstance(LoginPage.class).doLogin(Constant.getUserName("admin"), Constant.getPassword());
        CommonMethods.goToSpecifiedPage(driver, NotificationManagementPage.getMenuName());
        CommonMethods.goToSpecifiedPage(driver, NotificationManagementPage.getSubMenu1());

        NotificationManagementPage.sendNotification(driver, "system", "Device", "Merchant");
        data = CommonMethods.getToastMessage(driver);
        Assert.assertTrue(data.contains("Success"), "Notification sent failed ");
        CommonMethods.closeToastMessage(driver);
        CommonMethods.writeTestResult(data, "Success", 0, "SYS_191");
        page.getInstance(LoginPage.class).doLogout();

    }




}
