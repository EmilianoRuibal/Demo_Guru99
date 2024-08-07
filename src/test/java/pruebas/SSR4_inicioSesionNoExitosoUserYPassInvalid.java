package pruebas;

import org.openqa.selenium.Alert;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Utilidades.DatosExcel;
import base.BaseTest;
import pagina.PaginaLogin;

public class SSR4_inicioSesionNoExitosoUserYPassInvalid extends BaseTest{
	String archivoDatos = "..\\Demo_Guru99\\Datos\\Datos_Login.xlsx";
	
	@Test(dataProvider="Datos Login Excel")
	public void iniciarSesion(String userID, String password) {
		PaginaLogin login = new PaginaLogin(driver);
		login.escribirUsuer(userID);
		login.escribirPass(password);
		login.clickLogin();
		
		// Esperado mensaje de alerta
        String msjEsperado = "User or Password is not valid";
        // Cambia el foco a la alerta
        Alert alerta = driver.switchTo().alert();
        // Obtener el mensaje de la alerta
        String msjObtenido = alerta.getText();
        // Comparar el mensaje obtenido con el esperado
        Assert.assertEquals(msjObtenido, msjEsperado);
        // Aceptar la alerta para cerrarla
        alerta.accept();
	}
	
	@DataProvider(name="Datos Login Excel")
	public Object[][] obtenerDatosExcel() throws Exception{
	    Object[][] datosCompletos = DatosExcel.leerExcel(archivoDatos, "Hoja1");
		  // Devuelve el cuarto par de datos (3)
	    if (datosCompletos.length > 3) {
	        return new Object[][] { datosCompletos[3] };
	    } else {
	        return new Object[][] {};
	    }
	}

}
