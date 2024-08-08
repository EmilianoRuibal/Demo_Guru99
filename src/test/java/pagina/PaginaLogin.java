package pagina;


import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.BaseTest;


public class PaginaLogin extends BaseTest{
    private WebDriverWait wait;
    
	//Elementos Web
	private By useridFieldBy = By.name("uid");
    	private By passwordFieldBy = By.name("password");
    	private By loginButtonBy = By.name("btnLogin");
    
	//Constructor
	public PaginaLogin(WebDriver driver) {
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}
	
	//Acciones sobre los elementos
	public PaginaLogin enterUser(String userID) {
		WebElement useridField = wait.until(ExpectedConditions.visibilityOfElementLocated(useridFieldBy));
		useridField.sendKeys(userID);
		return this;
	}
	
	public PaginaLogin enterPassword(String password) {
		WebElement passwordField = wait.until(ExpectedConditions.visibilityOfElementLocated(passwordFieldBy));
		passwordField.sendKeys(password);
		return this;
	}
	
	public PaginaLogin clickLoginButton() {
		WebElement loginButton = wait.until(ExpectedConditions.elementToBeClickable(loginButtonBy)); 
		loginButton.click();
		return this;
	}

}
