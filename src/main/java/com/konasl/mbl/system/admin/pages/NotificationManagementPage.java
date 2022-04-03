package com.konasl.mbl.system.admin.pages;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import com.github.javafaker.Faker;
import com.konasl.mbl.system.admin.pages.*;
import com.konasl.mbl.utils.DatePicker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.konasl.mbl.utils.CommonMethods;
import com.konasl.mbl.utils.Constant;

public class NotificationManagementPage {
    private static Faker faker = new Faker();

    private static String menuName = "Notification Management";
    private static String subMenu1 = "Send Notification";
    private static String notficationTypeElement = "notificationType";
    private static String recipientCategoryElement = "category";

    private static String userTypeElement = "userTopic";

    private static String notificationTitleElement = "notificationTitle";
    private static String notificationDataTextElement = "notificationDataText";

    public static String getMenuName(){
        return menuName;
    }
    public static String getSubMenu1(){
        return subMenu1;
    }
    public static String getNotficationTypeElement(){
        return notficationTypeElement;
    }
    public static String getRecipientCategoryElement(){
        return recipientCategoryElement;
    }
    public static String getUserTypeElement(){
        return userTypeElement;
    }
    public static String getNotificationTitleElement(){
        return notificationTitleElement;
    }
    public static String getNotificationDataTextElement(){
        return notificationDataTextElement;
    }

    public static String getNotificationTypeDropdownValue(String dropdownValue){
        String notificationType = null;
        if(dropdownValue=="emergency"){
            notificationType = "Emergency Notice";
        }
        else if(dropdownValue=="marketing"){
            notificationType =  "Marketing";
        }
        else if(dropdownValue=="event"){
            notificationType =  "Event";
        }
        else if(dropdownValue=="system"){
            notificationType =  "System";
        }
        return notificationType;

    }

    public static void sendNotification(WebDriver driver, String notificationType, String recipientCategory, String userType) throws InterruptedException {
        CommonMethods.selectDropdownItemsByVisibleText(driver, "id", NotificationManagementPage.getNotficationTypeElement(), NotificationManagementPage.getNotificationTypeDropdownValue(notificationType));
        CommonMethods.selectDropdownItemsByVisibleText(driver, "id", NotificationManagementPage.getRecipientCategoryElement(), recipientCategory);
        CommonMethods.selectDropdownItemsByVisibleText(driver, "id", NotificationManagementPage.getUserTypeElement(), userType);
        driver.findElement(By.id(getNotificationTitleElement())).sendKeys(faker.company().name());
        driver.findElement(By.id(getNotificationDataTextElement())).sendKeys(faker.address().fullAddress());
        CommonMethods.clickOnButton(driver, "className", "btn-primary");

    }







}
