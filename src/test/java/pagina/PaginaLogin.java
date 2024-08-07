package pagina;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.BaseTest;


public class PaginaLogin extends BaseTest{
	//Elementos Web
	@FindBy(name = "uid")
	WebElement txtUserID;
	
	@FindBy(name = "password")
	WebElement txtPassword;
	
	@FindBy(name = "btnLogin")
	WebElement btnLogin;
	
	//Constructor
	public PaginaLogin(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	//Acciones sobre los elementos
	public void escribirUsuer(String userID) {
		txtUserID.sendKeys(userID);
	}
	
	public void escribirPass(String password) {
		txtPassword.sendKeys(password);
	}
	
	public void clickLogin() {
		btnLogin.click();
	}

}
