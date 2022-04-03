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

public class BillPayManagementTest extends BaseTest{

    public BillPayManagementTest(String url) {
        super(Constant.getUrl("admin"));
    }
    // Bill Pay Management --> Biller Service Search
    @Test(priority = 1, enabled = false)
    public void searchBillerWithName() throws InterruptedException, IOException {
        page.getInstance(LoginPage.class).doLogin(Constant.getUserName("admin"), Constant.getPassword());
        CommonMethods.goToSpecifiedPage(driver, BillPayManagementPage.getMenuName());
        CommonMethods.goToSpecifiedPage(driver, BillPayManagementPage.getSubMenu1());
        CommonMethods.generalSearch(driver, BillPayManagementPage.getBillerServiceName(), "id", BillPayManagementPage.getBillerServiceNameFieldElement());
        String data = CommonMethods.getResultData(driver, "tagName", "table");
        System.out.println("Result of search data with biller service name: \n"+data);
        Assert.assertTrue(data.contains(BillPayManagementPage.getBillerServiceName()), "Searched biller service is not found");
        CommonMethods.writeTestResult(data, BillPayManagementPage.getBillerServiceName(), 0, "SYS_179");
        page.getInstance(LoginPage.class).doLogout();

    }

    @Test(priority = 1, enabled = false)
    public void searchBillerWithServiceNumber() throws InterruptedException, IOException {
        page.getInstance(LoginPage.class).doLogin(Constant.getUserName("admin"), Constant.getPassword());
        CommonMethods.goToSpecifiedPage(driver, BillPayManagementPage.getMenuName());
        CommonMethods.goToSpecifiedPage(driver, BillPayManagementPage.getSubMenu1());
        CommonMethods.generalSearch(driver, BillPayManagementPage.getBillerServiceNumber(), "id", BillPayManagementPage.getGetBillerServiceNumberElement());
        String data = CommonMethods.getResultData(driver, "tagName", "table");
        System.out.println("Result of search data with biller service number: \n"+data);
        Assert.assertTrue(data.contains(BillPayManagementPage.getBillerServiceName()), "Searched biller service is not found");
        CommonMethods.writeTestResult(data, BillPayManagementPage.getBillerServiceName(), 0, "SYS_180");
        page.getInstance(LoginPage.class).doLogout();

    }


    @Test(priority = 1, enabled = false)
    public void viewDetailsOfBillerService() throws InterruptedException, IOException {
        page.getInstance(LoginPage.class).doLogin(Constant.getUserName("admin"), Constant.getPassword());
        CommonMethods.goToSpecifiedPage(driver, BillPayManagementPage.getMenuName());
        CommonMethods.goToSpecifiedPage(driver, BillPayManagementPage.getSubMenu1());
        CommonMethods.generalSearch(driver, BillPayManagementPage.getBillerServiceNumber(), "id", BillPayManagementPage.getGetBillerServiceNumberElement());
        CommonMethods.clickOnButton(driver, "className", BillPayManagementPage.getDetailsButtonElement());

        String data = CommonMethods.getResultData(driver, "className", "basic-info");
        System.out.println("Details of biller service: \n"+data);
        Assert.assertTrue(data.contains(BillPayManagementPage.getBillerServiceName()), "Details OK");
        CommonMethods.writeTestResult(data, BillPayManagementPage.getBillerServiceName(), 0, "SYS_181");
        page.getInstance(LoginPage.class).doLogout();

    }

    // Bill Pay Management --> Biller Service Registration

    @Test(priority = 1, enabled = true)
    public void registerBillerService() throws InterruptedException, IOException {
        page.getInstance(LoginPage.class).doLogin(Constant.getUserName("admin"), Constant.getPassword());
        CommonMethods.goToSpecifiedPage(driver, BillPayManagementPage.getMenuName());
        CommonMethods.goToSpecifiedPage(driver, BillPayManagementPage.getSubMenu2());
        BillPayManagementPage.fillUpBillerServiceRegistrationInfo(driver);
//        CommonMethods.generalSearch(driver, BillPayManagementPage.getBillerServiceNumber(), "id", BillPayManagementPage.getGetBillerServiceNumberElement());
//        CommonMethods.clickOnButton(driver, "className", BillPayManagementPage.getDetailsButtonElement());
//
//        String data = CommonMethods.getResultData(driver, "className", "basic-info");
//        System.out.println("Details of biller service: \n"+data);
//        Assert.assertTrue(data.contains(BillPayManagementPage.getBillerServiceName()), "Details OK");
//        CommonMethods.writeTestResult(data, BillPayManagementPage.getBillerServiceName(), 0, "SYS_181");
        Thread.sleep(3000);
        page.getInstance(LoginPage.class).doLogout();

    }




}
