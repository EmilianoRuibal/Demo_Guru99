package pruebas;

import java.io.File;
import java.io.IOException;


import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Utilidades.DatosExcel;
import base.BaseTest;
import pagina.PaginaLogin;
import pagina.PaginaPrincipal;

public class SSR1_inicioSesionExitoso extends BaseTest{
	String archivoDatos = "..\\Demo_Guru100\\Datos\\Datos_Login.xlsx";
	String directorioEvidencias = "..\\Demo_Guru100\\Evidencias\\";
	File screen;

	@Test(dataProvider="Datos Login Excel")
	public void iniciarSesion(String userID, String password) throws IOException {
		
		PaginaLogin login = new PaginaLogin(driver);
		login.enterUser(userID);
		login.enterPassword(password);
		login.clickLoginButton();
		
		PaginaPrincipal msj = new PaginaPrincipal(driver);
		String msjEsperado = "Manger Id : " + userID;
		String msjObtenido = msj.messageRetrieved();
		Assert.assertEquals(msjEsperado, msjObtenido);
		
		// Captura Pantalla #1
		String nombreArchivo = "Ventana Login-"+"U-"+userID+"-P-"+password+".jpg";
		screen = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screen, new File(directorioEvidencias + nombreArchivo));
		        
	}
	
	@DataProvider(name="Datos Login Excel")
	public Object[][] obtenerDatosExcel() throws Exception{
	    Object[][] datosCompletos = DatosExcel.leerExcel(archivoDatos, "Hoja1");
		  // Devuelve el primer par de datos (0)
	    if (datosCompletos.length > 0) {
	        return new Object[][] { datosCompletos[0] };
	    } else {
	        return new Object[][] {};
	    }
	}

}
