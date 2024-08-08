package pagina;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.BaseTest;

public class PaginaPrincipal extends BaseTest{
    private WebDriverWait wait;
	//Elementos Web
	private By mangerIdMessageBy = By.cssSelector("[class='heading3'] td");
	
	//Constructor
	public PaginaPrincipal(WebDriver driver) {
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}
	
	//Acciones sobre los elementos
	public String messageRetrieved( ) {
		WebElement msjMangerId = wait.until(ExpectedConditions.visibilityOfElementLocated(mangerIdMessageBy));
		return msjMangerId.getText();
	}
	
}
