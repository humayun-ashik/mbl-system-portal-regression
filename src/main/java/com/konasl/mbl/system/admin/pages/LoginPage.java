/**
 * 
 */
package com.konasl.mbl.system.admin.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

/**
 * @author sazzad.mohon
 *
 */
public class LoginPage extends BasePage {
	private By username = By.id("username");
	private By password = By.id("password");
	private By loginbtn = By.id("login_button");
	private By forgotpasswordbtn = By.xpath("//*[@id=\"login_form\"]/form/div[3]/a");
	
	private By inValidLogin = By.xpath("//*[@id=\"login_form\"]/form/div[3]/div[1]");
	
	private By logOutWrapperBtn = By.id("dropdownBasic3");
	private By logOutBtn = By.xpath("//*[@id=\"navbarSupportedContent\"]/ul/li[2]/div/a[3]");

	private By loginWrapperbtn = By.xpath("//*[@id=\"navbarSupportedContent\"]/a");
	
	public LoginPage(WebDriver driver) {
		super(driver);
	}

	/**
	 * @return the username
	 */
	public WebElement getUserName() {
		return getElementBy(username);
	}

	
	/**
	 * @return the password
	 */
	public WebElement getPassword() {
		return getElementBy(password);
	}

	
	
	
	/**
	 * @return the loginbtn
	 */
	public WebElement getLoginbtn() {
		return getElementBy(loginbtn);
	}

	public WebElement getLogoutWrapperBtn() {
		return getElementBy(logOutWrapperBtn);
	}

	public WebElement getLogoutBtn() {
		return getElementBy(logOutBtn);
	}
	
	public WebElement getLoginWrappertBtn() {
		return getElementBy(loginWrapperbtn);
	}

	/**
	 * @return the forgotpasswordbtn
	 */
	public By getForgotpasswordbtn() {
		return forgotpasswordbtn;
	}
	
	
	/**
	 * @return the forgotpasswordbtn
	 */
	public String getInvalidLoginError() {
		return getElementBy(inValidLogin).getText();
	}
	
	
	public String getLoginPageTitle() {
		return getPageTitle();
		
	}
	
	
	public HomePage doLogin(String username, String password)  {
		System.out.println("Logging you in ...\n\n");
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("username")));
		System.out.println(wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("username"))));
		System.out.println("username found: "+ username);
		getUserName().sendKeys(username);
		System.out.println("username inserted");
		getPassword().sendKeys(password);
		getLoginbtn().click();
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		// Return next landing page class object
		return getInstance(HomePage.class);
	}
	
	/**
	 * Method Overloading
	 * @return
	 */
	public void doLogin() {
		getUserName().sendKeys("");
		getPassword().sendKeys("");
		getLoginbtn().click();
		
	}
	
	// username: admin@laototo.pp.com
	public void doLogin(String userCred) {
		if(userCred.contains("username")) {
			getUserName().sendKeys(userCred.split(":")[1].trim());
		}
		else if(userCred.contains("password")) {
			getPassword().sendKeys(userCred.split(":")[1].trim());
		}
		
	}
	
	public void doLogout() {
		System.out.println("\nLogging you out ...\n");
		getLogoutWrapperBtn().click();
		getLogoutBtn().click();
		//getLoginWrappertBtn().click();

	}
	
	

	
}
