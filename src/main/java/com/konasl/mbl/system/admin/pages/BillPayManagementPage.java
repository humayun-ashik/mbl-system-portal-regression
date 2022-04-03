package com.konasl.mbl.system.admin.pages;

import com.github.javafaker.Faker;
import com.konasl.mbl.utils.CommonMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BillPayManagementPage {
    private  static Faker faker = new Faker();

    // test data
    private static String billerServiceName = "DESCO";
    private static String billerServiceNumber = "D001";

    // Element
    private static String menuName = "Bill Pay Management";
    private static String subMenu1 = "Biller Service Search";
    private static String subMenu2 = "Biller Service Registration";
    private static String billerServiceNameFieldElement = "name";
    private static String searchButtonElement = "btnSearchId";
    private static String getBillerServiceNumberElement = "serviceNumber";
    private static String detailsButtonElement = "from-group";
    private static String billerNameElement = "//table/tbody/tr[1]/td[2]";

    private static String serviceNameElement = "serviceName";
    private static String serviceNumberElement = "serviceNumber";
    private static String selectMerchantElement = "fa-ellipsis-h";
    private static String selectRadioButtonMerchantElement = "//*[@id=\"hoverable-rows\"]/div/div[2]/div/table/tbody/tr[1]/td[4]/input";
    private static String selectButtonElement = "btnSubmitId";
    private static String getAPISelectionElement = "getApiKey";
    private static String serviceCategoryElement = "serviceCategoryName";
    private static String amountDisplayNameEnElement = "amtDisplayNameEn";
    private static String amountDisplayNameBnElement = "amtDisplayNameBn";
    private static String amtDefaultValEnElement = "amtDefaultValEn";



    // Getter Setter Methods
    public static String getMenuName() {
        return menuName;
    }
    public static String getSubMenu1() {
        return subMenu1;
    }
    public static String getSubMenu2() {
        return subMenu2;
    }
    public static String getBillerServiceName(){
        return billerServiceName;
    }
    public static String getBillerServiceNameFieldElement(){
        return billerServiceNameFieldElement;
    }
    public static String getBillerServiceNumber(){
        return billerServiceNumber;
    }
    public static String getGetBillerServiceNumberElement(){
        return getBillerServiceNumberElement;
    }
    public static String getSearchButtonElement(){
        return searchButtonElement;
    }
    public static String getDetailsButtonElement(){
        return detailsButtonElement;
    }
    public static String getBillerNameElement(){
        return billerNameElement;
    }
    public static String getServiceNameElement(){
        return serviceNameElement;
    }
    public static String getServiceNumberElement(){
        return serviceNumberElement;
    }
    public static String getSelectMerchantElement(){
        return selectMerchantElement;
    }
    public static String getSelectRadioButtonMerchantElement(){
        return selectRadioButtonMerchantElement;
    }
    public static String getSelectButtonElement(){
        return selectButtonElement;
    }
    public static String getGetAPISelectionElement(){
        return getAPISelectionElement;
    }
    public static String getServiceCategoryElement(){
        return serviceCategoryElement;
    }
    public static String getAmountDisplayNameEnElement(){
        return amountDisplayNameEnElement;
    }
    public static String getAmountDisplayNameBnElement(){
        return amountDisplayNameBnElement;
    }
    public static String getAmtDefaultValEnElement(){
        return amtDefaultValEnElement;
    }

    public static void fillUpServiceBasicUInfo(WebDriver driver) throws InterruptedException {
        driver.findElement(By.id(getServiceNameElement())).sendKeys(faker.color().toString()); // insert service name
        driver.findElement(By.id(getServiceNumberElement())).sendKeys(faker.number().digits(4));
        CommonMethods.clickOnButton(driver,"className", getSelectMerchantElement());
        CommonMethods.clickOnButton(driver, "xpath", getSelectRadioButtonMerchantElement());
        CommonMethods.clickOnButton(driver, "id", getSelectButtonElement());
        CommonMethods.selectDropdownItemsByVisibleText(driver, "name",getGetAPISelectionElement(), "EKPAY BILLPAY");
        CommonMethods.selectDropdownItemsByIndex(driver, "id", getServiceCategoryElement(), 1);



    }

    public static void fillUpAmountInfo(WebDriver driver){
        driver.findElement(By.id(getAmountDisplayNameBnElement())).sendKeys("Amount");

    }


    public static void fillUpBillerServiceRegistrationInfo(WebDriver driver) throws InterruptedException {
        fillUpServiceBasicUInfo(driver);
    }

}
