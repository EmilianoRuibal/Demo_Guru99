package pagina;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.BaseTest;

public class PaginaPrincipal extends BaseTest{
	//Elementos Web
	@FindBy(css = "[class=\"heading3\"] td")
	WebElement msjMangerId;
	
	//Constructor
	public PaginaPrincipal(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	//Acciones sobre los elementos
	public String mensajeObtenido( ) {
		return msjMangerId.getText();
	}
	
	public WebElement getElementoParaCapturar() {
        return msjMangerId;
    }

}
