package com.konasl.mbl.system.admin.pages;

import com.github.javafaker.Faker;
import com.konasl.mbl.utils.CommonMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class UserManagementPage {
    private  static Faker faker = new Faker();

    // Test data
    private static String userId = "mbl_admin";
    private static String userName = "Administrator";
    private static String contactNo = "01711111111";
    private static String resetPasswordContact = "01612247760";


    // Element
    private static String menuName = "User Management";
    private static String subMenu1 = "List All";
    private static String subMenu2 = "Add New User";
    private static String userIdField = "userId";
    private static String userNameField = "name";
    private static String contactNoField = "contactNumber";
    private static String detailsButtonElement = "btn-outline-primary";
    private static String resetPasswordElement = "//*[@id=\"tabs\"]/div/div/div/div/div/div[1]/button";
    private static String resetPasswordElement2 = "btn-primary";
    private static String editButtonElement = "//*[@id=\"hoverable-rows\"]//table/tbody/tr/td[6]/div/span[2]/button";
    private static String organizationTypeField = "organizationName";
    private static String designationField = "designation";
    private static String departmentField = "department";

    private static String regUserEmail = "userId";





    public static String getMenuName() {
        return menuName;
    }
    public static String getSubMenu1() {
        return subMenu1;
    }
    public static String getSubMenu2() {
        return subMenu2;
    }
    public static String getUserIdField(){
        return userIdField;
    }
    public static String getUserId(){
        return userId;
    }

    public static String getUserName() {
        return userName;
    }

    public static String getUserNameField() {
        return userNameField;
    }

    public static String getcontactNo() {
        return contactNo;
    }
    public static String getContactNoField() {
        return contactNoField;
    }
    public static String getResetPasswordContact() {
        return resetPasswordContact;
    }

    public static String getDetailsButtonElement() {
        return detailsButtonElement;
    }

    public static String getResetPasswordButtonElement() {
        return resetPasswordElement;
    }

    public static String getResetPasswordButtonElement2() {
        return resetPasswordElement2;
    }
    public static String getEditButtonElement() {
        return editButtonElement;
    }
    public static String getOrganizationTypeField() {
        return organizationTypeField;
    }
    public static String getDesignationField() {
        return designationField;
    }
    public static String getDepartmentField() {
        return departmentField;
    }
    public static void editUser(WebDriver driver) throws InterruptedException {
        driver.findElement(By.id(getUserNameField())).clear();
        driver.findElement(By.id(getUserNameField())).sendKeys(faker.funnyName().name());
        driver.findElement(By.id(getContactNoField())).clear();
        driver.findElement(By.id(getContactNoField())).sendKeys(CommonMethods.randomMobileNoGenerator());
        driver.findElement(By.id(getOrganizationTypeField())).clear();
        driver.findElement(By.id(getOrganizationTypeField())).sendKeys(faker.internet().domainWord());
        driver.findElement(By.id(getDesignationField())).clear();
        driver.findElement(By.id(getDesignationField())).sendKeys(faker.internet().domainWord());
        driver.findElement(By.id(getDepartmentField())).clear();
        driver.findElement(By.id(getDepartmentField())).sendKeys(faker.internet().domainWord());
        CommonMethods.selectDropdownItemsByVisibleText(driver, "id", "gender", "ACTIVE");
        CommonMethods.clickOnButton(driver, "className", "btn-primary");

    }

    public static void addNewUser(WebDriver driver) throws InterruptedException {



    }

}
