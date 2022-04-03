package com.konasl.mbl.system.admin.pages;

import com.konasl.mbl.utils.CommonMethods;
import com.konasl.mbl.utils.RegexMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ApprovalManagementPage extends BasePage{

    private static String menuName = "Approval Management";
    private static String subMenu1 = "Approval Requests";
    private static String subMenu2 = "Approval History";
    private static String subMenu3 = "Waiting For Approval";
    private static String requestListElement = "ngb-panel-2-header";
    private static String billerMerchantRegistrationElement = "ngb-panel-3-header";
    private static String tableRowElement = "//*[@id=\"ngb-panel-2\"]/app-approval-task-list/app-common-table-advanced/table/tbody/tr";
    private static String detailsButtonXpath = "//*[@id=\"ngb-panel-2\"]/app-approval-task-list/app-common-table-advanced/table/tbody/tr[1]/td[5]/div/span[1]/button";
    private static String approveButtonId = "btnApprove";
    private static String confirmationYesButton = "swal2-confirm";
    private static String rejectButtonId = "btnReject";
    private static String selectOtherBox = "custom-control-label";
    private static String rejectionMessageBoxId = "rejectionMessage";
    private static String submitButtonId = "btnSubmitId";
    private static String collapseItemId = "ngb-panel-2";
    private static String approveButtonClass = "btn-primary";

    public ApprovalManagementPage(WebDriver driver) {
        super(driver);
    }

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
    public static String getRequestListElement(){
        return requestListElement;
    }
    public static String getRequestListElementForBillerMerchantReg(){
        return billerMerchantRegistrationElement;
    }
    public static String getApproveButtonClass(){
        return approveButtonClass;
    }
    public static String getTableRowElement(){
        return tableRowElement;
    }
    public static String getDetailsButtonXpath(){
        return detailsButtonXpath;
    }
    public static String getApproveButtonId(){
        return approveButtonId;
    }
    public static String getConfirmationYesButton(){
        return confirmationYesButton;
    }
    public static String getRejectButtonId(){
        return rejectButtonId;
    }
    public static String getSelectOtherBox(){
        return selectOtherBox;
    }
    public static String getRejectionMessageBoxId(){
        return rejectionMessageBoxId;
    }
    public static String getSubmitButtonId(){
        return submitButtonId;
    }
    public static String getCollapseItemId(){
        return collapseItemId;
    }
    public static String getCollapseShowText(WebDriver driver){
        return driver.findElement(By.id(getCollapseItemId())).getText();
    }
    public static void insertRejectionMessage(WebDriver driver){
        driver.findElement(By.id(rejectionMessageBoxId)).sendKeys("rejected by automation");
    }
    public static String getCountOfApprovalRequest(WebDriver driver){
        //return getElementBy(requestListElement);
        WebElement list = driver.findElement(By.id(getRequestListElement()));

        return RegexMethods.returnDigitFromString(list.getText());
    }
    public static int getListCountOfApprovalRequest(WebDriver driver) throws InterruptedException {
        CommonMethods.clickOnButton(driver,"id", requestListElement);
        List<WebElement> rows = driver.findElements(By.xpath(tableRowElement));
        return rows.size();
    }
}
