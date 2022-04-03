package com.konasl.mbl.system.admin.pages;

import com.github.javafaker.Faker;
import com.konasl.mbl.utils.CommonMethods;
import com.konasl.mbl.utils.DatePicker;
import org.apache.commons.lang3.RandomUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.LocalFileDetector;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MerchantManagementPage {
    private static Faker faker = new Faker();
    private static String menuName = "Merchant Management";
    private static String subMenu1 = "Generate QR";
    private static String subMenu2 = "Search Biller Merchant";
    private static String subMenu3 = "Biller Merchant Registration";
    private static String subMenu4 = "Search Merchant";
    private static String subMenu5 = "Merchant Registration";

    private static String merchantName = "Clearing store";
    private static String otherMerchantName = "Agora supershop ltd";
    private static String nameFieldElement = "name";

    private static String billerMerchantName = "DESCO";
    private static String billerMerchantNameField = "accountName";


    private static String merchantMobileNo = "01688882222";
    private static String merchantMobileNoElement = "accountNoModel";
    private static String billerMerchantMobileNo = "01777777111";
    private static String billerMerchantMobilenoElement = "accountNo";

    private static String merchantCode = "MC002205";
    private static String merchantCodeElement = "//*[@id=\"1\"]/div/form/div[1]/div/div[3]/div/div/input";
    private static String otherMerchantCodeElement = "username";
    private static String billerMerchantCode = "BI002162";
    private static String billerMerchantCodeElement = "username";

    private static String detailsButtonElement = "from-group";

    // Merchant registration -->  Biller Merchant Account Information element
    private static String selectAllCheckBoxElement = "//*[@id=\"hoverable-rows\"]/div[2]/div/div[2]/div[2]/div/app-common-table-advanced/table/thead/tr/th[5]/div/label";
    private static String generateQrButtonXpath = "//*[@id=\"hoverable-rows\"]/div[2]/div/div[2]/div[2]/div/div[2]/button";
    private static String merchantAccountType = "merchantAccountType";
    private static String merchantAccountno = "merchantAccountNo";
    private static String merchantMobileAccountNo = "accountNo";
    private static String merchantMNO = "mno";
    private static String merchantTerminalMobileNo = "terminalMobileNo";
    private static String terminalMNO = "mnoTerminal";
    private static String merchantAccountName = "accountName";
    private static String merchantAccountNameBangla = "accountNameBangla";
    private static String organizationType = "organizationType";
    private static String orgTradeLicenseNo = "orgTradeLicenseNo";
    private static String businessType = "businessType";
    private static String businessCategory = "businessCategory";
    private static String categoryCode = "categoryCode";
    private static String shopName = "shopName";

    // Merchant registration -->   Registered Address element
    private static String orgRegisteredAddress = "orgRegisteredAddress";
    private static String registeredDivision = "registeredDivision";
    private static String registeredDistrict = "registeredDistrict";
    private static String registeredThana = "registeredThana";
    private static String registeredPostCode = "registeredPostCode";

    // Merchant registration -->   Registered Address element
    private static String applicantName = "name";
    private static String applicantNameBangla = "nameBangla";
    private static String fatherName = "fatherName";
    private static String fatherNameBangla = "fatherNameBangla";
    private static String motherName = "motherName";
    private static String motherNameBangla = "motherNameBangla";
    private static String spouseName = "spouseName";
    private static String spouseNameBangla = "spouseNameBangla";
    private static String nationality = "nationality";
    private static String dob = "dob";
    private static String gender = "gender";
    private static String occupation = "occupation";
    private static String emergencyContactNo = "emergencyContactNo";
    private static String mnoEmergency = "mnoEmergency";
    private static String email = "email";
    private static String incomeSource = "incomeSource";
    private static String residentStatus = "residentStatus";

    // Merchant registration -->   Identification Info element
    private static String photoIdType = "photoIdType";
    private static String photoId = "photoId";
    private static String photoIdExpiryDate = "photoIdExpiryDate";
    private static String tin = "tin";

    private static String chooseFile = "file";
    private static String billPayOption = "//*[@id=\"horizontal-form-layouts\"]/div[2]/div/div/div/div/form/div[1]/div[43]/div[1]/div[1]/label/input";
    private static String onlinePayOption = "//*[@id=\"horizontal-form-layouts\"]/div[2]/div/div/div/div/form/div[1]/div[43]/div[1]/div[2]/label/input";
    private static String registerButton = "btn-primary";

    private static String uploadFilePath = "F:\\Automation\\qa-repo\\payment-project-automation\\src\\test\\resources\\BRANCH-QR.pdf";

    private static String transactionTabElement = "transactionTab";
    private static String approvalTabElement = "approvalTab";



    public static String getMenuName() {
        return menuName;
    }

    public static String getSubMenu1() {
        return subMenu1;
    }
    public static String getMerchantName(String merchantType){
        if(merchantType =="biller"){
            return billerMerchantName;
        }
        else if(merchantType=="other"){
            return otherMerchantName;
        }
        else{
            return merchantName;
        }

    }
    public static String getTransactionTabElement(){
        return transactionTabElement;
    }
    public static String getNameFieldElement(){
        return nameFieldElement;
    }
    public static String getBillerMerchantNameField(){
        return billerMerchantNameField;
    }
    public static  String getMerchantMobileNo(String merchantType){
        if(merchantType == "biller"){
            return billerMerchantMobileNo;
        }
        else{
            return merchantMobileNo;
        }

    }
    public static String getMerchantMobileNoElement(){
        return merchantMobileNoElement;
    }
    public static String getBillerMerchantMobilenoElement(){
        return billerMerchantMobilenoElement;
    }
    public static String getMerchantCode(String merchantType){
        if(merchantType == "biller"){
            return billerMerchantCode;
        }
        return merchantCode;
    }
    public static String getMerchantCodeElement(String merchantAccountType){
        if(merchantAccountType=="biller"){
            return billerMerchantCodeElement;
        }
        else if(merchantAccountType=="other"){
            return otherMerchantCodeElement;
        }
        return merchantCodeElement;
    }
    public static String getbillerMerchantCodeElement(){
        return billerMerchantCodeElement;
    }
    public static String getSelectAllCheckBoxElement(){
        return selectAllCheckBoxElement;
    }
    public static String getGenerateQrButtonXpath(){
        return generateQrButtonXpath;
    }
    public static void selectAllCheckBox(WebDriver driver) throws InterruptedException {
        new WebDriverWait(driver, 40).until(ExpectedConditions.elementToBeClickable(By.xpath(getSelectAllCheckBoxElement()))).click();

    }
    public static void selectMultipleCheckBox(WebDriver driver) throws InterruptedException {
        driver.findElement(By.id("checkBox0")).click();
        driver.findElement(By.id("checkBox2")).click();
        driver.findElement(By.id("checkBox4")).click();

    }

    public static String getSubMenu2() {
        return subMenu2;
    }
    public static String getSubMenu3() {
        return subMenu3;
    }
    public static String getSubMenu4() {
        return subMenu4;
    }

    public static String getSubMenu5() {
        return subMenu5;
    }
    public static String getDetailsButtonElement() {
        return detailsButtonElement;
    }
    public static WebDriver uploadDocumentFile(WebDriver driver, String path) throws InterruptedException {
        // TODO Auto-generated method stub
        System.out.println("Inside upload file function, file path: " + path);
        WebElement uploadElement = driver.findElement(By.name("file"));
        ((RemoteWebElement) uploadElement ).setFileDetector(new LocalFileDetector());

        System.out.println("Choose file button clicked");
        uploadElement.sendKeys("src/test/resources/BRANCH-QR.pdf");
        System.out.println("path location sent ");
        Thread.sleep(5000);
        return driver;

    }
    public static void fillBillerMerchantAccountInfo(WebDriver driver) throws InterruptedException {
        // Fill UP Biller Merchant Account Information

        CommonMethods.selectDropdownItemsByIndex(driver,"id", merchantAccountType, 2);

        driver.findElement(By.id(merchantAccountno)).sendKeys(faker.number().digits(15)); // fill up merchant account no
        driver.findElement(By.id(merchantMobileAccountNo)).sendKeys(CommonMethods.randomMobileNoGenerator()); // fill up merchant mobile no
        CommonMethods.selectDropdownItemsByIndex(driver,"id", merchantMNO, 1); // select merchant mobile no MNO
        driver.findElement(By.id(merchantTerminalMobileNo)).sendKeys(CommonMethods.randomMobileNoGenerator()); // fill up terminal MNO
        CommonMethods.selectDropdownItemsByIndex(driver,"id", terminalMNO, 1); // select merchant mobile no MNO
        driver.findElement(By.id(merchantAccountName)).sendKeys(faker.name().fullName()); // fill up merchant name
        driver.findElement(By.id(merchantAccountNameBangla)).sendKeys(faker.name().fullName()); // fill up merchant name in bangla
        CommonMethods.selectDropdownItemsByIndex(driver, "id", organizationType, 4); // select organization type
        driver.findElement(By.id(orgTradeLicenseNo)).sendKeys(faker.number().digits(20)); // fill up trade license no
        driver.findElement(By.id(businessType)).sendKeys(faker.business().toString()); // fill up types of business
        CommonMethods.selectDropdownItemsByIndex(driver, "id", businessCategory, 6); // select merchant business category
        CommonMethods.selectDropdownItemsByIndex(driver, "id", categoryCode, 6); // select category code
        driver.findElement(By.id(shopName)).sendKeys(faker.address().streetName()); // fill up shop name


    }
    private static void fillRegisteredAddressInfo(WebDriver driver) throws InterruptedException {
        // Fill Up Registered Address

        driver.findElement(By.id(orgRegisteredAddress)).sendKeys(faker.address().fullAddress()); // fill up address input field
        CommonMethods.selectDropdownItemsByIndex(driver, "id", registeredDivision, 6); // select division
        CommonMethods.selectDropdownItemsByIndex(driver, "id", registeredDistrict, 6); // select district
        CommonMethods.selectDropdownItemsByIndex(driver, "id", registeredThana, 6); // select thana
        driver.findElement(By.id(registeredPostCode)).sendKeys(faker.number().digits(4)); // fill up post code

    }
    public static void fillPersonalInfo(WebDriver driver) throws InterruptedException {

        // fill Up Personal Info
        driver.findElement(By.id(applicantName)).sendKeys(faker.name().fullName());  // fill up appplicant name
        driver.findElement(By.id(applicantNameBangla)).sendKeys(faker.name().fullName()); // fill up applicant name in Bangla
        driver.findElement(By.id(fatherName)).sendKeys(faker.name().fullName()); // fill up father name
        driver.findElement(By.id(fatherNameBangla)).sendKeys(faker.name().fullName()); // fill up father name in bangla
        driver.findElement(By.id(motherName)).sendKeys(faker.name().fullName()); // fill up mother name
        driver.findElement(By.id(motherNameBangla)).sendKeys(faker.name().fullName()); // fill up mother name in bangla
        driver.findElement(By.id(spouseName)).sendKeys(faker.name().fullName()); // fill up spouse name
        driver.findElement(By.id(spouseNameBangla)).sendKeys(faker.name().fullName()); // fill up spouse name in bangla
        CommonMethods.selectDropdownItemsByIndex(driver, "id", nationality, 3); // select nationality
        driver.findElement(By.id(dob)).sendKeys("1995-09-15");
       // DatePicker.selectStartDate(driver, dob); // pick DOB
        CommonMethods.selectDropdownItemsByIndex(driver, "id", gender, 4); // select gender
        driver.findElement(By.id(occupation)).sendKeys(faker.company().profession()); // fill up occupation
        driver.findElement(By.id(emergencyContactNo)).sendKeys(CommonMethods.randomMobileNoGenerator()); // fill up merchant emergency mobile no
        CommonMethods.selectDropdownItemsByIndex(driver,"id", mnoEmergency, 5); // select merchant mobile no MNO
        driver.findElement(By.id(email)).sendKeys(faker.internet().emailAddress()); // fill up email
        CommonMethods.selectDropdownItemsByIndex(driver, "id", incomeSource, 4); // select income source
        CommonMethods.selectDropdownItemsByIndex(driver, "id", residentStatus, 3); // select resident status


    }
    public static void fillUPIdentificationInfo(WebDriver driver) throws InterruptedException {
        // fill up identification info

        CommonMethods.selectDropdownItemsByIndex(driver, "id", photoIdType, 3); // select id type
        driver.findElement(By.id(photoId)).sendKeys(faker.number().digits(10)); // fill up Id number
        //DatePicker.selectStartDate(driver, photoIdExpiryDate); // pick id validity date
        driver.findElement(By.id(photoIdExpiryDate)).sendKeys("2021-09-15");
        driver.findElement(By.id(tin)).sendKeys(faker.number().digits(14)); // fill up Id number

    }
    public static void selectCapabilities(WebDriver driver, String merchantType){
        if (merchantType == "biller") {
            driver.findElement(By.xpath(billPayOption)).click();
        }
        else{
            driver.findElement(By.xpath(onlinePayOption)).click();
        }

    }
    public static void fillUpMerchantRegistrationInfo(WebDriver driver, String merchantType) throws InterruptedException {
        fillBillerMerchantAccountInfo(driver);
        Thread.sleep(1000);
        fillRegisteredAddressInfo(driver);
        Thread.sleep(1000);
        fillPersonalInfo(driver);
        Thread.sleep(1000);
        fillUPIdentificationInfo(driver);

        // Upload documents
        uploadDocumentFile(driver, uploadFilePath);
        Thread.sleep(1000);


        //Capabilities
        selectCapabilities(driver, merchantType);
        //driver.findElement(By.xpath(billPayOption)).click();
        Thread.sleep(1000);
        CommonMethods.clickOnButton(driver, "className", registerButton);
        Thread.sleep(3000);


    }


    public static String getApprovalTabElement() {
        return approvalTabElement;
    }

}
