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


public class UserManagementTest extends BaseTest{
    private static String data;

    public UserManagementTest(String url) {
        super(Constant.getUrl("admin"));
    }

    // User Management --> List all
    @Test(priority = 1, enabled = true)
    public void ListAll() throws InterruptedException, IOException {
        page.getInstance(LoginPage.class).doLogin(Constant.getUserName("admin"), Constant.getPassword());
        CommonMethods.goToSpecifiedPage(driver, UserManagementPage.getMenuName());
        CommonMethods.goToSpecifiedPage(driver, UserManagementPage.getSubMenu1());

        data = CommonMethods.getResultData(driver, "tagName", "table");
        System.out.println("List of user data: \n"+data);
        Assert.assertTrue(data.contains(UserManagementPage.getUserId()), "Searched user is not found");
        CommonMethods.writeTestResult(data, UserManagementPage.getUserId(), 0, "SYS_117");
        page.getInstance(LoginPage.class).doLogout();

    }

    @Test(priority = 1, enabled = true)
    public void searchUserWithUserID() throws InterruptedException, IOException {
        page.getInstance(LoginPage.class).doLogin(Constant.getUserName("admin"), Constant.getPassword());
        CommonMethods.goToSpecifiedPage(driver, UserManagementPage.getMenuName());
        CommonMethods.goToSpecifiedPage(driver, UserManagementPage.getSubMenu1());
        CommonMethods.generalSearch(driver, UserManagementPage.getUserId(), "id", UserManagementPage.getUserIdField());
        data = CommonMethods.getResultData(driver, "tagName", "table");
        System.out.println("Result of search data with user id: \n"+data);
        Assert.assertTrue(data.contains(UserManagementPage.getUserId()), "Searched user id is not found");
        CommonMethods.writeTestResult(data, UserManagementPage.getUserId(), 0, "SYS_118");
        page.getInstance(LoginPage.class).doLogout();

    }
    @Test(priority = 1, enabled = true)
    public void searchUserWithUserName() throws InterruptedException, IOException {
        page.getInstance(LoginPage.class).doLogin(Constant.getUserName("admin"), Constant.getPassword());
        CommonMethods.goToSpecifiedPage(driver, UserManagementPage.getMenuName());
        CommonMethods.goToSpecifiedPage(driver, UserManagementPage.getSubMenu1());
        data =  CommonMethods.generalSearch(driver, UserManagementPage.getUserName(), "name", UserManagementPage.getUserNameField());
        Assert.assertTrue(data.contains(UserManagementPage.getUserId()), "Searched user name is not found");
        CommonMethods.writeTestResult(data, UserManagementPage.getUserId(), 0, "SYS_119");
        page.getInstance(LoginPage.class).doLogout();

    }
    @Test(priority = 1, enabled = true)
    public void searchUserWithContactNo() throws InterruptedException, IOException {
        page.getInstance(LoginPage.class).doLogin(Constant.getUserName("admin"), Constant.getPassword());
        CommonMethods.goToSpecifiedPage(driver, UserManagementPage.getMenuName());
        CommonMethods.goToSpecifiedPage(driver, UserManagementPage.getSubMenu1());
        data =  CommonMethods.generalSearch(driver, UserManagementPage.getcontactNo(), "name", UserManagementPage.getContactNoField());
        Assert.assertTrue(data.contains(UserManagementPage.getcontactNo()), "Searched user name is not found");
        CommonMethods.writeTestResult(data, UserManagementPage.getcontactNo(), 0, "SYS_120");
        page.getInstance(LoginPage.class).doLogout();

    }
    @Test(priority = 1, enabled = true)
    public void viewUserDetails() throws InterruptedException, IOException {
        page.getInstance(LoginPage.class).doLogin(Constant.getUserName("admin"), Constant.getPassword());
        CommonMethods.goToSpecifiedPage(driver, UserManagementPage.getMenuName());
        CommonMethods.goToSpecifiedPage(driver, UserManagementPage.getSubMenu1());
        CommonMethods.generalSearch(driver, UserManagementPage.getcontactNo(), "name", UserManagementPage.getContactNoField());
        CommonMethods.clickOnButton(driver, "className", UserManagementPage.getDetailsButtonElement());
        data = CommonMethods.getResultData(driver, "className", "form-body");
        Assert.assertTrue(data.contains(UserManagementPage.getcontactNo()), "details is Ok");
        CommonMethods.writeTestResult(data, UserManagementPage.getcontactNo(), 0, "SYS_121");
        page.getInstance(LoginPage.class).doLogout();

    }
    @Test(priority = 1, enabled = true)
    public void resetPassword() throws InterruptedException, IOException {
        page.getInstance(LoginPage.class).doLogin(Constant.getUserName("admin"), Constant.getPassword());
        CommonMethods.goToSpecifiedPage(driver, UserManagementPage.getMenuName());
        CommonMethods.goToSpecifiedPage(driver, UserManagementPage.getSubMenu1());
        CommonMethods.generalSearch(driver, UserManagementPage.getResetPasswordContact(), "name", UserManagementPage.getContactNoField());
        CommonMethods.clickOnButton(driver, "className", UserManagementPage.getDetailsButtonElement());
        CommonMethods.clickOnButton(driver, "xpath", UserManagementPage.getResetPasswordButtonElement());
        CommonMethods.clickOnButton(driver, "className", UserManagementPage.getResetPasswordButtonElement2());
        Thread.sleep(5000);
        data = CommonMethods.getToastMessage(driver);
        Assert.assertTrue(data.contains("A new password has been sent to"), "details is Ok");
        CommonMethods.closeToastMessage(driver);
        CommonMethods.writeTestResult(data, "A new password has been sent to", 0, "SYS_132");
        page.getInstance(LoginPage.class).doLogout();

    }
    @Test(priority = 1, enabled = true)
    public void editUser() throws InterruptedException, IOException {
        page.getInstance(LoginPage.class).doLogin(Constant.getUserName("admin"), Constant.getPassword());
        CommonMethods.goToSpecifiedPage(driver, UserManagementPage.getMenuName());
        CommonMethods.goToSpecifiedPage(driver, UserManagementPage.getSubMenu1());
        CommonMethods.generalSearch(driver, UserManagementPage.getResetPasswordContact(), "name", UserManagementPage.getContactNoField());
        CommonMethods.clickOnButton(driver, "xpath", UserManagementPage.getEditButtonElement());
        UserManagementPage.editUser(driver);
        data = CommonMethods.getToastMessage(driver);
        Assert.assertTrue(data.contains("successful"), "Edit failed");
        CommonMethods.closeToastMessage(driver);
        CommonMethods.writeTestResult(data, "successful", 0, "SYS_122");
        page.getInstance(LoginPage.class).doLogout();

    }

    // User Management -- > Add new user | Bug: RAINBOW-942

    @Test(priority = 1, enabled = true)
    public void addNewUser() throws InterruptedException, IOException {
        page.getInstance(LoginPage.class).doLogin(Constant.getUserName("admin"), Constant.getPassword());
        CommonMethods.goToSpecifiedPage(driver, UserManagementPage.getMenuName());
        CommonMethods.goToSpecifiedPage(driver, UserManagementPage.getSubMenu2());

        CommonMethods.writeTestResult(data, "successful", 0, "SYS_133");
        page.getInstance(LoginPage.class).doLogout();

    }

}
