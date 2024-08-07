package pagina;


import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.BaseTest;


public class PaginaLogin extends BaseTest{
    private WebDriverWait espera;
    
	//Elementos Web
	private By txtUserIDBy = By.name("uid");
    private By txtPasswordBy = By.name("password");
    private By btnLoginBy = By.name("btnLogin");
    
	//Constructor
	public PaginaLogin(WebDriver driver) {
		this.espera = new WebDriverWait(driver, Duration.ofSeconds(10));
	}
	
	//Acciones sobre los elementos
	public PaginaLogin escribirUsuer(String userID) {
		WebElement txtUserID = espera.until(ExpectedConditions.visibilityOfElementLocated(txtUserIDBy));
		txtUserID.sendKeys(userID);
		return this;
	}
	
	public PaginaLogin escribirPass(String password) {
		WebElement txtPassword = espera.until(ExpectedConditions.visibilityOfElementLocated(txtPasswordBy));
		txtPassword.sendKeys(password);
		return this;
	}
	
	public PaginaLogin clickLogin() {
		WebElement btnLogin = espera.until(ExpectedConditions.elementToBeClickable(btnLoginBy)); 
		btnLogin.click();
		return this;
	}

}
