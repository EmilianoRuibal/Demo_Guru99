package pagina;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.BaseTest;

public class PaginaPrincipal extends BaseTest{
	WebDriverWait espera = new WebDriverWait(driver, Duration.ofSeconds(10));
	//Elementos Web
	@FindBy(css = "[class='heading3'] td")
	WebElement msjMangerId;
	
	//Constructor
	public PaginaPrincipal(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	//Acciones sobre los elementos
	public String mensajeObtenido( ) {
		espera.until(ExpectedConditions.visibilityOfAllElements(msjMangerId));
		return msjMangerId.getText();
	}
	
	public WebElement getElementoParaCapturar() {
		espera.until(ExpectedConditions.visibilityOfAllElements(msjMangerId));
		return msjMangerId;
    }

}
