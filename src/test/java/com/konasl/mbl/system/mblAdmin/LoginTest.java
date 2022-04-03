package com.konasl.mbl.system.mblAdmin;

import java.util.concurrent.TimeUnit;

import com.konasl.mbl.utils.CommonMethods;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.konasl.mbl.system.admin.pages.HomePage;
import com.konasl.mbl.system.admin.pages.LoginPage;
import com.konasl.mbl.utils.Constant;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;



public class LoginTest extends BaseTest {

	public LoginTest(String url) {
		super(Constant.getUrl("admin"));
	}

	
	
	@Test(priority = 1, enabled=true)
	public void LoginWithValidPassword() throws Exception{
		page.getInstance(LoginPage.class).doLogin(Constant.getUserName("admin"), Constant.getPassword());
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		WebElement footerText = driver.findElement(By.xpath("/html/body/app-root/app-full-layout/div/div[2]/app-footer/footer/div/p/a"));
		System.out.println(footerText.getText());
		Assert.assertEquals("KONA SOFTWARE LAB LTD.", footerText.getText());
		CommonMethods.writeTestResult(footerText.getText(), "KONA SOFTWARE LAB LTD.", 0, "SYS_057");
		page.getInstance(LoginPage.class).doLogout();
		
	}
	

	@Test(priority = 2, enabled=true)
	public void LoginWithInvalidPassword() throws Exception{
		page.getInstance(LoginPage.class).doLogin(Constant.getUserName("admin"), Constant.getPassword());
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		WebElement errorText = driver.findElement(By.className("error_message"));
		System.out.println(errorText.getText());
		Assert.assertEquals("Invalid Username or Password. Please try again.", errorText.getText());
		CommonMethods.writeTestResult(errorText.getText(), "Invalid Username or Password. Please try again.", 0, "SYS_058");
		
	}

		
	
//
//	@DataProvider(name="logindata")
//	public Object[][] TestDataFeed(){
//		ReadExcelFile readExcelObj = new ReadExcelFile("./Datafiles/users.xlsx");
//		
//		int sheet_index = 0;
//		
//		int rows = readExcelObj.getRowCount(sheet_index);
//		System.out.println("no of rows: "+rows);
//		
//		Object[][] credentials = new Object[rows][2];
//		
//		for (int i = 0; i < rows; i++) {
//			credentials[i][0] = readExcelObj.getData(sheet_index,i,0);
//			System.out.println("Credentials: "+credentials[i][0]);
//			credentials[i][1] = readExcelObj.getData(sheet_index,i,1);
//			System.out.println("Credentials: "+credentials[i][1]);
////			credentials[i][2] = readExcelObj.getBoolData(sheet_index,i,2);
////			System.out.println("Credentials: "+credentials[i][2]);
//		}
//		
//		return credentials;
//	}

}
